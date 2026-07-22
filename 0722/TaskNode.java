public class TaskNode {

    String taskCode;
    String description;
    boolean completed;
    TaskNode next;

    public TaskNode(String taskCode, String description) {
        this.taskCode = taskCode;
        this.description = description;
        this.completed = false;
        this.next = null;
    }
}