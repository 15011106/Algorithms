/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func hasPathSum(root *TreeNode, targetSum int) bool {

    ans := dfs(root, 0, targetSum)
    return ans
}

func dfs(root *TreeNode, cur int, targetSum int) bool {
    if root == nil {
        return false
    }

    if root.Left == nil && root.Right == nil {
        if (root.Val + cur) == targetSum{
            return true
        }
        return false
    }

    cur += root.Val
    return dfs(root.Left, cur, targetSum) || dfs(root.Right, cur,targetSum)
}
