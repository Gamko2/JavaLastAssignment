package universalshell;

import universalshell.command.Command;
import universalshell.output.Output;

/**
 * This is the Assign Command. Its used when the user enters the "assign"
 * command and wants to assign an Input to a Channel.
 *
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 */
class AssignCommand extends Command {

    private String[] args;
    private MultiplexerCommandFactory mpcf;
    private Output output;

    /**
     * This is the Constructor for the Assign Command. It just sets the values
     * given to its own values.
     *
     * @param args Thats the list of Arguments after the "assign" command.
     * @param mpcf This is the factory.
     * @param output This is the output.
     */
    AssignCommand(String[] args, MultiplexerCommandFactory mpcf,
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
                int channelid = Integer.valueOf(values[0]);
                int inputid = Integer.valueOf(values[1]);
                if (mpcf.getMultiplexer() != null) {
                    mpcf.getPCM().assignChannel(channelid,
                            mpcf.getMultiplexer().getInput(inputid));
                    output.writeLine("Assignment created");
                } else {
                    output.writeLine("Please create multiplexer");
                }
            } catch (NumberFormatException nfe) {
                output.writeLine("Wrong Input");
            }

        }
    }

}
