func twoSum(numbers []int, target int) []int {


    ans := []int{}
    eIndex := len(numbers)
    for i := 0; i< eIndex; i++{
        for j:= eIndex-1; i<j; j--{
            if numbers[i]+numbers[j] == target{
                ans = append(ans, i+1, j+1)    
            }
        }
    }
    return ans
}