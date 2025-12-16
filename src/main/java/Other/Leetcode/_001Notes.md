# First Missing Positive — LeetCode 41 (FAANG Level)

## Problem Statement
Given an unsorted integer array `nums`, return the **smallest missing positive integer**.

Constraints:
- Must run in **O(n)** time
- Must use **constant extra space**

---

## Implemented Approaches

| Method | Approach | Time | Space | FAANG Optimal |
|------|--------|------|------|--------------|
| method1 | Cyclic Sort / Index Placement | O(n) | O(1) | ✅ YES |
| method2 | TreeSet | O(n log n) | O(n) | ❌ |
| method3 | TreeSet + Array | O(n log n) | O(n) | ❌ |

---

## 🔥 Detailed Explanation — Cyclic Sort (BEST)

### Core Idea
For an array of size `n`, the numbers `1..n` **should be placed at indices `0..n-1`**.

So:
- Value `1` → index `0`
- Value `2` → index `1`
- Value `x` → index `x-1`

### Algorithm
1. Traverse array
2. While current value `x` is in range `[1,n]`
   and `nums[x-1] != x`
   → swap it to correct index
3. After placement, scan array:
    - First index `i` where `nums[i] != i+1` → answer is `i+1`
4. If all correct → answer is `n+1`

### Why This Works
- Every valid positive is placed exactly once
- Invalid numbers (≤0 or >n) are ignored
- Uses array itself as a hash structure

### Complexity
- **Time:** O(n)
- **Space:** O(1)
- **In-place:** Yes

This is the **official expected FAANG solution**.

---

## Other Approaches

### TreeSet
- Easy to code
- Sorted structure finds gaps
- Fails space constraint
- Good for explanation, not optimal

---

## Edge Cases
- Empty array → return 1
- All negatives → return 1
- Continuous range [1..n] → return n+1
- Duplicates → handled automatically
- Large numbers ignored safely

---

## FAANG Interview Notes

### What Interviewers Test
- Ability to reason about **index ↔ value mapping**
- Understanding of **in-place hashing**
- Avoidance of extra data structures
- Correct handling of duplicates

### How to Explain
> “Since the smallest missing positive must be in the range `1..n+1`,
> I use the array indices as buckets and place each number in its correct index.
> Then I scan to find the first mismatch.”

### Common Pitfalls
- Infinite swap loops
- Using HashSet / TreeSet without optimization
- Forgetting to ignore numbers > n
- Missing duplicate check in while condition

---

## Final Recommendation
Always implement **Cyclic Sort / Index Placement** in interviews.  
Mention TreeSet only as a baseline.

This problem is a **FAANG favorite** — mastering it is mandatory.
