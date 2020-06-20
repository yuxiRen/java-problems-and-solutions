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
        if (random < k) {
            sample.set(random, value);
        }
    }

    public List<Integer> sample() {
        return sample;
    }
}
