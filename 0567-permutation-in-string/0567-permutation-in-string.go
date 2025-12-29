func checkInclusion(s1 string, s2 string) bool {
    lenS1 := len(s1)
    lenS2 := len(s2)
    if lenS2 < lenS1 {
        return false
    }

    freqS1 := make(map[byte]int)
    freqS2 := make(map[byte]int)

    for i := 0; i < lenS1; i++ {
        freqS1[s1[i]]++
        freqS2[s2[i]]++
    }

    if equalFreq(freqS1, freqS2) {
        return true
    }

    for i := 1; i <= lenS2-lenS1; i++ {
        freqS2[s2[i-1]]--
        freqS2[s2[i+lenS1-1]]++

        if equalFreq(freqS1, freqS2) {
            return true
        }
    }
    return false
}

func equalFreq(a, b map[byte]int) bool {
   
    for k, v := range a {
        if b[k] != v {
            return false
        }
    }
    return true
}