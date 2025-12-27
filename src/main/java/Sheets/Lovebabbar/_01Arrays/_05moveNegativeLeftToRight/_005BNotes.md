# Move Negative Elements to Right (Same Order)

## Problem Statement
Given an integer array, move all **negative elements to the right side** of the array **while preserving the relative order** of all elements.

---

## Implemented Approaches

| Method | Name | Time | Space | Stable | Notes |
|------|------|------|------|--------|------|
| method1 | Two-Ended Stable Fill | O(n) | O(n) | ✅ YES | One-pass, clean logic |
| method2 | Two-Pass Stable | O(n) | O(n) | ✅ YES | Simpler & readable |

---

## 🔥 Detailed Explanation — Two-Ended Stable Fill (Your Approach)

This approach ensures **order preservation** while still running in **linear time**.

### Core Idea
- Use an auxiliary array
- Fill positives from the **left**
- Fill negatives from the **right**
- Traverse input from both ends logically

### Pointers Used
- `pos` → next index for positive element (starts at 0)
- `neg` → next index for negative element (starts at n-1)

### How Order Is Preserved

- Positives:
    - Scanned from left to right
    - Inserted from left to right
    - ✔ Order preserved

- Negatives:
    - Scanned from right to left
    - Inserted from right to left
    - ✔ Order preserved

### Visual Example
- Input: [-1, 3, -2, 4, -5, 6]
- Result: [ 3, 4, 6, -1, -2, -5]
### Complexity
- **Time:** O(n)
- **Space:** O(n)
- **Stable:** YES
- **In-place:** NO

---

## Alternative — Two-Pass Stable Method

- First pass → copy positives
- Second pass → copy negatives
- Same complexity, easier to explain

---

## Edge Cases
- Empty array
- All positives
- All negatives
- Single element
- Already segregated array

---

## FAANG Interview Notes

### What Interviewers Expect
- Recognition that **stability is required**
- Understanding that **in-place partition will not work**
- Correct use of auxiliary space
- Clear explanation of why order is preserved

### How to Explain in Interview
> "Since the problem requires maintaining the relative order,  
> an in-place partition is not suitable.  
> I use an auxiliary array to first place positive elements in order,  
> then negative elements in order, ensuring stability."

### Common Pitfalls
- Using in-place partition and breaking order
- Forgetting that stability requires extra space
- Over-complicating with swaps

---

## Final Recommendation
Use a **stable extra-array solution** when order matters.  
Mention that **O(1) space is impossible if stability is required** — this shows strong algorithmic understanding.

