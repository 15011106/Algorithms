func rotate(nums []int, k int)  {
    n := len(nums)
    k %= n
    reverse(nums)
    reverse(nums[:k])
    reverse(nums[k:])
}

func reverse(nums []int) {
    left, right := 0, len(nums)-1
    for left < right {
        nums[left], nums[right] = nums[right], nums[left]
        left++
        right--
    }
}