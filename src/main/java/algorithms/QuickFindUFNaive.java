package algorithms;

/* Class is responsible to unite points and
 * check if two points are connected,
 * Works even if two points are connected indirectly[(2, 3), (3, 4) => (2, 4)].
 * This class have naive implementation*/
public class QuickFindUFNaive {

    private int storage[];
    private int storageSize;

    public QuickFindUFNaive(int quantity) {
        storageSize = quantity;
        storage = new int[storageSize];
        for (int i = 0; i < storageSize; ++i) {
            storage[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return storage[p] == storage[q];
    }

    public void union(int p, int q) {
        int mainEntry = storage[q];
        int secondaryEntry = storage[p];
        for (int i = 0; i < storageSize; ++i) {
            if (storage[i] == secondaryEntry) {
                storage[i] = mainEntry;
            }
        }
    }
}
