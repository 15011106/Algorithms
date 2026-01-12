func canJump(nums []int) bool {

    maxJump := nums[0]
    for i:=0; i<len(nums);i++{
        if i> maxJump{
            return false
        }

        if nums[i] + i > maxJump{
            maxJump = nums[i]+i
        }
    }

    return true
}