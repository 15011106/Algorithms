
type Edge struct {
	src  Point
	dst  Point
	cost int
}

type Point struct {
	x, y int
}

func manhattanDist(p1, p2 Point) int {
	return int(math.Abs(float64(p1.x-p2.x)) + math.Abs(float64(p1.y-p2.y)))
}

type PriorityQueue []Edge

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}
func (pq PriorityQueue) Less(i, j int) bool {
		return pq[i].cost < pq[j].cost
}
func (pq PriorityQueue) Len() int {
	return len(pq)
}

func (pq *PriorityQueue) Push(x interface{}) {
	*pq = append(*pq, x.(Edge))
}

func (pq *PriorityQueue) Pop() (x interface{}) {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[0 : n-1]
    return item
}

func minCostConnectPoints(points [][]int) int {
	n := len(points)
	if n == 0 {
		return 0
	}

    visited := make(map[Point]bool)
    pq := &PriorityQueue{}
    heap.Init(pq)

    startPoint := Point{points[0][0], points[0][1]}
    visited[startPoint] = true

	for i := 1; i < n; i++ {
        dstPoint := Point{points[i][0], points[i][1]}
        cost := manhattanDist(startPoint, dstPoint)
        heap.Push(pq, Edge{src: startPoint, dst: dstPoint, cost: cost})
    }

	totalCost := 0

	for pq.Len() > 0 {
		edge := heap.Pop(pq).(Edge)

		if visited[edge.dst] {
			continue
		}

		totalCost += edge.cost
		visited[edge.dst] = true

		for _, point := range points {
            dstPoint := Point{point[0], point[1]}
			if !visited[dstPoint] {
				heap.Push(pq, Edge{src: edge.dst, dst: dstPoint, cost: manhattanDist(edge.dst, dstPoint)})
			}
		}
	}

	return totalCost
}