func uniquePaths(m int, n int) int {
    ans := make([][]int, n)
    for i:=0 ;i<n; i++{
        ans[i] = make([]int, m)
    }

    for i:=0; i<m; i++{
        ans[0][i] = 1
    }

    for j:=0 ;j<n; j++{
        ans[j][0] = 1
    }
    
    for i:=1 ; i < m ; i++{
        for j:=1; j < n; j++{
            ans[j][i] = ans[j-1][i] + ans[j][i-1]
        }
    }

    return ans[n-1][m-1]
}
