import java.util.Scanner;

abstract class Dummy {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

    abstract int search(int key);
}

class Linear extends Dummy {
    int search(int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
}

class Binary extends Dummy {

    int search(int key) {

        int l = 0, r = arr.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] == key) {
                return m;
            } else if (arr[m] > key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;

    }
}

class Searcher {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        System.out.println("result: "+new Linear().search(s.nextInt()));
        System.out.println("result: "+new Binary().search(s.nextInt()));
    }

}