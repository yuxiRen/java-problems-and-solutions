public class GeneralizedReservoirSampling {
    private final int k;
    private  List<Integer> sample;
    public Solution(int k) {
        this.k = k;
        this.sample = new ArrayList<Integer>();
    }

    public void read(int value) {
        int count = sample.size();
        if (count < k) {
            sample.add(value);
            return;
        }
        count++;
        int random = (int)(Math.random() * count);
        //the probability of set the new value into sample is k / n
        if (random < k) {
            //the probability of pick the one of the old sample to exchange with new value is 1/k
            sample.set(random, value);
        }
    }

    public List<Integer> sample() {
        return sample;
    }
}
