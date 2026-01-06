# Minimum Deletions to Remove Min and Max — LeetCode 2091 (FAANG Level)

## Problem Statement
You are given an integer array nums. In one move, you can delete one element from either the front or the back of the array.

Return the minimum number of deletions required to remove both the minimum and maximum elements from the array.

## Example
Input: nums = [2,10,7,5,4,1,8,6]  
Output: 5

---

## Core Insight (Most Important)
Only the **positions** of the minimum and maximum elements matter.

We do NOT need to simulate deletions.
We simply compute how many deletions are required using different strategies and take the minimum.

---

## Key Observation
There are only **three valid ways** to remove both min and max:

1. Remove everything from the front up to the farther index
2. Remove everything from the back up to the nearer index
3. Remove one from the front and one from the back

Trying all three guarantees the optimal answer.

---

## Implemented Approaches Overview

| Approach | Time | Space | Interview View |
|------|------|------|----------------|
| Index-based calculation | O(n) | O(1) | **Preferred** |
| Normalized index variant | O(n) | O(1) | Readability |

No faster or more optimal solution exists.

---

## Approach Explanation (Main Solution)

### Step 1: Find Min and Max Indices
Scan the array once to locate:
- index of minimum element
- index of maximum element

### Step 2: Evaluate All Strategies

Let:
- left = min(minIndex, maxIndex)
- right = max(minIndex, maxIndex)

Then:

Delete from front:
right + 1

Delete from back:
n - left

Delete from both sides:
(left + 1) + (n - right)

### Step 3: Return the Minimum

---

## Example Walkthrough
nums = [2,10,7,5,4,1,8,6]

min = 1 at index 5  
max = 10 at index 1

left = 1, right = 5

Front deletions = 6  
Back deletions = 7  
Both sides = 2 + 3 = 5

Answer = 5

---

## Complexity Analysis
Time Complexity: O(n), single scan  
Space Complexity: O(1), constant extra space

This is optimal.

---

## Edge Cases You Must Know
Array size = 1 → 1 deletion  
Min and max at same index → 1 deletion  
Min/max already at edges  
Min at front and max at back

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognition that brute force simulation is unnecessary
- Index-based reasoning
- Clean handling of three cases
- Linear time solution

### How to Explain in Interview (Verbatim-Ready)
“I find the indices of the minimum and maximum values. Then I compute the number of deletions needed using three strategies: from the front, from the back, and from both sides, and return the minimum.”

---

## Common Pitfalls
Trying to simulate deletions  
Forgetting the mixed front + back case  
Overthinking with data structures  
Incorrect index math

---

## Final Recommendation
This is a clean greedy-index problem. The optimal solution is already O(n) and O(1). Focus on explaining the three deletion strategies clearly—this is what interviewers care about.
