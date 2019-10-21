package data_structure.stack;

import java.io.Serializable;
import java.util.EmptyStackException;

public class SeqStack<T>  implements Stack<T>, Serializable {


    private static final long serialVersionUID = -6204041407782482210L;

    /**
     * 栈顶指针，-1表示空栈
     */
    private int top;

    /**
     * 默认容量大小为10
     */
    private int capacity = 10;

    /**
     * 存放元素的数组
     */
    private T[] array;

    private int size;

    public SeqStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public SeqStack() {
        array = (T[]) new Object[this.capacity];
    }

    public int size() {
        return size;
    }

    /**
     * -1为空栈，当栈顶指针top为空的时候，说明栈为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 添加元素，从栈顶（数组尾部）插入
     * @param data
     */
    @Override
    public void push(T data) {
        //先判断大小，如果数组长度等于与栈的大小,进行扩容
        if (array.length == size) {
            ensureCapacity(size << 1 + 1);
        }
        //从栈顶添加元素
        array[++top] = data;
        size++;
    }

    /**
     * 扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        if (capacity < size) {
            return;
        }

        T[] old = array;

        array = (T[]) new Object[capacity];

        System.arraycopy(old, 0, array, 0, size);
    }


    /**
     * 获取栈顶元素,不删除
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            new EmptyStackException();
        }


        return array[top];
    }

    /**
     * 从栈顶（数组尾部）删除数组
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            new EmptyStackException();
        }

        size--;

        return array[top--];
    }




    public static void main(String[] args) {
        SeqStack<String> seqStack = new SeqStack<>();
        seqStack.push("A");
        seqStack.push("B");
        seqStack.push("C");

        System.out.println("size-->" + seqStack.size());

        int l = seqStack.size();
        for (int i = 0; i < l-1; i++) {
            System.out.println("pop-->"+seqStack.pop());
        }

        //说明了pop后，栈里只剩了A，FILO原则
        System.out.println("peek-->"+seqStack.peek());
        //说明了peek后的元素还在
        System.out.println("peek-->"+seqStack.peek());

    }
}

