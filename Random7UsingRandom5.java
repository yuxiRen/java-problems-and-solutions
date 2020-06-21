public class Random7UsingRandom5 {
    public int random7() {
        while (true) {
            int random = RandomFive.random5()*5+RandomFive.random5();
            if (random < 7) {
                return random;
            }
        }
    }
}
