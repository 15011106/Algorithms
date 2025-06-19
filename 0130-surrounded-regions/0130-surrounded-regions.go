func solve(board [][]byte)  {
    

    m := len(board[0])
    n := len(board)

    var dfs func(int, int)

    dfs = func(x , y int){

   if x < 0 || y < 0 || x >= n || y >= m || board[x][y] != 'O' {
            return
        }
        
        board[x][y] = 'V'

        dx := []int{1,0,-1,0}
        dy := []int{0,1,0,-1}

        for i:=0; i<4; i++{

            nx := dx[i] + x
            ny := dy[i] + y
            if 0 <= nx && 0 <= ny && nx < len(board) && ny < len(board[0]) {
                dfs(nx,ny)
            }
        }

        return
    }

   for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            if i == 0 || j == 0 || i == n - 1 || j == m - 1 {
                if board[i][j] == 'O' {
                    dfs(i, j)
                }
            }
        }
    }
    

    for i:=0; i<n;i++{
        for j:=0 ;j<m; j++{
            if board[i][j] == 'O'{
                board[i][j] = 'X'
                }else if board[i][j] == 'V'{
                        board[i][j] = 'O'
                    }
                }
        }
    }
