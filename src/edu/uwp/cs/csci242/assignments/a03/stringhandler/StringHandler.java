package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * String Handler is a interface, Interfaces are abstract.
 * Interface must provide the specialized implementations of processDigit(), processLetter
 * () and processOther() like below;
 */
public interface StringHandler {
    /**
     * Three below methods are abstract and implements other classes.
     */
    /**
     * This abstract method process the digit in order to see if the password contains a digit .
     * @param digit char which process the digit.
     * @throws IllegalArgumentException thrown because to check if the method ahs been passed a legal or illegal argument.
     */
    void processDigit(char digit) throws IllegalArgumentException;
    /**
     * This abstract method process the letter and implements in other classes.
     * @param letter char is the data type of letter.
     */
    void processLetter(char letter);
    /**
     *This is abstract method which process the other character implements in other classes.
     * @param other char is the data type of other character.
     */
    void processOther(char other);

}
