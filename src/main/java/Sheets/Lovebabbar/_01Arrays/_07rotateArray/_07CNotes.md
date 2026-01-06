# Rotate Array Left by K (Counter-Clockwise)

## Problem Statement
Given an array `arr[]`, rotate the array to the **left (counter-clockwise)** by `d` steps.

- Rotation must be treated as **circular**
- Modification should be done **in place**

---

## Implemented Approaches

| Method | Approach | Time | Space | In-Place |
|------|--------|------|------|---------|
| method1 | Extra Array | O(n) | O(n) | ❌ |
| method2 | Extra Array Optimised | O(n) | O(n) | ❌ |
| method3 | Reversal Algorithm | O(n) | O(1) | ✅ **BEST** |

---

## 🔥 Detailed Explanation — Reversal Algorithm (FAANG Preferred)

### Core Idea
To rotate left by `k`:
1. Reverse first `k` elements
2. Reverse remaining `n-k` elements
3. Reverse the whole array

### Example
nums = [1,2,3,4,5,6]
k = 2

Step 1: reverse first k
[2,1,3,4,5,6]

Step 2: reverse remaining
[2,1,6,5,4,3]

Step 3: reverse whole
[3,4,5,6,1,2]

### Why This Works
- First reversal prepares the rotated prefix
- Second reversal prepares the suffix
- Final reversal restores correct order

### Complexity
- **Time:** O(n)
- **Space:** O(1)
- **In-place:** Yes

---

## Extra Array Approach (Baseline)

### Idea
- Compute new index using modulo
- Store in temp array
- Copy back

### Trade-off
- Easy to understand
- Uses extra memory

---

## Edge Cases
- `k = 0` → no change
- `k > n` → reduce using `k % n`
- Empty array
- Single element array
- Duplicate elements

---

## FAANG Interview Notes

### What Interviewers Expect
- Baseline solution using extra array
- Optimisation to **O(1) space**
- Correct handling of `k > n`
- Clear explanation of reversal logic

### How to Explain in Interview
> “For in-place rotation, I use the reversal algorithm.  
> I reverse the first k elements, then the rest, and finally the whole array.  
> This achieves left rotation in O(1) extra space.”

### Common Pitfalls
- Forgetting modulo reduction
- Reversing wrong segments
- Mixing left and right rotation logic

---

## Final Recommendation
Always use the **Reversal Algorithm** when the problem says **in place**.  
Mention the extra-array method only as a stepping stone.
