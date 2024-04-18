
func snakesAndLadders(board [][]int) int {
    n := len(board)
    maxNum := n * n

    flatBoard := make([]int, maxNum+1)
    idx := 1
    for i := n - 1; i >= 0; i-- {
        if (n-i)%2 == 1 {
            for j := 0; j < n; j++ {
                flatBoard[idx] = board[i][j]
                idx++
            }
        } else {
            for j := n - 1; j >= 0; j-- {
                flatBoard[idx] = board[i][j]
                idx++
            }
        }
    }

    queue := []int{1}
    visited := make([]bool, maxNum+1)
    moves := 0

    for len(queue) > 0 {
        size := len(queue)
        for i := 0; i < size; i++ {
            curPos := queue[0]
            queue = queue[1:]

            if curPos == maxNum {
                return moves
            }

            for dice := 1; dice <= 6 && curPos+dice <= maxNum; dice++ {
                nextPos := curPos + dice
                if flatBoard[nextPos] != -1 {
                    nextPos = flatBoard[nextPos]
                }
               if !visited[nextPos] {
                    visited[nextPos] = true
                    queue = append(queue, nextPos)
                }
            }
        }
        moves++
    }

    return -1
}
