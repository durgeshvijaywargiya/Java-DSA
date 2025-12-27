# Minimize the Heights I — GFG (FAANG Level)

## Problem Statement
You are given an array arr[] representing heights of towers and a positive integer k. You must modify each tower height exactly once by either increasing or decreasing it by k. The modified height may be negative.

Return the minimum possible difference between the height of the tallest and shortest towers after modification.

## Example
Input: arr = [1, 5, 8, 10], k = 2  
Output: 5  
Explanation: Modified heights can be [3, 3, 6, 8]. Difference = 8 − 3 = 5.

## Constraints
1 <= arr.length <= 10^5  
0 <= arr[i] <= 10^9  
k >= 0

---

## Core Insight (Most Important)
Instead of trying all 2^n combinations, we use a greedy strategy based on sorting and partitioning.

Key idea:  
After sorting, treat the array as two parts:
- Left part → increase heights by k
- Right part → decrease heights by k

We try every possible partition and compute the resulting minimum and maximum heights.

---

## Why Sorting Is Required
Sorting allows us to:
- Easily identify the smallest and largest elements
- Control how increasing or decreasing affects the extremes
- Avoid brute-force combinations

Once sorted, only adjacent partition points matter.

---

## Algorithm Explanation

### Step 1: Sort the Array
This helps us compare heights in increasing order.

### Step 2: Initialize Answer
Initial difference = arr[n − 1] − arr[0] (no modification).

### Step 3: Try All Partitions
For each index i from 0 to n − 2:
- Assume towers from index 0 to i are increased by k
- Assume towers from index i+1 to n−1 are decreased by k

Compute:
- minHeight = min(arr[0] + k, arr[i + 1] − k)
- maxHeight = max(arr[n − 1] − k, arr[i] + k)

Update the minimum difference.

---

## Example Walkthrough
arr = [1, 5, 8, 10], k = 2  
Sorted: [1, 5, 8, 10]

Initial difference = 9

i = 0:
min = min(1+2, 5−2) = 3  
max = max(10−2, 1+2) = 8  
diff = 5

i = 1:
min = min(1+2, 8−2) = 3  
max = max(10−2, 5+2) = 8  
diff = 5

i = 2:
min = min(1+2, 10−2) = 3  
max = max(10−2, 8+2) = 10  
diff = 7

Answer = 5

---

## Complexity Analysis
Time Complexity: O(n log n), due to sorting  
Space Complexity: O(1), ignoring sorting overhead

---

## Edge Cases You Must Know
Single tower → difference = 0  
k = 0 → no change, return original difference  
Negative heights allowed (no need to skip arr[i+1] − k < 0)  
Already sorted or reverse sorted arrays

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognition that brute force is impossible
- Greedy thinking using sorting
- Correct handling of minimum and maximum values
- O(n log n) time solution

### How to Explain in Interview (Verbatim-Ready)
“After sorting, I try all possible partitions. For each partition, towers on the left are increased by k and towers on the right are decreased by k. I compute the new minimum and maximum heights and update the minimum difference.”

---

## Common Follow-Up Questions
What if negative heights are not allowed? → Skip cases where arr[i+1] − k < 0  
What if each tower can be modified multiple times? → Different problem  
Why not dynamic programming? → Greedy is optimal here

---

## Common Pitfalls
Forgetting to sort the array  
Considering all combinations (2^n)  
Incorrect min/max calculations  
Not handling n = 1 case

---

## Final Recommendation
This is a classic greedy + sorting problem. Understanding why partitioning works is more important than memorizing the formula. Once the idea clicks, the implementation is straightforward and optimal.
