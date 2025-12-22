/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */


 // 1. count the level of right and left leaf node
 // 2. sum the level
 // 3. change roots.
func diameterOfBinaryTree(root *TreeNode) int {


    max :=0

    var dfs func(curNode *TreeNode) int
    dfs = func(curNode *TreeNode) int{
        if curNode == nil {
            return 0
        }
        left := dfs(curNode.Left)
        right := dfs(curNode.Right)

        if left + right > max{
            max = left + right
        }
        if left > right{
            return left + 1
        }
        return right + 1
    }

    dfs(root)
    return max
}