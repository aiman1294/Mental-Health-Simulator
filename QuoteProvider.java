package Mental_Health_Simulation_Assistant;
import java.util.Random;
public class QuoteProvider {
    private static String quotes[] = {"You are allowed to grow at your own pace.",

            "Small progress is still progress.",
            "Your feelings are valid, even when they are messy.",

            "You survived one hundred percent of your worst days.",
            "Rest is productive too.",
            "You are becoming someone stronger than you were yesterday."};

    public String getRandomQuote(){
        Random rand = new Random();
        return quotes[rand.nextInt(quotes.length)];
    }
}
