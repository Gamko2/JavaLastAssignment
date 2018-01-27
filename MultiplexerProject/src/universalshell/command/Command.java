package universalshell.command;

/**
 * A command that can be invoked by a CommandInvoker.
 *
 * @author Marc Bambey
 */
public abstract class Command {

    /**
     * Will be called by a CommandInvoker to run the command.
     */
    public abstract void execute();
}
