import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class Question implements ActionListener {
    private Quiz quiz;
    private JButton button;

    private State state;
    private String[] choices;
    private int status = UNANSWERED;

    public static final int UNANSWERED = 0;
    public static final int CORRECT = 1;
    public static final int INCORRECT = 2;

    // Given a chosen state and a list of possible states, creates a question
    // with randomly assigned choices, one of the choices being the true capital
    // of the state.
    public Question(Quiz quiz, State state, List<State> allStates) {
        this(quiz, state, allStates, 4);
    }

    public Question(Quiz quiz, State state, List<State> allStates, int choiceCount) {
        this.quiz = quiz;
        this.state = state;
        this.choices = new String[choiceCount];

        Random rng = new Random();

        List<State> others = allStates
                .stream()
                .filter(other -> !state.equals(other))
                .collect(Collectors.toCollection(ArrayList::new));

        // shuffle other states
        Collections.shuffle(others, rng);

        int correctChoice = rng.nextInt(choiceCount);
        for (int i = 0; i < choices.length; i++) {
            if (i < correctChoice) {
                choices[i] = others.get(i).getCapitalName();
            } else if (i > correctChoice) {
                choices[i] = others.get(i - 1).getCapitalName();
            } else {
                choices[i] = this.state.getCapitalName();
            }
        }

        // create button
        this.button = new JButton(this.state.getName());
        this.button.addActionListener(this);
    }

    public State getState() {
        return this.state;
    }

    public JButton getButton() {
        return this.button;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        if (status == Question.CORRECT) {
            this.button.setBackground(Color.GREEN);
        } else if (status == Question.INCORRECT) {
            this.button.setBackground(Color.RED);
        }

        this.status = status;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Question)) {
            return false;
        }

        Question question = (Question) other;

        return question.getState().equals(this.getState());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // this should always be a button press
        this.quiz.changeQuestion(this);
    }
}
