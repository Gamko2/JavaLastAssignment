package universalshell.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Can the next String input from a java.io.InputStream.
 *
 * @author Marc Bambey
 */
public class InputStreamInput extends Input {

    private final InputStream input;
    private final BufferedReader reader;

    /**
     * Creates a new instance of a InputStreamInput.
     * 
     * @param input The InputStream the String should be retrieved from.
     */
    public InputStreamInput(InputStream input) {
        this.input = input;
        this.reader = new BufferedReader(new InputStreamReader(this.input));
    }

    @Override
    public String getNextLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            System.out.println("Could not get from Input.");
        }
        return line;
    }

}
