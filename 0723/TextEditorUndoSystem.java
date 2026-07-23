import java.util.Stack;

public class TextEditorUndoSystem {

    public static void main(String[] args) {

        Stack<String> history = new Stack<>();
        String text = "";

        text = addText(text, "Hello", history);
        showText(text);

        text = addText(text, " Sam", history);
        showText(text);

        text = addText(text, " How are you", history);
        showText(text);

        text = deleteLast(text, 6, history);
        showText(text);

        text = undo(text, history);
        showText(text);

        text = undo(text, history);
        showText(text);

        text = undo(text, history);
        showText(text);

        text = undo(text, history);
        text = undo(text, history);
    }

    public static String addText(
            String text,
            String newText,
            Stack<String> history) {

        history.push(text);
        return text + newText;
    }

    public static String deleteLast(
            String text,
            int count,
            Stack<String> history) {

        if (count < 0 || count > text.length()) {
            System.out.println("刪除字元數量不正確！");
            return text;
        }

        history.push(text);
        return text.substring(0, text.length() - count);
    }

    public static String undo(
            String text,
            Stack<String> history) {

        if (history.isEmpty()) {
            System.out.println("沒有可以復原的歷史紀錄！");
            return text;
        }

        return history.pop();
    }

    public static void showText(String text) {

        System.out.println("目前內容：" + text);
    }
}