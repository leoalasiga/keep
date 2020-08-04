package node;

import java.util.LinkedList;

/**
 * @ClassName TreeNodeDemo
 * @Description TODO
 * @Author 刘嘉杰
 * @Date 2020/4/7 11:04
 * @Version 1.0
 */
public class TreeNodeDemo {

    public static TreeNode createBinaryTree(LinkedList<Integer> list) {
        TreeNode node = null;
        if (list == null || list.isEmpty()) {
            return null;
        }

        Integer data = list.removeFirst();

        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(list);
            node.rightChild = createBinaryTree(list);
        }

        return node;
    }


    /**
     * 先序遍历,先访问根节点,在访问左节点,最后访问右节点
     * 根->左->右
     * @param node
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data+" ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);

    }


    /**
     * 中序遍历,所谓的中序遍历就是先访问左节点,在访问根节点,最后访问右节点
     * 左->根->右
     * @param node
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraversal(node.rightChild);
    }


    /**
     * 后序序遍历,所谓的中序遍历就是先访问左节点,在访问右节点,最后访问根节点
     * 左->右->根
     * @param node
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data + " ");
    }



}


