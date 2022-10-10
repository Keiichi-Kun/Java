package ai221.shevchenko;

/**
 * Contains information about a student
 *
 * @author Keiichi-Kun
 * @version openjdk-19 10 Oct 2022
 */
public class Student extends Person{
    private String nameGroup;
    private int numberCard;

    public String getNameGroup(){
        return nameGroup;
    }
    public int getNumberCard(){
        return numberCard;
    }

    public void setNameGroup(String nameGroup){
        if(nameGroup.matches("[a-zA-Z]{2}-\\d{3}")){
            this.nameGroup = nameGroup;
        }
    }
    public void setNumberCard(int numberCard){
        if(numberCard > 1000 && numberCard < 9999){
            this.numberCard = numberCard;
        }
    }

    public  void printInfo(){
        System.out.println("Student of group: " + nameGroup + ". " +
                getName() + " " + getSurname() + ", age: " + getAge());
        System.out.println("Number of the Student`s card: " + numberCard);
    }
}
