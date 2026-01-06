# Maximum Subarray — LeetCode 53 (FAANG Level)

## Problem Statement
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

## Example
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]  
Output: 6  
Explanation: The subarray [4, -1, 2, 1] has the largest sum = 6.

## Constraints
1 <= nums.length <= 10^5  
-10^4 <= nums[i] <= 10^4

---

## Core Insight (Most Important)
If a subarray has a negative sum, extending it will only decrease the sum of any future subarray. Therefore, whenever the running sum becomes negative, it is optimal to discard it and start fresh.

This greedy observation is the foundation of Kadane’s Algorithm.

---

## Implemented Approaches Overview

| Method | Idea | Time | Space | Interview Use |
|------|----|------|------|--------------|
| Kadane (Optimized) | Greedy running sum | O(n) | O(1) | **Preferred** |
| Kadane (Original) | Reset on negative | O(n) | O(1) | Intuitive |
| Prefix Sum | Min prefix subtraction | O(n) | O(1) | Conceptual |
| Divide & Conquer | Recursive split | O(n log n) | O(log n) | Theory only |

---

## Approach 1: Kadane’s Algorithm (Optimized – Recommended)

### Core Idea
At every index, decide whether to:
- Extend the previous subarray, or
- Start a new subarray from the current element

This decision is made using:
currentSum = max(nums[i], currentSum + nums[i])

### Algorithm Explanation
- Initialize currentSum and maxSum to nums[0]
- Iterate from index 1 onward
- At each step:
    - Either start fresh from nums[i]
    - Or extend the previous subarray
- Update the global maximum

### Why This Works
- A negative running sum is never helpful
- Greedy local decisions lead to a global optimum
- Handles all-negative arrays naturally

### Complexity
Time Complexity: O(n)  
Space Complexity: O(1)

### When to Use
- Default interview solution
- Cleanest and most expressive form of Kadane’s Algorithm

---

## Approach 2: Kadane’s Algorithm (Original Form)

### Core Idea
Maintain:
- localMax → sum of current subarray
- globalMax → best sum seen so far

Whenever localMax becomes negative, reset it to 0.

### Why It Works
- Same greedy idea as optimized Kadane
- Slightly more intuitive for beginners
- Requires careful handling of all-negative arrays

### Complexity
Time Complexity: O(n)  
Space Complexity: O(1)

---

## Approach 3: Prefix Sum Interpretation

### Core Idea
Maximum subarray sum can be written as:
prefixSum[j] − minimumPrefixBefore(j)

Algorithm:
- Track running prefix sum
- Track minimum prefix seen so far
- Maximize their difference

### Why This Is Useful
- Shows Kadane is derived from prefix sums
- Good for explaining mathematical reasoning
- Same performance as Kadane

### Complexity
Time Complexity: O(n)  
Space Complexity: O(1)

---

## Approach 4: Divide & Conquer (Classic but Inferior)

### Core Idea
Split array into two halves:
- Max subarray in left half
- Max subarray in right half
- Max subarray crossing the midpoint

Return the maximum of the three.

### Why It’s Inferior
- Higher time complexity
- More complex
- Rarely used in real systems

### Complexity
Time Complexity: O(n log n)  
Space Complexity: O(log n) due to recursion

### Interview Note
Mention only if explicitly asked about alternative approaches.

---

## Step-by-Step Walkthrough (Kadane)
For nums = [-2,1,-3,4,-1,2,1,-5,4]:

Start: currentSum = -2, maxSum = -2  
Process 1 → currentSum = 1, maxSum = 1  
Process -3 → currentSum = -2, maxSum = 1  
Process 4 → currentSum = 4, maxSum = 4  
Process -1 → currentSum = 3, maxSum = 4  
Process 2 → currentSum = 5, maxSum = 5  
Process 1 → currentSum = 6, maxSum = 6

Final Answer = 6

---

## Edge Cases You Must Know
All numbers negative → return the largest (least negative) number  
Single element array → return that element  
All positive numbers → sum of entire array  
Large input size → linear solution required

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognition of Kadane’s Algorithm
- O(n) time and O(1) space solution
- Clear explanation of why negative sums are discarded
- Correct handling of all-negative arrays

### How to Explain in Interview (Verbatim-Ready)
“I maintain a running sum of the current subarray. If extending the subarray is worse than starting fresh, I reset it. This greedy choice is optimal because a negative sum can never help future subarrays.”

### Why Greedy Works
Discarding a negative prefix is locally optimal and guarantees a globally optimal maximum sum.

---

## Common Follow-Up Questions
Can you return the actual subarray? → Track start and end indices  
What if empty subarray is allowed? → Slight modification  
What about maximum product subarray? → Track min and max  
What about circular array? → Kadane twice

---

## Common Pitfalls
Resetting before updating global maximum  
Returning 0 for all-negative arrays  
Using nested loops (O(n²))  
Overengineering with DP

---

## Final Recommendation
Kadane’s Algorithm is the definitive solution to this problem. There is no more optimal algorithm in terms of time or space. Understanding why it works is more important than memorizing the code, and mastering it unlocks many advanced array and DP problems.
