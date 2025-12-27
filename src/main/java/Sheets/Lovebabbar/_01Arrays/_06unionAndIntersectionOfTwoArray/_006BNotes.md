# Intersection Size of Two Arrays (FAANG Level)

## Problem Statement
Given two integer arrays `a[]` and `b[]`, find the **intersection size**.

⚠️ The meaning of “intersection size” must be clarified:
- Count **all common occurrences** OR
- Count **distinct common elements only**

---

## Implemented Approaches

| Method | Description | Time | Space | Distinct |
|------|------------|------|------|----------|
| method1 | HashSet (occurrence count) | O(n + m) | O(n) | ❌ |
| method2 | HashSet (distinct intersection) | O(n + m) | O(n+m) | ✅ |
| method3 | Two Pointers (sorted arrays) | O(n + m) | O(1) | ✅ |

---

## 🔥 Detailed Explanation — HashSet Occurrence Count (Your Approach)

### Idea
- Store elements of array `a` in a HashSet
- For each element in `b`, check if it exists in the set
- Increment count on match

### Behavior
- Counts **duplicates in `b`**
- Useful when frequency matters

### Example
- a = [1,2,3]
- b = [2,2,3]
- Output = 3

---

## Distinct Intersection (Common Interview Variant)

To count only unique common values:
- Use another HashSet for intersection
- Add element only once

---

## Two Pointer Approach (FAANG Preferred for Sorted Arrays)

### When to use
- Arrays are sorted
- Extra space is restricted

### Idea
- Traverse both arrays using pointers
- Skip duplicates
- Count only distinct matches

### Complexity
- **Time:** O(n + m)
- **Space:** O(1)

---

## Edge Cases
- One or both arrays empty
- No common elements
- Arrays with duplicates
- Arrays of different sizes

---

## FAANG Interview Notes

### What Interviewers Expect
- Clarification of problem requirement (distinct vs occurrences)
- HashSet baseline solution
- Optimized two-pointer solution for sorted arrays
- Correct complexity analysis

### How to Explain in Interview
> “If duplicates should be counted, HashSet works directly.  
> If only distinct elements are required, we need another set or pointer-based solution.”

### Common Pitfalls
- Counting duplicates unintentionally
- Not clarifying the problem
- Using sorting unnecessarily

---

## Final Recommendation
- **Unsorted arrays → HashSet**
- **Sorted arrays → Two pointers (BEST)**

Clarifying the requirement is the real interview win here.
