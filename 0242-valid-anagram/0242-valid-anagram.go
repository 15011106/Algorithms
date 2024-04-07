func isAnagram(s string, t string) bool {

    mapS := make(map[byte]int)
    mapT := make(map[byte]int)

    if len(s) != len(t){
        return false
    }

    for i, _ := range(s){    
        mapS[s[i]]++
        mapT[t[i]]++
    }
    
      for k, v := range mapS {
        if mapT[k] != v {
            return false
        }
    }

    return true
}