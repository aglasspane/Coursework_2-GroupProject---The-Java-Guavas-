package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DataManager {
	
	public static void saveuser(User user, JFrame mainframe) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(user.getname()+".txt"))) 
		{
		   writer.write(user.getuserinfo());
		} 
		catch (IOException ex) {
			JOptionPane.showMessageDialog(mainframe, "Error saving user data!", "Error", JOptionPane.ERROR_MESSAGE);
		}

		}
	
	    public static User loaduser(User user, JFrame mainframe) {
	     
		 try (BufferedReader reader = new BufferedReader(new FileReader(user.getname()+".txt"))) 
		 
		{
			 String name = reader.readLine();
		     int age = Integer.parseInt(reader.readLine());
		     int weight = Integer.parseInt(reader.readLine());
		     int height = Integer.parseInt(reader.readLine());
		     
		     user = new User (name,age,weight,height);
		}
		 
		    catch (IOException ex) 
		{
            JOptionPane.showMessageDialog(mainframe, "Error loading user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		 
		return user;
		
	    }
	
        }
