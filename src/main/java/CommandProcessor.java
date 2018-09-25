import java.util.HashMap;
import java.util.Stack;

public class CommandProcessor {

    public static final int ADD = 0;
    public static final int REMOVE = 1;

    private static final String KEY_COMMAND = "command";
    private static final String KEY_ARGS = "args";

    private HashMap<Integer, Command> commands;
    private Stack<HashMap> history;

    public CommandProcessor() {
        commands = new HashMap<>();
        history = new Stack<>();
    }

    public void setCommand(int key, Command command) {
        commands.put(key, command);
    }

    public void execute(int commandKey, Object... args) {
        Command command = commands.get(commandKey);
        command.execute(args);

        HashMap<String, Object> entry = new HashMap<>();
        entry.put(KEY_COMMAND, command);
        entry.put(KEY_ARGS, args);
        history.push(entry);
    }

    public void undo() {
        if (history.empty()) {
            throw new IllegalStateException("No more command to undo");
        }

        HashMap<String, Object> lastExecuted = history.pop();
        Command command = (Command) lastExecuted.get(KEY_COMMAND);
        Object[] args = (Object[]) lastExecuted.get(KEY_ARGS);

        command.undo(args);
    }
}
