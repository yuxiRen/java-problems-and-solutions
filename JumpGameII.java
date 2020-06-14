public class JumpGameII {
    //method1: dynamic programming
    public int minJump(int[] array) {
        int[] minJump = new int[array.length];
        minJump[0] = 0;
        for (int i = 1; i < minJump.length; i++) {
            minJump[i] = -1;
            for (int j = 0; j < i; j++) {
                if (minJump[j] != -1 && j + array[j] >= i) {
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[minJump.length - 1];
    }
    //method2:greedy
    public int minJump(int[] array) {
        int jump = 0;
        int curMax = 0;
        int next = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > curMax) {
                if (curMax == next) {
                    return -1;
                }
                jump++;
                curMax = next;
            }
            next = Math.max(next, array[i] + i);
        }
        return jump;
    }

}
