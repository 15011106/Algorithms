/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
    max := 0

    var dfs func(node *TreeNode, level int)

    dfs = func(node *TreeNode, level int){

        if node == nil{
            if level > max {
                max = level
                }
            return
        }

        dfs(node.Left, level+1)
        dfs(node.Right, level+1)
    }
    
    dfs(root, 0)
    return max
}