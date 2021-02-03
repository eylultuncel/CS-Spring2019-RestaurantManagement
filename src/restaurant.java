public class restaurant {
    employerManager a = new employerManager();
    waiterManager b = new waiterManager();
    items c = new items();
    tableManager d = new tableManager();
    orderManager e = new orderManager();

    public void add_employer(int count, String name, double salary) {
        a.addEmployer(count, name, salary);
    }

    public void printallemployer(int count) {
        a.printall(count);
    }

    public void add_waiter(int count, String name, double salary) {
        b.addWaiter(count, name, salary);
    }

    public void printallwaiter(int count) {
        b.printall(count);
    }

    public void add_item(String name, double number, double cost,int howmanyitem) {
        c.addItem(name, number, cost,howmanyitem);
    }

    public void printallitems() {
        c.printall();
    }

    public boolean create_table(int id, double capacity, String whoCreates, int sumofemployers) {
        if (a.isEmployer(sumofemployers, whoCreates) == 0) {
            System.out.println("There is no employer named "+whoCreates);
        } else if (d.howManyTablesExist() >= 5) {
            System.out.println("Not allowed to exceed max. number of tables 5");
        } else if (a.whichEmployer(whoCreates) == false) {
            System.out.println(whoCreates + " has already created 2 tables");
        } else {
            d.createTable(id, capacity, whoCreates);
            System.out.println("A new table has successfully been added");
            return true;
        }
        return false;
    }

    public void printalltables(int count) {
        d.printall(count);
    }

    public boolean newOrder(String waiter, int personNum, String orderslist[]) {
        int tableId;
        if (b.isWaiter(waiter) == true) {
            tableId = d.searchTables(personNum, waiter);
            if (tableId == -1) {
                System.out.println("There is no appropriate table for this order!");
            } else {
                System.out.println("Table (= ID " + tableId+") has been taken into service");
                b.addTable(waiter, tableId);
                e.addTable(tableId);
                if(e.incrementOrdercount(tableId)==false){
                    return false;
                }
                int ordercount, i, j;
                ordercount = orderslist.length;
                for (i = 0; i < ordercount; i++) {
                    String[] oneorder = orderslist[i].split("-");
                    int numofİtem = Integer.parseInt(oneorder[1]);
                    for (j = 0; j < numofİtem; j++) {
                        if (c.stock(oneorder[0]) == true) {
                            e.addOrder(tableId, oneorder[0]);
                        }
                    }
                }
            }
        }
        return true;
    }


    public void addOrder(String waiter, int tableid, String orderslist[]) {
        int i, ordercount, countingitems=0, j;

        if (b.isWaiter(waiter, tableid) == true) {
            if (e.ordermax(tableid) < 5) {
                if(e.incrementOrdercount(tableid)==false){
                    System.out.println("maximum number of orders");
                    return;
                }
                b.incrementOrderNum(waiter);
                ordercount = orderslist.length;
                for (i = 0; i < ordercount; i++) {
                    String[] oneorder = orderslist[i].split("-");
                    int numofİtem = Integer.parseInt(oneorder[1]);
                    for (j = 0; j < numofİtem; j++) {
                        if(countingitems>=10){
                            System.out.println("Not allowed to exceed max number of items per order.");
                            continue;
                        }
                        if (c.stock(oneorder[0]) == true && e.ordermax(tableid) < 5) {
                            countingitems++;
                            e.addOrder(tableid, oneorder[0]);
                        } else if (e.ordermax(tableid) >= 5) {
                            System.out.println("Not allowed to exceed max number of orders!");
                            break;
                        }

                    }
                }
            }
        }
    }


    public void getEmployerSalary(){
        a.getEmployerSalary();
    }

    public void getWaiterSalary(){
        b.getWaiterSalary();
    }

    public void checkOut(String waiterName,int tableid){
        if(b.isWaiter(waiterName,tableid)==true){
            e.checkOut(tableid,c);
            b.checkOut(tableid);
            d.checkOut(tableid);
        }
    }

    public void getTableStatus(){
        d.getTableStatus();
    }

    public void getOrderStatus(){
        e.getOrderStatus(d);
    }

}