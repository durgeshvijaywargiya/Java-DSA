# Kth Largest Element in an Array — LeetCode 215 (FAANG Level)

## Problem Statement
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in sorted order, not the kth distinct element.

## Example
Input: nums = [3,2,1,5,6,4], k = 2  
Output: 5

---

## Core Insight
You do NOT need to sort the entire array.

Only k elements matter.

---

## Implemented Approaches Overview

| Approach | Time | Space | Interview View |
|-------|------|------|----------------|
| Min-Heap (size k) | O(n log k) | O(k) | Very Good |
| Max-Heap (size n) | O(n log n) | O(n) | Baseline |
| Quickselect | O(n) avg | O(1) | **Preferred** |

---

## Approach 1: Min-Heap of Size K (Better Heap)

### Idea
Keep only the k largest elements seen so far.

If heap size exceeds k, remove the smallest.

### Why Better Than Max-Heap
- Heap size is small
- Less memory
- Faster when k is small

---

## Approach 2: Max-Heap of Size N

### Idea
Insert all elements and pop k−1 times.

### Why It’s Worse
- Stores unnecessary elements
- Higher time and space
- Rarely preferred in interviews

---

## Approach 3: Quickselect (FAANG Preferred)

### Core Idea
Based on QuickSort partitioning.

At each step:
- Partition array around a pivot
- Decide which side to recurse on

Only one side is explored.

### Why It’s Optimal
- Average O(n)
- In-place
- No extra memory

---

## Complexity Analysis
Min-Heap: O(n log k)  
Max-Heap: O(n log n)  
Quickselect: O(n) average

---

## Edge Cases
k = 1 → maximum element  
k = n → minimum element  
Duplicates allowed  
Negative numbers

---

## FAANG Interview Expectations

### What Interviewers Expect
- Heap-based solution first
- Understanding of why min-heap is better
- Quickselect as optimization
- Correct complexity discussion

### How to Explain in Interview
“I first use a min-heap of size k to keep track of the k largest elements. To optimize further, I can use Quickselect, which finds the kth largest in average linear time.”

---

## Common Pitfalls
Using full sort O(n log n) unnecessarily  
Using max-heap without reason  
Confusing kth largest with kth distinct

---

## Final Recommendation
- Use **min-heap** if Quickselect is risky
- Use **Quickselect** for best performance
- Avoid full sorting unless asked

This problem tests algorithm selection, not just correctness.
