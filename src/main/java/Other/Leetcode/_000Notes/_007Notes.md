# Sqrt(x) — LeetCode 69 (FAANG Level)

## Problem Statement
Given a non-negative integer x, compute and return the square root of x. Since the return type is an integer, the decimal digits are truncated and only the integer part of the square root is returned.

## Example
Input: x = 8  
Output: 2  
Explanation: sqrt(8) ≈ 2.828, truncated to 2.

## Constraints
0 <= x <= 2^31 - 1  
Result must fit in 32-bit signed integer.

---

## Implemented Approaches Overview

| Approach | Technique | Time | Space | Interview View |
|--------|----------|------|------|----------------|
| Newton’s Method | Numerical / Math | O(log x) | O(1) | Strong optimization |
| Binary Search | Divide & Conquer | O(log x) | O(1) | Baseline expected |

---

## Approach 1: Newton’s Method (Optimized & Elegant)

### Core Idea
Newton’s Method is an iterative numerical technique to approximate roots. For square root, we continuously improve a guess r using the formula:  
r = (r + x / r) / 2  
We stop when r * r <= x.

This works because the method converges extremely fast; each iteration significantly reduces the error.

### Step-by-Step Example (x = 8)
Initial guess: r = 8  
Iteration 1: r = (8 + 8/8)/2 = 4  
Iteration 2: r = (4 + 8/4)/2 = 3  
Iteration 3: r = (3 + 8/3)/2 = 2  
Stop because 2 * 2 <= 8.

### Why This Works (Interview Explanation)
Newton’s Method uses tangent approximation to converge toward the root. In practice, it converges faster than binary search while still using constant space.

### Complexity
Time Complexity: O(log x)  
Space Complexity: O(1)

### When to Use
- When optimization matters
- When interviewer appreciates mathematical insight
- When you want to stand out after giving binary search

---

## Approach 2: Binary Search (Safe & Expected)

### Core Idea
The square root function is monotonic. We search for the largest integer mid such that:  
mid * mid <= x

Binary search works because once mid^2 exceeds x, all larger values will also exceed x.

### Algorithm Summary
- Search space: 1 to x/2
- Maintain answer for last valid mid
- Use long to avoid overflow

### Complexity
Time Complexity: O(log x)  
Space Complexity: O(1)

### When to Use
- First solution in interviews
- When mathematical methods are not expected
- When clarity and safety are preferred

---

## Edge Cases You MUST Handle
x = 0 → return 0  
x = 1 → return 1  
Large values like x = 2^31 - 1  
Overflow when computing mid * mid (must cast to long)  
Non-perfect squares (truncate result)

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognition that sqrt(x) is a monotonic function
- Binary search as baseline solution
- Awareness of overflow issues
- Correct truncation behavior
- Clean O(log x) time, O(1) space

### Bonus Points
- Explaining Newton’s Method clearly
- Comparing binary search vs Newton
- Explaining convergence intuitively

### How to Explain in Interview (Verbatim-Ready)
“I can compute the integer square root using binary search in O(log x) time since the square function is monotonic. Alternatively, Newton’s Method converges faster by iteratively refining the guess using a mathematical formula while still using constant space.”

---

## Common Interview Follow-Ups
- Why not use Math.sqrt()? → Not allowed, precision + control required
- Why use long? → Prevent overflow when squaring
- Which is faster in practice? → Newton’s Method
- Which is safer to explain? → Binary Search

---

## Common Pitfalls
Using mid * mid without long casting  
Using floating-point arithmetic unnecessarily  
Infinite loops due to incorrect termination  
Returning rounded value instead of truncated value

---

## Final Recommendation
In interviews, start with Binary Search to show correctness and clarity. Then mention Newton’s Method as an optimization to demonstrate deeper mathematical understanding. Knowing both reflects strong algorithmic maturity.
