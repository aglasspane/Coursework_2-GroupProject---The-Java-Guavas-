import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class GUI {

    private JFrame mainframe;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField weightField;
    private JTextField heightField;
    private JTextField durationField;

    private JLabel bmrLabel;
    private JLabel calorieLabel;

    public GUI() {

        run();

    }

    private void run() {

        mainframe = new JFrame();
        mainframe.setTitle("FITNESS TRACKER");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(800,400);
        mainframe.setLayout(new BorderLayout());

        JPanel formpanel = new JPanel(new GridLayout(7, 2, 2, 2));
        formpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel calcbuttonpanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        JPanel userbuttonpanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));

        mainframe.add(formpanel, BorderLayout.CENTER);
        mainframe.add(userbuttonpanel, BorderLayout.NORTH);
        mainframe.add(calcbuttonpanel, BorderLayout.SOUTH);

        nameField = new JTextField();
        ageField = new JTextField();
        weightField = new JTextField();
        heightField = new JTextField();
        durationField = new JTextField();

        calorieLabel = new JLabel("Calories burned: ");
        bmrLabel = new JLabel("BMR: ");

        String[] exercises = Tracker.getMetMapKeys();
        Arrays.sort(exercises);
        JComboBox<String> exerciseDropdown = new JComboBox<>(exercises);

        JButton calculatecaloriesButton = new JButton("Calculate calories burnt");
        JButton calculatebmrButton = new JButton("Calculate BMR");

        JButton saveuserbutton = new JButton("Save user");
        JButton loaduserbutton = new JButton("Load previous");
        JButton newuserbutton = new JButton("New user");

        formpanel.add(new JLabel("Name: "));
        formpanel.add(nameField);
        formpanel.add(new JLabel("Age: "));
        formpanel.add(ageField);
        formpanel.add(new JLabel("Weight (KG):"));
        formpanel.add(weightField);
        formpanel.add(new JLabel("Height (CM)"));
        formpanel.add(heightField);

        formpanel.add(new JLabel("Exercise:"));
        formpanel.add(exerciseDropdown);
        formpanel.add(new JLabel("Duration (Minutes):"));
        formpanel.add(durationField);
        formpanel.add(calorieLabel);
        formpanel.add(bmrLabel);

        calcbuttonpanel.add(calculatecaloriesButton);
        calcbuttonpanel.add(calculatebmrButton);

        userbuttonpanel.add(saveuserbutton);
        userbuttonpanel.add(loaduserbutton);
        userbuttonpanel.add(newuserbutton);

        calculatecaloriesButton.addActionListener(e -> {

            try {

                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                int weight = Integer.parseInt(weightField.getText());
                int height = Integer.parseInt(heightField.getText());
                String exercise = (String) exerciseDropdown.getSelectedItem();
                int duration = Integer.parseInt(durationField.getText());

                User user = new User(name,age,weight,height);
                Workout workout = new Workout(exercise, duration);

                double calories = Tracker.calculatecalories(user, workout);
                calorieLabel.setText("Calories burnt: " + String.format("%.2f", calories) + " Kcals per hour");
            }
            catch (Exception ex)

            {

                JOptionPane.showMessageDialog(mainframe, "Please enter valid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        calculatebmrButton.addActionListener(e -> {

                    try {
                        String name = nameField.getText();
                        int age = Integer.parseInt(ageField.getText());
                        int weight = Integer.parseInt(weightField.getText());
                        int height = Integer.parseInt(heightField.getText());

                        User user = new User(name, age, weight, height);

                        double bmr = Tracker.calculatebmr(user);
                        bmrLabel.setText("Your BMR is : " + String.format("%.2f", bmr) + " Kcals per day");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(mainframe, "Please enter valid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });

            saveuserbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e) {

                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    int weight = Integer.parseInt(weightField.getText());
                    int height = Integer.parseInt(heightField.getText());

                    User user = new User(name, age, weight, height);
                    DataManager.saveuser(user, mainframe);

                }
            });

            loaduserbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e) {
                    JFileChooser selectfile = new JFileChooser();

                    int result = selectfile.showOpenDialog(mainframe);

                    if (result == JFileChooser.APPROVE_OPTION) {
                        File chosenfile = selectfile.getSelectedFile();
                        User loadeduserfile = DataManager.loaduser(chosenfile);

                        if (loadeduserfile != null) {
                            nameField.setText(loadeduserfile.getname());
                            ageField.setText(String.valueOf(loadeduserfile.getage()));
                            weightField.setText(String.valueOf(loadeduserfile.getweight()));
                            heightField.setText(String.valueOf(loadeduserfile.getheight()));

                            JOptionPane.showMessageDialog(mainframe, "User data loaded successfully!");
                        } else {
                            JOptionPane.showMessageDialog(mainframe, "Failed to load user data.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

            newuserbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DataManager.newuser(nameField,ageField,weightField,heightField,durationField,calorieLabel,bmrLabel);
                }
            });

        mainframe.setVisible(true);

    }


    public static void main(String[] args) {

        new GUI();

    }
}
