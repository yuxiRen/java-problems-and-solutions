//at least one cut must be made
public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        int[] product = new int[length + 1];
        product[1] = 0;
        for (int i = 2; i < product.length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                product[i] = Math.max(product[i], j * Math.max((i - j), product[i - j]));
            }
        }
        return product[length];
    }
}
