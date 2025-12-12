# Palindrome Number (LeetCode / GFG-style)

## Problem Statement

Given an integer `x`, return `true` if `x` is a palindrome integer — that is, it reads the same backward as forward. Otherwise, return `false`.

**Assumptions (standard LeetCode interpretation):**
- Negative numbers are **not** palindromes (the minus sign `-` makes them asymmetric).
- `0` is a palindrome.
- We operate on 32-bit signed integers.

---

## Summary of Approaches (method1, method2, ...)

- **method1_originalLike** — String-based comparison (preserves original behavior).
- **method2_stringBased** — Micro-optimized string-based palindrome (DEMO).
- **method3_numericReverse** — Reverse the entire number arithmetically and compare (uses `long` to avoid overflow).
- **method4_reverseHalf** — Reverse half the digits and compare with the other half (preferred numeric solution).
- **method5_compareDigitsUsingPower** — Extract leading and trailing digits using powers of 10 and compare.

---

## Explanation of Each Approach

### `method1_originalLike` — String-based (original)
- Convert integer to string and compare characters from both ends moving to the center.
- Simple and easy to implement.
- **Time**: O(d), **Space**: O(d) due to string.

### `method2_stringBased` — Micro-optimized String-based (DEMO)
- Same idea, but uses two indices `i` and `j` and caches length — small readability/speed improvements.
- Good for code clarity and demonstration.
- **Time**: O(d), **Space**: O(d).

### `method3_numericReverse` — Reverse full number
- Reverse digits numerically and compare the reversed result with original.
- Use larger type (`long`) during reversal to guard against overflow.
- **Time**: O(d), **Space**: O(1).

### `method4_reverseHalf` — Reverse half (recommended)
- Reverse digits only until the reversed half is >= remaining half.
- For odd-digit numbers, drop the middle digit before comparison (reversedHalf/10).
- Avoids overflow because only half is reversed.
- **Time**: O(d), **Space**: O(1).
- **Why preferred:** Minimal memory, avoids `long` overflow, concise comparison, often accepted as optimal numeric approach in interviews.

### `method5_compareDigitsUsingPower` — Compare leading/trailing digits
- Compute the highest power of 10 ≤ x to extract leading digit.
- Compare leading and trailing digits, strip them, and reduce power by 100.
- **Time**: O(d), **Space**: O(1).
- Good when you want an explicit numeric end-to-end comparison without reversing.

---

## Time & Space Complexity Table

Let `d` be the number of digits of `x`.

| Method                       | Time Complexity | Space Complexity | Notes |
|-----------------------------:|----------------:|-----------------:|-------|
| method1_originalLike         | O(d)            | O(d)             | String allocation |
| method2_stringBased (demo)   | O(d)            | O(d)             | Readable; micro-optimized string check |
| method3_numericReverse       | O(d)            | O(1)             | Uses `long` guard for overflow |
| method4_reverseHalf (recommended) | O(d)      | O(1)             | Avoids overflow; minimal work |
| method5_compareDigitsUsingPower | O(d)         | O(1)             | Explicit digit extraction |

---

## Edge Cases

- **Negative numbers**: e.g., `-121` → `false` (minus sign).
- **Zero**: `0` → `true`.
- **Single-digit numbers**: `7` → `true`.
- **Numbers ending with 0** (but not 0 itself): e.g., `10` → `false`.
- **Max/min integers**:
    - `Integer.MAX_VALUE` (2147483647) → not palindrome.
    - `Integer.MIN_VALUE` (-2147483648) → not palindrome.

---

## How to Explain in an Interview

Start with a simple, correct solution:

1. **String-based (easy to explain)**:
    - “Convert to string and compare characters from both ends until the middle. O(d) time and O(d) space.”
2. **Then present the numeric improvement**:
    - “To avoid O(d) extra space, reverse numerically. But reversing entirely can overflow, so either reverse using `long` or reverse only half the digits.”
3. **Recommend the half-reverse approach**:
    - “Reverse half the number, compare with the other half; for odd-digit numbers ignore the middle digit. This is O(d) time and O(1) space and avoids overflow issues.”

Emphasize correctness and handling edge cases:
- Explain why negatives and numbers ending in 0 (except 0) are not palindromes.
- Show understanding of overflow concerns and how the half-reverse approach mitigates them.

---

## Trade-offs & Common Pitfalls

- **String-based vs numeric**:
    - String: simplest, but uses additional memory.
    - Numeric: avoids memory allocation, but needs careful handling of overflow.
- **Reversing whole number**:
    - Might overflow `int`; use `long` or reverse only half.
- **Forgetting to special-case**:
    - Negative numbers and numbers ending with 0 need correct handling.
- **Overcomplicating**:
    - Keep it simple — choose the approach that matches the interviewer’s constraints/goals.

---

## Sample I/O (kept short; full tests are in the code)
- `0` -> `true`
- `121` -> `true`
- `-121` -> `false`
- `10` -> `false`
- `12321` -> `true`

---

## Notes

- The merged Java file contains all methods and a `main` demonstrating `method2_stringBased` by default.
- If you prefer a different demo method (e.g., `method4_reverseHalf`), update the `main` to call that method instead.

---

## Final Words

- For interviews, present a correct simple solution first (string or loop), then offer the optimized numeric half-reverse approach if asked to reduce space or avoid string conversion.
- The provided code is production-ready and includes multiple FAANG-grade alternatives with clear comments, complexity analysis, and demonstration scaffolding.
