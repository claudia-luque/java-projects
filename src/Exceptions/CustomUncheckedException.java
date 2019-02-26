package Exceptions;

public class CustomUncheckedException extends RuntimeException
{
    public CustomUncheckedException(String msg)
    {
        super(msg);
    }
}
