public class TaskLinkedList {

    private TaskNode head;
    private int size;

    public TaskLinkedList() {
        head = null;
        size = 0;
    }

    public void addUrgentTask(String taskCode, String description) {

        if (findTask(taskCode) != null) {
            System.out.println("工作代碼重複：" + taskCode);
            return;
        }

        TaskNode newNode = new TaskNode(taskCode, description);

        newNode.next = head;
        head = newNode;

        size++;
    }

    public void addNormalTask(String taskCode, String description) {

        if (findTask(taskCode) != null) {
            System.out.println("工作代碼重複：" + taskCode);
            return;
        }

        TaskNode newNode = new TaskNode(taskCode, description);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        TaskNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;
    }

    public TaskNode findTask(String taskCode) {

        TaskNode current = head;

        while (current != null) {
            if (current.taskCode.equals(taskCode)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public void completeTask(String taskCode) {

        TaskNode task = findTask(taskCode);

        if (task == null) {
            System.out.println("找不到工作：" + taskCode);
            return;
        }

        task.completed = true;
        System.out.println("工作已完成：" + taskCode);
    }

    public void removeCompletedTasks() {

        while (head != null && head.completed) {
            head = head.next;
            size--;
        }

        if (head == null) {
            return;
        }

        TaskNode current = head;

        while (current.next != null) {

            if (current.next.completed) {
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }
    }

    public void printAllTasks() {

        if (head == null) {
            System.out.println("工作串列是空的！");
            return;
        }

        TaskNode current = head;

        while (current != null) {

            String status;

            if (current.completed) {
                status = "已完成";
            } else {
                status = "未完成";
            }

            System.out.println(
                    current.taskCode + " - "
                            + current.description + " - "
                            + status);

            current = current.next;
        }
    }

    public void printIncompleteTasks() {

        if (head == null) {
            System.out.println("工作串列是空的！");
            return;
        }

        TaskNode current = head;
        boolean found = false;

        while (current != null) {

            if (!current.completed) {
                System.out.println(
                        current.taskCode + " - "
                                + current.description);

                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("沒有未完成工作！");
        }
    }

    public int getSize() {
        return size;
    }

    public int getIncompleteCount() {

        int count = 0;
        TaskNode current = head;

        while (current != null) {

            if (!current.completed) {
                count++;
            }

            current = current.next;
        }

        return count;
    }
}