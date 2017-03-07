package util.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alexander on 02.03.2017.
 */
public class Test {

    public static void main(String[] args) {
        String[][] mas = {{"a", "b"},
                          {"b", "a"},
                          {"b", "a"},
                          {"a", "b", "a"}};
        System.out.println(allStringSetsIdentical(mas));
    }

    public static boolean allStringSetsIdentical(String[ ][ ] sets){
        List<String> stringList = Arrays.stream(sets)
                .map(set -> {
                    String sum = "";
                    for (String s : set) {
                        sum += s;
                    }
                    return sum;
                })
                .distinct()
                .collect(Collectors.toList());
        for (int i=0; i<stringList.size(); i++){
            String rev = reverse(stringList.get(i));
            boolean result = stringList.stream()
                    .skip(i+1)
                    .anyMatch(rev::equals);
            if (result) return true;
        }
        return false;
    }

    private static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

}
