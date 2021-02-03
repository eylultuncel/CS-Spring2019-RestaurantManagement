public class waiter {
    private String name;
    private double salary;
    private int[] tableid = new int[]{-1,-1,-1};
    private int totaltable;

    public waiter(String name,double salary){
        this.name = name;
        this.salary = salary;
        this.setTotaltable(0);
    }
    public void addTable(int id){
        int i;
        for(i=0;i<3;i++){
            if (tableid[i]==-1){
                tableid[i]=id;
                return;
            }
        }
    }
    public void incrementTotalTable(){
        this.totaltable++;
    }

    public int howManyTable(){
        int i,count=0;
        for(i=0;i<3;i++){
            if(this.tableid[i]==-1){
                continue;
            }
            else{
                count++;
            }
        }
        return count;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int[] getTableid() {
        return tableid;
    }

    public void setTableid(int[] tableid) {
        this.tableid = tableid;
    }

    public void setTableidindex(int index,int set){
        this.tableid[index]=-1;


    }

    public int getTotaltable() {
        return totaltable;
    }

    public void setTotaltable(int totaltable) {
        this.totaltable = totaltable;
    }
}
