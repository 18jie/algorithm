package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 深克隆无向图
 * @author fengjie
 * @date 2019:03:25
 */
public class CloneGraph1 {

    //非递归的广度优先遍历
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();

        Node clone = new Node();
        clone.neighbors = new ArrayList<>();
        clone.val = node.val;

        queue.offer(node);
        map.put(node, clone);

        while (!queue.isEmpty()) {
            Node pop = queue.pop();
            for (Node oldNode : pop.neighbors) {
                if (!map.keySet().contains(oldNode)) {
                    Node cloneNode = new Node();
                    cloneNode.val = oldNode.val;
                    cloneNode.neighbors = new ArrayList<>();
                    map.put(oldNode, cloneNode);
                    queue.offer(oldNode);
                }
                map.get(pop).neighbors.add(map.get(oldNode));
            }
        }
        return clone;
    }

    //递归的深度优先遍历方式
    public Node cloneGraph1(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return helper(node, map);
    }

    public Node helper(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node();
        clone.val = node.val;
        clone.neighbors = new ArrayList<>();
        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(helper(neighbor, map));
        }
        return clone;
    }

}
