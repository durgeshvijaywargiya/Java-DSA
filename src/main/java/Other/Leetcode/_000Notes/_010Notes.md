# Single Number — LeetCode 136 (FAANG Level)

## Problem Statement
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one. You must implement a solution with linear runtime complexity and constant extra space.

## Example
Input: nums = [4, 1, 2, 1, 2]  
Output: 4

## Constraints
1 <= nums.length <= 3 * 10^4  
-3 * 10^4 <= nums[i] <= 3 * 10^4  
Each element appears exactly twice except for one element which appears once.

---

## Implemented Approaches Overview

| Approach | Technique | Time | Space | Interview View |
|--------|----------|------|------|----------------|
| XOR Bit Manipulation | Bitwise XOR | O(n) | O(1) | **Strongly Preferred** |
| HashMap Counting | Frequency Map | O(n) | O(n) | Baseline / fallback |

---

## Approach 1: XOR Bit Manipulation (BEST)

### Core Idea
The XOR operation has three critical properties:
- a ^ a = 0
- a ^ 0 = a
- XOR is commutative and associative

By XOR-ing all elements together, all duplicate numbers cancel out, leaving only the number that appears once.

### Algorithm Explanation
- Initialize result = 0
- XOR every element in the array with result
- Return result

### Example Walkthrough
nums = [4, 1, 2, 1, 2]  
Step-by-step XOR:
0 ^ 4 = 4  
4 ^ 1 = 5  
5 ^ 2 = 7  
7 ^ 1 = 6  
6 ^ 2 = 4

Final result = 4

### Complexity
Time Complexity: O(n)  
Space Complexity: O(1)

### Why This Is Optimal
- Single pass
- Constant extra space
- No additional data structures
- Exactly matches problem constraints

---

## Approach 2: HashMap Frequency Counting

### Core Idea
Count the frequency of each number using a HashMap, then return the key with frequency 1.

### Why This Works
- Explicitly tracks occurrences
- Easy to understand and implement

### Complexity
Time Complexity: O(n)  
Space Complexity: O(n)

### When to Use
- When constraints are relaxed
- When problem is extended (e.g., multiple unique elements)
- As a stepping stone explanation before XOR

---

## Edge Cases You Must Know
Array with only one element  
Negative numbers included  
Large input size (linear solution required)

---

## FAANG Interview Expectations

### What Interviewers Expect
- Use of bit manipulation
- Understanding of XOR properties
- O(n) time and O(1) space solution
- No sorting or HashMap as final solution

### How to Explain in Interview
“Since every number appears twice except one, XOR-ing all elements cancels duplicates and leaves the unique number. This works because XOR of a number with itself is zero.”

### Common Follow-Up Questions
- What if every element appears three times except one? → Different problem (LC 137)
- What if two numbers appear once? → Use XOR + bit partitioning (LC 260)

---

## Common Pitfalls
Using HashMap as final solution when constant space is required  
Forgetting XOR properties  
Sorting the array unnecessarily  
Not handling negative numbers correctly (XOR handles them naturally)

---

## Final Recommendation
Always use the XOR solution in interviews. It is elegant, optimal, and demonstrates strong understanding of bitwise operations. The HashMap solution is useful only as a baseline or when constraints change.
