package data_structure.binarytree;



/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-11 22:41
 */
public class TreeDemo {
    public static void main(String[] args) {
        Node node = new Node();
        node.insert(1);
        node.insert(2);
        node.insert(3);
        node.insert(4);
        node.insert(5);

        Node node1 = node.find(5);
        node1.showNode();

        Node[] nodes = node.maxVal();
        System.out.println("min:" + nodes[0].iData + ",max:" + nodes[1].iData);
    }
}
