package leetCode

func majorityElement(nums []int) int {

	numsLen := len(nums) / 2
	ans := 0

	var numsMap map[int]int
	numsMap = make(map[int]int)

	for _, v := range nums {

		numsMap[v] += 1

		if numsMap[v] > numsLen {
			ans = v
			break
		}
	}

	return ans
}
