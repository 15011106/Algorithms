func lengthOfLongestSubstring(s string) int {

    left := 0
    ans := 0 
    strMap := make(map[string]int)
    curAns := 0

    for right, v := range s{     
        prevNum, exist := strMap[string(v)]
        if exist{
            if prevNum >= left{
                left = prevNum+1
                }
                strMap[string(v)] = right
        }else{
            strMap[string(v)] = right
        }
            curAns = right - left + 1
            if curAns > ans {
                    ans = curAns
            }
        }   
    return ans
}