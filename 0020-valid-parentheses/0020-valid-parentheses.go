type stack []interface{}
func (s *stack) IsEmpty() bool {
	if len(*s) == 0 {
		return true
	}
	return false
}

func (s *stack) Push(data interface{}) {
	*s = append(*s, data)
}

func (s *stack) Peek() interface{} {
	if s.IsEmpty() {
		fmt.Println("stack is empty")
		return nil
	} else {
		top := len(*s) - 1
		data := (*s)[top]
		return data
	}
}

func (s *stack) Pop() interface{} {
	if s.IsEmpty() {
		fmt.Println("stack is empty")
		return nil
	} else {
		top := len(*s) - 1
		data := (*s)[top]
		*s = (*s)[:top]
		return data
	}
}

func isValid(s string) bool {
	var st stack
	brackets := map[rune]rune{
		'(': ')',
		'[': ']',
		'{': '}',
	}

	for _, char := range s {
		if _, isOpening := brackets[char]; isOpening {
			st.Push(char)
		} else if !st.IsEmpty() && brackets[st.Peek().(rune)] == char {
			st.Pop()
		} else {
			return false
		}
	}

	return st.IsEmpty()
}