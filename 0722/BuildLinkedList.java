public class BuildLinkedList {

    public static void main(String[] args) {

        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        if (head == null) {
            System.out.println("串列是空的！");
            return;
        }

        IntNode current = head;
        int count = 0;
        int sum = 0;

        System.out.println("串列內容：");

        while (current != null) {
            System.out.print(current.data + " ");

            count++;
            sum += current.data;

            current = current.next;
        }

        System.out.println();
        System.out.println("節點數：" + count);
        System.out.println("總和：" + sum);

        int target = 30;
        current = head;
        boolean found = false;

        while (current != null) {
            if (current.data == target) {
                found = true;
                break;
            }

            current = current.next;
        }

        if (found) {
            System.out.println(target + " 找到了！");
        } else {
            System.out.println(target + " 不存在！");
        }

    }

}