import pandas as pd
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

def get_addresses(locations: list) -> list:
    options = webdriver.ChromeOptions()
    options.add_argument("--headless")  # 启用无头模式
    driver = webdriver.Chrome(options=options)
    driver.get("https://map.baidu.com/@13523265.31,3641114.64,12z")

    searched_addresses = []
    for location in locations:
        search_box = driver.find_element(By.ID, "sole-input")
        search_box.send_keys(Keys.CONTROL, "a")  # 全选输入框
        search_box.send_keys(Keys.BACKSPACE)  # 删除全选的内容
        search_box.send_keys(location)  # 输入新地址
        driver.find_element(By.XPATH, '//*[@id="search-button"]').click()
        time.sleep(2)
        driver.get(driver.current_url)
        time.sleep(5)  # 等待搜索结果加载

        # 尝试获取搜索到的地址
        try:
            place = driver.find_element(By.CLASS_NAME, 'poilist').find_element(By.TAG_NAME, 'li').find_element(By.XPATH,
                                                                                                               '//*[@id="card-1"]/div/div[1]/ul/li/div[1]/div[3]/div[2]').text
        except Exception:
            place = location  # 如果无法找到，则使用原始位置名称

        searched_addresses.append({'Company Name': location, 'Address': place})
        print(location + ": " + place)

    driver.quit()
    return pd.DataFrame(searched_addresses)  # 将列表转换为DataFrame

# 读取数据
file_path = 'enterprise.csv'
# 尝试使用GBK编码读取文件
try:
    data = pd.read_csv(file_path, encoding='GBK')
except UnicodeDecodeError:
    # 如果GBK编码失败，则尝试使用utf-8编码
    data = pd.read_csv(file_path, encoding='utf-8')
company_names = data['Appln_Applicant_First'].tolist()

# 获取地址
address_data = get_addresses(company_names[4000:4500])

address_data.to_csv('updated_company_addresses-1.csv', index=False)
print("已将地址信息更新至 'updated_company_addresses.csv'。")
