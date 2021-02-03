public class employer {
    private String name;
    private double salary;
    private int tablesCreated;

    public employer(String name,double salary){
        this.name=name;
        this.salary=salary;
        this.setTablesCreated(0);
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

    public int getTablesCreated() {
        return tablesCreated;
    }

    public void setTablesCreated(int tablesCreated) {
        this.tablesCreated = tablesCreated;
    }
}
