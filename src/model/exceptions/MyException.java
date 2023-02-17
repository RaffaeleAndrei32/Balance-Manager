package model.exceptions;

/**
 * @author Raffaele Andrei
 * Custom exception
 */
public class MyException extends Exception{
    public MyException(String title) {
        super(title);
    }
}
