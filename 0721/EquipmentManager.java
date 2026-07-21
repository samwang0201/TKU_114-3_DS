import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Equipment> list = new ArrayList<>();

        int choice = -1;

        do {

            printMenu();

            if (!sc.hasNextInt()) {
                System.out.println("請輸入數字！");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEquipment(list, sc);
                    break;

                case 2:
                    searchEquipment(list, sc);
                    break;

                case 3:
                    borrowEquipment(list, sc);
                    break;

                case 4:
                    returnEquipment(list, sc);
                    break;

                case 5:
                    showAvailableEquipment(list);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("沒有這個選項！");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n===== 設備管理系統 =====");
        System.out.println("1. 新增設備");
        System.out.println("2. 搜尋設備");
        System.out.println("3. 借出設備");
        System.out.println("4. 歸還設備");
        System.out.println("5. 列出可借設備");
        System.out.println("0. 離開");
        System.out.print("請選擇：");
    }

    public static void addEquipment(ArrayList<Equipment> list, Scanner sc) {

        System.out.print("輸入設備代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }

        if (findEquipment(list, code) != null) {
            System.out.println("代碼重複！");
            return;
        }

        System.out.print("輸入設備名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("名稱不可空白！");
            return;
        }

        list.add(new Equipment(code, name));
        System.out.println("新增成功！");
    }

    public static void searchEquipment(ArrayList<Equipment> list, Scanner sc) {

        System.out.print("輸入設備代碼：");
        String code = sc.nextLine();

        Equipment equipment = findEquipment(list, code);

        if (equipment == null) {
            System.out.println("找不到設備！");
        } else {
            System.out.println(equipment);
        }
    }

    public static void borrowEquipment(ArrayList<Equipment> list, Scanner sc) {

        System.out.print("輸入設備代碼：");
        String code = sc.nextLine();

        Equipment equipment = findEquipment(list, code);

        if (equipment == null) {
            System.out.println("找不到設備！");
            return;
        }

        if (!equipment.isAvailable()) {
            System.out.println("設備已借出！");
            return;
        }

        equipment.borrow();
        System.out.println("借出成功！");
    }

    public static void returnEquipment(ArrayList<Equipment> list, Scanner sc) {

        System.out.print("輸入設備代碼：");
        String code = sc.nextLine();

        Equipment equipment = findEquipment(list, code);

        if (equipment == null) {
            System.out.println("找不到設備！");
            return;
        }

        if (equipment.isAvailable()) {
            System.out.println("設備本來就在館內！");
            return;
        }

        equipment.giveBack();
        System.out.println("歸還成功！");
    }

    public static void showAvailableEquipment(ArrayList<Equipment> list) {

        System.out.println("\n===== 可借設備 =====");

        boolean found = false;

        for (Equipment equipment : list) {

            if (equipment.isAvailable()) {
                System.out.println(equipment);
                found = true;
            }

        }

        if (!found) {
            System.out.println("目前沒有可借設備。");
        }
    }

    public static Equipment findEquipment(ArrayList<Equipment> list, String code) {

        for (Equipment equipment : list) {

            if (equipment.getCode().equalsIgnoreCase(code)) {
                return equipment;
            }

        }

        return null;
    }
}