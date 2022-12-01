import java.util.Scanner;

public class State {
    private String name;
    private String capitalName;

    public State(String name, String capitalName) {
        this.name = name;
        this.capitalName = capitalName;
    }

    public State(Scanner in) {
        String line = in.nextLine();

        int comma = line.indexOf(',');

        this.name = line.substring(0, comma).trim();
        this.capitalName = line.substring(comma + 1).trim();
    }

    public String getName() {
        return this.name;
    }

    public String getCapitalName() {
        return this.capitalName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof State)) {
            return false;
        }

        State state = (State) other;

        return state.getName() == this.getName();
    }
}

