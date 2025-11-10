func isPalindrome(s string) bool {

    var alphaStr strings.Builder
    ans := true

    for _, v := range(s){
        if isAlpha(byte(v)){
            alphaStr.WriteString(string(v))
        }
    }
    
    str := strings.ToLower(alphaStr.String())
    eIndex := len(str)-1
    for i := 0 ; i <= eIndex; i++{
        if str[i] != str[eIndex-i]{
            return false
        }
    }

    return ans
}

func isAlpha(c byte) bool{
    return (c >= 'a' && c<= 'z') || (c >='A' && c <='Z') || (c >= '0' && c <= '9')
}