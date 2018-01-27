package multiplexerproject;

/**
 * This is the PCM class which simulates the PCM in a Multiplexer (Read up for
 * details on a real life PCM).
 *
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 */
public class PCM {

    private boolean even = true;
    private Channel[] channels = new Channel[32];

    /**
     * This is the constructor for the PCM. It creates new Channels in the PCM.
     */
    public PCM() {
        for (int i = 0; i < channels.length; i++) {
            channels[i] = new Channel((char) 0, i);
        }
        setEven(true);
        channels[16].setValue((char) 95);
    }

    /**
     * If the Input already exists this will remove the old Input.
     *
     * @param input This is the Input that it is checking for if it exists.
     */
    public void removeInputFromChannel(Input input) {
        for (int i = 0; i < channels.length; i++) {
            if (channels[i].getInput() != null && input.getInputId()
                    == channels[i].getInput().getInputId()) {
                channels[i].setInput(null);
                break;
            }
        }
    }

    /**
     * Here we assign a Channel to an Input.
     *
     * @param channelId The channelID of the channel we want to assign.
     * @param input The input that gets assigned to the channel.
     */
    public void assignChannel(int channelId, Input input) {
        removeInputFromChannel(input);
        if (channelId < 16) {
            channels[channelId].setInput(input);
        } else {
            channels[channelId + 1].setInput(input);
        }
    }

    /**
     * We get the Channels of the PCM.
     *
     * @return This returns a Channel array from the PCM Channels.
     */
    public Channel[] getChannels() {
        return channels;
    }

    /**
     * Here we check return even (Which we need for Channel 0 Assignement)
     *
     * @return This return the boolesn even.
     */
    public boolean isEven() {
        return even;
    }

    /**
     * We give even a value and adjust the Channel 0 accordingly.
     *
     * @param even this is the boolean that decides if its even or not.
     */
    public void setEven(boolean even) {
        this.even = even;
        if (even) {
            channels[0].setValue((char) 27);
        } else {
            channels[0].setValue((char) 64);
        }
    }
}
