func plusOne(digits []int) []int {
    
    carry := false
    for i:=len(digits)-1; i>=0; i--{
        
        if carry {
            if digits[i]+1 > 9{
                digits[i] = 0
            }else{
                digits[i]++
                return digits
            }
        }else{

        if digits[i] + 1 > 9{
            carry = true
            digits[i] = 0
        }else{
            digits[i]++
            return digits
        }
        }
    }

    ans := make([]int, len(digits)+1)
    if carry{
        ans[0] = 1
    }

    return ans
}