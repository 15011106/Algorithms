func findPeakElement(nums []int) int {

    low := 0
    high := len(nums)-1

    if len(nums) == 1{
        return 0
    }

    for low <= high{
        mid := (low + high)/2
        if nums[mid] < nums[mid+1]{
            low = mid + 1
        }else{
            high = mid - 1
        }
    }

 return low   
}