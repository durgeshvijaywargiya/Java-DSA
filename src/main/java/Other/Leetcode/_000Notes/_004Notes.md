# Absolute Difference of k Smallest and k Largest Elements

## Problem Statement
Given an integer array `nums` and an integer `k`, compute:

| (sum of k smallest elements) − (sum of k largest elements) |

---

## Approaches Used

### 1️⃣ Sorting-Based (Original & Optimized)
- Sort the array
- Add first k and last k elements

**Time:** O(n log n)  
**Space:** O(1)

Best when:
- n is small or moderate
- Simplicity is preferred

---

### 2️⃣ Heap-Based (FAANG Alternative)
- Min-heap for k smallest
- Max-heap for k largest

**Time:** O(n log k)  
**Space:** O(k)

Best when:
- k is small
- n is very large
- Full sort is unnecessary

---

## Constraints-Based Reasoning

### Given Constraints
- If n is small → sorting is fine
- If k ≪ n → heap approach is better

### Interview Explanation (Say This)
> “I used sorting for clarity, but if n is large and k is small, I would switch to a heap-based approach to reduce unnecessary work.”

---

## Complexity Summary

| Method | Time | Space | Notes |
|------|------|-------|------|
| Sorting | O(n log n) | O(1) | Clean & simple |
| Heap | O(n log k) | O(k) | Optimized for small k |

---

## Edge Cases
- k = 0 → answer = 0
- k = n/2 → both sides cover whole array
- nums length = 1 → result = abs(nums[0])

---

## Interview Cross-Questions

**Q: Why absolute difference?**  
Because result must be non-negative.

**Q: Can we do better than sorting?**  
Yes, using heaps or QuickSelect.

**Q: When is sorting still acceptable?**  
When constraints are small or code clarity matters.

---

## Final Notes
- Sorting solution is perfectly acceptable for most interviews.
- Mention heap optimization proactively to stand out.
