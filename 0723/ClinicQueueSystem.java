import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ClinicQueueSystem {

    public static void main(String[] args) {

        Queue<Patient> waitingQueue = new LinkedList<>();
        ArrayList<Integer> registeredNumbers = new ArrayList<>();

        int totalServed = 0;

        registerPatient(
                waitingQueue, registeredNumbers,
                new Patient(1, "小明", "內科"));

        registerPatient(
                waitingQueue, registeredNumbers,
                new Patient(2, "小華", "外科"));

        registerPatient(
                waitingQueue, registeredNumbers,
                new Patient(3, "小美", "內科"));

        registerPatient(
                waitingQueue, registeredNumbers,
                new Patient(4, "小安", "牙科"));

        registerPatient(
                waitingQueue, registeredNumbers,
                new Patient(2, "小傑", "眼科"));

        showNextPatient(waitingQueue);

        showWaitingList(waitingQueue);

        showDepartmentCount(waitingQueue);

        if (callPatient(waitingQueue)) {
            totalServed++;
        }

        if (callPatient(waitingQueue)) {
            totalServed++;
        }

        showNextPatient(waitingQueue);

        showWaitingList(waitingQueue);

        showDepartmentCount(waitingQueue);

        System.out.println("總服務人數：" + totalServed);
    }

    public static void registerPatient(
            Queue<Patient> waitingQueue,
            ArrayList<Integer> registeredNumbers,
            Patient patient) {

        if (registeredNumbers.contains(patient.getNumber())) {
            System.out.println("號碼不可重複！");
            return;
        }

        waitingQueue.offer(patient);
        registeredNumbers.add(patient.getNumber());

        System.out.println( "掛號成功：" + patient.getNumber() + "號 "+ patient.getName());
    }

    public static boolean callPatient(
            Queue<Patient> waitingQueue) {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有等待病患！");
            return false;
        }

        Patient patient = waitingQueue.poll();

        System.out.println("請以下病患看診：");
        patient.displayInfo();

        return true;
    }

    public static void showNextPatient(
            Queue<Patient> waitingQueue) {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有下一位病患！");
            return;
        }

        System.out.println("下一位病患：");
        waitingQueue.peek().displayInfo();
    }

    public static void showWaitingList(
            Queue<Patient> waitingQueue) {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有等待病患！");
            return;
        }

        System.out.println("等待清單：");

        for (Patient patient : waitingQueue) {
            patient.displayInfo();
        }
    }

    public static void showDepartmentCount(
            Queue<Patient> waitingQueue) {

        ArrayList<String> departments = new ArrayList<>();

        for (Patient patient : waitingQueue) {

            String department = patient.getDepartment();

            if (!departments.contains(department)) {
                departments.add(department);
            }
        }

        System.out.println("各科別等待人數：");

        if (departments.isEmpty()) {
            System.out.println("目前沒有等待病患！");
            return;
        }

        for (String department : departments) {

            int count = 0;

            for (Patient patient : waitingQueue) {

                if (patient.getDepartment().equals(department)) {
                    count++;
                }
            }

            System.out.println(department + "：" + count + "人");
        }
    }
}