package algorithms;

/* Class is responsible to unite points and
 * check if two points are connected,
 * works even if two points are connected indirectly[(2, 3), (3, 4) => (2, 4)].
 * This class implements tree idea*/
public class QuickFindUF {
    private int storage[];

    public QuickFindUF(int quantity) {
        storage = new int[quantity];
        for (int i = 0; i < quantity; ++i) {
            storage[i] = i;
        }
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        storage[pRoot] = qRoot;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /*Calculates the root of the given node*/
    private int root(int i) {
        while (storage[i] != i) {
            i = storage[i];
        }
        return i;
    }
}
