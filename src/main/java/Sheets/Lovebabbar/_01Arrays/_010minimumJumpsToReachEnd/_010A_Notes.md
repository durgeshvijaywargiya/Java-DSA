# Minimum Jumps to Reach End (GFG / FAANG)

## Problem Statement
You are given an array `arr[]` of non-negative integers.  
Each element represents the **maximum number of steps** you can jump forward from that index.

Your task is to find the **minimum number of jumps** needed to reach the **last index** starting from the first index.

- Return `-1` if the end is not reachable.

---

## Example
- Input: [2, 3, 1, 1, 4]
- Output: 2
---

## Implemented Approaches

| Approach | Description | Time | Space |
|-------|------------|------|------|
| Greedy + Reach Check | Two-pass solution | O(n) | O(1) |
| Single-Pass Greedy | Optimized FAANG solution | O(n) | O(1) |

---

## 🔹 Approach 1: Greedy + Reachability Check (Two-Pass)

### Idea
This approach separates the problem into two logical steps:

1. **Reachability Check (Jump Game I)**
    - Determine whether the last index is reachable at all.
2. **Minimum Jump Count (Jump Game II)**
    - Use greedy range expansion to count minimum jumps.

### Why This Works
- The reachability check avoids unnecessary computation
- Greedy ensures the minimum number of jumps
- Very clear and easy to reason about

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## 🔹 Approach 2: Single-Pass Greedy (FAANG Preferred)

### Core Insight
Each jump defines a **range of indices** you can reach.
While iterating:
- `currentEnd` → boundary of current jump
- `farthest` → farthest index reachable in the next jump

### Algorithm
1. Traverse the array up to `n-2`
2. Continuously update `farthest`
3. When you reach `currentEnd`:
    - You must take a jump
    - Update the range to `farthest`
4. If `farthest` does not move forward → unreachable

### Why This Is Better
- Combines reachability and jump counting
- Single traversal
- Cleaner, more professional interview solution

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## 🔥 Why Greedy Works (Key Interview Explanation)

- Each jump behaves like a **BFS level**
- Greedy expands the range as far as possible
- The first time you exhaust a range, you are forced to jump
- This guarantees the **minimum number of jumps**

---

## Edge Cases
- Array length = 1 → 0 jumps
- First element = 0 (size > 1) → unreachable
- Multiple zeros in between
- Large values of jumps

---

## FAANG Interview Notes

### What Interviewers Expect
- O(n) greedy solution
- Clear explanation of:
    - `currentEnd`
    - `farthest`
- Handling unreachable cases
- Avoiding DP (O(n²))

### How to Explain in Interview
> “I treat jumps as BFS levels.  
> Each jump covers a range.  
> When the range ends, I increment the jump count  
> and expand the next range greedily.”

### Common Pitfalls
- Using DP unnecessarily
- Missing unreachable cases
- Off-by-one errors
- Counting an extra jump at the end

---

## Final Recommendation
Use the **Single-Pass Greedy** solution in interviews.  
Mention the two-pass solution for clarity if needed.

This is a **must-know greedy pattern** for FAANG.


