import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class orderManager {
    private order[] orderOfTables =new order[5];

    public void addTable(int tableid){
        orderOfTables[tableid]= new order();
    }

    public boolean incrementOrdercount(int tableid){
        if (orderOfTables[tableid].addOneOrderCount()==true){
            return true;
        }
        else{
            return false;
        }
    }
    public void addOrder(int tableid,String itemName){
        System.out.println("Item "+itemName+" added into order");
        orderOfTables[tableid].addOrder(itemName);

    }

    public int ordermax(int tableid){

/*
        int i,sum=0;
        for(i=0;i<10;i++) {
            if(orderOfTables[tableid].getItemCount()[i]==0){
                break;
            }
        }
        System.out.println( "AAAAA  "+orderOfTables[tableid].getItemCount()[i-1]);
*/
        return orderOfTables[tableid].getOrderCount();

    }

    public void getOrderStatus(tableManager table){
        int i,j,ordercounttemp;
        for(i=0;i<5;i++){
            if(orderOfTables[i]==null){
                if(table.getTablesCreatedlist()[i]==null){
                    continue;
                }
                else if(table.getTableStatus(i)=="Free"){
                    System.out.println("Table: "+i);
                    System.out.println("\t0 order(s)");
                }
            }
            else{
                System.out.println("Table: "+i);
                ordercounttemp = orderOfTables[i].getOrderCount()+1;
                System.out.println("\t"+ ordercounttemp+" order(s)");
                for(j=0;j<10;j++){
                   if(orderOfTables[i].getItemCount()[j]==0) {
                       continue;
                   }
                   else{
                       System.out.println("\t\t"+orderOfTables[i].getItemCount()[j]+" item(s)");
                   }
                }
            }
        }
    }

    public void checkOut(int tableid,items object){
        int i,j,size;
        size = orderOfTables[tableid].sizeofitems();
        String orders[] = new String[size];

        for(i=0;i<size;i++){
            orders[i]=orderOfTables[tableid].getItem()[i];
        }

        String[] itemsordered= new String[size];
        int[] numberofordered= new int[size];
        for(i=0,j=0;i<size;i++){

            if(orders[i]==null){
                continue;
            }
            else if(Arrays.asList(itemsordered).contains(orders[i])==true){
                int k;
                for(k=0;k<size;k++){
                    if(itemsordered[k]==null){
                        continue;
                    }
                    else if(itemsordered[k].equalsIgnoreCase(orders[i])){
                        numberofordered[k]++;
                    }
                }

                }
            else {
                itemsordered[j]=orders[i];
                numberofordered[j]=1;
                j++;
            }

        }
        double sum=0;
        for(i=0;i<size;i++){

            if(itemsordered[i]==null){
                continue;
            }
            else{
                System.out.printf("%s\t%.3f (x %d) %.3f $\n",itemsordered[i]+":",object.costdict.get(itemsordered[i]),numberofordered[i],object.costdict.get(itemsordered[i])*numberofordered[i]);
                sum+=object.costdict.get(itemsordered[i])*numberofordered[i];

            }

        }
        System.out.printf("%s\t%.3f $\n","Total:",sum);

        orderOfTables[tableid]=null;

    }

    public order[] getOrderOfTables() {
        return orderOfTables;
    }

    public void setOrderOfTables(order[] orderOfTables) {
        this.orderOfTables = orderOfTables;
    }
}
