package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,10,3,5,9,11));

        Collections.sort(integers);

//        integers.removeAll(integers);
//        integers.clear();


        System.out.println(integers);

        strings.add("Tú");
        System.out.println(strings);

        System.out.println(strings.get(0));


    }
}