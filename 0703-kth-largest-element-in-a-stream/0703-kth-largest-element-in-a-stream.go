type KthLargest struct {
    k int
    minHeap intHeap
}

type intHeap struct{
    minHeap []int
}

func (intHeap intHeap) Len() int{
    return len(intHeap.minHeap)
}

func (intHeap intHeap) Less(i,j int) bool{
    return intHeap.minHeap[i] < intHeap.minHeap[j]
} 

func (intHeap intHeap) Swap(i, j int){
    intHeap.minHeap[i], intHeap.minHeap[j] = intHeap.minHeap[j], intHeap.minHeap[i]
}

func (intHeap *intHeap) Pop() any{

    old := intHeap.minHeap
    n := len(old)
    x := old[n-1]
    intHeap.minHeap = old[0:n-1]
    return x
}

func (intHeap *intHeap) Push(x any){
    intHeap.minHeap = append(intHeap.minHeap, x.(int))
}


func Constructor(k int, nums []int) KthLargest {

    minHeap := intHeap{minHeap: []int{}}
    kthLargest := KthLargest{k, minHeap}
    heap.Init(&kthLargest.minHeap)

    for i :=0 ;i<len(nums); i++{
        heap.Push(&kthLargest.minHeap, nums[i])
        if kthLargest.minHeap.Len() > kthLargest.k{
            heap.Pop(&kthLargest.minHeap)
        }
    }

    return kthLargest
}


func (this *KthLargest) Add(val int) int {

    heap.Push(&this.minHeap, val)
    if this.minHeap.Len() > this.k{
        heap.Pop(&this.minHeap)
    }

    return this.minHeap.minHeap[0]
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * obj := Constructor(k, nums);
 * param_1 := obj.Add(val);
 */