func maxArea(height []int) int {

    start := 0
    end := len(height)-1
    ans := 0
    
    for start < end {

        w := end-start
        h := height[start]

        if h > height[end]{
            h = height[end]
        }

        area := w * h

        if area > ans {
            ans = area
        }

        if height[end] > height[start] {
            start++
        }else{
            end--
        }
    }

    return ans
}