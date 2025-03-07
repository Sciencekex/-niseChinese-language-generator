package io.github.sciencekex.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class JapaneseKanjiConverter {
    private static final Map<String, String> CONVERSION_RULES = new LinkedHashMap<>() {{
        put("について", "に関して");
        put("かなり", "可成り");
        put("なぜ", "何故");
        put("ある", "有る");
        put("ない", "無い");
        put("ありません", "冇りません");
    }};

    public static String convert(String sentence) {
        for (Map.Entry<String, String> entry : CONVERSION_RULES.entrySet()) {
            sentence = sentence.replace(entry.getKey(), entry.getValue());
        }
        return sentence;
    }
}