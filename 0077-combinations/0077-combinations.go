func combine(n int, k int) [][]int {
    res := make([][]int, 0)
    arr := make([]int, 0, k)

    var dfs func(start int)
    dfs = func(start int) {
        if len(arr) == k {
            tmp := make([]int, k)
            copy(tmp, arr)
            res = append(res, tmp)
            return
        }

        for i := start; i <= n; i++ {
            arr = append(arr, i) 
            dfs(i + 1) 
            arr = arr[:len(arr)-1]
        }
    }

    dfs(1)
    return res
}