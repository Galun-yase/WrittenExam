package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC133 {

    HashMap<Node, Node> hashMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (hashMap.containsKey(node)) return hashMap.get(node);

        Node cloneNode = new Node(node.val, new ArrayList<>());
        hashMap.put(node, cloneNode);

        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            Node cloneGraph = cloneGraph(neighbor);
            cloneNode.neighbors.add(cloneGraph);
        }

        return cloneNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph_2(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);

        int val = node.val;
        Node cloneNode = new Node(val);
        map.put(val, cloneNode);

        ArrayList<Node> ne = new ArrayList<>();
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            Node n = cloneGraph_2(neighbor);
            ne.add(n);
        }
        cloneNode.neighbors = ne;
        return cloneNode;
    }
}
