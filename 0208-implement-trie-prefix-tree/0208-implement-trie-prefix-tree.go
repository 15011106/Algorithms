type Trie struct {
    Text string
    Left *Trie
    Right *Trie
}


func Constructor() Trie {

    var trie Trie
    return trie
}

func (this *Trie) Insert(word string)  {

    var bfs func(trie *Trie)
    bfs = func(trie *Trie){
        queue := []*Trie{}
        queue = append(queue, trie)
        
        for len(queue)>0{
            curTrie := queue[0]
            queue = queue[1:]
            if curTrie.Left == nil || curTrie.Right == nil{
            if curTrie.Left == nil{
                nextTrie := &Trie{
                Text: word,
                Left: nil,
                Right: nil,
                }
                curTrie.Left = nextTrie
                } else {
                    nextTrie := &Trie{
                        Text: word,
                        Left: nil,
                        Right: nil,
                    }
                        curTrie.Right =nextTrie
                        }   
                        break
            }else{
                queue = append(queue, curTrie.Left, curTrie.Right)

    }
    }
    }

    bfs(this)

}


func (this *Trie) Search(word string) bool {
    var dfs func(this *Trie) bool 
    dfs = func(this *Trie) bool{
        if this == nil{
            return false
        }

        if this.Text == word{
            return true
        }

    left := dfs(this.Left)
    right := dfs(this.Right)

    return left || right
    }

    search := dfs(this)
    return search
}


func (this *Trie) StartsWith(prefix string) bool {
        var dfs func(this *Trie) bool 
    dfs = func(this *Trie) bool{
        if this == nil{
            return false
        }

        if strings.HasPrefix(this.Text, prefix){
            return true
        }


    left := dfs(this.Left)
    right := dfs(this.Right)
    return left || right
    }

    startWith := dfs(this)
    return startWith
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */