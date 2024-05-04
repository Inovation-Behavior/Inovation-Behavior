import csv
import json
import pandas as pd
import ast


def read_csv_columns(file):
    try:
        keys = []
        df = pd.DataFrame()
        # 使用 read_csv 逐行读取文件
        for count, chunk in enumerate(pd.read_csv(file, encoding='GBK', chunksize=1, header=None, nrows=4)):
            row = chunk.iloc[0].tolist()
            if count == 0:
                keys.append('patentNo')
                keys += [list(item.keys())[0] for item in ast.literal_eval(row[1])]
                keys += [list(item.keys())[0] for item in ast.literal_eval(row[2])]
                keys += [list(item.keys())[0] for item in ast.literal_eval(row[3])]
                keys += [list(item.keys())[0] for item in ast.literal_eval(row[4])]
                keys += [list(item.keys())[0] for item in ast.literal_eval(row[5])]
                keys += ['award', 'addr', 'time', 'psw', 'type']
            values = [row[0]]

            for i in range(1, 6):  # 处理5个JSON列
                json_keys = [list(item.keys())[0] for item in ast.literal_eval(row[i])]
                values += [item[key] for item, key in zip(ast.literal_eval(row[i]), json_keys)]

            values += row[6:11]

            # type在79列
            # print(values[79])
            # 将当前行添加到DataFrame中
            temp_df = pd.DataFrame([values], columns=keys)
            df = pd.concat([df, temp_df], ignore_index=True)

        return df
    except FileNotFoundError:
        print(f"File '{file_path}' not found.")
        return None


file_path = 'survey-0427.csv'
csv_data = read_csv_columns(file_path)

output_file_path = 'survey-decode-0427.csv'
csv_data.to_csv(output_file_path, index=False, encoding='utf-8-sig')
