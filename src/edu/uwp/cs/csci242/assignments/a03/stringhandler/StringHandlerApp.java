package edu.uwp.cs.csci242.assignments.a03.stringhandler;
/**
 *   Name (Author): Ishmeet Singh (Singhi)
 *   Course: CSCI 242 - Computer Science II
 *   Section: 242
 *   Professor: Timothy H Knautz
 *   Assignment: 03 - StringHandler
 *
 *  Project/Class Description  :  This Project is to implement a string parsing system, called StringHandler.
 *  Java uses interfaces to specify common behavior and interface implementation to specify specific behavior on class
 *  .In this project, you will start by writing two interfaces from which the specific implementations will be derived.
 *  You will then implement two concrete classes from the interfaces as well as a string parser that calls the
 *  specific parsing methods given their implementations.
 *
 * This project will also make you learn how interfaces works with concrete classes because interfaces are abstract,they
 * have abstracts methods which can perform function in another class by implementing it.
 *
 * There are two interface in this project which will implement on another class (see instruction for that). There is
 * PasswordSecurity class which will take of the password level, there is HexStringHandler in which you will convert the
 * String to hex values, there is a string parse class which will assign if this is a digit or not, there is StringHandlerApp
 *class which you will do all the parsing and this class will contain your main.
 *
 *
 *  Known Bugs: None!!
 *
 *
 */

/**
 *Import statement for java file
 */

import java.io.File;
/**
 *Import statement for scanner to read file from the text file.
 */
import java.util.Scanner;

/**
 *StringHandlerApp class contains the main in it. In your main you will set the scanner to read files from
 * the data.txt file that you made to test your program. Main also converts the HexStringHandler and parse it in order
 * to use it and instantiate it.
 */
public class StringHandlerApp {
    /**
     *Instantiate the fileInOut in order to get the output.
     */
    private static FileInOut file = new FileInOut();
    /**
     * In your data.txt file it has pairs of lines that represent a string input. In the main you will be a letter
     * that represents the type of string being read like H is for a hex string and P is for a password string
     * The actual input string should skip H and p and reads the next line in order to recognize the length and security
     * level. Your program should stop reading the input when no more data are present.
     * @param args Main original array args.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //variables to skip the hex letter h
        String hexFlag = "h";
        //variable to skip the string letter p
        String parse = "p";
        //Set the data.txt file.
        file.setInFilename("data.txt");
        //instantiate the Scanner in order to read the file.
        Scanner inFile = new Scanner(new File(file.getInFilename()));
        try {
            while (inFile.hasNextLine()) {
                String str = inFile.nextLine();
                if (str.equalsIgnoreCase(hexFlag)) {
                    str = inFile.nextLine();
                    HexStringHandler hsh = new HexStringHandler();
                    StringParse hexParse = new StringParse(hsh);
                    hexParse.parse(str);
                    System.out.println(str + " = " + hsh.getNumber());
                }

                if (str.equalsIgnoreCase(parse)) {
                    str = inFile.nextLine();
                    PasswordSecurityHandler tempPsh = new PasswordSecurityHandler();
                    StringParse temp = new StringParse(tempPsh);
                    temp.parse(str);
                    System.out.println(str + "'s security is " + tempPsh.securityLevel());
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }

        inFile.close();

    }
}


