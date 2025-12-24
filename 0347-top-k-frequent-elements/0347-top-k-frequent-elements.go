// 1. using hash record the number of frequencies
// 2. iterate index

func topKFrequent(nums []int, k int) []int {


    hash := make(map[int]int)

    for i:=0 ; i<len(nums); i++ {
        hash[nums[i]]++
    }

   arr := []int{}
    for key := range hash {
        arr = append(arr, key)
    }

    sort.Slice(arr, func(i, j int) bool {
        return hash[arr[i]] > hash[arr[j]]
    })

    if k > len(arr) {
        k = len(arr)
    }

    return arr[:k]
}