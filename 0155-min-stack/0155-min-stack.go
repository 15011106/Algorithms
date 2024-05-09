type MinStack struct {
    items     []int
    minValues []int 
}

func Constructor() MinStack {
    return MinStack{}
}

func (this *MinStack) Push(val int) {

    this.items = append(this.items, val)
    
    if len(this.minValues) == 0 || val <= this.minValues[len(this.minValues)-1] {
        this.minValues = append(this.minValues, val)
    }
}

func (this *MinStack) Pop() {
    if len(this.items) == 0 {
        return
    }

    popped := this.items[len(this.items)-1]
    this.items = this.items[:len(this.items)-1]
    

    if popped == this.minValues[len(this.minValues)-1] {
        this.minValues = this.minValues[:len(this.minValues)-1]
    }
}

func (this *MinStack) Top() int {
    if len(this.items) == 0 {
        return 0
    }
    return this.items[len(this.items)-1]
}

func (this *MinStack) GetMin() int {
    if len(this.minValues) == 0 {
        return 0 
    }
    return this.minValues[len(this.minValues)-1]
}
