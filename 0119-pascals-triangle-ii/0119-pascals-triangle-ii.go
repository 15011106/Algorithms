func getRow(rowIndex int) []int {
    ans := make([][]int, rowIndex+1)
        for i := range ans {
            ans[i] = make([]int, rowIndex+1) 
        }

    ans[0][0] = 1

    for i:=1 ; i <= rowIndex ;i++{
        ans[i][0] = 1
        ans[i][i] = 1
    }

    for i:=2; i<= rowIndex ; i++{
         for j:=1; j < rowIndex; j++{
            ans[i][j] = ans[i-1][j-1]+ans[i-1][j]
         }
    }

    return ans[rowIndex]
}