/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
    var ans []int
    var stack []*TreeNode
    var current *TreeNode
    current = root


    for current != nil || len(stack) != 0{
        for current != nil{
            ans = append(ans, current.Val)
            stack = append(stack, current)
            current = current.Left
        }
        current = stack[len(stack)-1]
        stack = stack[:len(stack)-1]
        
        current = current.Right

    }

    return ans
}