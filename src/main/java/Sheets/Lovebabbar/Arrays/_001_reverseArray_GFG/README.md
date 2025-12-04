# Reverse Array — Complete Notes (FAANG Level)

## 📌 Problem Statement
You are given an array of integers `arr[]`.  
Your task is to **reverse the array**.  
The reversal can be done **in-place** (modifying the same array) or by **creating a new reversed array**, depending on requirements.

**Example:**  
Input: `[1, 2, 3, 4]`  
Output: `[4, 3, 2, 1]`

---

## 🚀 Approaches

### 1️⃣ Approach 1 — In-place Reverse Using For Loop (Symmetric Swap)
- Swap element at index `i` with element at index `n - 1 - i`.
- Work only until the midpoint.
- Same logic as initial solution, but structured and optimized.

**Time Complexity:** O(n)  
**Space Complexity:** O(1) (in-place)

**When to use:**  
Use when in-place modification is required and you prefer the classic for-loop structure.

---

### 2️⃣ Approach 2 — In-place Reverse Using Two Pointers (Recommended / Idiomatic)
- Use two pointers:  
  `i = 0`, `j = n - 1`
- Swap `arr[i]` and `arr[j]`, then move both pointers inward.
- Most readable and widely used in FAANG interviews.

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Why it’s preferred:**
- Intent is clear ("reverse using two pointers")
- Fewer operations
- Clean stopping condition (`i < j`)
- Very interviewer-friendly

---

### 3️⃣ Approach 3 — Return a New Reversed Array (Non-Mutating)
- Allocate a new array of size `n`
- Fill it from the end of the original array
- Original array remains unchanged

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**When to use:**  
When immutability is required (e.g., functional style, thread safety, no modification allowed).

---

## ⚙️ Code Summary (Methods)

### `reverseArray1` → For-loop in-place
### `reverseArray2` → Two-pointer in-place (BEST / IDIOMATIC)
### `reverseArray3` → Returns a new reversed array (non-mutating)

These 3 methods are implemented together in the Java class.

---

## 🧪 Edge Cases to Cover
| Case | Expected Behavior |
|------|-------------------|
| `arr == null` | Do nothing (or return null in copy version) |
| Empty array `[]` | Output `[]` |
| Single element `[5]` | Output `[5]` |
| Even length `[1,2,3,4]` | `[4,3,2,1]` |
| Odd length `[1,2,3]` | `[3,2,1]` |
| Duplicate elements | No problem |
| Negative values | No problem |

---

## 📘 Time & Space Complexity Summary

| Approach | Time | Space | Type |
|---------|------|--------|------|
| reverseArray1 | O(n) | O(1) | In-place |
| reverseArray2 | O(n) | O(1) | In-place (BEST) |
| reverseArray3 | O(n) | O(n) | Returns new array |

All approaches have **O(n)** time — this is optimal.  
Reversing requires touching each element at least once.

---

## 🎯 FAANG Interview Expectations
Interviewers evaluate you on:

### ✔ Correct & clean solution
Use a straightforward, readable approach (two-pointer is best).

### ✔ Edge-case handling
Mention `null`, empty, single-element arrays.

### ✔ Complexity explanation
Easy:
- Time → O(n)
- Space → O(1) or O(n) depending on approach

Explain *why* O(n) is the best possible.

### ✔ Code readability
- Clear variable names (`i`, `j` are okay here)
- Minimal repeated work (cache length once)
- Proper comments if needed

### ✔ Trade-off awareness
Be prepared to explain:
- In-place vs. immutability
- Why two-pointer is clearer and slightly cleaner than a symmetric for-loop

---

## 📝 Final Thoughts
Reversing an array is a fundamental problem but is also a gateway to:
- Two-pointer technique
- Array manipulation
- In-place operations
- Thinking about mutability vs. immutability

This is exactly how FAANG expects you to explain and reason during an interview.

---

## ✔ Included in the Project
- `reverseArray1()` — In-place using for-loop
- `reverseArray2()` — In-place using two-pointers
- `reverseArray3()` — Returning new reversed array
- `main()` — Demonstration using `reverseArray2`

You can manually test the other two.

