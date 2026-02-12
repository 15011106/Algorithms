
func minEatingSpeed(piles []int, h int) int {

	min :=1
	max :=0
	maxAns := 0

	for i:=0; i<len(piles);i++{
		if piles[i] > max {
			max = piles[i]
		}
	}

		for min <= max{
			mid := (min+max) /2
			tempNum := 0

			for i:=0; i<len(piles); i++{
				tempNum += piles[i] / mid
				if piles[i] % mid != 0{
					tempNum++
				} 
			}

			if tempNum <= h{
				if mid < maxAns {
					maxAns = mid
				}
				max = mid-1
			}else{
				min = mid+1
			}
		}


		return maxAns

}