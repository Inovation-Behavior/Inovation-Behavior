import pandas as pd
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from concurrent.futures import ThreadPoolExecutor
from tqdm import tqdm

def search_address(args):
    index, location = args  # 接收索引和位置
    options = webdriver.ChromeOptions()
    options.add_argument("--headless")  # 启用无头模式
    driver = webdriver.Chrome(options=options)
    driver.get("https://map.baidu.com")

    search_box = driver.find_element(By.ID, "sole-input")
    search_box.send_keys(Keys.CONTROL, "a")  # 全选输入框
    search_box.send_keys(Keys.BACKSPACE)  # 删除全选的内容
    search_box.send_keys(location)  # 输入新地址
    driver.find_element(By.XPATH, '//*[@id="search-button"]').click()
    time.sleep(2)  # 等待页面响应
    driver.get(driver.current_url)
    time.sleep(5)  # 等待搜索结果加载

    try:
        place = driver.find_element(By.CLASS_NAME, 'poilist').find_element(By.TAG_NAME, 'li').find_element(By.XPATH,
                                                                                                           '//*[@id="card-1"]/div/div[1]/ul/li/div[1]/div[3]/div[2]').text
    except Exception:
        place = location  # 如果无法找到，则使用原始位置名称

    driver.quit()
    return index, {'Company Name': location, 'Address': place}

def get_addresses(locations):
    with ThreadPoolExecutor(max_workers=6) as executor:
        # 创建一个索引和位置的元组列表
        args = [(i, loc) for i, loc in enumerate(locations)]
        # 使用 tqdm 包装 args 以显示进度条
        results = list(tqdm(executor.map(search_address, args), total=len(args)))
    # 排序结果以保持原始顺序
    results.sort(key=lambda x: x[0])  # 按照索引排序
    return pd.DataFrame([item[1] for item in results])  # 创建DataFrame

# 读取数据
file_path = 'enterprise.csv'
try:
    data = pd.read_csv(file_path, encoding='GBK')
except UnicodeDecodeError:
    data = pd.read_csv(file_path, encoding='utf-8')
company_names = data['Appln_Applicant_First'].tolist()

# 获取地址并保存
address_data = get_addresses(company_names[4500:5000])
address_data.to_csv('updated_company_addresses-2.csv', index=False)
print("已将地址信息更新至 'updated_company_addresses.csv'。")
