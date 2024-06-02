func minimumFuelCost(roads [][]int, seats int) int64 {
    graph := make(map[int][]int)
    for _, road := range roads {
        u, v := road[0], road[1]
        graph[u] = append(graph[u], v)
        graph[v] = append(graph[v], u)
    }

    var totalFuel int64

    var dfs func(int, int) int
    dfs = func(node int, parent int) int {
        representatives := 1
        
        for _, neighbor := range graph[node] {
            if neighbor != parent {
                representatives += dfs(neighbor, node)
            }
        }
        
        if node != 0 {
            carsNeeded := (representatives + seats - 1) / seats
            totalFuel += int64(carsNeeded)
        }
        
        return representatives
    }

    dfs(0, -1)

    return totalFuel
}