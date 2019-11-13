package data_structure.seqlist;

/**
 * 顺序列表顶级结构
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-06 22:36
 */
public interface SeqList<T> {

    /**
     * 判断列表是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 列表长度
     *
     * @return
     */
    int length();

    /**
     * 获取指定索引的元素
     *
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 设置某个元素的值
     *
     * @param index
     * @param data
     * @return
     */
    T set(int index, T data);

    /**
     * 根据index添加元素
     *
     * @param index
     * @param data
     * @return
     */
    boolean add(int index, T data);

    /**
     * 添加元素
     *
     * @param data
     * @return
     */
    boolean add(T data);

    /**
     * @param intdex
     * @return
     */
    T remove(int intdex);

    /**
     * 根据data移除元素
     *
     * @param data
     * @return
     */
    boolean remove(T data);

    /**
     * 根据data移除元素
     *
     * @param data
     * @return
     */
    boolean removeAll(T data);

    /**
     * 清空列表
     */
    void clear();

    /**
     * 是否包含data元素
     *
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     * 根据值查询下标
     *
     * @param data
     * @return
     */
    int indexOf(T data);

    /**
     * 根据data值查询最后出现在顺序列表的下标
     *
     * @param data
     * @return
     */
    int lastIndexOf(T data);



}
