package multiplexerproject;

import java.util.Observer;

/**
 * This implements a Channel which is part of a pcm.
 *
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 */
public class Channel {

    private char value;
    private Input input;
    private int channelNr;
    private Observer observer;

    /**
     * This is the constructor for a Channel. It just saves the parameters in
     * the Channel.
     *
     * @param value This is the value (as char)
     * @param channelNr This is the Channel number
     */
    public Channel(char value, int channelNr) {
        this.value = value;
        this.channelNr = channelNr;
        this.observer=null;
        this.input=null;
    }

    /**
     * Here we set the value of a Channel. We also check if something is already
     * saved in the Channel.
     *
     * @param value This is the value that we set in the channel.
     */
    public void setValue(char value) {
        if (input != null) {
            input.setValue(value);
        } else {
            this.value = value;
        }
    }

    /**
     * Here we set the Channel number.
     *
     * @param channelNr This is the channel number we set.
     */
    public void setChannelNr(int channelNr) {
        this.channelNr = channelNr;
    }

    /**
     * We return the value of a Channel.
     *
     * @return this is the value of the channel.
     */
    public char getValue() {
        if (input != null) {
            return input.getValue();
        } else {
            return value;
        }
    }
    
    public Observer getObserver(){
        return observer;
    }

    /**
     * We return the channel number of a Channel.
     *
     * @return This is the returned Channel number.
     */
    public int getChannelNr() {
        return channelNr;
    }

    /**
     * We set the input to a specific one.
     *
     * @param input this is the input we set.
     */
    public void setInput(Input input) {
       if (this.observer == null) {
           this.input = input;
       }
       else {
           input.addObserver(this.observer);
           if (this.input != null){
               this.input.deleteObservers();
           }
           this.input = input;
       }}

    /**
     * We return the Input of the Channel.
     *
     * @return This is the returned input.
     */
    public Input getInput() {
        return input;
    }
    
    

    public void referenceChannel(Observer observer) {
        if (input != null) {
            input.addObserver(observer);
        }
        this.observer = observer;
    }

}
