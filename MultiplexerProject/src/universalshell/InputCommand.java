package universalshell;

import universalshell.command.Command;
import universalshell.output.Output;

/**
 * This implements the specific Input Command. Its used to assign a value.
 *
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 */
class InputCommand extends Command {

    private String[] args;
    private MultiplexerCommandFactory mpcf;
    private Output output;

    /**
     * This is the constructor for a new InputCommand. It just sets the values
     * its getting to its own private values.
     *
     * @param args Thats the arguments after the "input" command.
     * @param mpcf This is the MultiplexerCommandFactory.
     * @param output Thats the output.
     */
    InputCommand(String[] args, MultiplexerCommandFactory mpcf,
            Output output) {
        this.args = args;
        this.mpcf = mpcf;
        this.output = output;
    }

    @Override
    public void execute() {

        String[] values = args[1].split(":");
        if (values.length == 2) {
            try {
                int input = Integer.valueOf(values[0]);
                if (input <= 127 || input >= -128) {
                    char convertedinput = (char) input;
                    int inputid = Integer.valueOf(values[1]);

                    if (mpcf.getMultiplexer() != null) {
                        mpcf.getMultiplexer().getInput(inputid).setValue(convertedinput);
                        output.writeLine("Value assigned");
                    } else {
                        output.writeLine("Please create multiplexer");
                    }

                } else {
                    output.writeLine("Wrong Number");
                }

            } catch (NumberFormatException nfe) {
                output.writeLine("Wrong Input");
            }

        }

    }
}
