import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeliveryProcessingSystem {

    public static void main(String[] args) {

        Queue<DeliveryTask> waitingQueue = new LinkedList<>();
        Stack<DeliveryTask> completedStack = new Stack<>();

        addTask(
                waitingQueue,
                new DeliveryTask("D001", "台北市", "文件"));

        addTask(
                waitingQueue,
                new DeliveryTask("D002", "新北市", "包裹"));

        addTask(
                waitingQueue,
                new DeliveryTask("D003", "桃園市", "家具"));

        showNextTask(waitingQueue);

        completeNextTask(waitingQueue, completedStack);
        completeNextTask(waitingQueue, completedStack);

        showCount(waitingQueue, completedStack);

        undoLastCompleted(waitingQueue, completedStack);

        showNextTask(waitingQueue);

        showCount(waitingQueue, completedStack);

        showWaitingTasks(waitingQueue);

        showCompletedRecords(completedStack);
    }

    public static void addTask(
            Queue<DeliveryTask> waitingQueue,
            DeliveryTask task) {

        waitingQueue.offer(task);

        System.out.println("新增成功：" + task.getTaskCode());
    }

    public static void completeNextTask(
            Queue<DeliveryTask> waitingQueue,
            Stack<DeliveryTask> completedStack) {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有待配送工作！");
            return;
        }

        DeliveryTask task = waitingQueue.poll();

        completedStack.push(task);

        System.out.println("完成配送：" + task.getTaskCode());
    }

    public static void showNextTask(
            Queue<DeliveryTask> waitingQueue) {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有下一筆配送工作！");
            return;
        }

        System.out.println("下一筆配送工作：");
        waitingQueue.peek().displayInfo();
    }

    public static void undoLastCompleted(
            Queue<DeliveryTask> waitingQueue,
            Stack<DeliveryTask> completedStack) {

        if (completedStack.isEmpty()) {
            System.out.println("目前沒有可以復原的完成紀錄！");
            return;
        }

        DeliveryTask task = completedStack.pop();

        waitingQueue.offer(task);

        System.out.println(
                "已復原：" + task.getTaskCode());
    }

    public static void showCount(
            Queue<DeliveryTask> waitingQueue,
            Stack<DeliveryTask> completedStack) {

        System.out.println("等待數：" + waitingQueue.size());
        System.out.println("完成數：" + completedStack.size());
    }

    public static void showWaitingTasks(
            Queue<DeliveryTask> waitingQueue) {

        System.out.println("等待配送紀錄：");

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有待配送工作！");
            return;
        }

        for (DeliveryTask task : waitingQueue) {
            task.displayInfo();
        }
    }

    public static void showCompletedRecords(
            Stack<DeliveryTask> completedStack) {

        System.out.println("完成處理紀錄：");

        if (completedStack.isEmpty()) {
            System.out.println("目前沒有完成紀錄！");
            return;
        }

        for (DeliveryTask task : completedStack) {
            task.displayInfo();
        }
    }
}