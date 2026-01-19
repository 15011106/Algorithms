func findRedundantConnection(edges [][]int) []int {

    parent := make([]int, len(edges)+1)
    rank := make([]int ,len(edges)+1)
    
    for i, _ := range edges{
        parent[i+1] = i+1
    }

    uf := &UnionFind{
        parent: parent,
        rank: rank,
    }

    	for _, e := range edges {
		u, v := e[0], e[1]
		if !uf.Union(u, v) {
			return []int{u, v}
		}
	}

	return nil

}

type UnionFind struct{
    parent []int
    rank []int
}



func (uf *UnionFind) Find(x int) int{
    if uf.parent[x] != x{
        uf.parent[x] = uf.Find(uf.parent[x])
    }

    return uf.parent[x]
}

func (uf *UnionFind) Union(a,b int) bool{

    ra := uf.Find(a)
    rb := uf.Find(b)

    if ra == rb{
        return false
    }

	if uf.rank[ra] < uf.rank[rb] {
		uf.parent[ra] = rb
	} else if uf.rank[ra] > uf.rank[rb] {
		uf.parent[rb] = ra
	} else {
		uf.parent[rb] = ra
		uf.rank[ra]++
	}
	return true
}
