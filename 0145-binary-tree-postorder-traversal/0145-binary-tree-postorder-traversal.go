/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func postorderTraversal(root *TreeNode) []int {
    
    ans := []int{}
    var lastVisited *TreeNode
    current := root
    var stack []*TreeNode

    for (current != nil || len(stack) > 0){
        for current != nil{
            stack = append(stack, current)
            current = current.Left
        }

        peek := stack[len(stack)-1]

        if peek.Right == nil || lastVisited == peek.Right{
            ans = append(ans, peek.Val)
            stack = stack[:len(stack)-1]
            lastVisited = peek
            current = nil
        }else{
            current = peek.Right
        }

    }
    return ans
}