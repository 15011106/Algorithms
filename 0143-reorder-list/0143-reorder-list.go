/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

 // 1. traversal the node to find the half of the list
func reorderList(head *ListNode)  {
    
    slow := head
    fast := head

    for fast != nil && fast.Next !=nil{
        
        slow = slow.Next
        fast = fast.Next.Next
    }
    
    prevNode := slow
    curNode := slow.Next
    slow.Next = nil

    for curNode != nil{
        
        tmp := curNode.Next
        curNode.Next = prevNode

        prevNode = curNode
        curNode = tmp
    }

    rearNode := prevNode
    frontNode := head

    tmpNode := head
    flag := true
    for tmpNode != slow{

        tmp := &ListNode{}
        if flag{
            tmp = frontNode.Next
            frontNode.Next = rearNode

            frontNode = tmp
            tmpNode = rearNode
            flag = false
        }else{
            tmp = rearNode.Next
            rearNode.Next = frontNode

            rearNode = tmp
            tmpNode = frontNode
            flag = true
        }
    }

}