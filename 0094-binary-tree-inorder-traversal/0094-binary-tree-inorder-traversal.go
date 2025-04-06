/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 
func inorderTraversal(root *TreeNode) []int {

    ans := make([]int, 0)
    ans = dfs(root, ans)

    return ans
}

func dfs (root *TreeNode, arr []int) ([]int){

    if root == nil{
        return arr
    }

    if root.Left != nil{
        arr = dfs(root.Left, arr)
    }

    arr = append(arr, root.Val)
    
    if root.Right != nil{
        arr = dfs(root.Right, arr)
    }

    return arr
}
