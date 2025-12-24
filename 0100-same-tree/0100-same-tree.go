/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSameTree(p *TreeNode, q *TreeNode) bool {

    arr1 := dfs(p)
    arr2 := dfs(q)

    if len(arr1) != len(arr2){
        return false
    }

    for i :=0; i<len(arr1) ;i++{
        if arr1[i] != arr2[i]{
            return false
        }
    }

    return true
}

func dfs(curNode *TreeNode) []string{
    if curNode == nil{
        return []string{"null"}
    }

    
    arr := []string{strconv.Itoa(curNode.Val)}

    left := dfs(curNode.Left)
    arr = append(arr,left...)
    right := dfs(curNode.Right)
    arr = append(arr,right...)
    
    return arr

}