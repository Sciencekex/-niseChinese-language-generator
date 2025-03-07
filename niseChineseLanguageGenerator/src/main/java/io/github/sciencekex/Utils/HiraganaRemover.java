import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class HiraganaRemover {
    // 预编译正则表达式提升性能
    private static final Pattern HIRAGANA_PATTERN = Pattern.compile("[\u3040-\u309F]");
    
    /**
     * 移除字符串中的平假名
     * @param text 输入字符串
     * @return 处理后的字符串
     */
    public static String removeHiragana(String text) {
        return HIRAGANA_PATTERN.matcher(text).replaceAll("");
    }
    
    /**
     * 处理文件读写操作
     * @param inputFile 输入文件路径
     * @param outputFile 输出文件路径
     * @throws IOException 文件操作异常
     */
    public static void processFiles(String inputFile, String outputFile) throws IOException {
        String content = Files.readString(Paths.get(inputFile));
        String result = removeHiragana(content);
        Files.writeString(Paths.get(outputFile), result);
    }
}