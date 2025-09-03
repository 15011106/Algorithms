/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findTarget(root *TreeNode, k int) bool {
    
    if root == nil {
            return false
                }

    queue := []*TreeNode{root}
    key := make(map[int]bool)

    for len(queue) > 0 {
        node := queue[0]
        queue = queue[1:]

        if !key[node.Val]{
            key[node.Val] = true
        }

        tempVal := 0

        if node.Right != nil{

            tempVal = k-node.Right.Val
            if key[tempVal]{
                return true
            }
            
            if !key[node.Right.Val]{
                key[node.Right.Val] = true
            } 
            
            queue = append(queue, node.Right)

        }

        if node.Left != nil{

            tempVal = k-node.Left.Val
            if key[tempVal]{
                return true
            }

            if !key[node.Left.Val]{
                key[node.Left.Val] = true
            }

            queue = append(queue, node.Left)

        }
    } 

    return false   
}