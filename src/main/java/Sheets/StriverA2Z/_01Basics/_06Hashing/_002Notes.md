# LeetCode 3005 — Count Elements With Maximum Frequency (FAANG-Ready)

## Problem Statement
Given an integer array `nums`, return the **total number of elements** whose frequency equals the **maximum frequency** in the array.

Example:
- nums = [1, 2, 2, 3, 1, 4]
- Frequencies = {1:2, 2:2, 3:1, 4:1}
- Maximum frequency = 2
- Elements with max frequency = {1, 2}
- Answer = 2 + 2 = 4
---

## Constraints (From Problem)
- 1 <= nums.length <= 100
- 1 <= nums[i] <= 100

These constraints are **very important** and directly influence the solution design.

---

# 🚀 Approaches Implemented

This solution intentionally includes **only two array-based approaches**, because they are the **best possible choices under the given constraints**.

---

## ⭐ Method 1: `method1_singlePass` — One-Pass Frequency Evaluation

### 🔹 Idea
- Use a frequency array of fixed size (100)
- Track:
    - maximum frequency found so far
    - total elements contributing to that frequency
- Update both in a single loop over the frequency array

### 🔹 Steps
1. Build frequency array
2. Traverse frequency array:
    - If current frequency equals max → add to result
    - If current frequency is greater → update max and reset result

### 🔹 Complexity
- **Time:** O(n)
- **Space:** O(1)

### 🔹 Pros
- Single pass over frequency array
- Efficient and compact

### 🔹 Cons
- Slightly tricky to explain in interviews
- Requires careful reasoning to avoid mistakes

### 🔹 Interview Cross-Questions
**Q: Can this be simplified?**  
Yes — the two-pass approach is easier to reason about.

---

## ⭐ Method 2: `method2_twoPass` (DEMO METHOD) — Clear & Interview-Preferred

### 🔹 Idea
Split the logic into **two clean phases**:
1. Find the maximum frequency
2. Count how many elements have that frequency

### 🔹 Steps
1. Build frequency array
2. Find `maxFreq`
3. Count how many numbers have `maxFreq`
4. Return `count * maxFreq`

### 🔹 Complexity
- **Time:** O(n)
- **Space:** O(1)

### 🔹 Why This Is the Best Interview Answer
- Very easy to explain
- No tricky logic
- Same performance as one-pass approach
- Preferred by FAANG interviewers for clarity

### 🔹 Interview Cross-Questions
**Q: Why multiply `count * maxFreq`?**  
Because each qualifying number appears `maxFreq` times.

---

# 🧠 Constraints-Based Reasoning (VERY IMPORTANT)

This section explains **why the solution uses an array instead of a HashMap**.

### 🔹 Given Constraints
- 1 <= nums[i] <= 100

This means:
- The value range is **small**
- The range is **fixed and known**
- We can safely map values directly to indices

### 🔹 Why Array Is Better Than HashMap Here

| Reason | Array | HashMap |
|------|------|--------|
| Access Time | O(1) | O(1) average |
| Memory | Lower | Higher (buckets, objects) |
| Autoboxing | ❌ No | ✅ Yes (int → Integer) |
| Simplicity | High | Medium |
| Overhead | Minimal | Higher |

### 🔹 Interview-Quality Explanation (Say This)

> “Because the constraints guarantee values are between 1 and 100,  
> I used a fixed-size frequency array instead of a HashMap.  
> This reduces memory overhead, avoids hashing, and keeps space constant.”

This sentence alone signals **strong problem understanding**.

---

## 🔄 What If Constraints Change?

### If constraints become:
- -10^9 <= nums[i] <= 10^9
- nums.length <= 10^5
  Then:
- Array is no longer feasible
- **HashMap becomes the correct choice**

### Interview Follow-Up Answer:
> “If the value range were large or unknown, I would switch to a HashMap to handle sparse values safely.”

---

# 📘 Complexity Summary

| Method | Time | Space | Notes |
|------|------|-------|------|
| method1_singlePass | O(n) | O(1) | Efficient but slightly tricky |
| method2_twoPass (DEMO) | O(n) | O(1) | Best balance of clarity & performance |

---

# ⚠️ Edge Cases

| Case | Output |
|----|----|
| All elements unique | n |
| All elements same | n |
| Single element | 1 |
| nums length = 1 | 1 |

---

# 🎯 What Interviewers Are Really Testing

They want to see if you can:

✔ Read and use constraints correctly  
✔ Choose the **right data structure**, not the default one  
✔ Explain trade-offs clearly  
✔ Write clean, maintainable code  
✔ Adapt solution when constraints change

Most candidates say:
> “I used HashMap for frequency.”

Strong candidates say:
> “Given the constraints, an array is optimal.”

---

# 🏁 Final Notes

- `method2_twoPass` is the **recommended interview solution**
- Always mention **why array was chosen**
- Always state what you would do if constraints change

This README now reflects **FAANG-level thinking**, not just correct code.
