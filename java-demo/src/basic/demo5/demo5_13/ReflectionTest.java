package basic.demo5.demo5_13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author ljj
 * @description This program uses reflection to print all features of a class
 * @date 2020-08-10
 */
public class ReflectionTest {
    public static void main(String[] args) {
        //read a class name from command line args or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        }else{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name(e.g. java.util.Date):");
            name = in.next();
        }

        //print class name and superclass name if !=Object
        try {
            Class<?> cl = Class.forName(name);
            Class<?> supercl= cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println("class " + name);
            if (supercl != null && supercl != Object.class) {
                System.out.println("extends " + supercl.getName());
            }

            System.out.print("\n{\n");
            printConstructor(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printField(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
    /**
     * print all fields of a class
     * @param cl
     */
    private static void printField(Class<?> cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class<?> type = f.getType();
            String name = f.getName();
            System.out.print("\t");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName()+" "+name+";");
        }
    }

    /**
     * print all methods of a class
     * @param cl
     */
    private static void printMethods(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class<?> returnType = m.getReturnType();
            String name = m.getName();
            System.out.print("\t");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name+"(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all constructors of a class
     * @param cl
     */
    private static void printConstructor(Class<?> cl) {
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            String name = c.getName();
            System.out.print("\t");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            //print parameter types
            Class<?>[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }
}
