/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {

    var dfs func(root *TreeNode)
    
    dfs = func(node *TreeNode){
        if node == nil{
            return
        }

        node.Left, node.Right = node.Right, node.Left
        dfs(node.Left)
        dfs(node.Right)

        return
    }

    dfs(root)

    return root
}