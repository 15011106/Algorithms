func sumOfSquares(n int) int {
    sum := 0
    for n > 0 {
        digit := n % 10
        sum += digit * digit
        n /= 10
    }
    return sum
}

func isHappy(n int) bool {
    seen := map[int]bool{}
    
    for n != 1 && !seen[n] {
        seen[n] = true
        n = sumOfSquares(n)
    }
    
    return n == 1
}
