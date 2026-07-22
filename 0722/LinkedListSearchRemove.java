public class LinkedListSearchRemove {

    public static void main(String[] args) {

        // 建立鏈結串列：10 -> 20 -> 30 -> 40
        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        System.out.print("原本：");
        printList(head);

        System.out.println("是否包含 30：" + contains(head, 30));
        System.out.println("是否包含 99：" + contains(head, 99));


        head = removeValue(head, 10);
        printList(head);

        head = removeValue(head, 30);
        printList(head);

        head = removeValue(head, 40);
        printList(head);

        head = removeValue(head, 99);
        printList(head);

        printList(head);

        IntNode emptyHead = null;

        System.out.println("空串列是否包含 10："
                + contains(emptyHead, 10));

        emptyHead = removeValue(emptyHead, 10);
        printList(emptyHead);
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

    public static void printList(IntNode head) {

        if (head == null) {
            System.out.println("串列是空的！");
            return;
        }

        IntNode current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println(" -> null");
    }
}