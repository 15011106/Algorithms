/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
   var ans [][]int
    if root == nil {
        return ans
    }

    queue := []struct {
        node  *TreeNode
        level int
    }{{root, 0}}

    for len(queue) > 0 {
        current := queue[0]
        queue = queue[1:]

        if len(ans) == current.level {
            ans = append(ans, []int{current.node.Val})
        } else {
            ans[current.level] = append(ans[current.level], current.node.Val)
        }

        if current.node.Left != nil {
            queue = append(queue, struct {
                node  *TreeNode
                level int
            }{current.node.Left, current.level + 1})
        }

        if current.node.Right != nil {
            queue = append(queue, struct {
                node  *TreeNode
                level int
            }{current.node.Right, current.level + 1})
        }
    }

    return ans
}