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
    public double userResults(){
        return 0.0;
    }
    public void userScore(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}





