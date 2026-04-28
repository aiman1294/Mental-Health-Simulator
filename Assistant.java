package Mental_Health_Simulation_Assistant;

import java.util.Scanner;
public class Assistant {
    private User user;
    private CalmActivity ca;
    private QuoteProvider qp;
    private MoodTracker mt;

    Assistant(User user){
        this.user = user;
        ca = new CalmActivity();
        qp = new QuoteProvider();
        mt = new MoodTracker();
    }

    public void startSession(Scanner sc){
        String mood = mt.askMood(sc, user);
        System.out.println("Logging the mood history");
        user.addMoodHistory(mood);
        if(mood.equals("SAD") || mood.equals("LONELY") || mood.equals("HOPELESS")){
            System.out.println("I'm sorry you're feeling that way. You're not alone.");
        }

        else if(mood.equals("ANXIOUS") || mood.equals("OVERWHELMED")){
            System.out.println("Let's slow things down together.");
        }

        else if(mood.equals("HAPPY") || mood.equals("GRATEFUL") || mood.equals("CONFIDENT")){
            System.out.println("That's wonderful to hear! Keep that energy going.");
        }

        else{
            System.out.println("Thanks for sharing how you feel.");
        }

        qp.getRandomQuote();
        System.out.println("Here is something for you:");
        System.out.println(qp.getRandomQuote());

        System.out.println("Would you like to try a breathing exercise?");
        String ans = sc.nextLine().trim().toLowerCase();

        if(ans.equals("yes")){
            ca.breathingExercise();
        }
        else if(ans.equals("no")){
            System.out.println("That's okay. Here is a quote instead:");
            System.out.println(qp.getRandomQuote());
        }
        else{
            System.out.println("Invalid choice. Showing a quote instead:");
            System.out.println(qp.getRandomQuote());
        }
        System.out.println("Thank you for initiating this session!");
    }

    public void showMoodHistory(){
        if(user.moodHistory().isEmpty()){
            System.out.println("You have not logged any moods yet.");
            return;
        }

        System.out.println("Your mood history:");
        for(String mood : user.moodHistory()){
            System.out.println(mood);
        }
        System.out.println();
    }
}
