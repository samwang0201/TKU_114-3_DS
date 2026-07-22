public class TaskLinkedListSystem {

    public static void main(String[] args) {

        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("===== 空串列測試 =====");
        taskList.printAllTasks();

        taskList.addNormalTask("T001", "擦黑板");
        taskList.addNormalTask("T002", "整理教室環境");
        taskList.addNormalTask("T003", "上傳上課檔案");

        taskList.addUrgentTask("T004", "輔導學生");

        taskList.addNormalTask("T001", "重複工作");

        System.out.println("\n===== 所有工作 =====");
        taskList.printAllTasks();

        System.out.println("\n===== 搜尋工作 =====");

        TaskNode foundTask = taskList.findTask("T002");

        if (foundTask != null) {
            System.out.println(
                    "找到工作：" + foundTask.taskCode
                            + " - " + foundTask.description);
        } else {
            System.out.println("找不到工作！");
        }

        foundTask = taskList.findTask("T999");

        if (foundTask != null) {
            System.out.println("找到工作：" 
            + foundTask.taskCode + " - " + foundTask.description);
        } else {
            System.out.println("找不到工作：T999");
 }

        System.out.println("\n===== 完成工作 =====");
        taskList.completeTask("T004");
        taskList.completeTask("T002");
        taskList.completeTask("T999");

        System.out.println("\n===== 完成狀態 =====");
        taskList.printAllTasks();

        System.out.println("\n===== 未完成工作 =====");
        taskList.printIncompleteTasks();

        System.out.println("\n===== 工作統計 =====");
        System.out.println("工作總數：" + taskList.getSize());
        System.out.println("未完成數量：" + taskList.getIncompleteCount());

        System.out.println("\n===== 刪除已完成工作 =====");
        taskList.removeCompletedTasks();
        taskList.printAllTasks();

        System.out.println("\n===== 刪除後統計 =====");
        System.out.println("工作總數：" + taskList.getSize());
        System.out.println("未完成數量：" + taskList.getIncompleteCount());
    }
}