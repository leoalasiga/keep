package data_structure.stack;

import java.util.Stack;

/**
 * @ClassName StackDemo
 * @Description TODO
 * @Author 刘嘉杰
 * @Date 2019/10/23 15:56
 * @Version 1.0
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("stack:" + stack);
        showPush(stack, 22);
        showPush(stack, 44);
        showPush(stack, 66);
        showPush(stack, 88);

        showPop(stack);
        showPop(stack);
        showPop(stack);
        showPop(stack);

        try {
            showPop(stack);
        } catch (Exception e) {
            System.out.println("empty stack");
        }

    }

    static void showPush(Stack<Integer> stack, int a) {
        stack.push(new Integer(a));
        System.out.println("push (" + a + ")");
        System.out.println("stack: " + stack);
    }


    static void showPop(Stack<Integer> stack) {
        Integer pop = stack.pop();
        System.out.println("pop->" + pop);
        System.out.println("stack: " + stack);


    }
}
