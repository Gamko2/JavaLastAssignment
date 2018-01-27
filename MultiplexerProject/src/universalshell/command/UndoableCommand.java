package universalshell.command;

/**
 * A command with the addition that it can be reverted.
 *
 * @author Marc Bambey
 */
public abstract class UndoableCommand extends Command {

    /**
     * This will be called by a command invoker if the command should be undone.
     */
    public abstract void undo();
}
