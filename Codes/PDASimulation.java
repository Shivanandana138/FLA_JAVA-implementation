import java.util.*;

public class PDASimulation {
    static boolean accepts(String s, boolean allowEmpty) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean readingOnes = false;            // q0 = pushing, q1 = popping

        for (char ch : s.toCharArray()) {
            if (ch == '0' && !readingOnes) {
                stack.push('X');
            } else if (ch == '1') {
                readingOnes = true;
                if (stack.isEmpty()) return false;
                stack.pop();
            } else {
                return false;                   // bad symbol or 0 after 1
            }
        }
        if (s.isEmpty()) return allowEmpty;
        return readingOnes && stack.isEmpty();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            System.out.println(accepts(sc.nextLine().trim(), false) ? "Accepted" : "Rejected");
        }
    }
}
