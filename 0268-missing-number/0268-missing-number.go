func missingNumber(nums []int) int {

    lengNums := len(nums)
    x := 0
    
    for i:=0 ;i < lengNums + 1 ;i++{
        x ^= i
    }

    for _, v:= range nums{
        x ^= v
    }

    return x
}