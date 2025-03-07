package io.github.sciencekex;

import io.github.sciencekex.Utils.HiraganaRemover;
import io.github.sciencekex.Utils.JapaneseKanjiConverter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            String input = Files.readString(Paths.get("input.txt"));
            String converted = JapaneseKanjiConverter.convert(input);
            String finalResult = HiraganaRemover.removeHiragana(converted);
            Files.writeString(Paths.get("finished_output.txt"), finalResult);
            System.out.println("转换完成，最终结果已写入finished_output.txt");
        } catch (IOException e) {
            System.err.println("文件操作错误: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("处理过程中发生错误: " + e.getMessage());
        }
    }
}
