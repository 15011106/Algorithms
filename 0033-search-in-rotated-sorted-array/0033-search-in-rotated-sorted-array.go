func search(nums []int, target int) int {

    low := 0
    high := len(nums)-1

    for (low < high){
        mid := (low + high)/2
        if nums[mid] > nums[high]{
            low = mid + 1
        }else{
            high = mid
        }
    }

   pivot := low
    low = 0
    high = len(nums) - 1

    if target >= nums[pivot] && target <= nums[high] {
        low = pivot
    } else {
        high = pivot - 1
    }

    for low <= high {
        mid := (low + high) / 2
        if nums[mid] == target {
            return mid
        } else if nums[mid] < target {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return -1 
}