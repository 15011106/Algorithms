func findOrder(numCourses int, prerequisites [][]int) []int {
    adj := make([][]int, numCourses)
    for _, v := range prerequisites{
        a, b := v[0], v[1]
        adj[b] = append(adj[b], a)
    }

    state := make([]int, numCourses)
    order := make([]int, 0,numCourses)
    hasCycle := false
    
    var dfs func(int)

    dfs = func(u int){
        
        if hasCycle{
            return
        }

        state[u] = 1
        for _, v := range adj[u]{
            if state[v] == 0{
                dfs(v)
                if hasCycle{
                    return
                    }
        } else if state[v] == 1{
            hasCycle = true
            return
        }
        }
        state[u] = 2
        order = append(order, u)
    }

    for i:=0; i<numCourses; i++{
        if state[i] == 0{
            dfs(i)
            if hasCycle{
                return []int{}
            }
        }
    }
    
    for i, j := 0, len(order)-1; i < j; i, j = i+1, j-1 {
        order[i], order[j] = order[j], order[i]
    }

    return order
}