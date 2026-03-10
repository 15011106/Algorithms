/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rightSideView(root *TreeNode) []int {

    type levelQueue struct{
        node *TreeNode
        level int
    }
    
    ans := []int{}
    queue := []levelQueue{}
    queue = append(queue, levelQueue{
        node :root,
        level :0,
    })

    if root == nil{
        return ans
    }

    prevVal := root.Val
    prevLevel := 0

    for len(queue)!=0{

        curNode := queue[0]
        queue = queue[1:]
    
        if curNode.level == 0 || curNode.level > prevLevel{
            ans = append(ans, prevVal)
            prevLevel = curNode.level
        }

        if curNode.node.Left != nil{
            queue = append(queue, levelQueue{
                node: curNode.node.Left,
                level: curNode.level+1,
                })
            prevVal = curNode.node.Left.Val
        }

        if curNode.node.Right != nil{
            queue = append(queue, levelQueue{
                node: curNode.node.Right,
                level: curNode.level+1,
                })
            prevVal = curNode.node.Right.Val
        }
    }

    return ans
}