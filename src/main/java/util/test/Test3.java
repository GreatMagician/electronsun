package util.test;

import java.util.Objects;

/**
 * Created by Alexander on 02.03.2017.
 */
public class Test3 {

    public static void main(String[] args) {
        String text = "     Определения       и допущения:\n" +
                "Слово является непустым последовательность символов, которая не содержит пробелов и символов новой строки.\n" +
                "Строки в возвращаемой строки отделяются друг от друга символом новой строки, '\\ п'.\n" +
                "Слова на каждой строке разделены пробелами. Предположим, что аргумент строка делает\n" +
                "не содержат каких-либо, кроме пробелов и переводов строк пробельных символов.\n" +
                "Требования:\n" +
                "1. Newlines в строке аргумента сохраняются.\n" +
                "2. Слова в обратном строке разделены либо одним пробелом или одной или\n" +
                "больше строк.\n" +
                "3. Строки в возвращенная строка не может начинаться или заканчиваться пробелов.\n" +
                "4. При построении возвращаемой строки из строки аргумента, каждое слово в\n" +
                "Строка с аргументом в большинстве символов maxCharsPerLine не должны быть разбиты.\n" +
                "Каждое слово в строке аргумента с большим количеством символов, чем maxCharsPerLine должны\n" +
                "разбиваться таким образом, что все другие требования удовлетворены.\n" +
                "5. Строка Аргумент может содержать строки длиннее maxCharsPerLine. Newlines\n" +
                "должны быть добавлены таким образом, чтобы каждая строка в возвращенная строка имеет не более maxCharsPerLine\n" +
                "персонажи. Для того, чтобы определить, где новые строки должны быть добавлены, пытаются втиснуть как можно больше слов\n" +
                "как это возможно на линии (сохраняя при этом длина строки в большинстве maxCharsPerLine и\n" +
                "удовлетворяющие другим требованиям) перед началом новой строки.";
        System.out.println(wrapText(text, 100));
    }

    public static String wrapText(String text, int maxCharsPerLine){
        text = text.replaceAll("\\n", " ");
        String[] texts = text.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();
        for (String word : texts) {
            if (Objects.equals(word, "")) continue;
            if ((line.length() + word.length()) < maxCharsPerLine) {
                line.append(word);
                line.append(' ');
            }else{
                if (line.length() > 0) {
                    line.deleteCharAt(line.length()-1);
                    result.append(line);
                    result.append('\n');
                }
                line = new StringBuilder();
                line.append(word);
                line.append(' ');
            }
        }
        return result.toString();
    }
}
