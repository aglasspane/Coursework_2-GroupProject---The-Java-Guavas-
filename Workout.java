//This class creates a workout session with the duration and type of workout
public class Workout {

    //The name of the exercise
    private String exercise;


    //Duration of the exercise in minutes
    private int duration;

    public Workout (String exercise, int duration) {
        //Makes an object with the exercise and duration
        this.exercise = exercise;
        this.duration = duration;
    }
    //Returns the name of the exercise
    public String getexercise() {
        return exercise;
    }
    //Returns the duration of the exercise
    public int getduration() {
        return duration;
    }
}
