func isHappy(n int) bool{

    x := make(map[int]int)
     
    for {
        sum := 0
        for n > 0{
            f := n % 10
            sum += (f*f)
            n = n/10
           }

           fmt.Println(sum)
            if sum == 1{
                break;
            }
        x[sum]++
        if x[sum] > 1{
            return false
        }
        n = sum
    }

    return true
}