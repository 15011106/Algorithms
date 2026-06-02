type Twitter struct {
    follows map[int]map[int]bool
	tweets map[int][]tweet
    time int

}

type tweetMaxHeap []tweet

type tweet struct{
    userId int
    tweetId int
    time int
}

func (t tweetMaxHeap) Len() int{
    return len(t)
}

func (t tweetMaxHeap) Less(i, j int) bool{
    return t[i].time > t[j].time
}

func (t tweetMaxHeap) Swap(i, j int){

    t[i], t[j] = t[j], t[i]
}

func (t *tweetMaxHeap) Push(x any){
    *t = append(*t, x.(tweet))
}

func (t *tweetMaxHeap) Pop() any {
    old := *t
    lenTweet := len(old)
    
    item := old[lenTweet-1]
    *t = old[:lenTweet-1]
    return item
}

func Constructor() Twitter {

     return Twitter{
        follows:  make(map[int]map[int]bool),
        tweets: make(map[int][]tweet),
        time:0,
    }
}

func (this *Twitter) PostTweet(userId int, tweetId int)  {
    this.time =  this.time + 1
	this.tweets[userId] = append(this.tweets[userId], tweet{
        userId :userId,
        tweetId :tweetId,
        time :this.time,
    })
}

func (this *Twitter) Follow(followerId int, followeeId int) {

    if this.follows[followerId] == nil {

        this.follows[followerId] = make(map[int]bool)

    }

    this.follows[followerId][followeeId] = true

}

func (this *Twitter) Unfollow(followerId int, followeeId int) {

    if this.follows[followerId] == nil {

        return

    }

    delete(this.follows[followerId], followeeId)

}

func (this *Twitter) GetNewsFeed(userId int) []int {

    h := &tweetMaxHeap{}
    heap.Init(h)

    for _, tw := range this.tweets[userId] {
        heap.Push(h, tw)
    }

    for followeeId := range this.follows[userId] {

        for _, tw := range this.tweets[followeeId] {

            heap.Push(h, tw)

        }

    }

    result := []int{}
    for i := 0; i < 10; i++ {
        if h.Len() == 0 {
            break
    }

    tw := heap.Pop(h).(tweet)
    result = append(result, tw.tweetId)
}

    return result

}