func isIsomorphic(s string, t string) bool {

    var mapOne map[byte]int
    var mapTwo map[byte]int

    mapOne = make(map[byte]int)
    mapTwo = make(map[byte]int)
     
    for i, _ := range s{

       _, ok := mapOne[s[i]]
       if !ok{
        mapOne[s[i]] = i
       }
       _, ok = mapTwo[t[i]]
       if !ok{
        mapTwo[t[i]] = i
       }

       if mapOne[s[i]] != mapTwo[t[i]]{
        return false
       }
    }

    return true
}