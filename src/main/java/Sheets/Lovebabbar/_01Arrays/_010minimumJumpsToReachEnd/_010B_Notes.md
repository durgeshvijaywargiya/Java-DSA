# Jump Game — LeetCode 55 (FAANG Level)

## Problem Statement
You are given an array `nums[]` where each element represents the **maximum jump length** at that position.

Return `true` if you can reach the **last index** starting from index `0`, otherwise return `false`.

---

## Example

- Input: [2, 3, 1, 1, 4]
- Output: true

- Input: [3, 2, 1, 0, 4]
- Output: false


---

## Implemented Approaches

| Approach | Direction | Time | Space | Notes |
|-------|----------|------|------|------|
| Backward Greedy | Right → Left | O(n) | O(1) | **FAANG Preferred** |
| Forward Greedy | Left → Right | O(n) | O(1) | Also valid |

---

## 🔹 Approach 1: Backward Greedy (BEST)

### Core Idea
Instead of asking:
> “Can I reach the end from the start?”

We ask:
> “From which positions can I reach the end?”

### Algorithm
1. Assume last index is reachable
2. Traverse array from right to left
3. If index `i` can reach the last good index:
    - Mark `i` as the new last good index
4. At the end, check if index `0` is a good index

### Why This Works
- We reduce the problem step by step
- Greedy ensures minimal checks
- No extra memory required

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## 🔹 Approach 2: Forward Greedy

### Core Idea
- Track the **farthest index** reachable
- If at any index `i`, `i > farthest`, then it’s unreachable

### Why It Works
- If we can always move the boundary forward, we can reach the end
- Early failure detection

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## 🔥 Why Greedy is Optimal (Interview Insight)

- DP solution exists but is **O(n²)** → rejected
- Each index only needs to be visited once
- Greedy keeps only **essential information**

This problem is about **reachability**, not jump count.

---

## Edge Cases
- Array of length 1 → always true
- First element = 0 (length > 1) → false
- Multiple zeros in between
- Large jump values

---

## FAANG Interview Notes

### What Interviewers Expect
- O(n) greedy solution
- Clear explanation of reachability logic
- No DP
- Clean edge-case handling

### How to Explain in Interview
> “I work backwards and track the leftmost index that can reach the end.  
> If index 0 becomes reachable, then the whole array is solvable.”

### Common Pitfalls
- Using DP unnecessarily
- Confusing Jump Game I with Jump Game II
- Off-by-one errors

---

## Final Recommendation
Use the **Backward Greedy approach** in interviews.  
It is clean, intuitive, and widely accepted at FAANG.

This problem is the **foundation** for:
- Jump Game II
- Minimum jumps problems


