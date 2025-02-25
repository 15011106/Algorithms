func countBits(n int) []int {
    
    ans := make([]int, n+1)
    sub := 2
    
    ans[0] = 0
    if n >=1{
        ans[1] = 1
    }

    for i:=2; i<=n;i++{
        
        if sub * 2 == i{
            sub = i
        }

        ans[i] = ans[i-sub] + 1
    }

    return ans
}