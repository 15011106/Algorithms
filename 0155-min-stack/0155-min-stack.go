type MinStack struct {
    item []int
}


func Constructor() MinStack {
    
    return MinStack{}
}

func (this *MinStack) Push(val int)  {

    this.item = append(this.item, val)
    
}


func (this *MinStack) Pop()  {
    this.item = this.item[0:len(this.item)-1]
}


func (this *MinStack) Top() int {
    
    return this.item[len(this.item)-1]

}


func (this *MinStack) GetMin() int {

    min := this.item[0]
    for _, v := range this.item{
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