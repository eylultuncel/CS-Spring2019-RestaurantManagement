import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Assignment2 {
    public static void main(String[] args) {
	// write your code here
        int count=0;
        restaurant myrestaurant = new restaurant();

        List<String> setup =  new ArrayList<String>();
        Scanner scanner = null;
        try { scanner = new Scanner(new File("setup.dat"));
            while (scanner.hasNext()) {
                setup.add(scanner.nextLine());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (scanner != null) scanner.close();
        }
        
        int size= setup.size(),i,howmanyemployer=0,howmanywaiter=0,howmanyitem=0;
        for (i=0;i<size;i++){
            String str;
            str= setup.get(i);
            String[] twopieces = str.split(" ");

            if (twopieces[0].equals("add_item")){
                String[] iteminfo = twopieces[1].split(";");
                double cost = new Double(iteminfo[1]).doubleValue()  ;
                double number = new Double(iteminfo[2]).doubleValue()  ;
                myrestaurant.add_item(iteminfo[0],number,cost,howmanyitem);
                howmanyitem++;
            }
            else if (twopieces[0].equals("add_employer")) {
                if (howmanyemployer>=5){
                    System.out.println("MAXIMUM NUMBER OF EMPLOYER");
                }
                else {
                    String[] employerinfo = twopieces[1].split(";");
                    double salary = new Double(employerinfo[1]).doubleValue();
                    myrestaurant.add_employer(howmanyemployer, employerinfo[0], salary);
                    howmanyemployer++;
                }
            }
            else if (twopieces[0].equals("add_waiter"))   {
                if (howmanywaiter>=5){
                    System.out.println("MAXIMUM NUMBER OF EMPLOYER");
                }
                else {
                    String[] waiterinfo = twopieces[1].split(";");
                    double salary = new Double(waiterinfo[1]).doubleValue();
                    myrestaurant.add_waiter(howmanywaiter, waiterinfo[0], salary);
                    howmanywaiter++;
                }
            }
        }

        List<String> commands =  new ArrayList<String>();
        Scanner scanner1 = null;

        try { scanner1 = new Scanner(new File("commands.dat"));
            while (scanner1.hasNext()) {
                commands.add(scanner1.nextLine());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (scanner1 != null) scanner1.close();
        }

        int sizeofcommands=commands.size();
        int howmanytable=0;
        for(i=0;i<sizeofcommands;i++){
            String str1;
            str1= commands.get(i);
            String[] twopiece = str1.split(" ");

            if (twopiece[0].equals("create_table")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: create_table");
                String[] tableinfo = twopiece[1].split(";");
                double capacity = new Double(tableinfo[1]).doubleValue();
                if(myrestaurant.create_table(howmanytable,capacity,tableinfo[0],howmanyemployer)==true){
                    howmanytable++;
                }
            }
            else if (twopiece[0].equals("new_order")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: new_order");
                String[]orderinfo = twopiece[1].split(";");
                int num = Integer.parseInt(orderinfo[1]);
                String[] orderslist = orderinfo[2].split(":");
                myrestaurant.newOrder(orderinfo[0],num,orderslist);
            }
            else if (twopiece[0].equals("add_order")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: add_order");
                String[] orderinfo = twopiece[1].split(";");
                int tableid= Integer.parseInt(orderinfo[1]);
                String [] orderslist= orderinfo[2].split(":");
                myrestaurant.addOrder(orderinfo[0],tableid,orderslist);
            }
            else if (twopiece[0].equals("check_out")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: check_out");
                String[] tableinfo = twopiece[1].split(";");
                int num = Integer.parseInt(tableinfo[1]);
                myrestaurant.checkOut(tableinfo[0],num);
            }
            else if (twopiece[0].equals("stock_status")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: stock_status");
                myrestaurant.printallitems();
            }
            else if (twopiece[0].equals("get_order_status")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: get_order_status");
                myrestaurant.getOrderStatus();
            }
            else if (twopiece[0].equals("get_employer_salary")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: get_employer_salary");
                myrestaurant.getEmployerSalary();
            }
            else if (twopiece[0].equals("get_waiter_salary")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: get_waiter_salary");
                myrestaurant.getWaiterSalary();
            }
            else if (twopiece[0].equals("get_table_status")){
                System.out.println("***********************************");
                System.out.println("PROGRESSING COMMAND: get_table_status");
                myrestaurant.getTableStatus();
            }
        }
    }
}
