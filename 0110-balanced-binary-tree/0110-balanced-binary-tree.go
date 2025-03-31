/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {

    ans, _ := dfs(root)
    return ans
}

func dfs (node *TreeNode) (bool, int){

    if node == nil{
        return true, 0
    }
    
    isBalanceLeft, left := dfs(node.Left)
    isBalanceRight, right := dfs(node.Right)

    diff := left - right
    if diff < 0 {
        diff = -diff
    }

    max := left 
    if left < right{
        max = right
    }

    if isBalanceLeft && isBalanceRight && diff <= 1{
        return true, max+1
    }

    return false, -1
}