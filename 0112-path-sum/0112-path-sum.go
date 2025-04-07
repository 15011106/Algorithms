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

func dfs(root *TreeNode, cur int, targetSum int) (ans bool) {
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
    leftCheck := dfs(root.Left, cur, targetSum)
    rightCheck := dfs(root.Right, cur, targetSum)


    return leftCheck || rightCheck
}
