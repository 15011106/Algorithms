func isPalindrome(x int) bool {
    if x < 0{
        return false
    }

    ogNumber := x
    rNumber :=0

    for {
        if ogNumber <= 0 {
            break
        }
        rNumber = rNumber * 10 + (ogNumber%10)
        ogNumber = ogNumber/10
    }

    return rNumber == x
}