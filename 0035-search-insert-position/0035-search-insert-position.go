func searchInsert(nums []int, target int) int {
    low := 0
    high := len(nums)-1

    for{
         if (low > high){
            break
         }
         mid := (low + high) /2
         if nums[mid] == target{
            return mid
         }else if nums[mid]< target{
            low = mid+1 
         }else{
            high = mid-1
         }
    }
    return low
}