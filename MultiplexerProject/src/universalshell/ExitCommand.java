package universalshell;

import universalshell.command.Command;

/**
 * This implements the specific Exit commands. Its uses to Exit the program.
 *
 * @version 1.0
 * @since 25.12.2017
 * @author Marc
 */
class ExitCommand extends Command {

    private final UniversalShell shell;

    /**
     * This is the constructor for the ExitCommand. It needs to get a
     * Universalshell.
     *
     * @param shell This is our Universalshell which we need for the Command.
     */
    ExitCommand(UniversalShell shell) {
        this.shell = shell;
    }

    @Override
    public void execute() {
        shell.close();
    }

}
