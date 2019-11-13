package data_structure.binarytree;

/**
 * 创建一个树节点
 * 每个node存放两个数据
 * 一个左node引用和一个右node引用
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-10 22:46
 */
public class Node {
    public int iData;
    public Node leftNode;
    public Node rightNode;

    public void showNode() {
        System.out.println("{" + iData  + "}");
    }


    private Node root;

    /**
     * 插入Node
     * 插入之前需要判断是否为null
     * 为null需要判断大小知道
     */
    public void insert(int iData) {
        //创建node节点
        Node newNode = new Node();
        newNode.iData = iData;

        //判断root是否为null
        if (root == null) {
            // 说明根节点为null，这个节点就是根节点
            root = newNode;
        }else{
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (iData < current.iData) {
                    //插入左节点
                    //不断向左node寻找是否为null
                    current = current.leftNode;
                    if (current == null) {
                        parent.leftNode = newNode;
                        return;
                    }
                }else {
                    current = current.rightNode;
                    //不断向右node寻找是否为null
                    if (current == null) {
                        parent.rightNode = newNode;
                        return;
                    }
                }
            }
        }

    }


    /**
     * 在tree中寻找关键字
     *
     * @param key
     * @return 返回一个Node
     */
    public Node find(int key) {
        //先把节点设置为根节点
        Node current = root;

        //根节点为空的话，直接返回就好了，没必要继续比较了
        if (current == null) {
            return null;
        }

        //当前节点不等于key的时候，循环查找
        while (current.iData != key) {
            //找不到，返回null
            if (current == null) {
                return null;
            }
            //当当前节点的数据大于key，往左查找
            if (current.iData > key) {
                current = current.leftNode;
            } else {
                //反之，向右
                current = current.rightNode;
            }
        }

        return current;
    }

    /**
     * 查找树中的最大值和最小值
     * 最小值存在于树的最左边
     * 最大值存在于树的最右边
     * @return
     */
    public Node[] maxVal() {
        if (root == null) {
            return null;
        }
        Node minNode = null;
        Node maxNode = null;
        Node[] minMaxNodes = new Node[2];
        Node current = root;
        while (current != null) {
            minNode = current;
            current = current.leftNode;
        }
        minMaxNodes[0] = minNode;

        current = root;
        while (current != null) {
            maxNode = current;
            current = current.rightNode;
        }

        minMaxNodes[1] = maxNode;
        return minMaxNodes;
    }
}
