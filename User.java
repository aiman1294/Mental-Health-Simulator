package Mental_Health_Simulation_Assistant;

import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<String>moodHistory;
    public User(String name){
        this.name = name;
        this.moodHistory = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void addMoodHistory(String currentMood){
        moodHistory.add(currentMood);
    }
    public ArrayList<String> moodHistory(){
        return moodHistory;
    }

}
