package pack;

import java.util.HashMap;
import java.util.Map;

public class Tracker {
	
	private static final Map <String, Double> MetMap = new HashMap <>();
	static {
		 
		MetMap.put("Walking", 2.0);
		MetMap.put("Weight lifting", 3.0);
		MetMap.put("Calisthenics", 3.8);
		MetMap.put("Cycling", 5.8);
		MetMap.put("Swimming", 7.0);
		MetMap.put("Martial arts", 10.0);
		MetMap.put("Running", 11.0);
		
	}
	
	public static double calculatecalories (User User, Workout Workout ) {
		
		String metvaluestring = Workout.getexercise();
		double metValue = MetMap.getOrDefault(metvaluestring,1.0);
		double durationhours = Workout.getduration() / 60.0;
		
		return metValue * User.getweight() * durationhours;
	}
	
	public static double calculatebmr(User User) {
		double bmr = 0.0;
		int age = User.getage();
		int weight = User.getweight();
		int height = User.getheight();
		return bmr + weight * 10 + 6.25 * height - 5 * age;
		
	}
	
	public static String[] getMetMapKeys() {
	    return MetMap.keySet().toArray(new String[0]);
	}
	
	}


