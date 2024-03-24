func romanToInt(s string) int {
    var ans, prev, cur int = 0, 0, 0
    for _, v := range s {
        cur = runeToInt(v)
        if prev < cur {
            ans -= prev
        } else {
            ans += prev
        }
        prev = cur
    }
    ans += cur
    return ans
    }

func runeToInt(r rune) int {
    switch r {
    case 'I':
        return 1
    case 'V':
        return 5
    case 'X':
        return 10
    case 'L':
        return 50
    case 'C':
        return 100
    case 'D':
        return 500
    case 'M':
        return 1000
    default:
        return 0
    }
}
