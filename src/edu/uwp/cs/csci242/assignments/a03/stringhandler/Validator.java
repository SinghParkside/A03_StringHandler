package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * Validator is an interface which impacts the other classes who are implementing validator.
 */
public interface Validator  {
    /**
     * isValid is a abstract method to check if the number is valid or not.
     * isValid implements other classes like HexStringHandler.
     */
    boolean isValid();

}
