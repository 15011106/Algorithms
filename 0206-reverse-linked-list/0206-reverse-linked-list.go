/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {

    dummyNode := &ListNode{}
    curNode := head
    prevNode := dummyNode

    prevNode = nil
    
    for curNode != nil{
        nextNode := curNode.Next
        curNode.Next = prevNode
        prevNode = curNode
        
        curNode = nextNode
    }

    return prevNode
}