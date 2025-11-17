func maxProfit(prices []int) int {

    maxRight := len(prices)
    left := 0 
    ans := 0
    
    for right:=1; right<maxRight; right++{
        if prices[right] < prices[left]{
            left = right
        }else{
            currentProfit := prices[right] - prices[left]
            if currentProfit > ans{
                ans = currentProfit
            }
        }
    }

    return ans
}