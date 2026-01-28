func search(nums []int, target int) int {

    l := 0
    h := len(nums)-1

    for l <= h{
        mid := (l+h)/2
        if nums[mid] == target{
            return mid
        }

        if nums[l] <= nums[mid]{
            if nums[l] <= target && target < nums[mid]{
                h = mid-1
            }else{
                l = mid+1
            }
        }else{
            if target > nums[mid] && nums[h] >= target{
                l= mid +1 
            }else{
                h=mid -1
            }
        }
    }

    return -1
}
