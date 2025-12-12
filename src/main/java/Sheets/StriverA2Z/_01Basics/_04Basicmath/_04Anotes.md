# GCD (Greatest Common Divisor) — FAANG-quality Solutions (Java)

## Problem Statement

Implement a function `gcd(a, b)` that returns the greatest common divisor of two integers `a` and `b`.

**Assumptions:**
- Inputs are 32-bit signed integers (`int`).
- `gcd(0, 0) = 0` by convention.
- GCD should be returned as a non-negative integer.
- Implementations should handle `Integer.MIN_VALUE` safely.

---

## Summary of Methods (in `GcdSolutions.java`)

- `method1_bruteforceOriginal(a, b)`  
  Brute-force downward search from `min(|a|, |b|)`. Time: `O(min(a,b))`, Space: `O(1)`.

- `method2_euclidIterative(a, b)` — **Recommended / Demo**  
  Euclidean algorithm (iterative). Time: `O(log(min(a,b)))`, Space: `O(1)`.

- `method3_euclidRecursive(a, b)`  
  Euclidean algorithm (recursive). Time: `O(log(min(a,b)))`, Space: `O(log(min(a,b)))` due to recursion.

- `method4_gcdOfArray(int[] arr)`  
  Compute gcd of multiple numbers by reducing pairwise using Euclid. Time: `O(n * log M)`, Space: `O(1)`.

---

## Detailed Explanations

### 1) Brute-force (Original / Micro-optimized)
- **Idea:** Check divisors starting from `min(|a|,|b|)` downwards; the first common divisor encountered is the GCD.
- **Pros:** Simple to understand.
- **Cons:** Very slow for large inputs (e.g., `a` and `b` up to 10^9).
- **Use-case:** Educational demonstration or tiny inputs.

### 2) Euclidean Algorithm (Iterative) — Recommended
- **Idea:** Replace `(a, b)` with `(b, a % b)` until `b == 0`. The gcd is `|a|`.
- **Pros:** Fast, simple, production-grade, minimal memory.
- **Cons:** None for typical integer ranges.
- **Use-case:** Default for interviews and production.

### 3) Euclidean Algorithm (Recursive)
- **Idea:** Same as iterative but expressed recursively.
- **Pros:** Very concise.
- **Cons:** Uses recursion stack (not an issue for 32-bit integers usually).


### 4) GCD of Array
- **Idea:** Reduce array by computing pairwise gcd: `g = gcd(arr[0], arr[1])`, then `g = gcd(g, arr[2])`, etc.
- **Pros:** Useful in problems requiring normalization or common step sizes.
- **Cons:** None significant; use Euclid for pairwise gcd.

---

## Time & Space Complexity Table

| Method                       | Time Complexity            | Space Complexity |
|-----------------------------:|---------------------------:|------------------:|
| method1_bruteforceOriginal   | O(min(|a|,|b|))            | O(1)             |
| method3_euclidIterative      | O(log(min(|a|,|b|)))       | O(1)             |
| method4_euclidRecursive      | O(log(min(|a|,|b|)))       | O(log(...))      |
| method6_gcdOfArray           | O(n * log M)               | O(1)             |

---

## Edge Cases & Notes

- `gcd(0, 0) = 0` (convention used across this package).
- `gcd(a, 0) = |a|`, `gcd(0, b) = |b|`.
- Negative inputs: handled by using absolute values internally.
- `Integer.MIN_VALUE` (−2^31): `Math.abs(Integer.MIN_VALUE)` overflows an `int`. Implementations use `long` to avoid overflow when taking absolute values.
- Early exit: in array reduction, if current gcd becomes `1`, we can stop early.

---

## Interview Notes — What Interviewers Expect

1. **Start with the Euclidean algorithm** (iterative): explain correctness by the property that `gcd(a, b) = gcd(b, a % b)`.
2. **Cover edge cases**: `(0,0)`, negative numbers, zeros.
3. **Complexity analysis**: Euclid runs in `O(log(min(a, b)))`.
4. **Alternatives**: mention Stein’s (binary GCD) as a division-free alternative and brute-force only as an educational approach.

How to explain Euclid concisely:
> “If `b` divides `a`, gcd is `b`. Otherwise gcd(a,b) = gcd(b, a mod b). Repeating this reduces input sizes quickly; running time is logarithmic in the input values.”

---

## Sample I/O

- `gcd(48, 18) = 6`
- `gcd(0, 5) = 5`
- `gcd(0, 0) = 0`
- `gcd(-24, 36) = 12`
- `gcd(Integer.MAX_VALUE, Integer.MAX_VALUE) = Integer.MAX_VALUE`

---

## Common Mistakes / Pitfalls

- Using brute-force for large inputs — leads to timeouts.
- Forgetting to handle zero or negative values.
- Using `Math.abs(int)` without considering `Integer.MIN_VALUE` overflow — use long internally if taking absolute value.
- Not choosing Euclid when efficiency matters.

---
