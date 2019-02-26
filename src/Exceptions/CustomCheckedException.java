package Exceptions;
/**
 * CustomCheckedException is a new exception that will be thrown when a string does not have a good format to be
 * converted to int
 * */
public class CustomCheckedException extends Exception
{
    public CustomCheckedException(String message)
    {
        super(message);
    }

    public CustomCheckedException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
