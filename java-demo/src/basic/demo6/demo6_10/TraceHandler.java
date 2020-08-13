package basic.demo6.demo6_10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ljj
 * @description An InvocationHandler that prints out the method name and parameters
 * @date 2020-08-13
 */
public class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * Constructor a TraceHandler
     * @param target
     */
    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //print implicit argument
        System.out.print(target);

        //print method name
        System.out.print("." + method.getName() + "(");
        //print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(",");
                }
            }

        }

        System.out.println(")");

        //invoke actual method
        return method.invoke(target, args);
    }


}
