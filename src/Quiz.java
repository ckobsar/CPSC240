import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz extends JFrame implements ActionListener {
    private List<State> states = new ArrayList<State>();
    private List<Question> questions;

    private int currentQuestion;

    private JPanel questionSelectPanel = new JPanel();

    private JLabel questionLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel correctLabel = new JLabel("", SwingConstants.CENTER);

    private JButton choice1 = new JButton();
    private JButton choice2 = new JButton();
    private JButton choice3 = new JButton();
    private JButton choice4 = new JButton();

    public static void main(String[] args) {
        // running the Quiz panel
        new Quiz();
    }

    // reads states (from a file?)
    private void readStates(String filename) throws FileNotFoundException {
        File text = new File(filename);
        Scanner in = new Scanner(text);

        while (in.hasNextLine()) {
            states.add(new State(in));
        }
    }

    // Regenerates questions
    public void generateQuestions() {
        this.questions = states
                .stream()
                .map(state -> new Question(this, state, states))
                .toList();

        // setup state buttons
        this.questionSelectPanel.removeAll();

        for (Question q : this.questions) {
            this.questionSelectPanel.add(q.getButton());
        }
    }

    // Writes new high score to a file
    public void writeHighScore(String filename, int score, String name) throws IOException {
        File text = new File(filename);
        text.createNewFile();

        // load high scores
        Scanner in = new Scanner(text);
        ArrayList<String> scores = new ArrayList<String>();
        while (in.hasNextLine()) {
            scores.add(in.nextLine());
        }

        in.close();

        // add new high score
        int place = scores.size();
        for (int i = 0; i < scores.size(); i++) {
            String[] line = scores.get(i).split("\\s+");

            int foundScore = Integer.parseInt(line[0]);

            if (foundScore < score) {
                place = i;
                break;
            }
        }

        scores.add(place, String.format("%d %s", score, name));

        // write to file
        FileWriter out = new FileWriter(text, false);

        for (String line : scores) {
            out.write(line + "\n");
        }

        out.flush();
        out.close();
    }

    //set the panel to null so that you postion components
    public Quiz(){
        // initialize states list first
        try {
            this.readStates("states.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Could not open states.txt for reading!");
            System.exit(1);
        }
        this.generateQuestions();

        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.add(questionLabel, BorderLayout.PAGE_START);

        JPanel choicesPanel = new JPanel(new FlowLayout());
        choicesPanel.add(choice1);
        choicesPanel.add(choice2);
        choicesPanel.add(choice3);
        choicesPanel.add(choice4);
        questionPanel.add(choicesPanel, BorderLayout.CENTER);

        JScrollPane questionScroll = new JScrollPane(questionSelectPanel);
        questionScroll.setMinimumSize(new Dimension(0, 60));
        questionScroll.setPreferredSize(new Dimension(500, 60));

        // default to first question
        this.changeQuestion(questions.get(0));

        // setup listeners
        choice1.addActionListener(this);
        choice2.addActionListener(this);
        choice3.addActionListener(this);
        choice4.addActionListener(this);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(questionScroll, BorderLayout.PAGE_START);
        //this.getContentPane().add(questionPanel, BorderLayout.PAGE_START);
        this.getContentPane().add(questionPanel, BorderLayout.CENTER);
        this.getContentPane().add(correctLabel, BorderLayout.PAGE_END);

        this.setSize(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void changeQuestion(Question q) {
        this.currentQuestion = this.questions.indexOf(q);

        questionLabel.setText("What is the capital of " + q.getState().getName() + "?");
        choice1.setText(q.getChoices()[0]);
        choice2.setText(q.getChoices()[1]);
        choice3.setText(q.getChoices()[2]);
        choice4.setText(q.getChoices()[3]);
    }

    public int numCorrect() {
        return (int) this.questions
                .stream()
                .filter(q -> q.getStatus() == Question.CORRECT)
                .count();
    }

    public int numAnswered() {
        return (int) this.questions
                .stream()
                .filter(q -> q.getStatus() != Question.UNANSWERED)
                .count();
    }

    public boolean completed() {
        return this.numAnswered() == this.questions.size();
    }

    public Question current() {
        return this.questions.get(this.currentQuestion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String answer = e.getActionCommand();

        if (this.current().getStatus() == Question.UNANSWERED) {
            if (this.current().getState().getCapitalName().equals(answer)) {
                this.current().setStatus(Question.CORRECT);
            } else {
                this.current().setStatus(Question.INCORRECT);
            }

            // update count
            this.correctLabel.setText("Correct: " + this.numCorrect());

            // move onto the next question
            if (this.currentQuestion + 1 < this.questions.size()) {
                this.changeQuestion(this.questions.get(this.currentQuestion + 1));
            }

            // check if completed
            if (this.completed()) {
                // create dialog
                String name = JOptionPane.showInputDialog(
                        this,
                        "Score: " + this.numCorrect() + ",\n Enter your name:",
                        "Completed!",
                        JOptionPane.QUESTION_MESSAGE);

                try {
                    this.writeHighScore("highscores.txt", this.numCorrect(), name);
                } catch (IOException er) {
                    System.out.printf("Failed to write to highscores.txt: %s", er);
                    System.exit(1);
                }

                // reset game
                this.generateQuestions();
            }
        }
    }
}





