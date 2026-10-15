import java.util.*;

public class NFAToDFA {
    // nfa[state][symbol] = destination states
    static final int[][][] NFA = {
        {{0, 1}, {0}},
        {{},     {1}}
    };
    static final Set<Integer> NFA_ACCEPT = Set.of(1);

    static Set<Integer> move(Set<Integer> from, int sym) {
        Set<Integer> to = new TreeSet<>();
        for (int s : from)
            for (int d : NFA[s][sym]) to.add(d);
        return to;
    }

    public static void main(String[] args) {
        Map<Set<Integer>, Integer> id = new LinkedHashMap<>();
        List<int[]> trans = new ArrayList<>();
        Queue<Set<Integer>> queue = new ArrayDeque<>();

        Set<Integer> start = new TreeSet<>(Set.of(0));
        id.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Set<Integer> cur = queue.poll();
            int[] row = new int[2];
            for (int sym = 0; sym < 2; sym++) {
                Set<Integer> next = move(cur, sym);
                if (!id.containsKey(next)) {
                    id.put(next, id.size());
                    queue.add(next);
                }
                row[sym] = id.get(next);
            }
            trans.add(row);          // BFS order == id order
        }

        System.out.println("DFA States and Transitions:");
        for (var e : id.entrySet()) {
            int i = e.getValue();
            boolean fin = e.getKey().stream().anyMatch(NFA_ACCEPT::contains);
            System.out.printf("State %d = %s%s%n", i, e.getKey(), fin ? "  (final)" : "");
            System.out.println("  0 -> " + trans.get(i)[0]);
            System.out.println("  1 -> " + trans.get(i)[1]);
        }
    }
}
