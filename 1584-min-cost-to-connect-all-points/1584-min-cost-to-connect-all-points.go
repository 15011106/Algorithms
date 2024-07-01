type Edge struct {
	src, dest, weight int
}

type Subset struct {
	parent, rank int
}

func find(subsets []Subset, i int) int {
	if subsets[i].parent != i {
		subsets[i].parent = find(subsets, subsets[i].parent)
	}
	return subsets[i].parent
}

func union(subsets []Subset, x, y int) {
	rootX := find(subsets, x)
	rootY := find(subsets, y)

	if subsets[rootX].rank < subsets[rootY].rank {
		subsets[rootX].parent = rootY
	} else if subsets[rootX].rank > subsets[rootY].rank {
		subsets[rootY].parent = rootX
	} else {
		subsets[rootX].parent = rootY
		subsets[rootY].rank++
	}
}


func manhattanDistance(p1, p2 []int) int {
    return abs(p1[0]-p2[0]) + abs(p1[1]-p2[1])
}

func abs(x int) int {
    if x < 0 {
        return -x
    }
    return x
}

func minCostConnectPoints(points [][]int) int {
  	var edges []Edge
	n := len(points)

	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			weight := manhattanDistance(points[i], points[j])
			edges = append(edges, Edge{i, j, weight})
		}
	}

    sort.Slice(edges, func(i,j int) bool{
		return edges[i].weight < edges[j].weight
    })
    
    subsets := make([]Subset, n)

    for i := range subsets {
		subsets[i] = Subset{i, 0}
	}

    minCost := 0

	for _, edge := range edges {
		x := find(subsets, edge.src)
		y := find(subsets, edge.dest)

		if x != y {
			minCost += edge.weight
			union(subsets, x, y)
		}
	} 
    return minCost
}