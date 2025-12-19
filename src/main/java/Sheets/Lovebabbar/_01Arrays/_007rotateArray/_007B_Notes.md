# Rotate Array Clockwise by K Positions

## Problem Statement
Given an array `nums` and an integer `k`, rotate the array **clockwise by `k` positions**.

---

## Implemented Approaches

| Method | Approach | Time | Space | In-Place | Notes |
|------|--------|------|------|---------|------|
| method1 | Reversal Algorithm | O(n) | O(1) | ✅ | **FAANG Preferred** |
| method2 | Extra Array + Modulo | O(n) | O(n) | ❌ | Simple baseline |

---

## 🔥 Detailed Explanation — Reversal Algorithm (BEST)

### Core Idea
Rotation can be achieved using **three reversals**:

1. Reverse the entire array
2. Reverse the first `k` elements
3. Reverse the remaining `n - k` elements

### Example
nums = [1,2,3,4,5,6,7]
k = 3

Step 1: Reverse whole
[7,6,5,4,3,2,1]

Step 2: Reverse first k
[5,6,7,4,3,2,1]

Step 3: Reverse rest
[5,6,7,1,2,3,4]

### Why It Works
- The last `k` elements move to the front
- Reversal restores their relative order
- Achieves rotation without extra space

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## Extra Array Approach (Baseline)

### Idea
- Create a temporary array
- Place each element at `(i + k) % n`
- Copy back

### Trade-off
- Easier to understand
- Uses extra memory

---

## Edge Cases
- `k = 0` → array unchanged
- `k > n` → use `k % n`
- Empty array
- Single element array
- Large `k`

---

## FAANG Interview Notes

### What Interviewers Expect
- Extra array approach as baseline
- Optimisation to **O(1) space**
- Clear explanation of reversal logic
- Proper handling of `k > n`

### How to Explain in Interview
> “I first normalize k using modulo.  
> Then I reverse the whole array, reverse the first k elements,  
> and finally reverse the remaining elements.  
> This rotates the array in-place with O(1) extra space.”

### Common Pitfalls
- Forgetting `k % n`
- Reversing wrong segments
- Confusing clockwise vs anti-clockwise rotation

---

## Final Recommendation
Always use the **Reversal Algorithm** in interviews.  
Mention the extra-array approach as a stepping stone.

This problem is a **must-know array manipulation pattern**.
