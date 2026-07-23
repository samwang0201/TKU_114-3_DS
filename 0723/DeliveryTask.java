public class DeliveryTask {

    private String taskCode;
    private String address;
    private String item;

    public DeliveryTask(String taskCode, String address, String item) {
        this.taskCode = taskCode;
        this.address = address;
        this.item = item;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public String getAddress() {
        return address;
    }

    public String getItem() {
        return item;
    }

    public void displayInfo() {
        System.out.println("編號：" + taskCode+ "，地址：" + address+ "，物品：" + item);
    }
}