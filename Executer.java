package Mental_Health_Simulation_Assistant;

import java.util.Scanner;

public class Executer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        String name = sc.nextLine();
        User user = new User(name);
        Assistant assistant = new Assistant (user);

        while(true){
            System.out.println("Check-in Menu");
            System.out.println("1. Start a Session");
            System.out.println("2. Show Mood History");
            System.out.println("3. Terminate the Session");

            String ch = sc.nextLine();

            switch (ch){
                case "1":
                    assistant.startSession(sc);
                    break;
                case "2":
                    assistant.showMoodHistory();
                    break;
                case "3":
                    System.out.println("Hope you had a great session!");
                    return;
                default:
                    System.out.println("Invalid input, try again.");
                    break;
            }
        }
    }
}
