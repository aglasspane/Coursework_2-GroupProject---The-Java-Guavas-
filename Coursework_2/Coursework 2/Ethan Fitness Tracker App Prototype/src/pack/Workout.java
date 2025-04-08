package pack;

public class Workout {
	
	private String exercise;
	private int duration;

	public Workout (String exercise, int duration) {
		this.exercise = exercise;
		this.duration = duration;
	}

public String getexercise() {
	return exercise;
}

public int getduration() {
	return duration;
}

public void getuserworkout() {
	System.out.println("\nWorkout: " + exercise + "\nDuration: " + duration + " minutes");
}

}


