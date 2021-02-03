import javax.jws.soap.SOAPBinding;

public class employerManager {
    private employer[] employerlist= new employer[5];

    public void addEmployer(int count,String name,double salary){
        this.employerlist[count] = new employer(name,salary);
    }

    public void printall(int count){
        int i;
        for (i=0;i<count;i++){
            System.out.println(employerlist[i].getName()+ "  " +employerlist[i].getSalary());
        }
    }
    public boolean whichEmployer(String newemployer){
        int i,j;

        for(i=0;i<5;i++){
            if(employerlist[i]==null){
                continue;
            }
            else if(employerlist[i].getName().equals(newemployer)){
                j=employerlist[i].getTablesCreated();
                employerlist[i].setTablesCreated(j+1);
                if (j==2){
                    return false;
                }
                else if(j<2){
                    employerlist[i].setTablesCreated(j+1);
                    return true;
                }
            }
        }
        return false;
    }


    public int isEmployer(int count,String employername){
        int i;
        for(i=0;i<count;i++){
            if (employerlist[i].getName().equals(employername)==true){
                return 1;
            }
        }

        return 0;
    }

    public void getEmployerSalary(){
        int i;
        for(i=0;i<5;i++){
            if(employerlist[i]==null){
                continue;
            }
            else{
                double award,total;
                award=(employerlist[i].getSalary()*employerlist[i].getTablesCreated())/10;
                //System.out.println(employerlist[i].getSalary()+ " " +employerlist[i].getTablesCreated()+ " " +award);
                total= award + employerlist[i].getSalary();
                System.out.println("Salary for "+employerlist[i].getName()+": "+total);
            }
        }
    }


    public employer[] getEmployerlist() {
        return employerlist;
    }

    public void setEmployerlist(employer[] employerlist) {
        this.employerlist = employerlist;
    }
}
