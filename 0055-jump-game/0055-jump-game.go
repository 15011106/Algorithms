func canJump(nums []int) bool {
     farthest := 0
    for i := 0; i < len(nums); i++ {
        if i > farthest {
            return false
        }
        farthest = max(farthest, i + nums[i])
        if farthest >= len(nums) - 1 {
            return true
        }
    }
    return false
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}