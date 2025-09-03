/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findTarget(root *TreeNode, k int) bool {
    
    arr := []int{}
    var arrangedArr []int

    arrangedArr = dfs(root, arr)

    l, r := 0,len(arrangedArr)-1

    for l < r{
        sum := arrangedArr[l] + arrangedArr[r]
        if sum == k{
            return true
        }

        if sum > k{
            r--  
        }else{
            l++
        }
    }

    return false
}


func dfs(node *TreeNode, arr []int) (accArr []int){
    
    accArr = arr
    if node == nil{
        return accArr
    }

    if node.Left != nil{
        accArr = dfs(node.Left, accArr)
    }

    accArr = append(accArr, node.Val)
    if node.Right != nil{
        accArr = dfs(node.Right, accArr)
    }

    return accArr
}