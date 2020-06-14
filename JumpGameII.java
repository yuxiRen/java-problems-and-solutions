public class JumpGameII {
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
}
