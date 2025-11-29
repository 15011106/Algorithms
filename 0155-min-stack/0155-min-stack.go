type MinStack struct {
    data []int
}


func Constructor() MinStack {

    var minStack MinStack
    return minStack
}


func (this *MinStack) Push(val int)  {
    this.data = append(this.data, val)
}


func (this *MinStack) Pop()  {

    this.data = this.data[:len(this.data)-1]
}


func (this *MinStack) Top() int {

    v := this.data[len(this.data)-1]
    return v
}


func (this *MinStack) GetMin() int {

    var min int
    min = this.data[0]

    for _,v := range this.data{
        if min > v{
            min = v
        }
    }

    return min
}


/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */