### Japanese Kanji Converter.py

def advanced_kanji_converter(sentence):
    # 定义转换规则,这个自己还能再想想
    conversion_rules = {
        "について": "に関して",
        "かなり": "可成り",
        "なぜ": "何故",
        "ある": "有る",
        "ない": "無い",
        "ありません": "冇りません"
    }

    # 按规则替换句子中的词汇
    for kana, kanji in conversion_rules.items():
        sentence = sentence.replace(kana, kanji)

    return sentence

# 文件操作版本
if __name__ == "__main__":
    # 读取输入文件
    with open("input.txt", "r", encoding="utf-8") as infile:
        input_sentence = infile.read()

    # 转换句子
    converted_sentence = advanced_kanji_converter(input_sentence)

    # 写入输出文件
    with open("output.txt", "w", encoding="utf-8") as outfile:
        outfile.write(converted_sentence)

    print("转换完成，结果已写入output.txt")