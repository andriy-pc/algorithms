package algorithms;

public class Shuffling {

    public static void shuffle(int arr[]) {

        int rand;
        int tmp;

        for(int i = 0; i < arr.length; ++i) {
            rand = (int)(Math.random()*(i + 1));
            System.out.println(rand);
            tmp = arr[rand];
            arr[rand] = arr[i];
            arr[i] = tmp;
        }
    }

}
