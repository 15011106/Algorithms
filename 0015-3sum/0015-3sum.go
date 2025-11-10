func threeSum(nums []int) [][]int {
    
    sort.Ints(nums)
    ans := [][]int{}

    for i:=0; i<len(nums);i++{
        if i>0 && nums[i] == nums[i-1]{
            continue
        }
        mid, end := i+1, len(nums)-1

        for mid < end{
            sum :=nums[i]+ nums[mid] + nums[end]
            if  sum == 0{
                ans = append(ans, []int{nums[i],nums[mid],nums[end]})
                mid++
                end--

                for mid < end && nums[mid] == nums[mid-1]{
                    mid++
                }
                for mid < end && nums[end] == nums[end+1]{
                    end--
                }
            }else if sum > 0{
                end--
            } else{
                mid++
            }
        }
    }

    return ans
}