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
        //when bigHalf.size()==smallHalf.size() or    bigHalf.size()==smallHalf.size()+1, don’t need to move
        if (bigHalf.size() > smallHalf.size() + 1) {
            smallHalf.offer(bigHalf.poll());
        } else if (smallHalf.size() > bigHalf.size()) {
            bigHalf.offer(smallHalf.poll());
        }
    }

    public double findMedian() {
        if (smallHalf.size() == bigHalf.size()) {
            return (smallHalf.peek() + bigHalf.peek()) / 2.0;
        }
        return (double)bigHalf.peek();
    }

}
