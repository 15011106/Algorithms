func climbStairs(n int) int {

    if n == 1{
        return 1
    }

    dpArr := make([]int, n)
    dpArr[0] = 1
    dpArr[1] = 2

    for i:=2; i<n; i++{
        dpArr[i] = dpArr[i-1]+ dpArr[i-2]
    }

    return dpArr[n-1]
}
