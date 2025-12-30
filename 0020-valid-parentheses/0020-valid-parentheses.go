func isValid(s string) bool {

    var stack Stack[rune]

    for _, v := range s{

        switch (v){
             case '(', '{', '[':
                stack.push(v)
            
            case ')', '}', ']':
                currentChar := stack.pop()
                if v == ')'{
                    if currentChar != '('{
                        return false
                    }
                }
                if v == '}'{
                    if currentChar !='{'{
                        return false
                    }
                }
                if v == ']'{
                    if currentChar != '['{
                        return false
                    }
                }
            }
        }

    if !stack.isEmpty(){
        return false
    }

    return true
}

type Stack[T any] struct {
    data []T
}

func (s *Stack[T])push(x T){
    s.data = append(s.data, x)
}

func (s *Stack[T]) pop() (x T){
    
    if s.isEmpty(){
        return x
    }

    popped := s.data[len(s.data)-1]
    s.data = s.data[:len(s.data)-1]

    return popped
}

func (s *Stack[T]) isEmpty() bool{

    if len(s.data) == 0{
        return true
    }

    return false
}