import java.util.ArrayList;

abstract class Employees{
    private String name;
    private int id;
    Employees(String name, int id){
       this.name=name;
       this.id=id;
    }
    public String getname(String name){
        return name;
    }
    public int getid(int id){
        return id;
    }
   public abstract double calculateSalary();
   @Override
   public String toString(){
    return "Employee[name="+ name+" ,id="+id+", salary="+calculateSalary()+"]";
    
   }
}
class FullTimeEmployee extends Employees{
    private double monthSalary;
    public FullTimeEmployee(String name, int id,double d){
        super(name,id);
        this.monthSalary=d;

    }
    @Override
   public  double calculateSalary(){
     return monthSalary;
      
    }
}
class PartTimeEmployee extends Employees{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name, int id, int hoursWorked,int hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hoursWorked;
    }
        @Override
         public double calculateSalary(){
            return hoursWorked*hourlyRate;
        }
    }
class PayRoleSystem{
    private static ArrayList<Employees> employeList;
   public PayRoleSystem() {
    employeList= new ArrayList<>();
   }
   public static void addEmployee(Employees employee){
    employeList.add(employee);
   }
   public static void removeEmployee(int id){
     Employees employeeToremove= null;
     for(Employees employee:employeList){
        if(employee.getid(id)==id){
            employeeToremove=employee;
            break;
        }
     }
     if(employeeToremove !=null){
        employeList.remove(employeeToremove);
     }
   }
   public static void displayEmployees(){
    for (Employees employee: employeList){
        System.out.println(employee);
    }
   }
}




public class Main{
    public static void main(String[] args) {
        PayRoleSystem payrole= new PayRoleSystem();
        FullTimeEmployee emp1= new FullTimeEmployee("Rahul", 1, 70000.0);
        PartTimeEmployee emp2= new PartTimeEmployee("vikash", 2, 5, 200);
        PayRoleSystem.addEmployee(emp1);
        PayRoleSystem.addEmployee(emp2);
        System.out.println("Initial employe details");
        PayRoleSystem.displayEmployees();
        System.out.println("removing employee");
        PayRoleSystem.removeEmployee(2);
        System.out.println("display remaining employee");
        PayRoleSystem.displayEmployees();

        
        
        
    }
}