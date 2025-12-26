// 1. I think it don't requires (O^3)
// 2. It seems It could be soloved by two pointers.


func threeSum(nums []int) [][]int {

    arr := [][]int{}
    sort.Slice(nums, func(i, j int) bool{
        return nums[i] < nums[j]
    })
    
    for i :=0 ; i< len(nums)-2; i++{        
        
        if i > 0 && nums[i] == nums[i-1] {
			continue
		}

        j := i+1
        k := len(nums)-1
    
        for j < k{
            if nums[i] + nums[j] + nums[k] > 0{
                k--
            }else if nums[i] + nums[j] + nums[k] < 0{
                j++
            }else{
                arr = append(arr, []int{nums[i],nums[j],nums[k]})
                
                j++
                k--
                
                for j < k && nums[j] == nums[j-1]{
                    j++
                }
                for j< k && nums[k] == nums[k+1]{
                    k--
                }
        }
    }
    }
    return arr   
}