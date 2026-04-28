package Mental_Health_Simulation_Assistant;

import javax.swing.*;
import java.awt.*;

public class AssistantUI {

    private JButton historyButton;
    private JFrame frame;
    private JTextField nameField;
    private JComboBox<String> moodBox;
    private JTextArea outputArea;
    private JButton startButton;
    private JButton moodButton;
    private JButton breathingButton;

    private User user;
    private Assistant assistant;

    public AssistantUI(){

        frame = new JFrame("Mental Health Assistant");
        frame.setSize(700,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Mental Health Assistant");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        titlePanel.add(titleLabel);

        frame.add(titlePanel, BorderLayout.NORTH);
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();


        topPanel.setLayout(new FlowLayout());
        middlePanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new FlowLayout());

        JLabel title = new JLabel("Mental Health Assistant");
        title.setFont(new Font("Arial", Font.BOLD, 28));

        topPanel.add(title);

        nameField = new JTextField(15);
        String[] moods = {
                "How do you feel?",
                "HAPPY","CALM","GRATEFUL","MOTIVATED","CONFIDENT","CONTENT",
                "TIRED","BORED","OVERWHELMED","RESTLESS","CONFUSED","MEH",
                "SAD","ANXIOUS","ANGRY","LONELY","FRUSTRATED","DISCOURAGED",
                "PANICKED","HOPELESS","IRRITATED","NUMB","BURNT_OUT"
        };

        moodBox = new JComboBox<>(moods);
        moodBox.setSelectedIndex(0);

        startButton = new JButton("Start");
        moodButton = new JButton("Submit Mood");
        historyButton = new JButton("Show Mood History");
        breathingButton = new JButton("Breathing Exercise");
        frame.add(historyButton);
        frame.add(breathingButton);
        historyButton.addActionListener(e -> {

            if(user == null){
                outputArea.append("Please start a session first.\n\n");
                return;
            }

            if(user.moodHistory().isEmpty()){
                outputArea.append("No moods logged yet.\n\n");
                return;
            }

            outputArea.append("Mood History:\n");

            for(String mood : user.moodHistory()){
                outputArea.append(mood + "\n");
            }

            outputArea.append("\n");
        });

        breathingButton.addActionListener(e -> {

            outputArea.append("Let's try a breathing exercise.\n");

            for(int i = 0; i < 3; i++){
                outputArea.append("Breathe in...\n");
                outputArea.append("Hold...\n");
                outputArea.append("Breathe out...\n");
            }

            outputArea.append("I hope it helps you feel calmer.\n\n");
        });

        outputArea = new JTextArea(10,30);
        outputArea.setEditable(false);
        outputArea.setText("Hello! I'm your Mental Health Assistant.\n");
        outputArea.append("Please enter your name to start a session.\n\n");

        middlePanel.add(new JLabel("Enter your name:"));
        middlePanel.add(nameField);
        middlePanel.add(startButton);

        middlePanel.add(new JLabel("Enter your mood:"));
        middlePanel.add(moodBox);
        middlePanel.add(moodButton);
        middlePanel.add(historyButton);
        middlePanel.add(breathingButton);
        moodButton.addActionListener(e -> {

            String mood = (String) moodBox.getSelectedItem();

            if("How do you feel?".equals(mood)){
                outputArea.append("Please select a mood first.\n\n");
                return;
            }

            user.addMoodHistory(mood);

            QuoteProvider qp = new QuoteProvider();

            outputArea.append("Mood logged: " + mood + "\n");

            if(mood.equals("SAD") || mood.equals("LONELY") || mood.equals("HOPELESS")){
                outputArea.append("I'm sorry you're feeling that way. You're not alone.\n");
            }
            else if(mood.equals("ANXIOUS") || mood.equals("OVERWHELMED")){
                outputArea.append("Let's slow things down together.\n");
            }
            else if(mood.equals("HAPPY") || mood.equals("GRATEFUL") || mood.equals("CONFIDENT")){
                outputArea.append("That's wonderful to hear! Keep that energy going.\n");
            }
            else{
                outputArea.append("Thanks for sharing how you feel.\n");
            }

            outputArea.append("Quote: " + qp.getRandomQuote() + "\n\n");
            outputArea.append("You can try the breathing exercise button if you'd like.\n");
            moodBox.setSelectedIndex(0);   // reset dropdown
        });

        //bottomPanel.add(new JScrollPane(outputArea));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(350,150));
        bottomPanel.add(scrollPane);

        startButton.addActionListener(e -> {

            String name = nameField.getText();

            user = new User(name);
            assistant = new Assistant(user);

            outputArea.setText("Hello " + user.getName() + "! Welcome.\n");
        });
        frame.setLocationRelativeTo(null);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new AssistantUI();
    }
}
