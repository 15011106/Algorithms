
type Stack struct{
    s string
    open int
    close int
}
func generateParenthesis(n int) []string {

    stack := []Stack{}
    ans := []string{}

    stack = append(stack, 
    Stack{
        s :"",
        open:0,
        close:0,
    })


    for len(stack) > 0{
        idx := len(stack) - 1
        cur := stack[idx]
        stack = stack[:idx]

        if len(cur.s) == 2*n{
            ans = append(ans, cur.s)
            continue
        }

        if cur.open < n{
            stack = append (stack, Stack{
                s: cur.s+"(",
                open : cur.open+1,
                close : cur.close,
            })
        }
        
        if cur.close < cur.open {
            stack = append (stack, Stack{
                s: cur.s+")",
                open : cur.open,
                close : cur.close+1,
            })
        }        

    }
    return ans
}
