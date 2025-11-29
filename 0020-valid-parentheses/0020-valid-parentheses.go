func isValid(s string) bool {

    if (len(s) %2 != 0){
        return false
    }

    var stack Stack[rune]
    pairs := make(map[rune]rune)
    pairs[')'] = '('
    pairs['}'] = '{'
    pairs[']'] = '['


    for _,v := range s{
        switch (v){
            case '(', '{', '[':
            stack.push(v)
            
            case ')', '}', ']':
            if stack.isEmpty(){
                return false
            }

            pop, t := stack.pop()
            if t == false {
                return false
            }

            if pop != pairs[v]{
                return false
            }
            default:
        }
    }

    return stack.isEmpty()
}

type Stack[T any] struct{
    data []T
}

func (s *Stack[T]) push(x T){
    s.data = append(s.data, x)
}

func (s *Stack[T]) pop() (T, bool){
    var zero T
    if len(s.data) == 0 {
        return zero, false
        }
    top := s.data[len(s.data)-1]
    s.data = s.data[:len(s.data)-1]
    return top, true
}

func (s *Stack[T]) isEmpty () bool{
    if len(s.data) == 0{
        return true
    }

    return false
}
