func finalPrices(prices []int) []int {
    n := len(prices)
    result := make([]int, n)
    copy(result, prices)
    var stack []int

    for i := 0; i < n; i++ {
        for len(stack) > 0 && prices[stack[len(stack)-1]] >= prices[i] {
            index := stack[len(stack)-1]
            stack = stack[:len(stack)-1] // pop from stack
            result[index] = prices[index] - prices[i]
        }
        stack = append(stack, i)
    }

    return result
}