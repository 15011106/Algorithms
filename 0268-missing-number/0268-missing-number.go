func missingNumber(nums []int) int {

    lengNums := len(nums)
    ans := 0
    sort.Slice(nums, func(i, j int) bool{
        return nums[i] < nums[j]
    })
    
    for i,v := range nums{
        if v != i{
            ans = i
            break;
        }
        ans = lengNums
    }

    return ans
}