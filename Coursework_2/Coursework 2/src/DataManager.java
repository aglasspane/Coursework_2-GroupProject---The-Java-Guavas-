
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.BufferedReader;

public class DataManager {

    public static void saveuser(User user, JFrame mainframe) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(user.getname() + " Fitness tracker.txt"))) {

            writer.write(user.getname());
            writer.newLine();
            writer.write(String.valueOf(user.getage()));
            writer.newLine();
            writer.write(String.valueOf(user.getweight()));
            writer.newLine();
            writer.write(String.valueOf(user.getheight()));
            writer.newLine();

            JOptionPane.showMessageDialog(mainframe, "User " + user.getname() + " saved successfully!");
        }

        catch (IOException ex) {
            JOptionPane.showMessageDialog(mainframe, "Error saving user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static User loaduser(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name = reader.readLine();
            int age = Integer.parseInt(reader.readLine());
            int weight = Integer.parseInt(reader.readLine());
            int height = Integer.parseInt(reader.readLine());

            return new User(name, age, weight, height); }

        catch (IOException e ) {
            return null;
        }
        catch (NumberFormatException e) {
            return null;
        }
    }

    public static void newuser(JTextField nameField, JTextField ageField, JTextField weightField, JTextField heightField, JTextField durationField,
                               JLabel calorieLabel, JLabel bmrLabel)
    {
        nameField.setText("");
        ageField.setText("");
        weightField.setText("");
        heightField.setText("");
        durationField.setText("");

        bmrLabel.setText("BMR: ");
        calorieLabel.setText("Calories burned: ");
    }
}
