/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var ans [][]int

func dfs(root *TreeNode, curNode []int, targetSum int){
	if root == nil {
		return
	}

	curNode = append(curNode, root.Val)

	if root.Left == nil && root.Right == nil{
		sum := 0
		for _, v := range curNode{
			sum +=v
		}
		if sum == targetSum {
			targetArr := make([]int, len(curNode))
			copy(targetArr, curNode)
			ans = append(ans, targetArr)
		}
		return
	}

	if root != nil{
		dfs(root.Left, curNode, targetSum)
		dfs(root.Right, curNode, targetSum)
	}
}

func pathSum(root *TreeNode, targetSum int) [][]int {
	ans = [][]int{}
	dfs(root, []int{}, targetSum)
	return ans
}
