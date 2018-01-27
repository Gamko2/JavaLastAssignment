/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplexerproject;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Marc
 */
public class Output implements Observer {

    private char value;
    private int outputId;
    private boolean valueAssigned;
    
    

    public Output(char value, int outputId) {
        this.value = value;
        this.outputId = outputId;
    }

    public boolean isValueAssigned() {
        return valueAssigned;
    }

    
    public void setValue(int value) {
        this.value = (char) value;
        valueAssigned=true;
    }

    public void setOutputId(int outputId) {
        this.outputId = outputId;
    }

    public char getValue() {
        return value;
    }

    public int getOutputId() {
        return outputId;
    }

    @Override
    public void update(Observable o, Object arg) {
        
        if (o instanceof Input) {
            Input input = (Input) o;
            this.setValue(input.getValue());
        }
    }

}
