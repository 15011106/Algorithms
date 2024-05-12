func isValidSudoku(board [][]byte) bool {
    for i := 0; i < 9; i++ {
        rowMap := make(map[byte]bool)
        colMap := make(map[byte]bool)
        for j := 0; j < 9; j++ {
            if board[i][j] != '.' {
                if rowMap[board[i][j]] {
                    return false
                }
                rowMap[board[i][j]] = true
            }
            if board[j][i] != '.' {
                if colMap[board[j][i]] {
                    return false
                }
                colMap[board[j][i]] = true
            }
        }
    }

    for i := 0; i < 9; i += 3 {
        for j := 0; j < 9; j += 3 {
            boxMap := make(map[byte]bool)
            for k := 0; k < 3; k++ {
                for l := 0; l < 3; l++ {
                    if board[i+k][j+l] != '.' {
                        if boxMap[board[i+k][j+l]] {
                            return false
                        }
                        boxMap[board[i+k][j+l]] = true
                    }
                }
            }
        }
    }

    return true
}