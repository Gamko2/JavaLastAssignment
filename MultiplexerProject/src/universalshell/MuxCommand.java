package universalshell;

import multiplexerproject.Multiplexer;
import multiplexerproject.PCM;
import universalshell.command.Command;
import universalshell.output.Output;

/**
 * This implements the specific Command MuxCommand.
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 * 
 */
class MuxCommand extends Command {

    private Multiplexer multiplexer;
    private PCM pcm;
    private Output output;

    /**
     * This is the conctructor. It just saves the multiplexer,pcm and 
     * output int the private variables of the MuxCommand
     * @param multiplexer This is the multiplexer.
     * @param pcm This is the pcm.
     * @param output This is the output. 
     */
    MuxCommand(Multiplexer multiplexer, PCM pcm, Output output) {
        this.multiplexer = multiplexer;
        this.pcm = pcm;
        this.output = output;
    }

    @Override
    public void execute() {
        if (multiplexer != null) {
            multiplexer.mux(pcm);
        } else {
            output.writeLine("Please create multiplexer");
        }
    }

}
