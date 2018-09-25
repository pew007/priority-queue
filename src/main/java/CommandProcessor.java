import java.util.Stack;

public class CommandProcessor {

    private Stack<Command> history;

    public CommandProcessor() {
        this.history = new Stack<>();
    }

    public void execute(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (!history.empty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        } else {
            throw new IllegalStateException();
        }
    }
}
