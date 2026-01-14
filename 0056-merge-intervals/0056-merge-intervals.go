func merge(intervals [][]int) [][]int {

    sort.Slice(intervals, func(i, j int) bool{
        return intervals[i][0] < intervals[j][0]
    })

    prev := intervals[0]
    ans := [][]int{}
    mergedArr := []int{}

    mergedArr = append(mergedArr, prev[0])
    mergedArr = append(mergedArr,prev[1])

    for i:=1 ;i <len(intervals); i++{
        if mergedArr[1] < intervals[i][0]{
            ans = append(ans, mergedArr)
            mergedArr = []int{intervals[i][0], intervals[i][1]}
            continue
        }


        if mergedArr[1] < intervals[i][1]{
            mergedArr[1] = intervals[i][1]
        }

    }
    ans = append(ans, mergedArr)

    return ans
}