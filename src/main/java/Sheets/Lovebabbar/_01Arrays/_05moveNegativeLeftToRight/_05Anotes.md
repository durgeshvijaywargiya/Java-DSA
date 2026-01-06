# Move All Negative Numbers to Left

## Problem Statement
Given an integer array, move all **negative numbers to the left side** of the array.

- Order of elements **may or may not be preserved** depending on approach.
- The operation should ideally be done **in-place**.

---

## Approaches Implemented

| Method | Name | Time | Space | Stable | Notes |
|------|------|------|------|--------|------|
| method1 | Partition-Based | O(n) | O(1) | ❌ No | FASTEST, in-place |
| method2 | Stable Extra Array | O(n) | O(n) | ✅ Yes | Order preserved |

---

## 🔥 Detailed Explanation — Partition-Based Approach (FAANG Preferred)

This approach is based on **array partitioning**, similar to QuickSort.

### Idea
Maintain a pointer `j` such that:
- All elements before `j` are negative
- Traverse array using pointer `i`

### Invariant
- [0 ... j-1] → negative numbers
- [j ... i-1] → non-negative numbers
- [i ... end] → unprocessed
### Algorithm
1. Initialize `j = 0`
2. Traverse array with `i`
3. If `arr[i] < 0`:
    - Swap `arr[i]` with `arr[j]`
    - Increment `j`

### Why it works
- Each negative number is placed immediately in its correct region
- Non-negatives automatically shift right
- Only one pass is required

### Complexity
- **Time:** O(n)
- **Space:** O(1)
- **In-place:** Yes
- **Stable:** No

---

## Other Approach — Stable Using Extra Array

- First copy all negatives
- Then copy all non-negatives
- Preserves order
- Uses extra memory

---

## Edge Cases

- Empty array
- All elements negative
- All elements positive
- Single element
- Already partitioned array

---

## FAANG Interview Notes

### What interviewers expect
- Recognition of this as a **partitioning problem**
- Use of **two pointers**
- O(n) time solution
- Awareness of stability trade-off

### How to explain in interview
> "I use a partition approach similar to QuickSort.  
> I maintain a pointer `j` that tracks where the next negative number should go.  
> While scanning the array, every negative element is swapped to the front.  
> This gives an in-place O(n) solution."

### Common Pitfalls
- Forgetting that the solution is **not stable**
- Using sorting unnecessarily
- Using extra space when not required
- Not explaining pointer invariant

---

## Final Recommendation
Use the **partition-based in-place approach** when order does not matter.  
Mention the **stable variant** to show deeper understanding.

