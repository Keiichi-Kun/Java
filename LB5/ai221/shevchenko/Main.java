package ai221.shevchenko;

/**
 * creates a database of university staff
 *
 * @author Keiichi-Kun
 * @version openjdk-19 10 Oct 2022
 */
public class Main {

    public static void main(String[] args) {
        Student student1 =  new Student();
        student1.setName("Sasha");
        student1.setSurname("Shevchenko");
        student1.setAge(12);
        student1.setNameGroup("CS-221");
        student1.setNumberCard(2134);

        Student student2 =  new Student();
        student2.setName("Vlad");
        student2.setSurname("Taranov");
        student2.setAge(17);
        student2.setNameGroup("CS-122");
        student2.setNumberCard(7854);

        Student student3 =  new Student();
        student3.setName("Elena");
        student3.setSurname("Akulova");
        student3.setAge(16);
        student3.setNameGroup("IS-411");
        student3.setNumberCard(1222);

        Lecturer lectuer1 =  new Lecturer();
        lectuer1.setName("Misha");
        lectuer1.setSurname("Aksenchuk");
        lectuer1.setAge(45);
        lectuer1.setSalary(450);
        lectuer1.setDepartment("Administrative and Financial Law");

        Lecturer lectuer2 =  new Lecturer();
        lectuer2.setName("Nickita");
        lectuer2.setSurname("Abakumov");
        lectuer2.setAge(53);
        lectuer2.setSalary(520.50);
        lectuer2.setDepartment("Cyber Security");

        Person[] staffUniversity = new Person[5];
        staffUniversity[0] = student1;
        staffUniversity[1] = student2;
        staffUniversity[2] = student3;
        staffUniversity[3] = lectuer1;
        staffUniversity[4] = lectuer2;
        for(int i = 0; i < 5; ++i){
            staffUniversity[i].printInfo();
            System.out.print("\n");
        }
    }
}