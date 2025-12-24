func twoSum(nums []int, target int) []int {

    ans := []int{}
    hash := make(map[int]int)

    for i := 0 ;i<len(nums); i++{
        hash[nums[i]] = i
    }

    for i := 0 ; i < len(nums);i++{

        v, exist := hash[target - nums[i]]
        if exist && hash[target - nums[i]] > i{
            ans = []int{i,v}
            break
        }
    }

    return ans
}