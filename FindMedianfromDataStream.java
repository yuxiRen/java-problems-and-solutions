public class FindMedianfromDataStream {
    private PriorityQueue<Integer> smallHalf;
    private PriorityQueue<Integer> bigHalf;
    /** initialize your data structure here. */
    public MedianFinder() {
        //最大堆，存比较小的那半部分
        smallHalf = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        //最小堆，存比较大的那半部分
        bigHalf = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if (!bigHalf.isEmpty() && num >= bigHalf.peek()) {
            bigHalf.offer(num);
        } else {
            smallHalf.offer(num);
        }
        //when bigHalf.size()==smallHalf.size() or bigHalf.size()==smallHalf.size()+1, don’t need to move
        if (bigHalf.size() > smallHalf.size() + 1) {
            smallHalf.offer(bigHalf.poll());
        } else if (smallHalf.size() > bigHalf.size()) {
            bigHalf.offer(smallHalf.poll());
        }
    }

    public double findMedian() {
        if (bigHalf.isEmpty()) {
            return 0.0;
        } else if (smallHalf.size() == bigHalf.size()) {
            return (smallHalf.peek() + bigHalf.peek()) / 2.0;
        }
        return (double)bigHalf.peek();
    }
    //Follow up1:If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    private int[] count;
    private int curCount;
    public MedianFinder() {
        this.count = new int[100];
        this.curCount = 0;
    }

    public void addNum(int num) {
        count[num]++;
        curCount++;
    }

    public double findMedian(int[] count,int curCount) {
        int tmpCount = 0;
        int i = 0;
        if (curCount % 2 == 1) {
            while (tmpCount < curCount / 2 + 1) {
                tmpCount += count[i++];
            }
            return i-1;
        } else {
            while (tmpCount < curCount / 2) {
                tmpCount += count[i++];
            }
            if (tmpCount == curCount / 2) {
                int j = i;
                while (count[j] == 0) {
                    j++;
                }
                return (i - 1 + j) / 2.0;
            } else {
                return (double)(i - 1);
            }
        }
    }
}
