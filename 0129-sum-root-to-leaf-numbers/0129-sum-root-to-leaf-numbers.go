/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sumNumbers(root *TreeNode) int {

    ans := dfs([]int{},root)

    return ans
    
}

func dfs(arr []int ,node *TreeNode) (ans int){

	if node == nil{
        return 0
	}

	arr = append(arr, node.Val)

    if node.Left == nil && node.Right == nil{
        arrLen := len(arr)
		
		if arrLen == 1{
			ans = arr[0]
			return ans
		}

		for i:=0 ;i < arrLen; i++ {

			digit := 1
			for j:=1; j<arrLen - i ;j++{
				digit = digit * 10
			}

			ans += arr[i] * digit
			}

			return ans
    }

	ans += dfs(arr, node.Left)
	ans += dfs(arr, node.Right)

	return ans
}