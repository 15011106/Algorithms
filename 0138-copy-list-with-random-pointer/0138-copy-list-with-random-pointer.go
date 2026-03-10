/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {

    copiedList := make(map[*Node]*Node)
    curNode := head

    for curNode != nil{
        copiedList[curNode] = &Node{
            Val :curNode.Val,
        }
        curNode = curNode.Next
    }

    curNode = head

    for curNode != nil{
        copiedList[curNode].Next = copiedList[curNode.Next]
        copiedList[curNode].Random = copiedList[curNode.Random]

        curNode = curNode.Next
    }   

    return copiedList[head]
}