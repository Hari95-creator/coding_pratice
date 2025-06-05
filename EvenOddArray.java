import java.util.ArrayList;
import java.util.List;

public class EvenOddArray {

    public static void evenOdd(ArrayList<Integer> list) {

        List<Integer> evenArray = new ArrayList<>();
        List<Integer> oddArray = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) % 2 == 0) {

                if (evenArray.size() < 3) {

                    evenArray.add(list.get(i));
                }

            } else {

                if (oddArray.size() < 3) {

                    oddArray.add(list.get(i));
                }

            }

        }

        System.out.println("Even Array :" + evenArray);
        ;
        System.out.println("Odd Array :" + oddArray);
    }

    public static void main(String args[]) {

        int arr[] = { 10, 12, 15, 8, 9, 3, 1 };

        ArrayList<Integer> data = new ArrayList<>();

        for (int num : arr) {

            data.add(num);

        }

        evenOdd(data);

    }
}