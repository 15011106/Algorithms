func isInterleave(s1 string, s2 string, s3 string) bool {

    s1Len := len(s1)
    s2Len := len(s2)

    if s1Len + s2Len != len(s3){
        return false
    }

    dp := make([][]bool, s1Len+1)

    for i:=0; i<= s1Len; i++{
        dp[i] = make([]bool, s2Len+1)
    }

    dp[0][0] = true

    for i:=1 ; i<=s1Len ;i++{
        dp[i][0] = dp[i-1][0] &&(s1[i-1] == s3[i-1])
    }

    for i:=1; i<=s2Len; i++{
        dp[0][i] = dp[0][i-1] && (s2[i-1] == s3[i-1])
    }

    for i:=1 ;i<= s1Len ;i++{
        for j:=1 ;j<= s2Len ;j++{
            k := i+j
            dp[i][j] = dp[i-1][j] && (s1[i-1] == s3[k-1]) || dp[i][j-1] && (s2[j-1] == s3[k-1])
        }
    }

    return dp[s1Len][s2Len]
}