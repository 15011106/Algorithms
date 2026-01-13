func insert(intervals [][]int, newInterval []int) [][]int {
   for i, seg := range intervals {
    if seg[1] < cur[0] {
        res = append(res, seg)
        continue
    }

    if seg[0] > cur[1] {
        res = append(res, cur)        
        res = append(res, intervals[i:]...)
        return res
    }

    if seg[0] < cur[0] { cur[0] = seg[0] }
    if seg[1] > cur[1] { cur[1] = seg[1] }
}
res = append(res, cur)
return res}