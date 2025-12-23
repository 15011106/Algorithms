/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {

    var dfs func(balanced bool, root *TreeNode) (bool, int)
    dfs = func(balanced bool, node *TreeNode)(ans bool, depth int) {

        if !balanced {
            return false, 0
        }

        if node == nil {
            return true, 0
        }

        lb, left := dfs(balanced, node.Left)
        rb, right := dfs(balanced, node.Right)

        if !lb {
            return false, 0
        }

        if !rb{
            return false, 0
        }

        if !(right - left == 1 || left - right == 1 || right - left == 0 || left-right ==0) {  
            return false , depth
        }
        
        if left > right{
            return true, left + 1
        }

        return true, right + 1
    }

    ans, _ := dfs(true, root)

    return ans
}