# Merge Intervals — LeetCode 56 (FAANG Level)

## Problem Statement
Given an array of intervals where intervals[i] = [startᵢ, endᵢ], merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

## Example
Input: [[1,3],[2,6],[8,10],[15,18]]  
Output: [[1,6],[8,10],[15,18]]

---

## Core Insight (Most Important)
Overlapping intervals only matter **after sorting by start time**.  
Once sorted, overlapping intervals appear next to each other.

This allows a **single linear scan** to merge intervals greedily.

---

## Implemented Approaches Overview

| Approach | Time | Space | Interview View |
|------|------|------|----------------|
| Greedy + List | O(n log n) | O(n) | **Preferred** |
| In-place Merge | O(n log n) | O(1) | Optimization |

---

## Approach 1: Greedy Using List (Recommended)

### Core Idea
1. Sort intervals by start time
2. Maintain a `prev` interval
3. Merge if overlapping, else store and move forward

### Why It Works
Once sorted:
- If `current.start ≤ prev.end`, they overlap
- Otherwise, they are independent

### Complexity
Time: O(n log n)  
Space: O(n)

### Interview Status
This is the **most readable and safest solution** for interviews.

---

## Approach 2: In-place Merge (Optimized)

### Core Idea
Reuse the original array:
- Maintain pointer `k` for merged intervals
- Modify array directly
- Slice final result

### Why It’s Used
- Avoids extra list
- Slightly better memory usage

### Drawback
- Harder to reason about
- Less readable

---

## Step-by-Step Walkthrough
Intervals: [[1,3],[2,6],[8,10],[15,18]]

Sorted → same

Compare [1,3] & [2,6] → merge → [1,6]  
Compare [1,6] & [8,10] → no overlap  
Compare [8,10] & [15,18] → no overlap

Final → [[1,6],[8,10],[15,18]]

---

## Edge Cases
Single interval  
Already merged intervals  
No overlapping intervals  
Intervals fully nested  
Empty input

---

## FAANG Interview Expectations

### What Interviewers Expect
- Sorting + greedy recognition
- Clean overlap condition
- Correct boundaries
- O(n log n) solution

### How to Explain (Verbatim-Ready)
“I first sort intervals by start time. Then I iterate and merge overlapping intervals greedily by comparing the current start with the previous end.”

---

## Common Follow-Up Questions
Insert Interval (LC 57)  
Non-overlapping intervals  
Meeting Rooms  
Interval intersection

---

## Common Pitfalls
Forgetting to sort  
Wrong overlap condition  
Modifying list incorrectly  
Off-by-one errors

---

## Final Recommendation
Use the greedy sorted approach. It is optimal, easy to explain, and forms the base of many advanced interval problems in FAANG interviews.
