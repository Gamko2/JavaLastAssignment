package universalshell;

import multiplexerproject.Multiplexer;
import multiplexerproject.PCM;
import multiplexerproject.STDMMultiplexer;
import universalshell.command.Command;
import universalshell.command.CommandFactory;
import universalshell.command.CommandInvoker;
import universalshell.command.SimpleCommandInvoker;

/**
 * This implements the specific MultiplexerCommandFactory which is used for
 * multiplexers.
 *
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 */
public class MultiplexerCommandFactory extends CommandFactory {

    private final UniversalShell shell;
    private final CommandInvoker invoker;
    private Multiplexer multiplexer;
    private STDMMultiplexer stdmMultiplexer;
    private PCM pcm;

    /**
     * This creates a new instance of the MultiplexerCommandFactory
     *
     * @param shell Is the shell we're using.
     */
    public MultiplexerCommandFactory(UniversalShell shell) {
        this.shell = shell;
        this.invoker = new SimpleCommandInvoker();
        this.pcm = new PCM();

    }

    @Override
    public CommandInvoker getCommandInvoker() {
        return invoker;
    }

    @Override
    public Command getCommand(String line) {
        line = line.toLowerCase();
        String[] args = line.split(" ");
        switch (args[0]) {
            case "q":
                return new ExitCommand(shell);
            case "mux":
                return new MuxCommand(multiplexer, pcm, shell.getOutput());
            case "create":
                return new CreateCommand(args, shell.getOutput(), this);
            case "assign":
                return new AssignCommand(args, this, shell.getOutput());
            case "input":
                return new InputCommand(args, this, shell.getOutput());
            case "refer":
                return new ReferenceCommand(args, this, shell.getOutput());
        }

        return null;
    }

    @Override
    public String getWelcomeMessage() {
        return null;
    }

    @Override
    public String getInputPrompt() {
        return "Input: ";
    }

    @Override
    public String getUnknownCommandMessage() {
        return "Wrong Input";
    }

    /**
     * We set the multiplexer given as parameter to the multiplexer in our
     * MultiplexerCommandFactory
     *
     * @param multiplexer This is the multiplexer
     */
    public void setMultiplexer(Multiplexer multiplexer) {
        this.multiplexer = multiplexer;
    }

    /**
     * This returns the Multiplexer of my factory.
     *
     * @return We return the multiplexer.
     */
    public Multiplexer getMultiplexer() {
        return multiplexer;
    }

    /**
     * We set the pcm given as parameter to the pcm in our Factory.
     *
     * @param pcm This is the pcm we set.
     */
    public void setPCM(PCM pcm) {
        this.pcm = pcm;
    }

    /**
     * We return the PCM from our Factory.
     *
     * @return This returns the pcm.
     */
    public PCM getPCM() {
        return pcm;
    }

}
