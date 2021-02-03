public class tableManager {
    private table[] tablesCreatedlist = new table[5];

    public void createTable(int id,double capacity,String whoCreates){
        this.tablesCreatedlist[id] = new table(id,capacity,whoCreates);

    }

    public void printall(int count){
        int i;
        for(i=0;i<count;i++){
            System.out.println(tablesCreatedlist[i].getId()+" "+tablesCreatedlist[i].getCapacity()+" "+tablesCreatedlist[i].getWhoCreates());
        }
    }
    public int howManyTablesExist(){
        int i,count=0;
        for(i=0;i<tablesCreatedlist.length;i++){
            if(tablesCreatedlist[i]==null){
                continue;
            }
            else{
                count++;
            }
        }
        return count;
    }


    public int searchTables(int personNum,String waiter){
        int i;
        for (i=0;i<5;i++){
            if (tablesCreatedlist[i]==null){
                continue;
            }
            else{
                if (tablesCreatedlist[i].getCapacity()>= personNum && tablesCreatedlist[i].getStatus()=="Free"){
                    tablesCreatedlist[i].setStatus("Reserved");
                    tablesCreatedlist[i].setWaiter(waiter);
                    return i;
                }

            }
        }
        return -1;
    }

    public void getTableStatus(){
        int i;
        for(i=0;i<5;i++){
            if(tablesCreatedlist[i]==null){
                continue;
            }
            else{
                System.out.print("Table "+i+": "+tablesCreatedlist[i].getStatus());
                if(tablesCreatedlist[i].getStatus()=="Reserved"){
                    System.out.print(" ("+tablesCreatedlist[i].getWaiter()+")\n");
                }
                else{
                    System.out.print("\n");
                }
            }
        }
    }

    public void checkOut(int tableid){
        tablesCreatedlist[tableid].setStatus("Free");
        tablesCreatedlist[tableid].setWaiter(null);
        tablesCreatedlist[tableid].setOrderInfo(null);
    }

    public table[] getTablesCreatedlist() {
        return tablesCreatedlist;
    }

    public void setTablesCreatedlist(table[] tablesCreatedlist) {
        this.tablesCreatedlist = tablesCreatedlist;
    }
    public String getTableStatus(int i){
        return tablesCreatedlist[i].getStatus();
    }
}
