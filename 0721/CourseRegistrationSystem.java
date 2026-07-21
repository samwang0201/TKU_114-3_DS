import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Course_> courses = new ArrayList<>();

        int choice = -1;

        do {
            printMenu();
            System.out.print("請選擇功能：");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤，請輸入整數！");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addCourse(courses, sc);
                    break;

                case 2:
                    enrollCourse(courses, sc);
                    break;

                case 3:
                    withdrawCourse(courses, sc);
                    break;

                case 4:
                    removeCourse(courses, sc);
                    break;

                case 5:
                    searchCourse(courses, sc);
                    break;

                case 6:
                    showAllCourses(courses);
                    break;

                case 7:
                    showStatistics(courses);
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
        System.out.println("\n===== 課程選課系統 =====");
        System.out.println("1. 新增課程");
        System.out.println("2. 選課");
        System.out.println("3. 退選");
        System.out.println("4. 刪除課程");
        System.out.println("5. 搜尋課程");
        System.out.println("6. 顯示全部課程");
        System.out.println("7. 顯示統計資料");
        System.out.println("0. 離開");
    }

    public static void addCourse(
            ArrayList<Course_> courses,
            Scanner sc
    ) {
        System.out.print("請輸入課程代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("課程代碼不可空白！");
            return;
        }

        if (findCourse(courses, code) != null) {
            System.out.println("課程代碼已存在，不可重複新增！");
            return;
        }

        System.out.print("請輸入課程名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("課程名稱不可空白！");
            return;
        }

        System.out.print("請輸入課程容量：");

        if (!sc.hasNextInt()) {
            System.out.println("輸入錯誤，容量必須是整數！");
            sc.nextLine();
            return;
        }

        int capacity = sc.nextInt();
        sc.nextLine();

        if (capacity <= 0) {
            System.out.println("課程容量必須大於 0！");
            return;
        }

        Course_ course = new Course_(code, name, capacity);
        courses.add(course);

        System.out.println("課程新增成功！");
    }

    public static void enrollCourse(
            ArrayList<Course_> courses,
            Scanner sc
    ) {
        System.out.print("請輸入要選課的課程代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("課程代碼不可空白！");
            return;
        }

        Course_ found = findCourse(courses, code);

        if (found == null) {
            System.out.println("找不到此課程，選課失敗！");
            return;
        }

        if (found.enroll()) {
            System.out.println("選課成功！");
            System.out.println(
                    "目前人數：" + found.getCurrentStudents()
                            + "/" + found.getCapacity()
            );
        } else {
            System.out.println("課程已額滿，無法選課！");
        }
    }

    public static void withdrawCourse(
            ArrayList<Course_> courses,
            Scanner sc
    ) {
        System.out.print("請輸入要退選的課程代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("課程代碼不可空白！");
            return;
        }

        Course_ found = findCourse(courses, code);

        if (found == null) {
            System.out.println("找不到此課程，退選失敗！");
            return;
        }

        if (found.withdraw()) {
            System.out.println("退選成功！");
            System.out.println(
                    "目前人數：" + found.getCurrentStudents()
                            + "/" + found.getCapacity()
            );
        } else {
            System.out.println("目前選課人數為 0，無法退選！");
        }
    }

    public static void removeCourse(
            ArrayList<Course_> courses,
            Scanner sc
    ) {
        System.out.print("請輸入要刪除的課程代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("課程代碼不可空白！");
            return;
        }

        Course_ found = findCourse(courses, code);

        if (found == null) {
            System.out.println("找不到此課程，刪除失敗！");
            return;
        }

        courses.remove(found);
        System.out.println("課程刪除成功！");
    }

    public static void searchCourse(
            ArrayList<Course_> courses,
            Scanner sc
    ) {
        System.out.print("請輸入要搜尋的課程代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("課程代碼不可空白！");
            return;
        }

        Course_ found = findCourse(courses, code);

        if (found == null) {
            System.out.println("找不到此課程！");
        } else {
            System.out.println("搜尋結果：");
            System.out.println(found);
        }
    }

    public static void showAllCourses(ArrayList<Course_> courses) {
        System.out.println("\n===== 全部課程 =====");

        if (courses.isEmpty()) {
            System.out.println("目前沒有任何課程。");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
    }

    public static void showStatistics( ArrayList<Course_> courses) {
        int totalEnrolled = 0;
        int fullCourseCount = 0;

        for (Course_ course : courses) {
            totalEnrolled += course.getCurrentStudents();

            if (course.isFull()) {
                fullCourseCount++;
            }
        }

        System.out.println("\n===== 課程統計 =====");
        System.out.println("總課程數：" + courses.size());
        System.out.println("總選課人次：" + totalEnrolled);
        System.out.println("額滿課程數：" + fullCourseCount);

        System.out.println("\n===== 額滿課程 =====");

        if (fullCourseCount == 0) {
            System.out.println("目前沒有額滿課程。");
            return;
        }

        for (Course_ course : courses) {
            if (course.isFull()) {
                System.out.println(course);
            }
        }
    }

    public static Course_ findCourse(
            ArrayList<Course_> courses,
            String code
    ) {
        for (Course_ course : courses) {
            if (course.getCode().equalsIgnoreCase(code)) {
                return course;
            }
        }

        return null;
    }
}