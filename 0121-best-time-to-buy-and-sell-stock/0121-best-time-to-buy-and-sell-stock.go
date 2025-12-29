

// 1. should it be ascend? to get maximum difference?
// 2. How could I get maxProfit???


func maxProfit(prices []int) int {

    min := prices[0]
    maxProfit := 0

    for i:=1; i < len(prices); i++{
        
        if min > prices[i]{
            min = prices[i]
            continue
        }

        if prices[i] - min > maxProfit{
            maxProfit = prices[i] - min
        }
    }

    return maxProfit
}