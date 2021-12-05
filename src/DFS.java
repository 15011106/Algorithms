
class Node{
    int data;
    Node lt, rt;
    Node(int val){
        data = val;
        lt=null;
        rt=null;
    }
}

public class DFS {
    Node root;
    public void dfs(Node root){
        if(root==null) {
        } else {
            dfs(root.lt);
            dfs(root.rt);
            System.out.println(root.data+" ");
        }
    }

    public static void main(String[] args) {

        DFS tree = new DFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.dfs(tree.root);

    }
}
