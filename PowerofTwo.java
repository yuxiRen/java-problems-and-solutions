public class PowerofTwo {
    //method1: there's only one bit of 1
    public boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        while ((number & 1) == 0) {
            number >>>= 1;
        }
        return number == 1;
    }
    //method2: count 1's amount
    public boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>>= 1;
        }
        return count == 1;
    }
    //method3: x & (x-1) removes the rightmost 1
    public boolean isPowerOfTwo(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }
}
