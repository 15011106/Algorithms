func wordPattern(pattern string, s string) bool {
    splitString := strings.Split(s, " ")
    mapOne := make(map[byte]int)
    mapTwo := make(map[string]int)

    for i, _ := range pattern {
        _, ok := mapOne[pattern[i]]
        if !ok {
            mapOne[pattern[i]] = i
        }

        _, ok = mapTwo[splitString[i]]
        if !ok {
            mapTwo[splitString[i]] = i
        }

        if mapOne[pattern[i]] != mapTwo[splitString[i]] {
            return false
        }
    }

    return true
}