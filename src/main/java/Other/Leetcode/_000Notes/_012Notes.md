# Find the Duplicate Number — LeetCode 287 (FAANG Level)

## Problem Statement
Given an array nums containing n + 1 integers where each integer is in the range [1, n], inclusive, there is exactly one duplicate number. Return the duplicate number.

You must solve the problem without modifying the array and using only constant extra space.

## Example
Input: nums = [1,3,4,2,2]  
Output: 2

## Constraints
1 <= n <= 10^5  
nums.length == n + 1  
Each integer is between 1 and n (inclusive)  
Exactly one number is repeated

---

## Core Insight (Most Important)
This is NOT just a “find duplicate” problem. It is a **cycle detection problem disguised as an array problem**.

Because:
- Values range from 1 to n
- Indices range from 0 to n
- nums[i] can be treated as a pointer to another index

This guarantees a cycle due to the pigeonhole principle.

---

## Implemented Approaches Overview

| Method | Time | Space | Modifies Input | Interview Status |
|-----|------|------|---------------|------------------|
| Negative Marking | O(n) | O(1) | Yes | ❌ Constraint violation |
| HashSet | O(n) | O(n) | No | ❌ Extra space |
| Counting Array | O(n) | O(n) | No | ❌ Extra space |
| Floyd’s Cycle Detection | O(n) | O(1) | No | ✅ **Preferred** |

---

## Approach 1: Negative Marking
Each number is used as an index. If we encounter a number whose index is already negative, it means that number appeared before.

Why it works: duplicate index is visited twice.

Why it’s rejected: it modifies the input array, which is explicitly disallowed.

---

## Approach 2: HashSet
Insert elements into a set. The first element that already exists is the duplicate.

Why it works: detects repeated values directly.

Why it’s rejected: violates constant space requirement.

---

## Approach 3: Frequency Array
Maintain a count array of size n + 1. Increment count for each number. If count exceeds 1, return the number.

Why it works: direct counting.

Why it’s rejected: uses extra O(n) space.

---

## Approach 4: Floyd’s Tortoise and Hare (FAANG Preferred)

### Key Insight
Treat the array as a linked list:
- Index → node
- Value → next pointer

Because there are n + 1 nodes but only n possible values, a cycle must exist.

### Algorithm
Phase 1: Detect cycle using slow and fast pointers  
Phase 2: Reset one pointer to start and move both one step at a time to find cycle entry

The cycle entry point is the duplicate number.

### Example
nums = [1,3,4,2,2]

Mapping:
0 → 1 → 3 → 2 → 4 → 2 (cycle)

Duplicate = 2

---

## Complexity Analysis
Time Complexity: O(n)  
Space Complexity: O(1)

---

## Edge Cases You Must Know
Duplicate appears multiple times  
Duplicate appears at the beginning or end  
Minimum size input  
Array values strictly within [1, n]

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognition of cycle detection pattern
- Use of Floyd’s algorithm
- Respecting constraints strictly
- No modification of input
- Constant space solution

### How to Explain in Interview (Verbatim-Ready)
“Since the numbers are in the range [1, n], we can treat each value as a pointer to another index. This guarantees a cycle, and the duplicate number is the entry point of that cycle, which can be found using Floyd’s Tortoise and Hare algorithm.”

---

## Common Follow-Up Questions
What if there are multiple duplicates? → Problem constraints change  
What if array can be modified? → Negative marking works  
What if numbers start from 0? → Adjust indexing logic

---

## Common Pitfalls
Missing the cycle interpretation  
Using HashSet despite constant space requirement  
Modifying the array  
Returning wrong index instead of value

---

## Final Recommendation
Always use Floyd’s Cycle Detection for this problem in interviews. Other methods are useful for learning, but only Floyd’s satisfies all constraints and demonstrates strong algorithmic insight.
