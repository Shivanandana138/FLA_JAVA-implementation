import java.util.*;

public class DFAIntersection {
    // DFA1: ends in 1
    static final int[][] D1 = {{0, 1}, {0, 1}};
    static final boolean[] F1 = {false, true};
    // DFA2: even number of 1s
    static final int[][] D2 = {{0, 1}, {1, 0}};
    static final boolean[] F2 = {true, false};

    static boolean accepts(String s) {
        int p = 0, q = 0;                       // product state (p, q)
        for (char ch : s.toCharArray()) {
            if (ch != '0' && ch != '1') return false;
            int c = ch - '0';
            p = D1[p][c];
            q = D2[q][c];
        }
        return F1[p] && F2[q];                  // F = F1 x F2
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a binary string: ");
            System.out.println(accepts(sc.nextLine().trim()) ? "Accepted" : "Rejected");
        }
    }
}
