func canConstruct(ransomNote string, magazine string) bool {
  magazineHash := make(map[rune]int)

    for _, v := range magazine {
        magazineHash[v]++
    }

    for _, v := range ransomNote {
        if magazineHash[v] == 0 {
            return false
        }
        magazineHash[v]--
    }

    return true
}