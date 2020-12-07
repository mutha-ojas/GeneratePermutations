import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneratePermutationTest {

    public static Set<String> getPermutationSet(String str, String ans, Set<String> set) {
        // If string is empty
        if (str.length() == 0) {
            set.add(ans);
            return set;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String result = str.substring(0, i) + str.substring(i + 1);
            getPermutationSet(result, ans + ch, set);
        }
        return set;
    }

    private static boolean checkIfSimilar(String a, String b) {
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
        String b = "1201";
        Set<String> set = new HashSet<>();
        boolean bComp = checkIfSimilar(a, b);
        if (bComp) {
            Set<String> setString = getPermutationSet(a, " ", set);
            System.out.println(setString.size());
        } else {
            Set<String> setString = getPermutationSet(b, " ", set);
            System.out.println(setString.size());
        }
    }
}

