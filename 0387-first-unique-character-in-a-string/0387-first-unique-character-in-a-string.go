func firstUniqChar(s string) int {
    	charFrequency := make(map[rune]int)

	for _, char := range s {
		charFrequency[char]++
	}

	for i, char := range s {
		if charFrequency[char] == 1 {
			return i
		}
	}

	return -1
}