func summaryRanges(nums []int) []string {
    	n := len(nums)
	if n == 0 {
		return nil
	}

	result := make([]string, 0)
	start, end := nums[0], nums[0]

	for i := 1; i < n; i++ {
		if nums[i] == end+1 {
			end = nums[i]
		} else {
			if start == end {
				result = append(result, strconv.Itoa(start))
			} else {
				result = append(result, fmt.Sprintf("%d->%d", start, end))
			}
			start, end = nums[i], nums[i]
		}
	}

	if start == end {
		result = append(result, strconv.Itoa(start))
	} else {
		result = append(result, fmt.Sprintf("%d->%d", start, end))
	}

	return result
    
}