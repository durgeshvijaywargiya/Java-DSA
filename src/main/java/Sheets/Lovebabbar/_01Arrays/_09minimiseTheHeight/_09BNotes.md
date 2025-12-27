# Minimize the Heights II — GFG (FAANG Level)

## Problem Statement
You are given an array arr[] representing heights of n towers and a positive integer k. For each tower, you must modify its height exactly once by either increasing or decreasing it by k. After modification, no tower height can be negative.

Return the minimum possible difference between the tallest and shortest towers after modification.

## Example
Input: arr = [3, 9, 12, 16, 20], k = 3  
Output: 11  
Explanation: Modified heights can be [6, 12, 9, 13, 17]. Difference = 17 − 6 = 11.

## Constraints
1 <= n <= 10^5  
0 <= arr[i] <= 10^9  
k >= 0  
Heights after modification must be non-negative

---

## Core Insight (Most Important)
This problem is a greedy optimization problem based on **partitioning a sorted array**.

Key idea:
After sorting, treat the array as two parts:
- Left part → increase heights by k
- Right part → decrease heights by k

Try every possible partition and compute the resulting minimum and maximum heights.

This avoids brute-force combinations, which would be exponential.

---

## Difference from “Minimize the Heights I”
| Feature | Heights I | Heights II |
|------|----------|-----------|
| Negative heights allowed | Yes | ❌ No |
| Extra check needed | No | Yes (`minHeight < 0`) |
| Core logic | Same | Same |

The only additional constraint is that resulting heights must not be negative.

---

## Algorithm Explanation

### Step 1: Sort the Array
Sorting helps us:
- Identify smallest and largest towers
- Control how adding or subtracting k affects extremes

### Step 2: Initialize Answer
Initial difference = arr[n − 1] − arr[0] (no modification).

### Step 3: Try All Valid Partitions
For each index i from 0 to n − 2:
- Increase towers from index 0 to i by k
- Decrease towers from index i+1 to n−1 by k

Compute:
minHeight = min(arr[0] + k, arr[i + 1] − k)  
maxHeight = max(arr[n − 1] − k, arr[i] + k)

If minHeight < 0, skip this partition.

Update the minimum difference.

---

## Example Walkthrough
arr = [3, 9, 12, 16, 20], k = 3  
Sorted: [3, 9, 12, 16, 20]

Initial difference = 17

i = 0:
min = min(3+3, 9−3) = 6  
max = max(20−3, 3+3) = 17  
diff = 11

i = 1:
min = min(3+3, 12−3) = 6  
max = max(20−3, 9+3) = 17  
diff = 11

i = 2:
min = min(3+3, 16−3) = 6  
max = max(20−3, 12+3) = 17  
diff = 11

Answer = 11

---

## Complexity Analysis
Time Complexity: O(n log n), due to sorting  
Space Complexity: O(1), ignoring sorting overhead

---

## Edge Cases You Must Know
Single tower → difference = 0  
k = 0 → no change  
Skipping partitions where arr[i+1] − k < 0  
Array already sorted or reverse sorted  
Large values of k

---

## FAANG Interview Expectations

### What Interviewers Expect
- Greedy thinking with sorting
- Avoidance of brute force (2^n)
- Correct handling of non-negative constraint
- Clear min/max computation

### How to Explain in Interview (Verbatim-Ready)
“After sorting, I try every partition. Towers on the left are increased by k and towers on the right are decreased by k. I compute the new minimum and maximum heights and track the minimum difference, skipping cases where heights become negative.”

---

## Common Follow-Up Questions
What if negative heights were allowed? → Same logic without skipping  
Why sorting is required? → To control extremes efficiently  
Can this be done in O(n)? → No, sorting is necessary

---

## Common Pitfalls
Forgetting to sort  
Not checking for negative heights  
Incorrect min/max logic  
Trying all combinations

---

## Final Recommendation
This is a classic greedy + sorting problem. The logic is identical to Minimize the Heights I, with the added constraint of non-negative heights. Understanding why partitioning works is the key to mastering this problem.
