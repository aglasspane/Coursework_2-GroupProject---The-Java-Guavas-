public class User {

    private String name;
    private int age;
    private int weight;
    private int height;
    private String gender;

    public User (String name, int age, int weight, int height, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }
    public String getgender() {
    	return gender;
    }

    public int getweight() {
        return weight;
    }

    public int getheight() {
        return height;
    }

}
