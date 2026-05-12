

func exist(board [][]byte, word string) bool {

	visited := make([][]bool, len(board))
	for i:= range visited{
		visited[i] = make([]bool, len(board[0]))
	}

	for i:=0; i<len(board) ;i++{
		for j:=0; j<len(board[0]);j++{
			if !visited[i][j] && board[i][j] == word[0]{
                visited[i][j] = true
				if retrieve(board, j, i, 1, word, visited){
					return true
				}
                visited[i][j] = false
			}
		}
	}
	return false
}

	func retrieve(board [][]byte,curX,curY, idx int, word string, visited [][]bool) bool{
		if idx == len(word){
		return true
	}

		direction := [][]int{{0,1},{0,-1},{1,0},{-1,0}}
	
		for i:=0; i<4; i++{
		x := curX + direction[i][1]
		y := curY + direction[i][0]

		if x>=0 && x<len(board[0]) && y>=0 && y < len(board){
		if !visited[y][x] && board[y][x] == word[idx]{
			visited[y][x] = true
			if retrieve(board, x, y, idx+1, word, visited){
                return true
                }
                visited[y][x] = false
            }
            }    
        }

		return false
	}


