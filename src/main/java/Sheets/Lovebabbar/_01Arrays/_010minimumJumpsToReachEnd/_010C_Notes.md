# Jump Game II — LeetCode 45 (FAANG Level)

## Problem Statement
You are given an array `nums[]` where each element represents the **maximum jump length** at that position.

Your task is to return the **minimum number of jumps** required to reach the **last index** starting from index `0`.

You can assume that the last index is always reachable.

---

## Example

- Input:[2, 3, 1, 1, 4]
- Output:2

Explanation:
- Jump from index 0 → index 1
- Jump from index 1 → index 4

---

## Implemented Approach

| Approach | Strategy | Time | Space |
|-------|---------|------|------|
| Greedy (Single-Pass) | Range Expansion | O(n) | O(1) |

---

## 🔥 Core Greedy Insight (FAANG EXPECTED)

This problem is solved using a **range-based greedy strategy**.

### Key Variables
- `currentEnd` → boundary of the current jump
- `farthest` → farthest index reachable in the next jump
- `jumps` → number of jumps taken

---

## Algorithm (Step-by-Step)

1. Initialize:
    - `currentEnd = 0`
    - `farthest = 0`
    - `jumps = 0`

2. Traverse the array from index `0` to `n - 2`:
    - Update `farthest = max(farthest, i + nums[i])`
    - If `i == currentEnd`:
        - You must take a jump
        - Increment `jumps`
        - Set `currentEnd = farthest`

3. Return `jumps`

---

## Why This Works

- Each jump defines a **range of indices**
- Greedy ensures we extend the next range as far as possible
- When the current range ends, a jump is unavoidable
- This guarantees the **minimum number of jumps**

This approach is equivalent to **BFS level traversal**, without using a queue.

---

## Relation to Other Problems

| Problem | Difference |
|------|-----------|
| Jump Game I (LC 55) | Check if end is reachable |
| Jump Game II (LC 45) | Count minimum jumps |
| Minimum Jumps (GFG) | Same logic + unreachable handling |

---

## Edge Cases
- Array length = 1 → 0 jumps
- Large jump values → handled naturally
- Consecutive small jumps → greedy still optimal

> Note: LeetCode guarantees the end is reachable, so no `-1` case needed.

---

## FAANG Interview Notes

### What Interviewers Expect
- O(n) greedy solution
- Clear explanation of range expansion
- Understanding of BFS-like behavior
- No DP (O(n²) rejected)

### How to Explain in Interview
> “Each jump defines a range.  
> I expand the next range greedily.  
> When the current range is exhausted, I increment the jump count.”

### Common Pitfalls
- Off-by-one errors
- Counting jump at last index
- Using DP unnecessarily
- Forgetting that the end is guaranteed reachable

---

## Final Recommendation
This **single-pass greedy solution** is the **industry-standard** and **FAANG-approved** approach.

If you master this, you automatically master:
- Jump Game I
- Minimum Jumps
- Range-based greedy patterns

