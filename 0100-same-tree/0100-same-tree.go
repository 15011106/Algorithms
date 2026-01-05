/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 // 1. traversal twice

func isSameTree(p *TreeNode, q *TreeNode) bool {
    var dfs func(p, q *TreeNode) bool
    
    dfs = func(p, q *TreeNode) bool{    
        if p == nil || q == nil{
            if p != q{
                return false
            }
            return true
        }

        if p.Val != q.Val{
            return false
        }

        left := dfs(p.Left, q.Left)
        right := dfs(p.Right,q.Right)

        return left && right
    }

    isSame := dfs(p,q)

    return isSame
}