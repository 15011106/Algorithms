func islandPerimeter(grid [][]int) int {
    rows := len(grid)
    cols := len(grid[0])
    visited := make([][]bool, rows)
    for i := range visited {
        visited[i] = make([]bool, cols)
    }

    for i := 0; i < rows; i++ {
        for j := 0; j < cols; j++ {
            if grid[i][j] == 1 {
                return dfs(i, j, grid, visited)
            }
        }
    }

    return 0 
}

var visited [][]bool

func dfs(x, y int, grid [][]int, visited [][]bool) int {
    dx := []int{0, -1, 0, 1}
    dy := []int{-1, 0, 1, 0}

    if visited[x][y] {
        return 0
    }

    visited[x][y] = true
    ans := 0

    for i := 0; i < 4; i++ {
        nx := x + dx[i]
        ny := y + dy[i]

        if nx < 0 || ny < 0 || nx >= len(grid) || ny >= len(grid[0]) || grid[nx][ny] == 0 {
            ans += 1
        } else if !visited[nx][ny] && grid[nx][ny] == 1 {
            ans += dfs(nx, ny, grid, visited)
        }
    }

    return ans
}