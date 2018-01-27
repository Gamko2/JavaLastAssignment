package multiplexerproject;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * This represents the input.
 *
 * @version 1.0
 * @author Marc
 * @since 25.12.2017
 */
public class Input extends Observable {
    
    private char value;
    private int inputId;
    ArrayList<Observer> observerlist = new ArrayList<>();
    private boolean changed = false;
    private boolean valueAssigned =false;

    /**
     * This is a constructor. Creates an Input with value and inputID.
     *
     * @param value The value of the Input.
     * @param inputId The inputID of the Input.
     */
    public Input(char value, int inputId) {
        this.value = value;
        this.inputId = inputId;
    }

    /**
     * Sets the value of the input
     *
     * @param value The int containing the value.
     */
    public void setValue(int value) {
        this.value = (char) value;
        valueAssigned = true;
        setChanged();
    }

    public boolean isValueAssigned() {
        return valueAssigned;
    }

    
    
    

    /**
     * Sets the InpudID of the input
     *
     * @param inputId This is the Inputid to be set.
     */
    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    /**
     * Gets the value of an Input.
     *
     * @return the value of the Input.
     */
    public char getValue() {
        return value;
    }

    /**
     * This returns the Inputid of an Input.
     *
     * @return This is the inputId.
     */
    public int getInputId() {
        return inputId;
    }
    
    @Override
    public void addObserver(Observer o) {
        observerlist.add(o);
    }
    
    @Override
    protected void clearChanged() {
        changed = false;
    }
    
    @Override
    public int countObservers() {
        return observerlist.size();
    }
    
    @Override
    public void deleteObserver(Observer o) {
        observerlist.remove(o);
    }
    
    @Override
    public void deleteObservers() {
        observerlist.clear();
    }
    
    @Override
    public boolean hasChanged() {
        return changed;        
    }
    
    @Override
    public void notifyObservers(Object arg) {
        if (hasChanged()) {
            for (int i = 0; i < observerlist.size(); i++) {
                observerlist.get(i).update(this, arg);
                
            }
            clearChanged();
        }        
    }
    
    @Override
    public void notifyObservers(){
       this.notifyObservers(null);
    }
    
    @Override
    public void setChanged() {
        changed = true;
        notifyObservers();
    }
    
    public ArrayList<Observer> getObservers(){
    return observerlist;    
    }
}
