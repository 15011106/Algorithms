package leetCode

func isSubsequence(s string, t string) bool {

	pointerOne := 0
	pointerTwo := 0

	for pointerOne < len(s) && pointerTwo < len(t) {
		if s[pointerOne] == t[pointerTwo] {
			pointerOne++
			pointerTwo++
		} else {
			pointerTwo++
		}
	}

	if pointerOne == len(s) {
		return true
	} else {
		return false
	}

}
