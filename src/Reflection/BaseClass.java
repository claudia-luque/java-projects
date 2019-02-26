package Reflection;

public class BaseClass
{
    public int baseInt;

    public static void method3()
    {
        System.out.println("Method 3");
    }

    public int method4()
    {
        System.out.println("Method 4");
        return 0;
    }

    public static void method5()
    {
        System.out.println("Method 5");
    }

    void method6()
    {
        System.out.println("Method 6");
    }

    public class InnerClass{}

    public enum MemberEnum{}
}
