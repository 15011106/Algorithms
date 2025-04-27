/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func binaryTreePaths(root *TreeNode) []string {

    ans := dfs(root, "")

    return ans
}

func dfs(node *TreeNode,  numString string) (ans []string) {
        if node == nil {
        return nil
    }
    
    numString += strconv.Itoa(node.Val)
    
    if node.Left == nil && node.Right == nil {
        return []string{numString}
    }
        
    if node.Left != nil {
        ans = append(ans, dfs(node.Left, numString+"->")...)
    }
    if node.Right != nil {
        ans = append(ans, dfs(node.Right, numString+"->")...)
    }
    
    return ans
}