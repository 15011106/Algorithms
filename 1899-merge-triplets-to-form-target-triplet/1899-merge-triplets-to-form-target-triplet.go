func mergeTriplets(triplets [][]int, target []int) bool {
    refinedTriplets := [][]int{}
        for j:=0 ; j<len(triplets); j++{
            if target[0] >= triplets[j][0]&& target[1] >= triplets[j][1] && target[2] >= triplets[j][2]{
                refinedTriplets = append(refinedTriplets, triplets[j])
                }
    }

    for i:=0; i<len(target); i++{
        integerExists := false
        for j:=0; j<len(refinedTriplets);j++{
            if (refinedTriplets[j][i] == target[i]){
                integerExists = true
            }
        }
        if !integerExists{
            return false
        }
    }  

    return true
}