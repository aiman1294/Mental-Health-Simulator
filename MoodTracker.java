package Mental_Health_Simulation_Assistant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class MoodTracker {
    private static final List<String> validMoods = Arrays.asList(
            "HAPPY", "CALM", "GRATEFUL", "MOTIVATED", "CONFIDENT", "CONTENT",
            "TIRED", "BORED", "OVERWHELMED", "RESTLESS", "CONFUSED", "MEH",
            "SAD", "ANXIOUS", "ANGRY", "LONELY", "FRUSTRATED", "DISCOURAGED",
            "PANICKED", "HOPELESS", "IRRITATED", "NUMB", "BURNT_OUT"
    );

    public String askMood(Scanner sc, User user) {
        System.out.println("Hey " + user.getName() + "! How are you feeling today?");
//        System.out.println
//                ("HAPPY, CALM, GRATEFUL, MOTIVATED, CONFIDENT, CONTENT," +
//                        "TIRED, BORED, OVERWHELMED, RESTLESS, CONFUSED, MEH," +
//                        "SAD, ANXIOUS, ANGRY, LONELY, FRUSTRATED, DISCOURAGED," +
//                        "PANICKED, HOPELESS, IRRITATED, NUMB, BURNT_OUT");
        System.out.println(validMoods);

        while (true) {
            System.out.print("Your mood: ");
            String mood = sc.nextLine().trim().toUpperCase();

            if (validMoods.contains(mood)) {
                return mood;
            }
            System.out.println("Invalid mood. Please choose from the list above.");
        }
    }
}
