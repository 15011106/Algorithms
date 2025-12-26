func isPalindrome(s string) bool {

    if len(s) == 0{
        return true
    }

    var sb strings.Builder

    for _, v := range s{
        if (v >= 'a' && v <= 'z') || (v >= 'A' && v <= 'Z') || (v >= '0' && v<= '9'){
            sb.WriteString(string(v))
        }
    }

    str := sb.String()
    str = strings.ToLower(str)

    i := 0

    for i < len(str)-i-1 {
        if str[i] != str[len(str)-i-1]{
            return false
        }
        i++
    }

    return true
}