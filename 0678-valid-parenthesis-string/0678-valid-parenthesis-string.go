func checkValidString(s string) bool {

    var lp  stack[rune]
    var star stack[rune]
    
    for _,v := range s{

        if v == '('{
            lp.push(v)
        }else if v == '*'{
            star.push(v)
        }else{
            if !lp.isEmpty(){
                lp.pop()
                continue
            }else if !star.isEmpty(){
                star.pop()
                continue
            }else{
                return false
            }
        }
    }

    if lp.isEmpty(){
        return true
    }

    if len(star.data) < len(lp.data){
        return false
    }

    return true
}

type stack [T any] struct{
    data[] T
}

func (s *stack[T]) push (x T){
    s.data = append(s.data, x)
}

func (s *stack[T]) pop() (x T){
    if s.isEmpty(){
        return x
    }
    
    last := s.data[len(s.data)-1]
    s.data = s.data[:len(s.data)-1]
    return last
}

func (s *stack[T]) isEmpty() bool{

    if len(s.data) != 0{
        return false
    }

    return true
}