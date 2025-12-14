# Armstrong Number Checker (Java) — FAANG-Level Solutions

## Problem Statement
Determine whether a number `n` is an Armstrong Number.

## Definition (General)
A number with `d` digits is an Armstrong number if:

digit1^d + digit2^d + ... + digit_d^d = n

### Examples
- 153 = 1^3 + 5^3 + 3^3
- 9474 = 9^4 + 4^4 + 7^4 + 4^4
- 548834 = 5^6 + 4^6 + 8^6 + 8^6 + 3^6 + 4^6

---

## Methods Included

### method1_original3Digit
Brute cube-only logic (works only for 3-digit Armstrong numbers). Matches the original input code.

### method2_armstrongGeneralSafe
General Armstrong checker **without** floating point.
- Uses manual exponentiation (digit * digit ...)
- Eliminates floating-point rounding concerns

### method3_armstrongLookup
Precomputed Armstrong numbers for the 32-bit integer range.
- Ultra-fast O(1) lookup
- Only useful when constraints are known

---

## Time and Space Complexity

| Method                         | Time Complexity | Space Complexity | Notes |
|-------------------------------|----------------|-----------------|-------|
| method1_original3Digit        | O(d)           | O(1)            | Only for 3-digit numbers |
| method4_armstrongGeneralSafe  | O(d * digits)  | O(1)            | Avoids floating point |
| method5_armstrongLookup       | O(k)           | O(1)            | k is number of Armstrong numbers in int range |

---

## Edge Cases
- `0` → Armstrong
- Any 1-digit number → Armstrong
- Large multi-digit Armstrong numbers like `9474`, `548834`
- Negative numbers → Not Armstrong
- Very large numbers → Use general or safe approach

---
