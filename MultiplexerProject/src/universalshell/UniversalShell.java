package universalshell;

import universalshell.command.Command;
import universalshell.command.CommandFactory;
import universalshell.command.CommandInvoker;
import universalshell.input.Input;
import universalshell.output.Output;

/**
 * Shell that can run a program based on a CommandFactory and
 * provides means to retrieve input
 * and create output.
 *
 * @author Marc Bambey
 */
public class UniversalShell {

    private final Input input;
    private final Output output;
    
    private boolean running = true;

    /**
     * Creates a new instance of a universal shell.
     * 
     * @param input Input that will be used by the program 
     * to retrieve input from the user.
     * @param output Output that will be used to create output to the user.
     */
    public UniversalShell(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    /**
     * This will stop the shell from executing the program.
     */
    public void close() {
        running = false;
    }

    /**
     * This runs the shell. It specifies what should happen while its running.
     * @param factory This is the CommandFactory we're using.  
     */
    public void run(CommandFactory factory) {
        if(factory.getWelcomeMessage() != null) {
            output.writeLine(factory.getWelcomeMessage());
        }
        while (running) {
            output.write(factory.getInputPrompt());
            String line = input.getNextLine();
            Command command = factory.getCommand(line);
            if (command != null) {
                CommandInvoker invoker = factory.getCommandInvoker();
                invoker.executeCommand(command);
            } else {
                output.writeLine(factory.getUnknownCommandMessage());
            }
        }
    }
    
    /**
     * Returns the Output the shell program should use.
     * 
     * @return The Output.
     */
    public Output getOutput() {
        return output;
    }

    /**
     * Returns the Input the shell program should use.
     * 
     * @return The Input.
     */
    public Input getInput() {
        return input;
    }
   
}