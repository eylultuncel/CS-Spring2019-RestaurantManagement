public class order {
    private String[] item = new String[50];
    private int[] itemCount = new int[10];
    private int orderCount=-1;

    public boolean addOneOrderCount(){
        if (this.orderCount==5){
            System.out.println("Not allowed to exceed max. number of orders");
            return false;
        }
        else {
            this.orderCount++;
            return true;
        }
    }

    public void addOrder(String itemName){
        int i;
        for(i=0;i<50;i++){
            if(item[i]==null){
                item[i]=itemName;
                itemCount[orderCount]++;
                return;
            }
        }
    }

    public int sizeofitems(){
      return item.length;
    }

    public String[] getItem() {
        return item;
    }

    public void setItem(String[] item) {
        this.item = item;
    }

    public int[] getItemCount() {
        return itemCount;
    }

    public void setItemCount(int[] itemCount) {
        this.itemCount = itemCount;
    }

    public int getOrderCount() {
        return orderCount;
    }
    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}
