package ai221.shevchenko;

/**
 * Contains information about a Lecturer
 *
 * @author Keiichi-Kun
 * @version openjdk-19 10 Oct 2022
 */
public class Lecturer extends Person{
    private String department;
    private double salary;

    public String getDepartment(){
        return department;
    }
    public double getSalary(){
        return salary;
    }

    public void setDepartment(String department){
        if(department.matches("[a-zA-Z]{5,50}")){
            this.department = department;
        }
    }
    public void setSalary(double salary){
        if(salary > 0 && salary < 999999){
            this.salary = salary;
        }
    }

    public  void printInfo(){
        System.out.println("Lecturer at the cathedra: " + getName() + " " + getSurname() +
                ", age: " + getAge() + ". Salary: " + salary);
    }
}
