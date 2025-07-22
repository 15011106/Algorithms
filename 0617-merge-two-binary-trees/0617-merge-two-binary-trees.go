/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
    ans := merge(root1,root2)

    return ans
}

func merge(tree1 *TreeNode,tree2 *TreeNode) *TreeNode{
    if tree1 == nil{
        return tree2
    }

    if tree2 == nil{
        return tree1
    }

    merged := &TreeNode{}

    merged.Val = tree1.Val + tree2.Val
    merged.Left = merge(tree1.Left, tree2.Left)
    merged.Right = merge(tree1.Right, tree2.Right)

    return merged
}