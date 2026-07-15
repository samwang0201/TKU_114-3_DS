import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = inputText(scanner);
        String trimmedText = text.trim();
        String[] words = splitWords(trimmedText);

        System.out.println("\n===== 文字分析結果 =====");
        System.out.println("原始文字：" + text);
        System.out.println("原始字元數：" + getOriginalLength(text));
        System.out.println("有效字元數：" + getTrimmedLength(text));
        System.out.println("單字數量：" + getWordCount(words));
        System.out.println("母音總數：" + countVowels(text));
        System.out.println("最長單字：" + findLongestWord(words));

        String keyword = inputKeyword(scanner);
        int keywordCount = countKeyword(text, keyword);

        System.out.println("關鍵字「" + keyword + "」出現次數：" + keywordCount);

        scanner.close();
    }

    public static String inputText(Scanner scanner) {
        String text;

        while (true) {
            System.out.print("請輸入一行文字：");
            text = scanner.nextLine();

            if (!text.trim().isEmpty()) {
                return text;
            }

            System.out.println("輸入不能是空字串或全部空白，請重新輸入。");
        }
    }

    public static int getOriginalLength(String text) {
        return text.length();
    }

    public static int getTrimmedLength(String text) {
        return text.trim().length();
    }

    public static String[] splitWords(String text) {
        return text.split("\\s+");
    }

    public static int getWordCount(String[] words) {
        return words.length;
    }

    public static int countVowels(String text) {
        int count = 0;
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char letter = lowerText.charAt(i);

            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                count++;
            }
        }

        return count;
    }

    public static String findLongestWord(String[] words) {
        String longestWord = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        return longestWord;
    }

    public static String inputKeyword(Scanner scanner) {
        String keyword;

        while (true) {
            System.out.print("\n請輸入要搜尋的關鍵字：");
            keyword = scanner.nextLine().trim();

            if (!keyword.isEmpty()) {
                return keyword;
            }

            System.out.println("關鍵字不能是空白，請重新輸入。");
        }
    }

    public static int countKeyword(String text, String keyword) {
        int count = 0;
        int position = 0;

        String lowerText = text.toLowerCase();
        String lowerKeyword = keyword.toLowerCase();

        while (true) {
            position = lowerText.indexOf(lowerKeyword, position);

            if (position == -1) {
                break;
            }

            count++;
            position = position + lowerKeyword.length();
        }

        return count;
    }
}