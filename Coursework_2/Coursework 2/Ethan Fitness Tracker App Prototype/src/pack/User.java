package pack;

import javax.swing.JTextField;

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
	
	public String getuserinfo() {
		return name + age + weight + height;
	}
	
	    public static User getuserinput(JTextField nameField, JTextField ageField, JTextField weightField, JTextField heightField) {
	    String name = nameField.getText();
	    int age = Integer.parseInt(ageField.getText());
	    int weight = Integer.parseInt(weightField.getText());
	    int height = Integer.parseInt(heightField.getText());
	    
	    return new User(name, age, weight, height); 
	}
}
	
	
