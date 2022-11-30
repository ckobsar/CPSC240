import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz extends JFrame implements ActionListener {
    private String fileName;
    private static ArrayList<State> quiz;
    static JLabel counterLabel = new JLabel("\tCorrect: ");
    static int counter = 0;
    static JPanel mainPanel = new JPanel();
    static JPanel stateContainer = new JPanel();
    static JLabel questionLabel = new JLabel("What is the Capitol of: " + quiz.get(0).getStateName());

    // 50 state buttons in an array
    static JButton[] states = new JButton[50];

    // here are the four choices that each state has
    static JButton choice1 = new JButton(quiz.get(0).getChoice1());
    static JButton choice2 = new JButton(quiz.get(0).getChoice2());
    static JButton choice3 = new JButton(quiz.get(0).getChoice3());
    static JButton choice4 = new JButton(quiz.get(0).getChoice4());

    // scroll the 50 states horizontally
    static JScrollPane scrollPane = new JScrollPane(stateContainer);
    

    public Quiz(String fileName){
        File file = new File("stateslist.txt");
        this.fileName = fileName;
        try{
            Scanner in = new Scanner(file);
            quiz = new ArrayList<>();
            while (in.hasNextLine()){
                quiz.add(new State(in));
                in.nextLine();
                
            }
        }
        catch (Exception stateReadError){
            stateReadError.printStackTrace();
        }
    }

    public static JLabel getQuestionLabel() {
        return questionLabel;
    }
    // set where the scroll pane will be on the main panel            
        scrollPane.setBounds(10, 20, 360, 60);
    // set where the question label will sit inside the main panel
        questionLabel.setBounds(50, 105, 300, 40);
    //set the postion for the choices
        choice1.setBounds(50, 160, 200, 40);
        choice2.setBounds(50, 200, 200, 40);
        choice3.setBounds(50, 240, 200, 40);
        choice4.setBounds(50, 280, 200, 40);
    // setting position of counter label
        counterLabel.setBounds(10, 360, 300, 40);
    // add all components to the main panel
        mainPanel.add(counterLabel);
        mainPanel.add(questionLabel);
        mainPanel.add(choice1);
        mainPanel.add(choice2);
        mainPanel.add(choice3);
        mainPanel.add(choice4);
    
    // add scroll to the main panel
        mainPanel.add(scrollPane);
    
    //add mainpanel to frame itself so you can see
        add(mainPane);
    //setting the size of the window
        setSize(400, 500);
    //making sure that the red x works on to close window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //setting visible for the frame, otherwise you see nothing
        setVisible(true);
    
    public double userResults(){
        return 0.0;
    }
    public void userScore(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}





