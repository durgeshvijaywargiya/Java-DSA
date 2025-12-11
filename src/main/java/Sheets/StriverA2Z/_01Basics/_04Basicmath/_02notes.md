# Reverse Integer — LeetCode 7 (FAANG-Level)

## Problem Statement
Given an integer `x`, return `x` with its digits reversed.  
If reversing the number causes overflow (outside 32-bit signed integer range), return **0**.

Example:
- Input: `x = 123` → Output: `321`
- Input: `x = -123` → Output: `-321`
- Input: `x = 1534236469` → Output: `0` (overflow)

---

## Approaches Implemented

### ✔ method1_original — Your original logic (beautified)
- Reverse digit-by-digit
- Checks overflow using cutoff thresholds
- Uses absolute value + applies sign at end
- Time: O(log₁₀ n)
- Space: O(1)

### ✔ method2_mathReverse — FAANG-preferred (cleanest)
- No absolute value
- Handles negative numbers naturally
- Checks overflow using:
    - `rev > Integer.MAX_VALUE/10`
    - `rev < Integer.MIN_VALUE/10`
- Most commonly accepted in interviews
- Time: O(log₁₀ n)
- Space: O(1)

### ✔ method3_reverseUsingLong
- Uses long temporarily
- Overflow checked after reversing
- Simplest logic, but less strict
- Time: O(log₁₀ n)
- Space: O(1)

---

## Time & Space Complexity

| Method | Time | Space | Notes |
|--------|------|--------|-------|
| method1_original | O(log n) | O(1) | Absolute + manual overflow detection |
| method2_mathReverse | O(log n) | O(1) | FAANG standard solution |
| method3_reverseUsingLong | O(log n) | O(1) | Simplest, uses `long` |

---

## Edge Cases
- Overflow → return `0`
- Negative input → preserve sign
- Input ending with 0 → reverse removes leading zeros
- Input = 0 → return 0
- Input = Integer.MIN_VALUE → overflow on abs, but handled correctly

---

## FAANG Interview Notes
- **Always mention overflow handling**. This is what interviewers look for.
- Avoid String-based solutions—they ignore integer overflow concepts.
- Explain why:
  ```java
  if (rev > MAX/10 || (rev == MAX/10 && digit > 7))
