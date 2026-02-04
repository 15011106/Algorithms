func longestConsecutive(nums []int) int {

    numMap := make(map[int]int)
    maxCnt := 0

    for i:=0 ;i <len(nums); i++{
        numMap[nums[i]] = 1
    }

    for k, _ := range numMap{
        _, exist := numMap[k-1]
        if exist{
            continue
        }else{
            tempCnt := 1
            for{
                k++
                _, exist := numMap[k]
                if exist{
                    tempCnt++
                }else{
                    break
                }
            }
            if tempCnt > maxCnt{
                maxCnt = tempCnt
            }
        }
    }

    return maxCnt
}
