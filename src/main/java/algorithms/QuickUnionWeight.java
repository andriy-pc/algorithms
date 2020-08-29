package algorithms;

/* Class is responsible to unite points and
 * check if two points are connected,
 * Works even if two points are connected indirectly[(2, 3), (3, 4) => (2, 4)].
 * This class implements tree idea with weight of tree.
 * The weight is used when connecting two trees.
 * The connection should be provided from most 'heavy' tree
 * To the most 'light' tree. It is important for 'root' function*/
public class QuickUnionWeight {

    private int storage[];
    private int weight[];
    private int storageSize;

    public QuickUnionWeight(int quantity) {
        storageSize = quantity;
        storage = new int[storageSize];
        weight = new int[storageSize];
        for (int i = 0; i < storageSize; ++i) {
            storage[i] = i;
            weight[i] = 1;
        }
    }

    /* Unities two points.
     * Unite operation is performed based on the quantity of
     * nodes in one tree. Larger tree has to be united into smaller one*/
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (weight[pRoot] < weight[qRoot]) {
            storage[pRoot] = qRoot;
            weight[qRoot] += weight[pRoot];
        } else {
            storage[qRoot] = pRoot;
            weight[pRoot] += weight[qRoot];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /*Calculates the root of the given node*/
    private int root(int i) {
        while (storage[i] != i) {
            //We make every other node in the path
            //point to its grand parent on the way up the tree
            storage[i] = storage[storage[i]]; //EXTRA SPEED!!1
            i = storage[i];
        }
        return i;
    }
}

