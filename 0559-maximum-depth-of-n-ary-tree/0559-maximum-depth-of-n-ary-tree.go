/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func maxDepth(root *Node) int {
    if root == nil{
        return 0
    }

    depth := 0
    queue := []*Node{root}

    for len(queue) > 0{
        arrLen := len(queue)
        for i:=0; i<arrLen ;  i++{
            node := queue[0]
            queue = queue[1:]

            for _, child := range node.Children{
                if child != nil{
                    queue = append(queue, child)
                } 
            }
        }
        depth++
    }

    
    return depth
}
