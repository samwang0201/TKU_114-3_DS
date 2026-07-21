import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        int choice=-1;

        do {
            printMenu();
            System.out.print("請選擇功能：");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤，請輸入數字。");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addName(names, sc);
                    break;

                case 2:
                    searchName(names, sc);
                    break;

                case 3:
                    updateName(names, sc);
                    break;

                case 4:
                    deleteName(names, sc);
                    break;

                case 5:
                    showAllNames(names);
                    break;

                case 0:
                    System.out.println("程式結束。");
                    break;

                default:
                    System.out.println("沒有這個選項，請重新輸入。");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== 姓名名單管理系統 ===");
        System.out.println("1. 新增姓名");
        System.out.println("2. 搜尋姓名");
        System.out.println("3. 修改姓名");
        System.out.println("4. 刪除姓名");
        System.out.println("5. 列出全部");
        System.out.println("0. 離開");
    }

    public static void addName(
            ArrayList<String> names,
            Scanner sc
    ) {
        System.out.print("請輸入要新增的姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("姓名不可為空白。");
            return;
        }

        names.add(name);
        System.out.println("新增成功：" + name);
    }

    public static void searchName(
            ArrayList<String> names,
            Scanner sc
    ) {
        System.out.print("請輸入要搜尋的姓名：");
        String target = sc.nextLine().trim();

        if (target.isEmpty()) {
            System.out.println("搜尋姓名不可為空白。");
            return;
        }

        int index = findNameIndex(names, target);

        if (index == -1) {
            System.out.println("找不到姓名：" + target);
        } else {
            System.out.println("找到姓名：" + names.get(index));
        }
    }

    public static void updateName(
            ArrayList<String> names,
            Scanner sc
    ) {
        System.out.print("請輸入要修改的姓名：");
        String oldName = sc.nextLine().trim();

        if (oldName.isEmpty()) {
            System.out.println("姓名不可為空白。");
            return;
        }

        int index = findNameIndex(names, oldName);

        if (index == -1) {
            System.out.println("找不到姓名：" + oldName);
            return;
        }

        System.out.print("請輸入新的姓名：");
        String newName = sc.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("新姓名不可為空白，修改失敗。");
            return;
        }

        names.set(index, newName);
        System.out.println("修改成功：" + oldName + " → " + newName);
    }

    public static void deleteName(
            ArrayList<String> names,
            Scanner sc
    ) {
        System.out.print("請輸入要刪除的姓名：");
        String target = sc.nextLine().trim();

        if (target.isEmpty()) {
            System.out.println("姓名不可為空白。");
            return;
        }

        int index = findNameIndex(names, target);

        if (index == -1) {
            System.out.println("刪除失敗，找不到姓名：" + target);
        } else {
            String deletedName = names.remove(index);
            System.out.println("刪除成功：" + deletedName);
        }
    }

    public static void showAllNames(ArrayList<String> names) {
        System.out.println("\n=== 全部姓名 ===");

        if (names.isEmpty()) {
            System.out.println("目前沒有姓名資料。");
            return;
        }

        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }

    public static int findNameIndex(ArrayList<String> names,String target
    ) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }

        return -1;
    }
}