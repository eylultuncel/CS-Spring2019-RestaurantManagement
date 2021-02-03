import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class items {
    private LinkedHashMap<String,Double> itemdict= new LinkedHashMap<String,Double>();
    public LinkedHashMap<String,Double> costdict= new LinkedHashMap<String, Double>();
    public String[] itemnames = new String[50];
    public double[] itemcosts = new double[50];

    public void addItem(String name,double number, double cost ,int index){
        itemdict.put(name,number);
        costdict.put(name,cost);
        itemnames[index]= name;
        itemcosts[index]=cost;
    }

    public boolean stock(String itemName){
        int i;
        if(itemdict.get(itemName)==null){
            System.out.println("There is no item in this name in the stock");
            return false;
        }
        itemdict.put(itemName,itemdict.get(itemName)-1);
        if (itemdict.get(itemName)<0){
            System.out.println( "Sorry! No "+itemName+" in the stock!");
            itemdict.put(itemName,itemdict.get(itemName)+1);
            return false;
        }
        return true;
    }

    public double cost(String item){
        return costdict.get(item);
    }

    public void printall(){
        for (Map.Entry m:itemdict.entrySet()){

            System.out.printf("%s\t%.0f\n",m.getKey()+":",m.getValue());
        }
    }

    public HashMap<String, Double> getItemdict() {
        return itemdict;
    }

    public void setItemdict(LinkedHashMap<String, Double> itemdict) {
        this.itemdict = itemdict;
    }

    public HashMap<String, Double> getCostdict() {
        return costdict;
    }

    public void setCostdict(LinkedHashMap<String, Double> costdict) {
        this.costdict = costdict;
    }
}
