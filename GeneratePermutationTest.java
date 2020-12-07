package com.ambry.pedigree;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneratePermutationTest {

    public static Set<String> printPermutn(String str, String ans, Set<String> set) {
        // If string is empty
        if (str.length() == 0) {
            set.add(ans);
            return set;
        }
        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);
            // Recurvise call
            printPermutn(ros, ans + ch,set);
        }
        //System.out.println(set.stream().collect(Collectors.joining(", ")));
        return set;
    }

    private static boolean bSimilar(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Set<Character> setA = a.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        Set<Character> setB = b.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        if (setA.retainAll(setB)) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String a = "1230";
        String b = "1203";
        Set<String> set = new HashSet<>();
        boolean bComp = bSimilar(a, b);
        if (bComp) {
            Set<String> setString = printPermutn(a, " ", set);
            System.out.println(setString.size());
        } else {
            Set<String> setString = printPermutn(b, " ", set);
            System.out.println(setString.size());
        }
    }
}
