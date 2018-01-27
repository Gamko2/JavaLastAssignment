package universalshell.command;

/**
 * A command factory is a "program" that can be run in the UniversalShell. It
 * returns a command for a given input string.
 *
 * @author Marc Bambey
 */
public abstract class CommandFactory {

    /**
     * Returns CommandInvoker instance the program is using.
     *
     * @return The CommandInvoker instance of the program.
     */
    public abstract CommandInvoker getCommandInvoker();

    /**
     * Returns the Command for a given input String.
     *
     * @param line Input String the CommandFactory will lookup a command for.
     * @return The command that has been found for the given input String. Null
     * of no command has been found.
     */
    public abstract Command getCommand(String line);

    /**
     * Welcome message that should be displayed by the shell when the program
     * starts up.
     *
     * @return The welcome message.
     */
    public abstract String getWelcomeMessage();

    /**
     * String that will be prompted before retrieving input from the user.
     *
     * @return String that will be output.
     */
    public abstract String getInputPrompt();

    /**
     * Returns the message that should be displayed when the user inputs an
     * unknown command.
     *
     * @return The unknown command message.
     */
    public abstract String getUnknownCommandMessage();
}
