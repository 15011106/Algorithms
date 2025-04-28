/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findMode(root *TreeNode) []int {

    tree := dfs(root)
    ansMap := make(map[int]int)

    for _,v  := range tree{
        ansMap[v] += 1
    }

    maxV := 0 
    var ans []int

    for k, v := range ansMap {
        if v > maxV {
            maxV = v
            ans = []int{k}
        } else if v == maxV {
            ans = append(ans, k) 
        }
    }
    
    return ans
}

func dfs(node *TreeNode) []int{
    
    if node == nil{
        return nil
    }

    var ans []int
    ans = append(ans, node.Val)
    ans = append(ans, dfs(node.Left)...)
    ans = append(ans,dfs(node.Right)...)

    return ans
}