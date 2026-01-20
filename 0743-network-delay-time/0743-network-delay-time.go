
func networkDelayTime(times [][]int, n int, k int) int {
    graph := make([][][2]int, n+1)

    for _, t := range times{
        u,v,w := t[0],t[1],t[2]
        graph[u] = append(graph[u], [2]int{v,w})
    }

    inf := math.MaxInt
    dist := make([]int, n+1)
    for i:=1 ; i<=n; i++{
        dist[i] = inf
    }
    dist[k] = 0
    
    pq := &MinHeap{}
    heap.Init(pq)
    heap.Push(pq, Item{node:k, dist:0})

    for pq.Len() >0{
        cur := heap.Pop(pq).(Item)
        u := cur.node
        d := cur.dist

        if d > dist[u]{
            continue
        }

        for _, edge := range graph[u] {
            v, w := edge[0], edge[1]
            nd := d + w
            if nd < dist[v]{
                dist[v] = nd
                heap.Push(pq, Item{node: v, dist: nd})
            }
        }
    }
    ans := 0
    for i:=1 ; i <=n ;i ++{
        if dist[i] == inf{
        return -1
        }

        if dist[i] > ans{
            ans = dist[i]
        }
    }
    return ans
}

type MinHeap []Item
type Item struct{
    node int
    dist int
}
func (h MinHeap) Less(i, j int) bool{
    return h[i].dist<h[j].dist
}
func (h MinHeap) Swap(i, j int){
    h[i],h[j] = h[j], h[i]
}
func (h MinHeap) Len() int{
    return len(h)
}
func (h *MinHeap)Push(x interface{}){
    *h = append(*h, x.(Item))
}

func (h *MinHeap)Pop() interface{}{
    old := *h
    n := len(old)
    item := old[n-1]
    *h = old[:n-1]

    return item
}