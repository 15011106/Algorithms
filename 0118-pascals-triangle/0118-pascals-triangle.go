func generate(numRows int) [][]int {
    
    num := numRows

    ans := make([][]int, num)
    for i := 0; i < num; i++ {
        ans[i] = make([]int, i+1)
    }

    for i := 0 ;i<num; i++{
        ans[i][0] = 1
        ans[i][i] = 1
    }

    if num == 1{
        return ans
    }

    for i:= 2; i<num; i ++{
        for j:= 1; j<i ;j++{
            ans[i][j] = ans[i-1][j-1] + ans[i-1][j]
        }
    }

    return ans
}