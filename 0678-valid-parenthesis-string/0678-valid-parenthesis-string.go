func checkValidString(s string) bool {

    var lp  stack[int]
    var star stack[int]


    for i,v := range s{

        if v == '('{
            lp.push(i)
        }else if v == '*'{
            star.push(i)
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

    for !lp.isEmpty() && !star.isEmpty(){

        l := lp.pop()
        st := star.pop()

        if l > st{
            return false
        }
    }

    return lp.isEmpty()
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