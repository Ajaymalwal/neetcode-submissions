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
    HashMap<Node, Node> graph = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
       return dfs(node);
        
    }

   public Node dfs(Node node){
       if(graph.containsKey(node)){
        return graph.get(node);
       }

       Node clone = new Node(node.val);
       graph.put(node,clone);

       for(Node neighbors : node.neighbors){
        clone.neighbors.add(dfs(neighbors));
       }
       return clone;
    }
}
