package universalshell.command;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of the command invoker that stores the last 10
 * UndoableCommands.
 *
 * @author Marc Bambey
 */
public class SimpleCommandInvoker extends CommandInvoker {

    private List<UndoableCommand> lastCommands;

    /**
     * Creates a new instance of a SimpleCommandInvoker.
     */
    public SimpleCommandInvoker() {
        lastCommands = new ArrayList<>();
    }

    @Override
    public void executeCommand(Command command) {
        command.execute();
        if (command instanceof UndoableCommand) {
            if (lastCommands.size() >= 10) {
                lastCommands = lastCommands.subList(1, 10);
            }
            lastCommands.add((UndoableCommand) command);
        }
    }

    @Override
    public Command undoLastCommand() {
        if (lastCommands.size() > 0) {
            UndoableCommand command = lastCommands.get(lastCommands.size() - 1);
            command.undo();
            lastCommands.remove(lastCommands.size() - 1);
            return command;
        }
        return null;
    }

}
