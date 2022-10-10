package ai221.shevchenko;

/**
 * Contains information about a person
 *
 * @author Keiichi-Kun
 * @version openjdk-19 10 Oct 2022
 */
class Person {
    private String name;
    private String surname;
    private int age;

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getAge(){
        return age;
    }

    public void setName(String name){
         if(name.matches("[a-zA-Z]{1,20}")){
             this.name = name;
         }
    }
    public void setSurname(String surname){
        if(surname.matches("[a-zA-Z]{1,25}")){
            this.surname = surname;
        }
    }
    public void setAge(int age){
        if(age > 1 && age < 99){
            this.age = age;
        }
    }

    public void printInfo(){
        System.out.println("Person " + name  + " " + surname + ", age: " + age);
    }
}
