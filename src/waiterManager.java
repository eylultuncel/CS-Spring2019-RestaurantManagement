
public class waiterManager {
    private waiter[] waiterlist= new waiter[5];


    public void addWaiter(int count,String name,double salary){
        this.waiterlist[count] = new waiter(name,salary);
    }

    public void printall(int count){
        int i;
        for(i=0;i<count;i++){
            System.out.println(waiterlist[i].getName()+ "  " +waiterlist[i].getSalary());
        }
    }

    public boolean isWaiter(String waiterName){
        int i,j;
        for(i=0;i<5;i++){
            if(waiterlist[i]==null){
                continue;
            }
            else{
                if(waiterName.equalsIgnoreCase(waiterlist[i].getName())==true ){
                    if(waiterlist[i].howManyTable()>=3){
                        System.out.println("Not allowed to service max. number of tables");
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        System.out.println( "There is no waiter named "+waiterName);
        return false;
    }

    public boolean isWaiter(String waiterName,int tableid){
        int i,j;
        for(i=0;i<5;i++){
            if(waiterlist[i]==null){
                continue;
            }
            else{
                if(waiterName.equalsIgnoreCase(waiterlist[i].getName())==true ){
                    for(j=0;j<3;j++){
                        if(waiterlist[i].getTableid()[j]==tableid){
                            return true;
                        }
                    }
                    System.out.println("This table is either not in service now or "+ waiterName+ " cannot be assigned this table!");
                    return false;
                }
            }
        }
        System.out.println( "There is no waiter named "+waiterName);
        return false;
    }



    public void addTable(String waiterName,int id){
        int i;
        for(i=0;i<5;i++){
            if(waiterlist[i]==null){
                continue;
            }
            else{
                if(waiterlist[i].getName().equalsIgnoreCase(waiterName)==true){
                    waiterlist[i].addTable(id);
                    waiterlist[i].incrementTotalTable();
                }
            }
        }
    }

    public void checkOut(int tableid){
        int i,j;
        for(j=0;j<5;j++){

        for(i=0;i<3;i++){
            if(waiterlist[j]==null){
                continue;
            }
            else if(waiterlist[j].getTableid()[i]==tableid){
                waiterlist[j].setTableidindex(i,-1);
                return;
            }
        }

        }
    }

    public void getWaiterSalary(){
        int i;
        for (i=0;i<5;i++){
            if(waiterlist[i]==null){
                continue;
            }
            else {
                double award,total;
                award = (waiterlist[i].getSalary()*waiterlist[i].getTotaltable())/20;
                total = award + waiterlist[i].getSalary();
                System.out.println("Salary for "+waiterlist[i].getName()+": "+total);
            }
        }
    }

    public void incrementOrderNum(String waiterName){
        int i;
        for(i=0;i<5;i++){
            if(waiterlist[i]==null){
                continue;
            }
            else if( waiterlist[i].getName().equalsIgnoreCase(waiterName)==true) {
                waiterlist[i].incrementTotalTable();
            }
        }
    }
}
