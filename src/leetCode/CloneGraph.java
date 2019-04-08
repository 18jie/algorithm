package leetCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:03:25
 */
public class CloneGraph {

    public Node cloneGraph(Node node) throws IOException, ClassNotFoundException {
        FileOutputStream ot = new FileOutputStream("C:\\Users\\丰杰\\Desktop\\nodeOutput.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(ot);
        objectOutputStream.writeObject(node);
        System.out.println(node);

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\丰杰\\Desktop\\nodeOutput.txt");
        ObjectInputStream oin = new ObjectInputStream(fileInputStream);
        Node node1 = (Node) oin.readObject();
        System.out.println(node1);
        return null;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CloneGraph c = new CloneGraph();
        Node nod1 = new Node();
        Node nod2 = new Node();
        Node nod3 = new Node();
        Node nod4 = new Node();

        nod1.val = 1;
        nod2.val = 2;
        nod3.val = 3;
        nod4.val = 4;
        List<Node> list1 = new ArrayList<>();
        list1.add(nod2);
        list1.add(nod4);
        nod1.neighbors = list1;

        List<Node> list2 = new ArrayList<>();
        list2.add(nod1);
        list2.add(nod3);
        nod2.neighbors = list2;

        List<Node> list3 = new ArrayList<>();
        list3.add(nod2);
        list3.add(nod4);
        nod3.neighbors = list3;

        List<Node> list4 = new ArrayList<>();
        list4.add(nod1);
        list4.add(nod3);
        nod4.neighbors = list4;

        c.cloneGraph(nod1);
    }

}
