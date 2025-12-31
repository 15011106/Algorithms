
func search(nums []int, target int) int {

    sort.Slice(nums, func(i, j int) bool{
        return i < j
    })

    high := len(nums)-1
    low := 0

    for low <= high {
        
        mid := (high+low) /2
        if nums[mid] == target{
            return mid
        }

        if nums[mid] < target{
            low = mid+1
        }else{
            high = mid-1
        }
    }

    return -1
}