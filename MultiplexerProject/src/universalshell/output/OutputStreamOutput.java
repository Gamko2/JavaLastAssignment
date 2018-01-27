package universalshell.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Writes a String to a java.io.OutputStream.
 *
 * @author Marc Bambey
 */
public class OutputStreamOutput extends Output {

    private final OutputStream stream;
    private final Writer outputStreamWriter;

    /**
     * Creates a new instance of OutputStreamOutput.
     *
     * @param stream OutputStream that will be used for creating output.
     */
    public OutputStreamOutput(OutputStream stream) {
        this.stream = stream;
        outputStreamWriter = new OutputStreamWriter(stream);
    }

    @Override
    public void writeLine(String line) {
        this.write(line + "\n");
    }

    @Override
    public void write(String string) {
        try {
            outputStreamWriter.write(string);
            outputStreamWriter.flush();
        } catch (IOException e) {
            System.out.println("Could not write to Output.");
        }
    }

}
