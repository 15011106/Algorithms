func exist(board [][]byte, word string) bool {
	visited := make([][]bool, len(board))
	for i := range visited {
		visited[i] = make([]bool, len(board[0]))
	}

	ans := false
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if board[i][j] == word[0] {
				if dfs(i, j, word, board, visited, 0) {
					return true
				}
			}
		}
	}
	
	return ans
}

func dfs(x int, y int, word string, board [][]byte, visited [][]bool, idx int) (ans bool) {
	if x < 0 || y < 0 || x >= len(board) || y >= len(board[0]) || visited[x][y] || board[x][y] != word[idx] {
		return false
	}

	if idx == len(word)-1 {
		return true
	}

	visited[x][y] = true
	if dfs(x+1, y, word, board, visited, idx+1) || dfs(x-1, y, word, board, visited, idx+1) || dfs(x, y+1, word, board, visited, idx+1) || dfs(x, y-1, word, board, visited, idx+1) {
		return true
	}

	visited[x][y] = false
	return false
}
