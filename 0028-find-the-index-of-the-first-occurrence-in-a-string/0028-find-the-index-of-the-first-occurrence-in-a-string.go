func strStr(haystack string, needle string) int {
    
    if len(haystack) < len(needle){
        return -1
    }


    haystackLen := len(haystack)
    needleLen := len(needle)

    for i := 0 ; i<= haystackLen-needleLen ; i++{
        if haystack[i:i+needleLen] == needle{
            return i
        }
    }

    return -1
}