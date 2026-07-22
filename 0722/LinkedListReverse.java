public class LinkedListReverse {

    public static void main(String[] args) {

        IntNode emptyHead = null;
        emptyHead = reverse(emptyHead);
        printList(emptyHead);

        IntNode singleHead = new IntNode(10);
        singleHead = reverse(singleHead);
        printList(singleHead);

        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        head = reverse(head);
        printList(head);
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
            System.out.println("null");
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

        System.out.println();
    }
}