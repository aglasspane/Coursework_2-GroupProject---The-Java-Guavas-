import java.util.HashMap;
import java.util.Map;
//The Tracker class is used to track and calculate BMR and Calories burned

public class Tracker {
    //This is a map to store MET (Metabolic Equivalent of Task) values of specific tasks
//MET represents the rate of expenditures of energy during specific activities
//They are used to estimate calories burned per minute per kilo of body weight
        private static final Map<String, Double> MetMap = new HashMap<>();
        static {
//These values are the MET value for each specific activity
            MetMap.put("Walking", 2.0);
            MetMap.put("Weight lifting", 3.0);
            MetMap.put("Calisthenics", 3.8);
            MetMap.put("Cycling", 5.8);
            MetMap.put("Swimming", 7.0);
            MetMap.put("Martial arts", 10.0);
            MetMap.put("Running", 11.0);

        }

        public static double calculatecalories (User User, Workout Workout ) {

            //Used to get the name of the exercise from the workout object
            String metvaluestring = Workout.getexercise();
            //Get the MET value for given exercise, it will default to 1.0 if it's not found
            double metValue = MetMap.getOrDefault(metvaluestring,1.0);
            //This converts the duration that the user inputs into hours
            double durationhours = Workout.getduration() / 60.0;
            //Calculates and returns the calories burned
            return metValue * User.getweight() * durationhours;
        }

        public static double calculatebmr(User User) {
            double bmr = 0.0;
            //Retrieves the users data
            int age = User.getage();
            int weight = User.getweight();
            int height = User.getheight();

            //Calculates the BMR of the user based on what the user enters
            return bmr + weight * 10 + 6.25 * height - 5 * age;

        }
        //Converts the keys from the MET map to a string array then return it
        public static String[] getMetMapKeys() {
            return MetMap.keySet().toArray(new String[0]);
        }

    }
