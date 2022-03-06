package edu.uwp.cs.csci242.assignments.a03.stringhandler;
/**
 * This Class HexStringHandler converts the string to hex numbers. This class also
 * contains the abstract method from the interface StringHandler and Validator in order
 * to process.
 */
public class HexStringHandler implements StringHandler , Validator {
    /**
     *Constant for the invalid numbers
     */
    private static final int INVALID_NUMBER = -1;
    /**
     *Constant for number system
     */
    private static final int NUMBER_SYSTEM = 16;
    /**
     *Constant for number min
     */
    private static final int NUMBER_MIN = 10;
    /**
     *Constant for number max
     */
    private static final int NUMBER_MAX = 16;
    /**
     * validHex is a boolean that indicates whether the string being parsed contains only valid hex
     * characters.
     */
    private boolean validHex;
    /**
     * Int variable holds the number that the decimal equivalent of the hex value
     */
    private int number;
    /**
     *Two arguments constructor and it sets the variable to the arguments
     * @param validHex sets the valid hex to the variable
     * @param number sets the number to variable.
     */
    public HexStringHandler(boolean validHex, int number) {
        this.validHex = validHex;
        this.number = number;
    }

    /**
     *Default constructor for HexString Handler
     */
    public HexStringHandler() {

    }

    /**
     *This methods process the number and if the number is valid then it return number if not then
     * the constant
     * @return temp temporary variable made to work with the method.
     */
    public int getNumber() {
        int temp;
        if (isValid()){
            temp = number;
        }else {
            return INVALID_NUMBER;
        }
        return temp;
    }

    /**
     * This method also came from the interface StringHandler because the class HExString Handler
     * implements the String handler. This method use the formula and converts the digit to Hex value.
     * @param digit char which process the digit.
     */
    @Override
    public void processDigit(char digit) {
        if (Character.isDigit(digit)) {
            this.validHex = true;
            int i = Character.getNumericValue(digit);
            number = (number * NUMBER_SYSTEM) + i;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     *TThis method also came from the interface StringHandler because the class HExString Handler implements
     * the String handler.This method convert the letter to the hex value and letter which counts as hex are
     * a-f.
     * @param letter char is the data type of letter.
     */
    @Override
    public void processLetter(char letter){
        this.validHex = true;
        int i = Character.getNumericValue(letter);

        if (i >= NUMBER_MIN && i < NUMBER_MAX) {
            number = number * NUMBER_MAX + i;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     *This method also came from the interface StringHandler because the class HExString Handler implements
     * the String handlerThis method returns false because when processing other number hex should be false.
     * @param other char is the data type of other character.
     */
    @Override
    public void processOther (char other){
        this.validHex = false;
    }

    /**
     *This method also came from the interface Validator because the class HexString Handler
     *implements Validator an interface.
     * This method sets the valid hex value to valid
     * @return
     */
    @Override
    public boolean isValid () {
        return validHex;
    }
}

