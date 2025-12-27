# Excel Sheet Column Title — LeetCode 168 (FAANG Level)

## Problem Statement
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

Excel columns are labeled as:
A → 1  
B → 2  
...  
Z → 26  
AA → 27  
AB → 28

## Example
Input: columnNumber = 28  
Output: "AB"

## Constraints
1 <= columnNumber <= 2^31 − 1

---

## Core Insight (Most Important)
This problem looks like base-26 conversion, but it is NOT standard base-26.

Why?
- Standard base systems use digits starting from 0
- Excel columns are 1-based and have no zero character

There is no representation for zero in Excel columns.

This is the key trick interviewers test.

---

## Key Observation
To correctly map numbers to characters:
- Subtract 1 before modulo
- Then map 0 → 'A', 25 → 'Z'

This adjustment converts the problem into a valid base-26 system.

---

## Algorithm Explanation

### Step-by-Step Logic
1. While columnNumber > 0:
    - Decrement columnNumber by 1
    - Take columnNumber % 26 to get the character index
    - Convert index to character ('A' + index)
    - Divide columnNumber by 26
2. Reverse the string (because digits are processed from least significant to most significant)

---

## Example Walkthrough

### Example 1: columnNumber = 1
columnNumber = 1  
1 − 1 = 0 → 'A'  
Result = "A"

### Example 2: columnNumber = 26
26 − 1 = 25 → 'Z'  
Result = "Z"

### Example 3: columnNumber = 28
28 − 1 = 27  
27 % 26 = 1 → 'B'  
27 / 26 = 1  
1 − 1 = 0 → 'A'  
Reverse → "AB"

---

## Why columnNumber-- is REQUIRED
Without decrement:
- 26 % 26 = 0 → incorrectly maps to 'A'
- Excel expects 26 → 'Z'

The decrement shifts the numbering system so it behaves like zero-based indexing.

This is the most common interview pitfall.

---

## Complexity Analysis
Time Complexity: O(log₍₂₆₎ n), number of digits in base-26  
Space Complexity: O(log₍₂₆₎ n), size of result string

---

## Edge Cases You Must Know
columnNumber = 1 → "A"  
columnNumber = 26 → "Z"  
columnNumber = 27 → "AA"  
Very large column numbers  
Multiple trailing Zs (e.g., 702 → "ZZ")

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognition that this is not standard base-26
- Correct handling of 1-based indexing
- Clean loop-based solution
- Explanation of why decrement is needed

### How to Explain in Interview (Verbatim-Ready)
“Excel columns don’t have a zero character, so I shift the number by subtracting one before taking modulo. This converts the problem into a proper base-26 representation.”

---

## Common Follow-Up Questions
How would you convert title back to number? → LeetCode 171  
Why can’t we use normal base-26? → No zero digit exists  
What if lowercase letters were allowed? → Adjust ASCII offset

---

## Common Pitfalls
Forgetting to subtract 1 before modulo  
Mapping 26 to 'A' instead of 'Z'  
Not reversing the string  
Overcomplicating with recursion

---

## Final Recommendation
This is a classic base-conversion-with-offset problem. The logic is simple once the indexing trick is understood. Mastering this pattern helps solve many similar encoding problems and is frequently tested in FAANG interviews.

