package data_structure.stack;

/**
 * 自定义栈
 */
public interface Stack<T> {
    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 推入栈
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素，未出栈
     * @return
     */
    T peek();

    /**
     * 出栈，返回栈顶元素，同时移除栈中该元素
     * @return
     */
    T pop();
}
