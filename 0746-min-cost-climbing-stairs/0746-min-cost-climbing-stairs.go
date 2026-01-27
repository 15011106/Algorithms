func minCostClimbingStairs(cost []int) int {
	lenCost := len(cost)
	dp := make([]int, lenCost)
	dp[0] = cost[0]
	dp[1] = cost[1]

	for i:=2; i<len(cost) ;i++{
	min := dp[i-1]
	if dp[i-1] > dp[i-2]{
	    min = dp[i-2]
	}
	dp[i] = min + cost[i]
	}

    if dp[len(cost)-1] < dp[len(cost)-2]{
        return dp[len(cost)-1]
    }
    
	return dp[len(cost)-2]
}