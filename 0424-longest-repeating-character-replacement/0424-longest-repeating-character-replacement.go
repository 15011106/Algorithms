func characterReplacement(s string, k int) int {

    numString := len(s)
    left := 0
    maxCount := 0
    ans := 0
    freq := make(map[int]int)

    for right := 0; right < numString; right++{
        idx := int(s[right]-'A')
        freq[idx]++

        if freq[idx] > maxCount{
            maxCount = freq[idx]
        }

        for (right-left+1)-maxCount > k{
            freq[int(s[left] - 'A')]--
            left++
        }

        if right-left+1 > ans{
            ans = right - left + 1
        }
        
    }
    return ans
}