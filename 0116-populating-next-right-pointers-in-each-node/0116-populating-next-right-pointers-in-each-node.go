/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

func connect(root *Node) *Node {

    var dfs func(node *Node)

    dfs = func(node *Node){
        if node == nil{
            return
        }
        
        if node.Left != nil && node.Right != nil {
            node.Left.Next = node.Right
            if node.Next != nil{
                node.Right.Next = node.Next.Left
                }
                dfs(node.Left)
                dfs(node.Right)
        }
    }

    dfs(root)

    return root
}



