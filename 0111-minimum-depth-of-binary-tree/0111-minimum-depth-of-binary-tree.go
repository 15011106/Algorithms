/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func minDepth(root *TreeNode) int {
    
    queue := []struct{
        node *TreeNode
        depth int
        }{{root, 0}}
    ans := 0

    if root == nil{
        return 0
    }    

    for len(queue) > 0{
        cur := queue[0]
        queue = queue[1:]


        if cur.node.Left == nil && cur.node.Right == nil{
            ans = cur.depth
            break
        }

        if cur.node.Left != nil{
            left := struct{
                node *TreeNode
                depth int
            }{cur.node.Left, cur.depth+1}

            queue = append(queue, left)
        }

        if cur.node.Right != nil{
            right := struct{
                node *TreeNode
                depth int
            }{cur.node.Right, cur.depth+1}
            queue = append(queue, right)
        }
    }

    return ans + 1
}