func orangesRotting(grid [][]int) int {

    type coords struct{
        cnt int
        xCoord int
        yCoord int
    }

    xLen := len(grid[0])
    yLen := len(grid)

    nextCoords := [][]int{{0,1},{1,0},{-1,0},{0,-1}}
    visited := make([][]bool, yLen)

    for i := 0; i < yLen; i++ {
        visited[i] = make([]bool, xLen)
        }    
        
    queue := []coords{}
    max :=0
    
    for i:=0; i<yLen; i++{
        for j:=0; j<xLen; j++{
            if grid[i][j] == 2 {
                queue = append(queue, coords{xCoord: i, yCoord: j, cnt:0})
                visited[i][j] = true
            }
        }
    }

    var bfs func()
    bfs = func(){
        for len(queue)!=0{
            curCoords := queue[0]
            curCnt := curCoords.cnt
            if curCnt > max {
                max = curCnt
            }

            queue = queue[1:]
            
            for _,v := range nextCoords{

                nextX := curCoords.xCoord+v[0]
                nextY := curCoords.yCoord+v[1]
                if (nextX >=0 && nextY >= 0 && nextX < xLen && nextY < yLen){
                    if !visited[nextX][nextY] && grid[nextX][nextY] != 0{
                        visited[nextX][nextY] = true
                        if grid[nextX][nextY] == 1 {
                            grid[nextX][nextY] = 2
                        } 
                        queue = append(queue, coords{xCoord: nextX, yCoord: nextY, cnt: curCnt+1})
                    }
                }
            }

        }
    }

    bfs()

    for i:=0; i<yLen; i++{
        for j:=0; j<xLen; j++{
            if grid[i][j] == 1{
                return -1
                }
            }
        }


    return max
}