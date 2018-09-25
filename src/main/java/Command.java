public abstract class Command {
    public abstract void execute(Object... args) throws IllegalArgumentException;

    public abstract void undo(Object... args) throws IllegalArgumentException;
}
