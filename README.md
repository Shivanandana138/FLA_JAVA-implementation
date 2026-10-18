# Formal Languages and Automata — Java Implementations

This repository contains small Java programs demonstrating common finite-automaton and pushdown-automaton operations. The transition tables and example machines are defined directly in the source files.

## Repository contents

- `CB.SC.U4AIE24049.pdf` — the accompanying PDF document for this coursework.
- `Codes/` — Java source files and, when compiled, generated `.class` files. Generated class files are ignored by Git.

### Programs in `Codes/`

| File | What it demonstrates |
| --- | --- |
| `DFASimulation.java` | Simulates a DFA over `{0, 1}` that accepts binary strings ending in `1`. |
| `DFAIntersection.java` | Simulates the product of two DFAs and accepts strings that both end in `1` and contain an even number of `1`s. |
| `DFAMinimization.java` | Refines state partitions to minimize the sample DFA in the source, then prints the resulting groups and transitions. |
| `NFAToDFA.java` | Applies subset construction to the NFA in the source and prints the reachable DFA states, transitions, and accepting states. |
| `PDASimulation.java` | Simulates a PDA for strings of the form `0ⁿ1ⁿ`, with `n >= 1` (one or more zeroes followed by the same number of ones). |

The simulation programs read one line from standard input and print `Accepted` or `Rejected`. The minimization and conversion programs print their results directly.

## Compile and run

Use JDK 10 or later. From the repository root, compile all five programs:

```powershell
javac -d out Codes\DFAIntersection.java Codes\DFAMinimization.java Codes\DFASimulation.java Codes\NFAToDFA.java Codes\PDASimulation.java
```

Run a program by its class name:

```powershell
java -cp out DFASimulation
java -cp out DFAIntersection
java -cp out DFAMinimization
java -cp out NFAToDFA
java -cp out PDASimulation
```

For the two DFA simulations, enter a binary string when prompted. `PDASimulation` similarly reads a string over `{0, 1}`. `DFAMinimization` and `NFAToDFA` do not require input.
