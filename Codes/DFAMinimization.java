import java.util.*;

public class DFAMinimization {
    public static void main(String[] args) {
        int[][] dfa = {{1, 2}, {1, 2}, {1, 2}};
        boolean[] fin = {false, true, true};
        int n = dfa.length, k = dfa[0].length;

        int[] group = new int[n];
        for (int i = 0; i < n; i++) group[i] = fin[i] ? 1 : 0;
        int count = (int) Arrays.stream(group).distinct().count();

        while (true) {
            Map<String, Integer> map = new HashMap<>();
            int[] next = new int[n];
            for (int i = 0; i < n; i++) {
                StringBuilder key = new StringBuilder().append(group[i]);
                for (int c = 0; c < k; c++) key.append(',').append(group[dfa[i][c]]);
                next[i] = map.computeIfAbsent(key.toString(), x -> map.size());
            }
            group = next;
            if (map.size() == count) break;   // no new split -> stable
            count = map.size();
        }

        System.out.println("Minimized DFA (" + count + " states):");
        boolean[] done = new boolean[count];
        for (int i = 0; i < n; i++) {
            if (done[group[i]]) continue;
            done[group[i]] = true;
            System.out.print("Group " + group[i] + (fin[i] ? " (final)" : ""));
            for (int c = 0; c < k; c++)
                System.out.print("  " + c + "->" + group[dfa[i][c]]);
            System.out.println();
        }
    }
}
