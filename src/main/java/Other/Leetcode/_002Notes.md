# Divisor Game — LeetCode 1025 (FAANG Level)

## Problem Statement
Alice and Bob play a game with a number `n`.

- Alice starts first.
- On each turn, a player chooses a divisor `x` of `n` such that `0 < x < n`,
  and replaces `n` with `n - x`.
- The player who cannot make a move loses.

Return `true` if Alice wins assuming both play optimally.

---

## Core Insight

The entire game reduces to **parity (odd/even)**.

- If `n` is **even** → Alice **wins**
- If `n` is **odd** → Alice **loses**

---

## Why This Works (FAANG Explanation)

### Observations
1. Every number has divisor `1`
2. Odd numbers only have **odd divisors**
3. Even numbers have at least one **odd divisor (1)**

### Strategy
- If Alice starts with **even n**, she subtracts `1` and gives Bob an **odd number**
- Any move Bob makes on odd `n` gives Alice an **even number**
- This repeats until Bob loses

### Winning & Losing States
| n | Result |
|---|--------|
| 1 | Lose |
| 2 | Win |
| 3 | Lose |
| 4 | Win |
| ... | Alternating |

This leads to the final rule:
- n % 2 == 0 → true
- n % 2 != 0 → false

---

## Implemented Approaches

| Method | Description | Time | Space |
|------|-------------|------|-------|
| Parity Logic | Mathematical insight | O(1) | O(1) |
| DP (Explanation) | Explicit game simulation | O(n²) | O(n) |

---

## Edge Cases
- `n = 1` → Alice loses
- `n = 2` → Alice wins
- Large `n` → still O(1) solution

---

## FAANG Interview Notes

### What Interviewers Expect
- Recognition that this is a **game theory** problem
- Ability to reason about **winning/losing states**
- Deriving a mathematical simplification
- NOT writing DP unless asked

### How to Explain in Interview
> “I observed that even numbers are winning states and odd numbers are losing states.  
> Starting from an even number, Alice can always force Bob into an odd number.  
> This invariant guarantees Alice’s win.”

### Common Pitfalls
- Writing unnecessary DP
- Not explaining reasoning
- Assuming result without proof

---

## Final Recommendation
Always give the **parity-based solution** with a clear explanation.  
This problem is about **thinking**, not coding.

