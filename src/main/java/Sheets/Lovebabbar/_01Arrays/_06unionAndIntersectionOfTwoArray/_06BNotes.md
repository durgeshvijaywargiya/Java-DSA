# Intersection of Two Arrays — LeetCode 349 (FAANG Level)

## Problem Statement
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

## Example
Input: nums1 = [1,2,2,1], nums2 = [2,2]  
Output: [2]

---

## Core Insight
We need:
- Only **unique elements**
- Only elements present in **both arrays**

The challenge is choosing the most efficient data structure or technique.

---

## Implemented Approaches Overview

| Approach | Time | Space | Interview View |
|-------|------|------|----------------|
| HashSet | O(n + m) | O(n + m) | Simple & safe |
| Sorting + Two Pointers | O(n log n + m log m) | O(1) | **Preferred** |
| Boolean Array | O(n + m) | O(1) | Constraint-based |

---

## Approach 1: HashSet (Baseline)

### Idea
- Store nums1 elements in a set
- Check nums2 elements against it
- Use another set to ensure uniqueness

### Pros
- Very easy to implement
- Fast in practice

### Cons
- Uses extra memory
- Relies heavily on collections

---

## Approach 2: Sorting + Two Pointers (FAANG Preferred)

### Core Idea
- Sort both arrays
- Traverse them simultaneously
- Add common elements
- Skip duplicates manually

### Why Interviewers Like This
- No heavy data structures
- From-scratch logic
- Demonstrates algorithmic thinking

### Complexity
Time: O(n log n + m log m)  
Space: O(1) (excluding output)

---

## Approach 3: Boolean Array (Highly Optimized)

### When This Works
If constraints guarantee:
0 ≤ nums[i] ≤ 1000

### Why It’s Fast
- Direct indexing
- No hashing
- Constant memory

### Interview Note
Mention only if constraints allow.

---

## Edge Cases
One array empty  
No common elements  
All elements common  
Duplicates in input arrays

---

## FAANG Interview Expectations

### What Interviewers Expect
- HashSet solution first
- Ability to optimize
- Awareness of constraints
- Avoiding unnecessary data structures

### How to Explain in Interview
“I can use a HashSet for simplicity. If space is a concern, I can sort both arrays and use a two-pointer technique to find the intersection without extra memory.”

---

## Common Pitfalls
Returning duplicates  
Using nested loops O(n²)  
Ignoring constraints  
Overusing collections unnecessarily

---

## Final Recommendation
- Use **HashSet** for clarity
- Use **two pointers** for space optimization
- Use **boolean array** only when constraints permit

This problem tests your ability to choose the right trade-off.
