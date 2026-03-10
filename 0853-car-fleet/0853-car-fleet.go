func carFleet(target int, position []int, speed []int) int {

    carTelemetries := make([]telemetry, len(position))
    for i:=0; i<len(position);i++{
        carTelemetries[i] = telemetry{
            position :position[i],
            speed :speed[i],
        }
    }

    sort.Slice(carTelemetries, func (i, j int) bool{
        return carTelemetries[i].position > carTelemetries[j].position
    })

    var st stack[float64]

    for i := 0 ; i < len(carTelemetries); i++{
        t := float64(target - carTelemetries[i].position) / float64(carTelemetries[i].speed)

        if st.isEmpty(){
            st.push(t)
            continue
        }

        last := st.pop()

        if t > last{
            st.push(last)
            st.push(t)
        }else{
            st.push(last)
        }
    }

    return len(st.data)
}

type telemetry struct{
    position int
    speed int
}

func (s *stack[T]) isEmpty() bool{
    if len(s.data) == 0{
        return true
    }

    return false
}

func (s *stack[T]) pop() (x T){  
    if s.isEmpty(){
        return x
    }

    last := s.data[len(s.data)-1]
    s.data = s.data[:len(s.data)-1]

    return last
}

func (s *stack[T]) push (x T){
    s.data = append(s.data, x)
}

type stack[T any] struct{
    data []T
}