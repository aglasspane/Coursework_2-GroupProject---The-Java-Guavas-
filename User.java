//The user class stores all information for the User that is needed to calculate
//The calories and the BMR

public class User {
    //Stores Users full name
    private String name;
    //Users age
    private int age;
    //Users weight
    private int weight;
    //Users Height
    private int height;

    public User (String name, int age, int weight, int height) {
        //Creates an Object of the User
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    //Returns users name
    public String getname() {
        return name;
    }
    //Returns users age
    public int getage() {
        return age;
    }
    //Returns users weight
    public int getweight() {
        return weight;
    }
    //Returns users height
    public int getheight() {
        return height;
    }

}
