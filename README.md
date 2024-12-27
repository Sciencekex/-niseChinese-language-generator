最近有个日区App Store有个社交应用非常火爆, 名字为「対多」, 日语读法谐音[Twitter], 特点是只用"偽中国語"发推



个人认为的"偽中国語": 把日语句子删掉假名保留汉字, (优化:把片假名单词转为原英语词汇, 毕竟现在日语这么多片假名谁TM看得懂啊,还得先TM读一遍才能懂什么意思)



(偽中国語生成器:[GPT自动翻译日语,选用尽量多汉字的日语词]->[GPT转换外来语:转成原英语]->[Py日语汉字词汇转换器:如について→に関して，かなり→可成り，なぜ→何故，ある→有る，ない→無い，ありません→冇りません]->[Py去掉假名])

第一步的GPT提示词:`翻译成日语,要求使用尽可能多汉字的日语词汇`

第二步的GPT提示词:`把一下日语文章中的外来语词汇用原英语词汇替换,举个例子如「アイドル」→「idol」,「バンドリ」→「bangdre」等等`

第三步:

```python
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

```

第四步:

```python
### Remove Hiragana.py

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
```

`最后再手动删删减减片假名,手敲原英语词汇(考验你日语水平的时刻到了),即可完成`

***

看下效果



原文:

```
第一次写日记, 那就鞋垫流水账吧.

为什么会写日记呢? 肯定是想记录一下每日的想法.
其实主要就是室友也在写日记, 这种带头效应的效果很明显.

昨日的VRChat话题について：最后聊到了中国大人气的アイドルアニメ　バンドリ／ラブライブ 也是可以的

今天上午收到了快递, 二手iPhone SE 2, 很开心, 立马激活了日本关东交通卡Suica, 不愧是最全球化的手机品牌.

最后想了想人生走势, 还得是测开+运维岗, 语言:日语顶级+英语四级(纯個人的な趣味)
当然, 学习路线依旧可以参考:Java后端+Python测试+Vue.js前端
```



转换后:
```
初日記執筆、偽中国語、適当流水帳。  

何故日記書？確日々考記録理由有。  
実際主roommate日記書、先導効果leading effect可成顕著。  

昨日VRChat話題関：最後中国人気idol anime『bangdre』『Love Live』関話、結構盛上。  

本日午前、宅配便届。中古iPhone SE 2、大喜、早速日本関東交通card「Suica」activate。最global化smartphone brand言。  

最後人生進路関少考。test engineer＋operation management職種良。言語日本語top level＋英語CET-4（完全個人趣味）。  
学習route引続以下参考：Java backend＋Python test＋Vue.js frontend。
```

