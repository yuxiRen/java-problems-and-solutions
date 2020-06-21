public class Random1000UsingRandom5 {
    public int random1000() {
        while (true) {
            int random = 0;
            int i = 0;
            //random(3125)
            while (i < 5) {
                random = 5 * random + RandomFive.random5();
                i++;
            }
            //P(0 | [0, 999]) = P(0) / P([0,999]) = 1/3125 / 1000/3125 = 1/1000
            if (random < 3000) {
                return random%1000;
            }
        }
    }
}
