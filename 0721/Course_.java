public class Course_ {

    private String code;
    private String name;
    private int capacity;
    private int currentStudents;

    public Course_(String code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
        this.currentStudents = 0;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentStudents() {
        return currentStudents;
    }

    public boolean isFull() {
        return currentStudents >= capacity;
    }

    public boolean enroll() {
        if (isFull()) {
            return false;
        }

        currentStudents++;
        return true;
    }

    public boolean withdraw() {
        if (currentStudents <= 0) {
            return false;
        }

        currentStudents--;
        return true;
    }

    @Override
    public String toString() {
        return "代碼：" + code
                + "，名稱：" + name
                + "，容量：" + capacity
                + "，目前人數：" + currentStudents
                + "，狀態：" + (isFull() ? "已額滿" : "可選課");
    }
}