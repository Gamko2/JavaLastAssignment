package multiplexerproject;

/**
 * This is the abstract Multiplexer class. We will implement a specific 
 * Multiplexer that will use the functions from this.
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 */
public abstract class Multiplexer {

    private int inputNr;
    private Input[] inputs;

    /**
     * This is the abstract Method for mux which will be implemented by the
     * specific Multiplexer.
     * @param pcm You will get a pcm to perform the mux on.
     */
    public abstract void mux(PCM pcm);

    /**
     * This creates a Multiplexer with as many Inputs as specified. It's the
     * same for all types of Multiplexers.
     * @param inputNr This is the number of inputs your multiplexer should have.
     */
    public Multiplexer(int inputNr) {
        this.inputNr = inputNr;
        inputs = new Input[inputNr];
        for (int i = 0; i < inputNr; i++) {
            inputs[i] = new Input((char) 0, i + 1);
        }

    }

    /**
     * We get the InputNr of the Multiplexer. 
     * @return This returns the InputNr.
     */
    public int getInputNr() {
        return inputNr;
    }

    /**
     * We get the Input from a specific InputID.
     * @param inputId This is the ID from where we want to get the Input.
     * @return This returns the input at the specified inputID.
     */
    public Input getInput(int inputId) {
        return inputs[inputId - 1];
    }

    /**
     * This calculates the Binary number of the value given. 
     * @param value this is the value we want the binary from
     * @return We return the string which contains the binary of the value
     */
    protected String toBinary(char value) {
        String tmp = "";
        for (int x = 7; x >= 0; x--) {
            tmp += ((1 << x) & value) != 0 ? "1" : "0";
        }
        return tmp;
    }

}
