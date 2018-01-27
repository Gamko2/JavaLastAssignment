package multiplexerproject;

import static multiplexerproject.Demultiplexer.getDemultiplexer;

/**
 * This implements the specific STDMMultiplxer which is a type of a Multiplexer
 * This does Synchronous Time Division.
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 */
public class STDMMultiplexer extends Multiplexer {
    
    /**
     * This is the Constructor for a STDMMultiplexer. It creates a new one.
     * @param inputNumber The number of inputs the multiplexer should handle.
     */
    public STDMMultiplexer(int inputNumber){
      super(inputNumber);  
    }

    private String type = "STDM";

    /**
     * This returns the type of the multiplexer.
     * @return Returns the type of the multiplexer as String.
     */
    public String getType() {
        return type;
    }

    @Override
    public void mux(PCM pcm) {
        Demultiplexer demultiplexer = getDemultiplexer();
        demultiplexer.demux(pcm);
        /*
        for (int i = 0; i < pcm.getChannels().length; i++) {
            System.out.print("|" + toBinary(pcm.getChannels()[i].getValue())
                    + " Channel " + pcm.getChannels()[i].getChannelNr());
        }
        System.out.print("|\n");
        pcm.setEven(!pcm.isEven());
        */
    }

}
