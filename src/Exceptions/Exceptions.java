package Exceptions;

public class Exceptions
{
    public static void main(String[] args) throws CustomCheckedException
    {
        convertNumber("Test");
    }

    public static int convertNumber(String number) throws CustomCheckedException
    {
        int result = 0;
        try {
            result = Integer.valueOf(number) + 20;
        } catch (NumberFormatException e) {
            throw new CustomCheckedException( number + " String can't be converted to int");
        }

        return result;
    }
}
