/*Given a list of integers representing the lengths of urls,
find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).
The maximum length of valid url is 4096*/
public class The95Percentile {
    public int percentile95(List<Integer> lengths) {
        int count = 0;
        int[] urlLength = new int[4097];
        for (int l : lengths) {
            urlLength[l]++;
        }
        int i = 4069;
        while (count <= lengths.size()*0.05) {
            count += urlLength[i--];
        }
        return i + 1;
    }
}
