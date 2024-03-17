func maxProfit(prices []int) int {
    
    minPrice := prices[0]
    maxProfit :=0 

    for i := 0; i< len(prices); i++{
        tempProfit := prices[i] - minPrice
        maxProfit = max(maxProfit,tempProfit)
        minPrice = min(minPrice, prices[i])
    }

    return maxProfit
}