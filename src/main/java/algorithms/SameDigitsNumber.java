package algorithms;

import java.util.Arrays;

public class SameDigitsNumber {
    public static long bigger(long n) {
        long originNumber = n;
        char tmp;

        char digs[] = String.valueOf(originNumber).toCharArray();
        int smlPos = -1;
        for (int i = digs.length - 1; i >= 0; --i) {
            if (digs[i - 1] < digs[i]) {
                smlPos = i - 1;
                break;
            }
        }

        if (smlPos == -1) {
            return -1;
        }
        int minIndex = smlPos + 1;
        for (int i = smlPos + 1; i < digs.length; ++i) {
            if (digs[i] < digs[minIndex] && digs[i] > digs[smlPos]) {
                minIndex = i;
            }
        }
        if (minIndex == smlPos + 1) {
            minIndex = smlPos + 1;
        }
        tmp = digs[minIndex];
        digs[minIndex] = digs[smlPos];
        digs[smlPos] = tmp;

        Arrays.sort(digs, smlPos + 1, digs.length);

        return Long.parseLong(new String(digs));
    }

    public static long smaller(long n) {
        long originNumber = n;
        char tmp;

        char digs[] = String.valueOf(originNumber).toCharArray();
        int bigPos = -1;
        for (int i = digs.length - 1; i > 0; --i) {
            if (digs[i - 1] > digs[i]) {
                bigPos = i - 1;
                break;
            }
        }

        if (bigPos == -1) {
            return -1;
        }
        int maxIndex = bigPos + 1;
        for (int i = bigPos + 1; i < digs.length; ++i) {
            if (digs[i] > digs[maxIndex] && digs[i] < digs[bigPos]) {
                maxIndex = i;
            }
        }
        if (maxIndex == bigPos + 1) {
            maxIndex = bigPos + 1;
        }
        tmp = digs[maxIndex];
        digs[maxIndex] = digs[bigPos];
        digs[bigPos] = tmp;

        Arrays.sort(digs, bigPos + 1, digs.length);
        StringBuilder sb = new StringBuilder();
        for (int i = bigPos + 1; i < digs.length; ++i) {
            sb.append(digs[i]);
        }
        sb.reverse();
        String res = new String(digs);
        res = res.substring(0, bigPos + 1);
        res += sb.toString();

        return res.startsWith("0") ? -1 : Long.parseLong(res);
    }
}
