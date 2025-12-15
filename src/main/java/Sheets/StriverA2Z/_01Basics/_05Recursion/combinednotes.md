# Recursion Basics – Interview Notes & Code Reference

This repository contains **8 fundamental recursion problems** commonly asked in  
**GFG / LeetCode / FAANG-style interviews**.

For each problem, this README covers:
- Problem description
- Core recursion idea
- Base case & recursive relation
- Time & space complexity
- Optimization ideas
- Interview explanation tips

---

## 1️⃣ Print `"GFG"` N Times

### 📌 Problem
Print the string `"GFG"` exactly **N times** using recursion.

### 🧠 Core Idea
Reduce the problem size by 1 after each print.

### 🔁 Recurrence
printGfg(N) = "GFG" + printGfg(N-1)

### 🛑 Base Case
if N == 0 → stop
### ⏱ Time Complexity
- **O(N)**

### 🧠 Space Complexity
- **O(N)** (recursion stack)

### 🚀 Optimization
- Convert to an iterative loop → **O(1)** space

### 🎤 Interview Tip
> Linear recursion where work is done before the recursive call.

---

## 2️⃣ Print Numbers from 1 to N

### 📌 Problem
Print numbers from **1 to N** using recursion.

### 🧠 Core Idea
Use a helper function that increments a counter.

### 🔁 Recurrence
print(count) → print(count + 1)
### 🛑 Base Case
if count == N → stop
### ⏱ Time Complexity
- **O(N)**

### 🧠 Space Complexity
- **O(N)**

### 🚀 Optimization
- Tail recursion or loop

### 🎤 Interview Tip
> Printing before recursion produces increasing order.

---

## 3️⃣ Print Numbers from N to 1

### 📌 Problem
Print numbers from **N to 1** using recursion.

### 🧠 Core Idea
Print first, then reduce the problem size.

### 🔁 Recurrence
print(n) → print(n - 1)
### 🛑 Base Case
if n < 1 → stop
### ⏱ Time Complexity
- **O(N)**

### 🧠 Space Complexity
- **O(N)**

### 🚀 Optimization
- Iterative loop removes recursion stack

### 🎤 Interview Tip
> Printing before recursion reverses order.

---

## 4️⃣ Sum of First N Natural Numbers

### 📌 Problem
Return the sum of first **N natural numbers**.

### 🧠 Core Idea
Break the sum into a smaller subproblem.

### 🔁 Recurrence
sum(N) = N + sum(N-1)
### 🛑 Base Case
if N == 1 → return 1
### ⏱ Time Complexity
- **O(N)**

### 🧠 Space Complexity
- **O(N)**

### 🚀 Optimization
- Mathematical formula:
  N * (N + 1) / 2→ **O(1)** time and space

### 🎤 Interview Tip
> Recursion shows concept; formula is optimal.

---

## 5️⃣ Factorial of a Number

### 📌 Problem
Calculate **N!** using recursion.

### 🧠 Core Idea
Multiply N with factorial of (N−1).

### 🔁 Recurrence
fact(N) = N * fact(N-1)
### 🛑 Base Case
if N <= 1 → return 1
### ⏱ Time Complexity
- **O(N)**

### 🧠 Space Complexity
- **O(N)**

### 🚀 Optimization
- Iterative loop avoids stack overflow

### 🎤 Interview Tip
> Classic example of non-tail recursion.

---

## 6️⃣ Reverse an Array

### 📌 Problem
Reverse an array using recursion.

### 🧠 Core Idea
Swap elements from both ends and shrink the range.

### 🔁 Recurrence
swap(start, end) → helper(start+1, end-1)
### 🛑 Base Case
if start > end → stop
### ⏱ Time Complexity
- **O(N)**

### 🧠 Space Complexity
- **O(N)**

### 🚀 Optimization
- Two-pointer iterative solution → **O(1)** space

### 🎤 Interview Tip
> In-place recursion without extra array.

---

## 7️⃣ Check Palindrome String

### 📌 Problem
Check whether a string is a palindrome using recursion.

### 🧠 Core Idea
Compare outer characters and move inward.

### 🔁 Recurrence
check(start, end) → check(start+1, end-1)
### 🛑 Base Case
if start >= end → true
### ⏱ Time Complexity
- **O(N)**

### 🧠 Space Complexity
- **O(N)**

### 🚀 Optimization
- Iterative two-pointer approach → **O(1)** space

### 🎤 Interview Tip
> Early termination when mismatch occurs.

---

## 8️⃣ Fibonacci Numbers

### 📌 Problem
Generate the first **N Fibonacci numbers**.

### 🧠 Core Idea
Each number is the sum of the previous two.

### 🔁 Recurrence
fib(n) = fib(n-1) + fib(n-2)
### 🛑 Base Cases
fib(0) = 0
fib(1) = 1
### ⏱ Time Complexity
- **O(2^N)** ❌ (naive recursion)

### 🧠 Space Complexity
- **O(N)**

### 🚀 Optimization
- Memoization (DP) → **O(N)**
- Iterative solution → **O(1)** space

### 🎤 Interview Tip
> Always explain why naive recursion is exponential.

---

## 🔑 Final Interview Advice

- Always explain the **base case first**
- Mention **stack space** clearly
- Draw a recursion tree if asked
- Provide an optimized version when possible

---

📘 *Use this README as a last-day recursion revision sheet before interviews.*
