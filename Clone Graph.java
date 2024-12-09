/*
// Definition for a Node.
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
*/

class Solution {
    HashMap<Integer, Node> map = new HashMap<>();
    HashSet<Node> visited = new HashSet<>();

    public Node cloneGraph(Node node) {
        if(node == null)return null;
        clone(node);
        cloneG(node);
        return map.get(node.val);
    }

    public void clone(Node node) {
        if (!map.containsKey(node.val)) {
            Node block = new Node(node.val);
            map.put(node.val, block);
            // visited.add(node);
            for (Node val : node.neighbors) {
                clone(val);
            }
        }
    }
    public void cloneG(Node node) {
        if (!visited.contains(node)) {
            visited.add(node);
            Node curr = map.get(node.val);
            for (Node value : node.neighbors) {
                curr.neighbors.add(map.get(value.val));
            }
            for (Node value : node.neighbors) {
                cloneG(value);
            }
        }

    }
}
