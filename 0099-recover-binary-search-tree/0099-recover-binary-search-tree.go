/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var swap1 *TreeNode
var swap2 *TreeNode
var prev *TreeNode

func dfs(cur *TreeNode){
    if cur == nil{
        return
    }

    dfs(cur.Left)

    if prev != nil && cur.Val < prev.Val{
        if swap1 == nil{
            swap1 = prev
            swap2 = cur
        }else{
            swap2 = cur
        }
    }
    
    prev = cur
    dfs(cur.Right)
}

func recoverTree(root *TreeNode)  {
    swap1, swap2, prev = nil, nil, nil

    dfs(root)   
     if swap1 != nil && swap2 != nil {
        swap1.Val, swap2.Val = swap2.Val, swap1.Val
    }
}