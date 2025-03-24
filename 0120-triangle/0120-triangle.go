func minimumTotal(triangle [][]int) int {
    dp := make([][]int, len(triangle))

    for i, _ := range dp{
        dp[i] = make([]int, i+1)
    }

    dp[0][0] = triangle[0][0]

    for i:=1 ; i < len(triangle); i++{
        for j:=0; j < len(triangle[i]); j++{
            if j == 0{
                dp[i][j] = triangle[i][j] + dp[i-1][j]
                continue
            }
            
            if j == len(triangle[i])-1{
                dp[i][j] = triangle[i][j] + dp[i-1][j-1]
                continue
            }

            dp[i][j] = triangle[i][j] + findMinNum(dp[i-1][j], dp[i-1][j-1])
        }
    }

    ans := dp[len(triangle)-1][0]

    for _, v:= range dp[len(triangle)-1]{
        if ans > v{
            ans = v
        }
    }

    return ans
}

func findMinNum(a, b int) (minNum int) {

    if a < b{
        return a
    }

    return b
}