# Find Common Elements Between Two Arrays — LeetCode 2956 (FAANG Level)

## Problem Statement
You are given two integer arrays nums1 and nums2.

Return an array ans of size 2 where:
- ans[0] is the number of elements in nums1 that are present in nums2
- ans[1] is the number of elements in nums2 that are present in nums1

Each occurrence is counted separately.

---

## Example
Input:  
nums1 = [2,3,2]  
nums2 = [1,2]

Output:  
[2,1]

Explanation:
- nums1 has two elements (2,2) that appear in nums2
- nums2 has one element (2) that appears in nums1

---

## Core Insight
This is **NOT** an intersection-with-uniqueness problem.

Duplicates must be counted based on **presence**, not frequency matching.

---

## Implemented Approaches Overview

| Approach | Time | Space | Interview View |
|------|------|------|----------------|
| Two HashSets | O(n + m) | O(n + m) | Correct |
| Single HashSet | O(n + m) | O(n) | Better |
| Frequency Array | O(n + m) | O(1) | **Best (constraints)** |

---

## Approach 1: Two HashSets (Baseline)

### Idea
- Find unique common elements
- Count how many times those appear in both arrays

### Drawback
- Uses unnecessary extra memory
- Can be simplified

---

## Approach 2: Optimized HashSet (Preferred General Solution)

### Core Idea
- Use HashSet for fast lookup
- Count directly without storing intersection set

### Why It’s Better
- Fewer data structures
- Cleaner logic
- Same time complexity

---

## Approach 3: Frequency Array (Most Optimized)

### Why This Is Best
- Constraints guarantee values ≤ 100
- Boolean array lookup is O(1)
- No hashing overhead

### When to Use
Only when constraints are explicitly small and fixed.

---

## Complexity Analysis
Time Complexity: O(n + m)  
Space Complexity:
- HashSet: O(n)
- Frequency array: O(1)

---

## Edge Cases
No common elements  
All elements common  
Duplicates in arrays  
Single-element arrays

---

## FAANG Interview Expectations

### What Interviewers Expect
- Correct interpretation of the problem
- Avoiding overcomplication
- Constraint-aware optimization

### How to Explain in Interview
“I use a fast lookup structure to check presence across arrays and count occurrences accordingly. With small constraints, a frequency array is the most optimal.”

---

## Common Pitfalls
Confusing with LeetCode 349 / 350  
Using HashMap unnecessarily  
Counting unique instead of occurrences

---

## Final Recommendation
- Use **frequency array** when constraints allow
- Otherwise, use **HashSet**
- Keep logic simple and linear

This problem tests clarity more than complexity.
