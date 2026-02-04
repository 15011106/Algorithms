func reverse(x int) int {

const MaxInt32 = 1<<31 - 1
const MinInt32 = -1 << 31 

    ans := 0 
    
    for x != 0{
        cur := x % 10
        x = x / 10

        if ans > MaxInt32/10 || (ans == MaxInt32 / 10 && cur >7){
            return 0
        }

        if ans < MinInt32/10 || (ans == MinInt32 / 10 && cur < -8){
            return 0
        }

        ans = ans * 10 + cur
    }

    return ans
}
