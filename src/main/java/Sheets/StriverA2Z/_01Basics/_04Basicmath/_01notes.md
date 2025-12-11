# Count Digit (Striver A2Z – Basic Math)

## Problem Statement

> **count digit**

Given an integer `n`, return the number of digits in its decimal representation.

- `0` is considered to have **1 digit**.
- Negative numbers are counted by their **absolute value**.

Examples:

- `n = 0` → `1`
- `n = 7` → `1`
- `n = 123` → `3`
- `n = -456` → `3`

---

## Approaches Overview

All implementations are contained in the Java file for this problem (e.g. `CountDigitAllApproaches.java`).

The following methods are implemented:

- **`method1_originalLike`**  
  Original GFG-style loop: counts digits only for `n > 0`.  
  Kept to show the starting point; not fully correct for this problem.

- **`method2_doWhileIterative`** ✅ (Recommended / Demo)  
  Robust iterative approach using a `do-while` loop and `Math.abs(n)`.  
  Handles `0` and negative numbers correctly. This is the **default interview answer**.

- **`method3_whileIterative`**  
  Robust `while` loop with explicit `n == 0` handling, then repeated division.  
  Equivalent correctness to `method2`, but with an explicit special case.

- **`method4_log10Based`**  
  Uses the mathematical formula:  
  `digits = floor(log10(|n|)) + 1` for `n != 0`, and `1` for `n == 0`.  
  Constant-time in theory; showcases mathematical insight.

- **`method5_stringBased`**  
  Converts the number to a string and counts characters, ignoring a leading `'-'`.  
  Very readable; slightly more expensive in time/space.

- **`method6_thresholdBased`**  
  Uses fixed comparisons against powers of 10 for 32-bit `int`.  
  True constant-time with a small, fixed sequence of comparisons.

---

## Time & Space Complexity

Let `d` be the number of digits in `n`.

| Method                   | Description                    | Time Complexity | Space Complexity | Notes                                      |
|--------------------------|--------------------------------|-----------------|------------------|--------------------------------------------|
| `method1_originalLike`   | Original GFG-style loop        | O(d)            | O(1)             | Incorrect for `n <= 0`                     |
| `method2_doWhileIterative` | Iterative do-while (demo)   | O(d)            | O(1)             | Recommended, robust, interview-friendly    |
| `method3_whileIterative` | Iterative while + zero check  | O(d)            | O(1)             | Same logic as method2, more explicit       |
| `method4_log10Based`     | `Math.log10` based            | O(1)            | O(1)             | Uses floating-point arithmetic             |
| `method5_stringBased`    | String conversion             | O(d)            | O(d)             | Very simple, uses extra memory             |
| `method6_thresholdBased` | Threshold comparisons         | O(1)            | O(1)             | Fastest for fixed 32-bit `int` range       |

---

## Edge Cases

These are handled by the robust methods (`method2` and onwards):

1. **Zero**
    - Input: `0`
    - Output: `1`
    - Important: a naive `while (n > 0)` loop would incorrectly give `0`.

2. **Single-digit positive**
    - Example: `5` → `1`

3. **Single-digit negative**
    - Example: `-7` → `1` (digits are counted on `|n|`)

4. **Multiple digits**
    - Examples:
        - `10` → `2`
        - `99` → `2`
        - `100` → `3`
        - `12345` → `5`

5. **Large values**
    - `Integer.MAX_VALUE` (`2147483647`) → `10`
    - `Integer.MIN_VALUE` (`-2147483648`) → `10`

---

## Intuition

For the iterative approaches:

- Each division by 10 **drops the last digit** of the number.
- The number of times you can divide until it becomes `0` equals the number of digits.
- Using `Math.abs(n)` ensures that the sign does not affect counting.
- Using a `do-while` loop ensures that `0` is processed at least once, giving it exactly one digit.

For the `log10` approach:

- `log10(n)` answers “how many times you multiply 10 to get to `n`”.
- Taking `floor(log10(n)) + 1` gives how many digits `n` has in base 10.

For the threshold approach:

- The number of digits for an `int` is determined by where `|n|` lies among powers of 10.
- Comparing against `10, 100, 1000, ...` yields a constant number of branches.

---

## FAANG Interview Notes

### What Interviewers Expect

- A **clear, correct** solution first:
    - Typically the simple iterative division method (`method2_doWhileIterative` or `method3_whileIterative`).
- Proper handling of:
    - `0`
    - Negative values
    - Large values within `int` range
- Correct discussion of **time and space complexity**.
- Ability to reason about and discuss **alternative approaches**.

### How to Explain Your Solution (for the Recommended Method)

A concise explanation for `method2_doWhileIterative`:

> “I take the absolute value of the number so that the sign doesn’t matter. Then I repeatedly divide the value by 10 to remove the last digit, counting how many times I do this until the value becomes zero. I use a `do-while` loop so that the body runs at least once, which ensures that `0` is correctly counted as having one digit. This runs in O(d) time, where d is the number of digits, and uses O(1) extra space.”

### Trade-Offs Between Approaches

- **Iterative loop vs `log10`:**
    - Iterative:
        - Very easy to implement and reason about.
        - No floating-point issues.
    - `log10`:
        - Mathematically elegant, constant-time.
        - Requires careful handling of `0` and floating-point precision.

- **Arithmetic vs String-based:**
    - Arithmetic:
        - More efficient, avoids allocations.
        - Best for performance-critical contexts.
    - String-based:
        - Very readable and concise.
        - Uses extra memory; better suited to high-level application logic.

- **Threshold-based:**
    - Very fast in theory and truly constant-time.
    - Less flexible (hard-coded thresholds for `int`).
    - Mainly useful in low-level or performance-critical libraries.

### Common Pitfalls

- Returning `0` for input `0` (forgetting `"0"` has one digit).
- Ignoring negative numbers and their absolute value.
- Using `log10` without:
    - Handling `n == 0` separately.
    - Taking `Math.abs(n)` first.
- Over-engineering: adding unnecessary patterns to a fundamentally simple problem.

---

## How to Run

1. Add the Java file (e.g. `CountDigitAllApproaches.java`) to your project.
2. Compile and run it with your Java toolchain.
3. The `main` method is set up to demonstrate the **recommended** method (`method2_doWhileIterative`) on multiple test values.  
   You can modify the `main` method or write your own tests to call any other method (`method3_whileIterative`, `method4_log10Based`, etc.).

---

## Summary

- The **core idea** is to count how many digits a number has in base 10.
- The **recommended solution** is a simple iterative division approach with absolute value handling and a `do-while` loop.
- Additional approaches (`while`-based, `log10`, string-based, threshold-based) demonstrate different trade-offs and are useful to discuss during FAANG-style interviews.
