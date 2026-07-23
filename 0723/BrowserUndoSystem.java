import java.util.Stack;

public class BrowserUndoSystem {

    public static void main(String[] args) {

        Stack<String> browserHistory = new Stack<>();

        showCurrentPage(browserHistory);

        goBack(browserHistory);

        openPage(browserHistory, "Google");

        openPage(browserHistory, "YouTube");

        openPage(browserHistory, "Instagram");

        showCurrentPage(browserHistory);

        goBack(browserHistory);

        showCurrentPage(browserHistory);

        goBack(browserHistory);

        showCurrentPage(browserHistory);

        goBack(browserHistory);
    }

    public static void openPage(
            Stack<String> browserHistory, String page) {

        browserHistory.push(page);
        System.out.println("開啟頁面：" + page);
    }

    public static void goBack(Stack<String> browserHistory) {

        if (browserHistory.size() <= 1) {
            System.out.println("沒有上一頁可以返回！");
            return;
        }

        String closedPage = browserHistory.pop();

        System.out.println("離開頁面：" + closedPage);
        System.out.println("返回頁面：" + browserHistory.peek());
    }

    public static void showCurrentPage(
            Stack<String> browserHistory) {

        if (browserHistory.isEmpty()) {
            System.out.println("目前沒有開啟任何頁面！");
            return;
        }

        System.out.println("目前頁面：" + browserHistory.peek());
    }
}