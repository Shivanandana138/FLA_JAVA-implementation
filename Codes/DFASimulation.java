import java.util.*;

public class DFASimulation {
    // delta[state][symbol], accepts strings ending in 1
    static final int[][] DELTA = {{0, 1}, {0, 1}};
    static final boolean[] ACCEPT = {false, true};

    static boolean accepts(String s) {
        int state = 0;
        for (char ch : s.toCharArray()) {
            if (ch != '0' && ch != '1') return false;
            state = DELTA[state][ch - '0'];
        }
        return ACCEPT[state];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a binary string: ");
            String s = sc.nextLine().trim();
            System.out.println(accepts(s) ? "Accepted" : "Rejected");
        }
    }
}
