# Prime Number Checking — FAANG-Level Approaches (Java)

This repository implements four different approaches to check if a number `n` is prime.  
Each approach provides a deeper level of optimization and mathematical insight.

The main class used:
`_07checkprimenumber.java`

---

# 🚀 Methods Included

## **1️⃣ method1_original — Basic Trial Division**
### ✔ Idea
Check divisibility from `2` to `sqrt(n)`.  
If any divisor is found → not prime.

### ✔ Why it's important
This is the **first approach** you must explain in interviews because it shows basic understanding.

### ✔ Complexity
- **Time:** O(sqrt(n))
- **Space:** O(1)

### ✔ Interview Cross-Questions
1. *Why only up to sqrt(n)?*
   > Because if `n = a * b`, one of the factors must be ≤ `sqrt(n)`.

2. *Can we do better than O(sqrt(n))?*
   > Yes — next methods (skip evens, 6k±1, Miller–Rabin).


---

## **2️⃣ method2_microOptimized — Improved Trial Division**
### ✔ Additional Optimizations
- Handle 2 separately
- Reject all even numbers
- Check only odd integers from 3 to sqrt(n)

### ✔ Why it matters
Shows you know real-world improvements without changing complexity.

### ✔ Complexity
- **Time:** O(sqrt(n) / 2)
- **Space:** O(1)

### ✔ Interview Cross-Questions
1. *Why skip even numbers?*
   > No even number except 2 can be prime.

2. *Why check only odd divisors?*
   > n % even = 0 only if n is even (already handled).


---

## **3️⃣ method3_isPrime6k — 6k ± 1 Optimization (Demo Method)**
### ✔ Idea
- All primes > 3 satisfy:  
- Prime = 6k - 1 OR 6k + 1

### ✔ Why this works
Every integer can be written as:  
`6k, 6k±1, 6k±2, 6k±3`
- 6k   → divisible by 6
- 6k±2 → even
- 6k±3 → divisible by 3  
  Only 6k±1 can be prime.

### ✔ Complexity
- **Time:** O(sqrt(n) / 3)
- **Space:** O(1)

### ✔ Interview Cross-Questions
1. *Why do primes follow the 6k±1 pattern?*
   > Because composites in other forms are divisible by 2 or 3.

2. *Does 6k±1 guarantee primality?*
   > No — it's a **necessary but not sufficient** condition.

3. *Is this the fastest deterministic method?*
   > No — Miller–Rabin is faster for large numbers.


---

## **4️⃣ method4_MillerRabin — Deterministic Miller–Rabin (FAANG Standard)**
### ✔ Idea
Probabilistic primality test made **deterministic** for 32-bit integers using bases `{2, 7, 61}`.

### ✔ Why FAANG uses it
- Extremely fast for large numbers
- Primality test in **O(log n)**
- Works in cryptography & competitive programming

### ✔ Complexity
- **Time:** O(log n)
- **Space:** O(1)

### ✔ Required Concepts
- Modular exponentiation
- `n - 1 = d * 2^s` decomposition
- "Strong probable prime" test

### ✔ Interview Cross-Questions
1. *Why are bases {2, 7, 61} enough?*
   > They guarantee correctness for all 32-bit integers.

2. *What makes Miller–Rabin faster than trial division?*
   > It reduces exponentiation using modular arithmetic and binary exponentiation.

3. *Is Miller–Rabin always deterministic?*
   > For int range: yes  
   > For general big integers: no — but probability of error is negligible.

---

# 📘 Summary Table

| Method | Description | Time Complexity | Space | Use Case |
|--------|-------------|-----------------|--------|----------|
| method1_original | Basic sqrt trial division | O(sqrt(n)) | O(1) | Simple, beginner-friendly |
| method2_microOptimized | Skip evens, check odds | O(sqrt(n)/2) | O(1) | Efficient small-to-medium n |
| method3_isPrime6k | Use 6k±1 pattern | O(sqrt(n)/3) | O(1) | Best simple deterministic |
| method4_MillerRabin | Deterministic fast primality test | O(log n) | O(1) | FAANG-level, large n |

---

# ⚠️ Edge Cases

| Input | Output |
|--------|---------|
| n <= 1 | false |
| n = 2, 3 | true |
| even number > 2 | false |
| large prime like 2,147,483,647 | true (Miller–Rabin handles it fast) |

---

# 🎯 What FAANG Interviewers Check

### ✔ You understand ALL approaches
Not just trial division — they want to see growth & deeper insight.

### ✔ Can justify skipping half of numbers
Shows algorithmic thinking.

### ✔ Understand modular exponentiation
Crucial for advanced primality tests.

### ✔ Clear Big-O explanations
Don’t speak formulas — explain in terms of operations saved.

### ✔ Know when to choose each method
- Trial division → small numbers
- 6k±1 → medium numbers
- Miller–Rabin → large numbers

---

# 🎤 Common Interview Cross-Questions (Prepare These)

### **Q1. Why check only up to sqrt(n)?**
> Because if `n = a * b`, at least one of the factors is ≤ sqrt(n).

---

### **Q2. Why use 6k±1?**
> Because all primes > 3 must be of form 6k−1 or 6k+1.

---

### **Q3. Does 6k±1 guarantee a prime?**
> No — numbers like 25 = 6*4 + 1 still pass but are composite.

---

### **Q4. How does Miller–Rabin prove primality?**
> It checks if `a^d mod n` behaves as expected for primes.

---

### **Q5. When is Miller–Rabin deterministic?**
> For 32-bit integers using fixed bases {2,7,61}.

---

### **Q6. Why is modular exponentiation needed?**
> To avoid overflow and compute large powers efficiently.

---

### **Q7. What if n is extremely large (like 10^18)?**
> Use Miller–Rabin with a slightly larger base set.

---

# 🏁 Final Notes

- You should always start explaining with the **simplest method** (trial division).
- Then move to **optimized**, then **6k±1**, and finally **Miller–Rabin**.
- Interviewers love when you compare algorithms and show when each is useful.
- Knowing Miller–Rabin guarantees strong impression in FAANG coding rounds.

---

