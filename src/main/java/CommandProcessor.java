import java.util.List;
import java.util.Stack;

public class CommandProcessor {

    AddCommand addCommand;
    RemoveCommand removeCommand;
    Stack history;

    public void execute(Command command) {
        command.execute();
    }
}
