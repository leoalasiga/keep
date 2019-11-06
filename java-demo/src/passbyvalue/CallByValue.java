package passbyvalue;

import common.entity.User;

/**
 * java 的调用是按照值传递而不是引用传递
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-05 22:20
 */
public class CallByValue {
    private static User user = null;
    private static User student = null;


    /**
     * 交换两个对象
     * 我们发现user和stu的值并没有发生变化，也就是方法并没有改变存储在变量user和stu中的对象引用。
     * swap方法的参数x和y被初始化为两个对象引用的拷贝，这个方法交换的是这两个拷贝的值而已，
     * 最终，所做的事都是白费力气罢了。在方法结束后x，y将被丢弃，而原来的变量user和stu仍然引用这个方法调用之前所引用的对象。
     * @param a
     * @param b
     */
    public static void swap(User a, User b) {
        User temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        user = new User("user", 26);
        student = new User("student", 18);
        System.out.println("调用user前：" + user.toString());
        System.out.println("调用student前：" + student.toString());
        swap(user, student);
        System.out.println("调用user后：" + user.toString());
        System.out.println("调用student后：" + student.toString());
    }

}
