func insert(intervals [][]int, newInterval []int) [][]int {
    ans := [][]int{}
    startNum, endNum := 0, 0
    flag := false

    if len(intervals) == 0 {
        return append(ans, newInterval)
    }

    for i := 0; i < len(intervals); i++ {
        s := intervals[i][0]
        e := intervals[i][1]

        if !flag && s > newInterval[1] {
            ans = append(ans, newInterval)
            ans = append(ans, intervals[i:]...)
            return ans
        }

        if flag && s > endNum {
            ans = append(ans, []int{startNum, endNum})
            ans = append(ans, intervals[i:]...)
            return ans
        }

        if !flag && e < newInterval[0] {
            ans = append(ans, intervals[i])
            continue
        }

        if !flag {
            flag = true
            if s < newInterval[0] {
                startNum = s
            } else {
                startNum = newInterval[0]
            }

            if e > newInterval[1] {
                endNum = e
            } else {
                endNum = newInterval[1]
            }
        } else {
            if e > endNum {
                endNum = e
            }
        }
    }

    if !flag {
        ans = append(ans, newInterval)
        return ans
    }

    ans = append(ans, []int{startNum, endNum})
    return ans
    }