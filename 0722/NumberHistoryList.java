public class NumberHistoryList {

    public static void main(String[] args) {

        IntNode head = null;

        System.out.println("===== 空串列統計 =====");
        printList(head);
        printStatistics(head);

        head = addFirst(head, 20);

        head = addFirst(head, 10);

        head = addLast(head, 30);

        head = addLast(head, 40);

        System.out.println("\n===== 新增後 =====");
        printList(head);

        System.out.println("是否包含 30：" + contains(head, 30));

        System.out.println("是否包含 99：" + contains(head, 99));

        head = removeValue(head, 20);

        head = removeValue(head, 99);

        System.out.println("\n===== 刪除後 =====");
        printList(head);

        head = reverse(head);

        System.out.println("\n===== 反轉後 =====");
        printList(head);

        System.out.println("\n===== 串列統計 =====");
        printStatistics(head);
    }

    public static IntNode addFirst(IntNode head, int value) {

        IntNode newNode = new IntNode(value);
        newNode.next = head;

        return newNode;
    }

    public static IntNode addLast(IntNode head, int value) {

        IntNode newNode = new IntNode(value);

        if (head == null) {
            return newNode;
        }

        IntNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    public static boolean contains(IntNode head, int target) {

        IntNode current = head;

        while (current != null) {
            if (current.data == target) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public static IntNode removeValue(IntNode head, int target) {

        if (head == null) {
            System.out.println("串列是空的，無法刪除！");
            return null;
        }

        if (head.data == target) {
            System.out.println("成功刪除：" + target);
            return head.next;
        }

        IntNode current = head;

        while (current.next != null) {
            if (current.next.data == target) {
                current.next = current.next.next;
                System.out.println("成功刪除：" + target);
                return head;
            }

            current = current.next;
        }

        System.out.println("找不到資料：" + target);
        return head;
    }

    public static IntNode reverse(IntNode head) {

        IntNode previous = null;
        IntNode current = head;

        while (current != null) {
            IntNode nextNode = current.next;

            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public static void printList(IntNode head) {

        if (head == null) {
            System.out.println("串列是空的！");
            return;
        }

        IntNode current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void printStatistics(IntNode head) {

        if (head == null) {
            System.out.println("大小：0");
            System.out.println("總和：0");
            System.out.println("最大值：無");
            System.out.println("最小值：無");
            return;
        }

        int size = 0;
        int sum = 0;
        int max = head.data;
        int min = head.data;

        IntNode current = head;

        while (current != null) {
            size++;
            sum += current.data;

            if (current.data > max) {
                max = current.data;
            }

            if (current.data < min) {
                min = current.data;
            }

            current = current.next;
        }

        System.out.println("大小：" + size);
        System.out.println("總和：" + sum);
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
    }
}