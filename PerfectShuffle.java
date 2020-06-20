public class PerfectShuffle {
    public void shuffle(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int random = (int)(Math.random()*(i + 1));
            swap(array, random, i);
        }
    }
}
