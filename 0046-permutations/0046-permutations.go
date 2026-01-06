func permute(nums []int) [][]int {
    res := make([][]int, 0)

    var dfs func(first int)
    dfs = func(first int) {
        if first == len(nums) {
            tmp := make([]int, len(nums))
            copy(tmp, nums)
            res = append(res, tmp)
            return
        }

        for i := first; i < len(nums); i++ {
            nums[first], nums[i] = nums[i], nums[first] 
            dfs(first + 1)                               
            nums[first], nums[i] = nums[i], nums[first] 
        }
    }

    dfs(0)
    return res
}