/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isValidBST(root *TreeNode) bool {
    
    var prev *TreeNode
    ans := true
    var dfs func(*TreeNode)

    dfs = func(cur *TreeNode){
        if cur == nil{
            return
        }
    
        dfs(cur.Left)
        
        if prev != nil{
            if prev.Val >= cur.Val{
                ans = false
                return
            }
        }
        prev = cur   

        dfs(cur.Right)
    }

    dfs(root)

    return ans
}