/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    
    var prevNode *ListNode
    curNode := head

    for curNode != nil{
        tmp := curNode.Next
        curNode.Next = prevNode

        prevNode = curNode        
        curNode = tmp
    }

    curNode = prevNode
    prevNode = nil
    cnt := 1

    for curNode != nil{
        tmp := curNode.Next

        if cnt == n{
            curNode.Next = nil
            curNode = tmp
            cnt++
            continue
        }

        curNode.Next = prevNode
        prevNode = curNode
        curNode = tmp

        cnt++
    }

    return prevNode
}
