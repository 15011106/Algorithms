func isPalindrome(s string) bool {
    
    var sArray []rune
    for _,v := range s{
        if (v >= 'a' && v <= 'z') || (v >= 'A' && v <= 'Z'){
           sArray = append(sArray, unicode.ToLower(v)) 
        }else if (v >= '0' && v <= '9'){
        sArray = append(sArray, v) 
        }
    }


    if len(sArray) == 1{
        return true
    }

    p1 := 0
    p2 := len(sArray)-1
    ans := true

    for p1 < p2{
        if sArray[p1] == sArray[p2]{
            p1++
            p2--
            continue
        }else{
            return false
        }
    }

    return ans
}