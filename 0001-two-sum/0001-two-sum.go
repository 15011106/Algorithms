func twoSum(nums []int, target int) []int {

      indexMap := make(map[int]int)

    for i, num := range nums {
        complement := target - num
        
        if index, ok := indexMap[complement]; ok {
            return []int{index, i}
        }
        indexMap[num] = i
    }
    return []int{}
    
}