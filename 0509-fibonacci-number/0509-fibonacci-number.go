func fib(n int) int {

    fi := make([]int, n+1)
    
    if n == 0{
        return 0
    }

    if n >= 1{
        fi[0] = 0
        fi[1] = 1
    }

    for i:=2; i<=n; i++{
        fi[i] = fi[i-2] + fi[i-1]
    }

    return fi[n]
}