import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        int choice = -1;

        do {
            printMenu();
            System.out.print("請選擇功能：");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤，請輸入數字！");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addContact(contacts, sc);
                    break;

                case 2:
                    searchContact(contacts, sc);
                    break;

                case 3:
                    updatePhone(contacts, sc);
                    break;

                case 4:
                    deleteContact(contacts, sc);
                    break;

                case 5:
                    showAllContacts(contacts);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("沒有這個選項，請重新輸入！");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n===== 聯絡人管理系統 =====");
        System.out.println("1. 新增聯絡人");
        System.out.println("2. 搜尋聯絡人");
        System.out.println("3. 修改電話");
        System.out.println("4. 刪除聯絡人");
        System.out.println("5. 顯示完整清單");
        System.out.println("0. 離開");
    }

    public static void addContact(
            ArrayList<Contact> contacts,
            Scanner sc
    ) {
        System.out.print("請輸入聯絡人代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }

        if (findContactByCode(contacts, code) != null) {
            System.out.println("代碼已存在，不可重複加入！");
            return;
        }

        System.out.print("請輸入姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        System.out.print("請輸入電話：");
        String phone = sc.nextLine().trim();

        if (phone.isEmpty()) {
            System.out.println("電話不可空白！");
            return;
        }

        System.out.print("請輸入電子郵件：");
        String email = sc.nextLine().trim();

        if (email.isEmpty()) {
            System.out.println("電子郵件不可空白！");
            return;
        }

        Contact contact = new Contact(code, name, phone, email);
        contacts.add(contact);

        System.out.println("新增聯絡人成功！");
    }

    public static void searchContact(
            ArrayList<Contact> contacts,
            Scanner sc
    ) {
        System.out.print("請輸入要搜尋的聯絡人代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("搜尋代碼不可空白！");
            return;
        }

        Contact contact = findContactByCode(contacts, code);

        if (contact == null) {
            System.out.println("找不到此聯絡人！");
        } else {
            System.out.println("搜尋結果：");
            System.out.println(contact);
        }
    }

    public static void updatePhone(
            ArrayList<Contact> contacts,
            Scanner sc
    ) {
        System.out.print("請輸入要修改的聯絡人代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }

        Contact contact = findContactByCode(contacts, code);

        if (contact == null) {
            System.out.println("找不到此聯絡人，修改失敗！");
            return;
        }

        System.out.println("目前電話：" + contact.getPhone());
        System.out.print("請輸入新電話：");
        String newPhone = sc.nextLine().trim();

        if (newPhone.isEmpty()) {
            System.out.println("新電話不可空白，修改失敗！");
            return;
        }

        contact.setPhone(newPhone);
        System.out.println("電話修改成功！");
    }

    public static void deleteContact(
            ArrayList<Contact> contacts,
            Scanner sc
    ) {
        System.out.print("請輸入要刪除的聯絡人代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }

        Contact contact = findContactByCode(contacts, code);

        if (contact == null) {
            System.out.println("找不到此聯絡人，刪除失敗！");
            return;
        }

        contacts.remove(contact);
        System.out.println("刪除成功：" + contact.getName());
    }

    public static void showAllContacts(
            ArrayList<Contact> contacts
    ) {
        System.out.println("\n===== 完整聯絡人清單 =====");

        if (contacts.isEmpty()) {
            System.out.println("目前沒有聯絡人資料。");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public static Contact findContactByCode(
            ArrayList<Contact> contacts,
            String code
    ) {
        for (Contact contact : contacts) {
            if (contact.getCode().equalsIgnoreCase(code)) {
                return contact;
            }
        }

        return null;
    }
}