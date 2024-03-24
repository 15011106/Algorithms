

type NodeQueue struct {
	nodes []*TreeNode
}

func (q *NodeQueue) Enqueue(node *TreeNode) {
	q.nodes = append(q.nodes, node)
}

func (q *NodeQueue) Dequeue() *TreeNode {
	if len(q.nodes) == 0 {
		return nil
	}
	node := q.nodes[0]
	q.nodes = q.nodes[1:]
	return node
}

func averageOfLevels(root *TreeNode) []float64 {
	var result []float64
	if root == nil {
		return result
	}

	q := NodeQueue{}
	q.Enqueue(root)

	for len(q.nodes) > 0 {
		levelSize := len(q.nodes)
		sum := 0

		for i := 0; i < levelSize; i++ {
			node := q.Dequeue()
			sum += node.Val

			if node.Left != nil {
				q.Enqueue(node.Left)
			}
			if node.Right != nil {
				q.Enqueue(node.Right)
			}
		}

		average := float64(sum) / float64(levelSize)
		result = append(result, average)
	}

	return result
}