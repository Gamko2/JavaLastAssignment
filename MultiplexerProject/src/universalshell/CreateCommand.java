package universalshell;

import multiplexerproject.STDMMultiplexer;
import universalshell.command.Command;
import universalshell.output.Output;

/**
 * This is a Create Command which is used to create a new Multiplexer.
 *
 * @version 1.0
 * @author Marc
 * @since 25.12.017
 */
class CreateCommand extends Command {

    private String[] args;
    private Output output;
    private MultiplexerCommandFactory mpcf;

    /**
     * This is the constructor for the Create Command. It just sets the values
     * given to it to his own private values.
     *
     * @param args Those are the arguments after the "create" command.
     * @param output This is the output.
     * @param mpcf This is our Factory.
     */
    CreateCommand(String[] args, Output output,
            MultiplexerCommandFactory mpcf) {
        this.args = args;
        this.output = output;
        this.mpcf = mpcf;
    }

    @Override
    public void execute() {
        String[] multiplexerdetails = args[1].split(":");
        if (multiplexerdetails.length == 2) {
            if (multiplexerdetails[0].equals("stdm")) {
                try {
                    int number = Integer.valueOf(multiplexerdetails[1]);
                    mpcf.setMultiplexer(new STDMMultiplexer(number));
                    output.writeLine("STDM multiplexer created");

                } catch (NumberFormatException nfe) {
                    output.writeLine("Wrong Input");
                }
            } else if (multiplexerdetails[0].equals("atdm")) {
                output.writeLine("This type is not implemented");
            } else if (multiplexerdetails[0].equals("cdm")) {
                output.writeLine("This type is not implemented");
            }
        } else {
            output.writeLine("Wrong Input");
        }
    }

}
