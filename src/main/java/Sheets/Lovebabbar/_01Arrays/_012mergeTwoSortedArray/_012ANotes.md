# Merge Two Sorted Arrays Without Extra Space (FAANG Level)

## Problem Statement
You are given two sorted arrays a[] and b[] of size n and m respectively. Merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

## Example
Input:  
a = [1, 4, 7, 8, 10]  
b = [2, 3, 9]

Output:  
a = [1, 2, 3, 4, 7]  
b = [8, 9, 10]

---

## Core Insight (Most Important)
Since extra space is not allowed, we must rearrange elements across both arrays in place. The challenge is to maintain sorted order without merging into a new array.

---

## Implemented Approaches Overview

| Approach | Time | Space | Interview View |
|-------|------|------|----------------|
| Swap + Sort | O((n+m) log(n+m)) | O(1) | Acceptable |
| Gap Method | O((n+m) log(n+m)) | O(1) | **Preferred** |

---

## Approach 1: Swap Largest of a[] with Smallest of b[] (Your Solution)

### Core Idea
- Compare the largest element of a[] with the smallest of b[]
- If out of order, swap them
- After swaps, sort both arrays

### Why This Works
After swapping extremes, all smaller elements move toward a[] and larger ones toward b[]. Sorting restores order.

### Drawback
Sorting both arrays makes this solution slower in practice.

### Complexity
Time Complexity: O((n + m) log(n + m))  
Space Complexity: O(1)

---

## Approach 2: Gap Method (FAANG Preferred)

### Core Idea
Inspired by Shell Sort. Treat both arrays as a single combined array and compare elements at a certain gap.

Steps:
1. Initialize gap = ceil((n + m) / 2)
2. Compare elements at distance = gap
3. Swap if out of order
4. Reduce gap until it becomes 0

This gradually sorts the combined structure in place.

---

## Example Walkthrough (Gap Method)
a = [1, 4, 7, 8, 10], b = [2, 3, 9]

Total length = 8  
Initial gap = 4

Compare and swap elements at distance 4  
Reduce gap → 2 → 1 → 0  
Arrays become fully sorted without extra space.

---

## Complexity Analysis
Time Complexity: O((n + m) log(n + m))  
Space Complexity: O(1)

Although time complexity looks similar to sorting, the gap method avoids full re-sorting and performs fewer comparisons.

---

## Edge Cases You Must Know
One array empty  
All elements of a[] smaller than b[]  
All elements of b[] smaller than a[]  
Duplicate elements  
Already merged arrays

---

## FAANG Interview Expectations

### What Interviewers Expect
- Awareness that simple merge using extra space is not allowed
- In-place strategy
- Knowledge of Gap Method
- Clean handling of indices across arrays

### How to Explain in Interview (Verbatim-Ready)
“I treat both arrays as a single virtual array and use a shrinking gap technique similar to Shell Sort. This allows me to compare and swap elements across arrays in place without extra space.”

---

## Common Follow-Up Questions
Why not use insertion sort? → Too slow  
Can we do this in O(n + m)? → Not without extra space  
Is gap method stable? → No, but stability is not required

---

## Common Pitfalls
Using extra array  
Incorrect index mapping between a[] and b[]  
Forgetting to reduce gap correctly  
Sorting the full combined array explicitly

---

## Final Recommendation
In interviews, always present the Gap Method as the final solution. The swap-and-sort approach is acceptable but not optimal. Understanding how to treat two arrays as a single structure is the key insight that interviewers look for.
