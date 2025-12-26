/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 // 1. traversal two tree
 // 2. compare two tree using for 
func isSubtree(root *TreeNode, subRoot *TreeNode) bool {

    rootArr := dfs(root)
    subArr := dfs(subRoot)

    fmt.Println(rootArr)
    fmt.Println(subArr)

    for i:=0; i<len(rootArr); i++{
        if rootArr[i] == subArr[0] && len(rootArr) - i >= len(subArr){
            flag := true

            for j, subArrVal := range subArr{
                if subArrVal != rootArr[i+j]{
                    flag = false
                    break
                }
            }
            if flag{
                return true
            }
        }
    }

    return false
}

func dfs(curNode *TreeNode) []string {

    if curNode == nil{
        return []string{"null"}
    }

    arr := []string{strconv.Itoa(curNode.Val)}

    left := dfs(curNode.Left)
    arr = append(arr, left...)

    right := dfs(curNode.Right)
    arr = append(arr, right...)

    return arr
}

