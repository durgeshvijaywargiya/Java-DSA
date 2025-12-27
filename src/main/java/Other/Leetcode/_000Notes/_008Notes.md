# Mirror Distance of an Integer — LeetCode 3783 (FAANG Level)

## Problem Statement
You are given an integer n. Define its mirror distance as the absolute difference between n and its digit-reversed value. Formally: mirrorDistance(n) = |n − reverse(n)|, where reverse(n) is the integer formed by reversing the digits of n. Return the mirror distance of n.

## Example
Input: n = 123  
Output: 198  
Explanation: reverse(123) = 321, |123 − 321| = 198.

## Constraints
n is a non-negative integer.  
Digits fit within standard integer range.

---

## Core Approach Overview
The problem is solved in two simple steps:
1. Reverse the digits of the given integer.
2. Compute the absolute difference between the original number and its reverse.

This approach is optimal because every digit must be processed at least once.

---

## Step-by-Step Explanation

### Step 1: Reverse the Integer
We extract digits one by one using modulo (%) and rebuild the reversed number using multiplication by 10. This is a standard integer-reversal pattern commonly used in multiple problems.

### Step 2: Compute Mirror Distance
Once the reversed number is obtained, we compute the mirror distance using absolute value to ensure the result is non-negative.

---

## Example Walkthrough
For n = 120:
- Reverse process: 021 → 21
- Mirror distance: |120 − 21| = 99

Leading zeros are naturally ignored during integer reversal, which is expected behavior.

---

## Complexity Analysis
Time Complexity: O(d), where d is the number of digits in n  
Space Complexity: O(1), constant extra space

---

## Edge Cases You Must Know
n = 0 → reverse = 0, distance = 0  
Single-digit numbers → distance = 0  
Numbers ending with zeros (e.g., 120) → reversed value drops leading zeros  
Large integers → handled safely within integer limits

---

## FAANG Interview Expectations

### What Interviewers Expect
- Correct integer reversal logic
- Use of absolute value to handle ordering
- Awareness of leading zero behavior
- Clean O(d) time and O(1) space solution

### How to Explain in Interview
“I reverse the digits of the number using modulo and division, then compute the absolute difference between the original number and the reversed number. This ensures correctness regardless of digit order.”

### Follow-Up Questions You May Get
- How does your solution handle trailing zeros?
- What happens for single-digit numbers?
- Can this overflow? (Here, constraints ensure safety)

---

## Common Pitfalls
Forgetting to use absolute value  
Incorrect digit reversal logic  
Using strings unnecessarily  
Overcomplicating a simple digit problem

---

## Final Recommendation
This problem tests clarity, not complexity. Use clean integer manipulation without strings. A correct and simple solution is exactly what interviewers want to see.
