package universalshell.command;

/**
 * A command invoker is responsible for executing commands.
 *
 * @author Marc Bambey
 */
public abstract class CommandInvoker {

    /**
     * Executes a command.
     *
     * @param command Command that will be executed.
     */
    public abstract void executeCommand(Command command);

    /**
     * Undoes the last command that can be undone.
     *
     * @return The command that has been undone. Null if no command could be
     * undone.
     */
    public abstract Command undoLastCommand();
}
