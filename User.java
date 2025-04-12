public class User {

    private String name;
    private int age;
    private int weight;
    private int height;

    public User (String name, int age, int weight, int height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    public int getweight() {
        return weight;
    }

    public int getheight() {
        return height;
    }

}
