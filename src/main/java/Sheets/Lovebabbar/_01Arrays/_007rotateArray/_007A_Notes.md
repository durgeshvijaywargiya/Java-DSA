# Cyclically Rotate an Array by One (Clockwise)

## Problem Statement
Given an array `arr`, rotate the array by **one position in clockwise direction**.

### Example
Input:[1, 2, 3, 4, 5]
Output:[5, 1, 2, 3, 4]

---

## Implemented Approaches

| Method | Approach | Time | Space | In-Place |
|------|--------|------|------|---------|
| method1 | Extra Array | O(n) | O(n) | ❌ |
| method2 | Extra Array Optimised | O(n) | O(n) | ❌ |
| method3 | In-Place Shift | O(n) | O(1) | ✅ |

---

## 🔥 Detailed Explanation — In-Place Rotation (FAANG Preferred)

### Core Idea
- Store the **last element**
- Shift all elements one position to the right
- Place the saved element at index `0`

### Steps
1. `last = arr[n-1]`
2. For `i = n-1` to `1`, do `arr[i] = arr[i-1]`
3. Set `arr[0] = last`

### Why This Works
- Clockwise rotation means every element moves one step forward
- Last element wraps around to the front
- No extra memory needed

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## Edge Cases
- Empty array
- Single element array
- Array with duplicates
- Large arrays

---

## FAANG Interview Notes

### What Interviewers Expect
- Extra-array solution first (baseline)
- Then optimisation to **in-place O(1) space**
- Clear explanation of shifting logic

### How to Explain in Interview
> “To rotate clockwise by one, I save the last element,  
> shift all elements one step to the right,  
> and put the saved element at index 0.”

### Common Pitfalls
- Forgetting to save the last element
- Shifting in the wrong direction
- Using extra space when not needed

---

## Final Recommendation
Use the **in-place shifting approach** in interviews.  
Mention the extra-array method only as a stepping stone.
