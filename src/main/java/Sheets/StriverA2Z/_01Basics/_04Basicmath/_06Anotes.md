# Divisors of an Integer — FAANG-Quality Solutions (Java)

## Problem Statement

Given a positive integer `n`, enumerate (and optionally print) all positive divisors of `n` in ascending order.

**Assumptions**
- Divisors are defined for positive integers. If `n <= 0` the implementations will return an empty list or print an error message.
- Input type is `int`.

---

## Implemented Methods (in `DivisorsSolutions.java`)

- `method1_bruteforce(n)`  
  Check every integer `i` in `[1..n]` and collect `i` if `n % i == 0`. Complexity: O(n).

- `method2_sqrtPairNoSort(n)` ✅ (DEMO)  
  Iterate `i` from `1..floor(sqrt(n))`. For each divisor `i`, push `i` to `small` and `n/i` to `large` (if different). Then append `large` in reverse to `small` to obtain ascending order. Complexity: O(sqrt(n)). This is the default recommended method.

- `method3_sqrtOriginalSortedPrint(n)`  
  Preserves original behavior: collects `small` and `large`, sorts `large`, and prints small then large. Complexity: O(sqrt(n) + k log k).

---

## Complexity Summary

Let `k` = number of divisors of `n` and `d = floor(sqrt(n))`.

| Method                      | Time Complexity         | Space Complexity |
|----------------------------:|------------------------:|------------------:|
| Brute-force                 | O(n)                    | O(k)             |
| Sqrt pairing (no sort)      | O(sqrt(n))              | O(k)             |
| Sqrt pairing (sort large)   | O(sqrt(n) + k log k)    | O(k)             |
---

## Edge Cases

- `n = 1` → divisors: [1]
- `n` prime → divisors: [1, n]
- `n` a perfect square → ensure sqrt only counted once (e.g., 36 → 1 2 3 4 6 9 12 18 36)
- `n <= 0` → implementations return empty list or print message

---

## When to Use Which Approach

- **Use `method2_sqrtPairNoSort`** for single-query enumeration — fastest, minimal memory, simple.
- **Use brute-force** only for tiny `n` or when you need a toy/simple implementation.

---

## Implementation Notes & Micro-optimizations

- Common micro-optimizations:
    - Iterate only to `floor(sqrt(n))`.
    - Avoid sorting by collecting "large" divisors and appending them in reverse order.
    - Use preallocated `ArrayList` capacity if approximate number of divisors is known.

---

## Final Notes

- The `method2_sqrtPairNoSort` is the FAANG-friendly default: O(sqrt(n)), clear, and avoids unnecessary sorting.

Happy coding! 🚀
