package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * There are two interface String Handler and validator, This class implement the String handler
 * inorder to process a digit, letter , and other character.
 *
 * This Class also determines if the password level is weak which is, if the length is less than eight then defined as weak
 * ,If length is more than eight and it has a digit or otherCharacter than the security level is medium and if
 * the password is more than 8 in length and has a digit and has a other character than its a strong level security.
 */
public class PasswordSecurityHandler implements StringHandler{
    /**
     * Constant value for weak
     */
    private static final String SECURITY_LEVEL_WEAK = "weak";
    /**
     * Constant value for medium
     */
    private static final String SECURITY_LEVEL_MEDIUM = "medium";
    /**
     * Constant value for strong
     */
    private static final String SECURITY_LEVEL_STRONG = "strong";
    /**
     * Length variable that holds the number of length in the password.
     */
    private int length;
    /**
     * Digit variable used to indicate whether the password has a digit or not.
     */
    private boolean digit;
    /**
     * otherCharacter variable checks if the password has any other character beside digit or letter.
     */
    private boolean otherCharacter;

    /**
     * Three argument constructor for the password security
     * @param length sets up the length
     * @param digit sets up the digit
     * @param otherCharacter sets up the otherCharacter
     */
    public PasswordSecurityHandler(int length, boolean digit, boolean otherCharacter) {
        this.length = length;
        this.digit = digit;
        this.otherCharacter = otherCharacter;
    }

    /**
     * Default Constructor for password Security
     */
    public PasswordSecurityHandler() {

    }
    /**
     * This Method determines the security level of the password in the data.txt file.
     * @return String which can help determine weather a password is weak, medium or strong by setting
     * the variable to the constants.
     */
    public String securityLevel() {
        String levels = "";

        if (length < 8){
            levels = SECURITY_LEVEL_WEAK;
        }else{
            if(digit || otherCharacter){
                levels = SECURITY_LEVEL_MEDIUM;
            }
            if (digit && otherCharacter){
                levels = SECURITY_LEVEL_STRONG;
            }
        }
        return levels;
    }
    /**
     * This method uses one of the very efficient character class to determine weather its a digit or not.
     * @param digit char is the data type used in this method as a argument to process digit.
     */
    @Override
    public void processDigit(char digit) {
        if(Character.isDigit(digit)){
            this.digit = true;
            length++;
        }
        else {
            throw new IllegalArgumentException("Error argument is what not expected");
        }
    }
    /**
     *This method also uses character class to determine that is its a letter or not in password.
     * @param letter chr data type used to process letter.
     */
    @Override
    public void processLetter(char letter) {

        if (Character.isLetter(letter)){
            this.digit = true;
            length++;
        }else {
            throw new IllegalArgumentException("Error argument is not what expected");
        }
    }
    /**
     * This uses the character class inorder to process other character see if the password ahs other character or not.
     * @param other char data type used process the other character and it also checks the special character.
     */
    @Override
    public void processOther(char other) {

        if(!Character.isLetterOrDigit(other) && !Character.isISOControl(other)){
            this.otherCharacter = true;
            length++;
        }
    }
    /**
     * Getter for the length.
     * @return length so that it can instantiate the object.
     */
    protected int getLength() {
        return length;
    }
    /**
     * Getter for the digit
     * @return length so that it can instantiate the object.
     */
    protected boolean isDigit() {
        return digit;
    }
    /**
     * Getter for the otherCharacter.
     * @return length so that it can instantiate the object.
     */
    protected boolean isOtherCharacter() {
        return otherCharacter;
    }
}
