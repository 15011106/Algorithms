func findPeakElement(nums []int) int {

    p1 := 0
    ans := 0

    if len(nums) == 2{
        if nums[0] >nums[1]{
            return 0
        }else{
            return 1
        }
    }

    for p1 < len(nums)-1 {
        if p1 == 0 && nums[p1] > nums[p1+1]{
             ans = p1
             break
        }else if p1 > 0{
            if (nums[p1] > nums[p1-1] && nums[p1] > nums[p1+1]){
            ans = p1
            break
            }
            if p1 == len(nums)-2 && nums[p1+1] > nums[p1]{
                ans = p1+1
                break;
            }
        }

        p1++
    }

 return ans   
}