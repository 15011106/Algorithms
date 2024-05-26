func makeGood(s string) string {
        stack := []rune{}

    for _, char := range s {
        if len(stack) > 0 && ((unicode.IsLower(stack[len(stack)-1]) && unicode.ToUpper(stack[len(stack)-1]) == char) ||
            (unicode.IsUpper(stack[len(stack)-1]) && unicode.ToLower(stack[len(stack)-1]) == char)) {
            stack = stack[:len(stack)-1]
        } else {
            stack = append(stack, char)
        }
    }

    return string(stack)
}