# Fibonacci – All Approaches (FAANG Level)

## Problem Statement
Given an integer `n`, return the `n`th Fibonacci number.

The Fibonacci sequence is defined as:
F(0) = 0  
F(1) = 1  
F(n) = F(n − 1) + F(n − 2) for n ≥ 2

---

## Implemented Approaches Overview

| Method | Technique | Time | Space | Interview View |
|------|----------|------|------|----------------|
| Iterative | Loop + variables | O(n) | O(1) | **Preferred** |
| Recursive | Plain recursion | O(2ⁿ) | O(n) | Baseline only |
| Memoization | Top-down DP | O(n) | O(n) | Acceptable |
| Tabulation | Bottom-up DP | O(n) | O(n) | Acceptable |

---

## Approach 1: Iterative (BEST / DEMO METHOD)

### Core Idea
Instead of recursion or arrays, maintain only the last two Fibonacci values and build the result iteratively.

### Why This Works
Each Fibonacci number depends only on the previous two values. There is no need to store the entire sequence.

### Algorithm
- Initialize two variables `a = 0` and `b = 1`
- Loop from 2 to n
- Compute `c = a + b`
- Shift values (`a = b`, `b = c`)
- Return `b`

### Complexity
Time Complexity: O(n)  
Space Complexity: O(1)

### Interview Status
This is the **most optimal and interview-preferred solution**.

---

## Approach 2: Recursive (Baseline)

### Core Idea
Directly follow the mathematical definition of Fibonacci using recursion.

### Why It Is Inefficient
The same subproblems are recomputed multiple times, leading to exponential time complexity.

### Complexity
Time Complexity: O(2ⁿ)  
Space Complexity: O(n) (recursion stack)

### Interview Note
Useful only to demonstrate understanding of recursion.  
**Never use this in production or final interview answers.**

---

## Approach 3: Memoization (Top-Down Dynamic Programming)

### Core Idea
Store already computed Fibonacci values in an array to avoid recomputation.

### Why This Works
Each Fibonacci value is computed only once and reused when needed.

### Complexity
Time Complexity: O(n)  
Space Complexity: O(n)

### Interview Note
Good stepping stone to explain optimization from recursion to DP.

---

## Approach 4: Tabulation (Bottom-Up Dynamic Programming)

### Core Idea
Build the Fibonacci sequence from the base cases up to `n` using an array.

### Why This Works
Each value is computed once in order, avoiding recursion overhead.

### Complexity
Time Complexity: O(n)  
Space Complexity: O(n)

### Interview Note
Accepted solution, but not space-optimal.

---

## Edge Cases
n = 0 → 0  
n = 1 → 1  
Large n → risk of integer overflow (use `long` if required)

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognition that recursion is inefficient
- Optimization using DP
- Final space-optimized iterative solution
- Clear explanation of time and space trade-offs

### How to Explain in Interview (Verbatim-Ready)
“I start with the recursive definition, optimize it using memoization, then tabulation, and finally reduce space to O(1) by keeping only the last two values.”

---

## Common Follow-Up Questions
Can you optimize space further? → Yes, iterative approach  
What if n is very large? → Use `long` or modulo  
What if recursion depth is limited? → Avoid recursion

---

## Common Pitfalls
Using plain recursion  
Ignoring time complexity  
Using DP array when not required  
Integer overflow for large n

---

## Final Recommendation
Always present the **iterative solution** as the final answer.  
Use recursion and DP only to show optimization progression if asked.

This problem is often used by interviewers to evaluate **optimization thinking**, not just correctness.
