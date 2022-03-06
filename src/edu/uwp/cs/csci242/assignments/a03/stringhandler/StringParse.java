package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 *The String parse class contains a parse() method takes the String to parse as a parameter and walks through the String a
 * character at a time, determining the type of character and calling the appropriate method of the
 * StringHandler interface for each character.
 */
class StringParse {
    /**
     * Variable relationship to interface StringHandler.
     */
    private StringHandler handler;

    /**
     * Default Constructor for string parse class.
     * @param handler class related variable to the String Handler.
     */
    StringParse(StringHandler handler){ this.handler = handler;}
    /**
     * String parse method which walks thought a string character at a time and determine the type of character.
     * @param s String is a argument in order to walk through each character.
     */
    void parse(String s) {
        for (int i = 0; i <  s.length() ; i++)
        if (Character.isDigit(s.charAt(i))){
            handler.processDigit(s.charAt(i));
         } else if (Character.isLetter(s.charAt(i))){
            handler.processLetter(s.charAt(i));
        }else{
            handler.processOther(s.charAt(i));
        }
    }
}