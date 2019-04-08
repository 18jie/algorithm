package leetCode;

import java.io.Serializable;
import java.util.List;

public class Node implements Serializable {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public String toString() {
        String neis = "";
        for (Node node : neighbors) {
            neis += "node_val : " + node.val;
        }
        return "node_val : " + this.val + "neighbors : " + neis;
    }

}