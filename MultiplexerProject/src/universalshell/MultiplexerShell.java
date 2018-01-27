package universalshell;

import universalshell.command.CommandFactory;
import universalshell.input.InputStreamInput;
import universalshell.output.OutputStreamOutput;

/**
 * Starts up the Multiplexer Program.
 *
 * @author Marc Bambey
 */
public class MultiplexerShell {

    /**
     * Starts up the Multiplexer Program in a universal shell.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UniversalShell shell = new UniversalShell(new InputStreamInput(System.in),
                new OutputStreamOutput(System.out));
        CommandFactory factory = new MultiplexerCommandFactory(shell);
        shell.run(factory);
    }

}
