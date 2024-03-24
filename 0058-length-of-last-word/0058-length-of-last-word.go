func lengthOfLastWord(s string) int {

    s = strings.Trim(s," ")
    stringArr := strings.Split(s, " ")
    return len(stringArr[len(stringArr)-1])
    
}