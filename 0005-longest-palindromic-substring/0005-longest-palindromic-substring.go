func longestPalindrome(s string) string {
    
    var buffer bytes.Buffer
    buffer.WriteByte('*')

    for i:=0; i<len(s); i++{
        buffer.WriteByte(s[i])
        buffer.WriteByte('*')
    }

    qs := buffer.String()

    center := 0
    radius := 0
    dp := make([]int, len(qs))

    for center < len(qs){
        for center-radius-1 >=0 && center+radius + 1 < len(qs){
            if qs[center-radius-1] == qs[center+radius+1]{
                radius++
            }else{
                break
            }
        }

        dp[center] = radius
        oldCenter, oldRadius := center,radius
        upperBound := oldCenter + oldRadius

        center++
        radius = 0
        for center <= upperBound {
            mirror := 2 * oldCenter - center
            mmr := upperBound - center
            
            if dp[mirror] == mmr {
                radius = mmr
                break
            } 
            
            dp[center] = minVal(dp[mirror], mmr)
            center++
        }
    }

    max := 0
    maxIdx := 0

    for i, v := range dp{
        if dp[i] > max{
            max = v
            maxIdx = i
        }
    }

    ansString := qs[maxIdx-max:maxIdx+max+1]
    
    var ansBuffer bytes.Buffer
    for i:=1; i<len(ansString); i+=2{
        ansBuffer.WriteByte(ansString[i])
    }

    return ansBuffer.String()
}

func minVal(x int, y int) int{
    if x < y{
        return x
    }
    return y
}