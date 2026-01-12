func maxSubArray(nums []int) int {
    if len(nums) == 0 {
        return 0
    }

    cur := nums[0]
    best := nums[0] 

    for i := 1; i < len(nums); i++ {
        if cur+nums[i] < nums[i] {
            cur = nums[i]
        } else {
            cur = cur + nums[i]
        }

        if cur > best {
            best = cur
        }
    }
    return best
}