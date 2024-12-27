### step4-Remove Hiragana.py

import re

def remove_hiragana(text):
    """
    去掉字符串中的平假名。

    参数：
        text (str): 输入的字符串。

    返回：
        str: 去掉平假名后的字符串。
    """
    # Unicode 平假名范围：\u3040-\u309F
    hiragana_pattern = r'[\u3040-\u309F]'
    return re.sub(hiragana_pattern, '', text)

def process_files(input_file, output_file):
    """
    读取输入文件，去掉平假名后写入输出文件。

    参数：
        input_file (str): 输入文件路径。
        output_file (str): 输出文件路径。
    """
    try:
        with open(input_file, 'r', encoding='utf-8') as infile:
            text = infile.read()

        result = remove_hiragana(text)

        with open(output_file, 'w', encoding='utf-8') as outfile:
            outfile.write(result)

    except FileNotFoundError:
        print(f"文件 {input_file} 未找到！")
    except Exception as e:
        print(f"发生错误: {e}")

# 测试示例
if __name__ == "__main__":
    input_file = "output.txt"
    output_file = "finished_output.txt"
    process_files(input_file, output_file)