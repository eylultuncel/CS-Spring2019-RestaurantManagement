public class table {
    private int id;
    private double capacity;
    private String whoCreates;
    private String status;
    private String waiter;
    private String orderInfo;

    public table(int id,double capacity,String whoCreates){
        this.setId(id);
        this.setCapacity(capacity);
        this.setWhoCreates(whoCreates);
        this.setStatus("Free");
        this.setWaiter(null);
        this.setOrderInfo(null);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getWhoCreates() {
        return whoCreates;
    }

    public void setWhoCreates(String whoCreates) {
        this.whoCreates = whoCreates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
}
