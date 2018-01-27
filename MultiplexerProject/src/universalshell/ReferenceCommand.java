/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalshell;

import multiplexerproject.Demultiplexer;
import static multiplexerproject.Demultiplexer.getDemultiplexer;
import universalshell.command.Command;
import universalshell.output.Output;

/**
 *
 * @author Marc
 */
public class ReferenceCommand extends Command {

    private String[] args;
    private MultiplexerCommandFactory mpcf;
    private Output output;

    ReferenceCommand(String[] args, MultiplexerCommandFactory mpcf,
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
                int channelId = Integer.valueOf(values[0]);
                char convertedinput = (char) channelId;
                int outputid = Integer.valueOf(values[1]);
                if (mpcf.getMultiplexer() != null) {
                    Demultiplexer demultiplexer = getDemultiplexer();
                    demultiplexer.refer(channelId, outputid,mpcf.getPCM());

                    
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
