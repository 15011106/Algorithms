/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSymmetric(root *TreeNode) bool {
    if root == nil {
        return true
    }
    
    queue := []*TreeNode{root, root}
    
    for len(queue) > 0 {
        left := queue[0]
        right := queue[1]
        queue = queue[2:]
        
        if left == nil && right == nil {
            continue
        }
        if left == nil || right == nil {
            return false
        }
        if left.Val != right.Val {
            return false
        }
        
        queue = append(queue, left.Left, right.Right)
        queue = append(queue, left.Right, right.Left)
    }
    
    return true
}