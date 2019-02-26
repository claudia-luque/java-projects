package Reflection;


public class Main
{
    public static void main(String[] args)
    {
        Class<?> concreteClass = ConcretClass.class;
        Class<?> superClass = null;
        Class<?>[] classes = concreteClass.getClasses();
        concreteClass = new ConcretClass(5).getClass();

        Class<?>[] explicitClasses = null;

        try {
            concreteClass = Class.forName("Reflection.ConcretClass");
            // get SuperClass
            superClass = Class.forName("Reflection.ConcretClass").getSuperclass();
            explicitClasses = Class.forName("Reflection.ConcretClass").getDeclaredClasses();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        System.out.println(concreteClass.getCanonicalName());

        System.out.println(superClass);

        System.out.println(classes);

        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName());

        Class<?> doubleClass = double.class;
        System.out.println(doubleClass.getCanonicalName());
    }
}
