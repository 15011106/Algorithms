func evalRPN(tokens []string) int {


    var s Stack[int]

    for i, _ := range tokens{
        
        v := tokens[i]
        switch (v){
            case "+":
            v2 := s.pop()
            v1 := s.pop()
            addition := v1 + v2 
            s.push(addition)

            case "-":
            v2 := s.pop()
            v1 := s.pop()
            subtraction := v1 - v2
            s.push(subtraction)

            case "*":
            v2 := s.pop()
            v1 := s.pop()
            multiplication := v1 * v2
            s.push(multiplication)

            case "/":
            v2 := s.pop()
            v1 := s.pop()
            division := v1 / v2
            s.push(division)

            default:
            num, _ := strconv.Atoi(v)
            s.push(num)
        }
    }

    return s.pop()
}


type Stack[T any] struct{
    data []T
}

func (s *Stack[T]) pop() T{
    v := s.data[len(s.data)-1]
    s.data = s.data[:len(s.data)-1]
    
    return v
}

func (s *Stack[T]) push(v T) {
    s.data = append(s.data, v)
}

func (s *Stack[T]) isEmpty() bool{

    return len(s.data) == 0
}