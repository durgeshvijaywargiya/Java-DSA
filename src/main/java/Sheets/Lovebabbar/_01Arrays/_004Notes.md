# Sort 0s, 1s, and 2s — (Dutch National Flag + All Approaches)

## Problem Statement
Given an array containing only **0s, 1s, and 2s**, sort the array **in-place** in linear time **without using any extra sorting library**.

---

# Implemented Approaches

This Java class implements **4 different approaches** to solve the Sort 0-1-2 (GFG/LeetCode 75) problem.

| Method | Name | Description | Time | Space | Notes |
|--------|------|-------------|------|-------|-------|
| method1 | `method1_ArrayBased` | Uses two pointers and builds a new array | O(n) | O(n) | Simple, but uses extra space |
| method2 | `method2_arrayBasedOptimised` | Same idea as method1 but optimized using `Arrays.fill` and `System.arraycopy` | O(n) | O(n) | Cleaned-up version |
| method3 | `method3_countingSort` | Count # of 0s,1s,2s and overwrite array | O(n) | O(1) | Very reliable and interview-safe |
| method4 | `method3_dutchNationalFlag` | Dutch National Flag Algorithm (BEST) | O(n) | O(1) | FAANG-preferred, single-pass, in-place |

---

# 🔥 Detailed Explanation — Dutch National Flag Algorithm (FAANG-Preferred)

This is the **most optimal** and **most commonly expected** solution in FAANG interviews.

### 🎯 Goal
Sort the array in one pass using constant space.

### 🎛 We use 3 pointers:

- `low`   → boundary for placing 0s
- `mid`   → current element being processed
- `high`  → boundary for placing 2s

### 🔄 Meaning of the regions:
- [0 ... low-1] → All 0s
- [low ... mid-1] → All 1s
- [mid ... high] → Unknown region (to process)
- [high+1 ... end] → All 2s

### 🚀 Algorithm Steps

While `mid <= high`:

#### Case 1 → `arr[mid] == 0`
- Swap arr[low] ↔ arr[mid]
- Expand the 0s region → `low++`
- Move mid forward → `mid++`

#### Case 2 → `arr[mid] == 1`
- Do nothing
- Just move mid → `mid++`
- Because 1 is already in correct zone

#### Case 3 → `arr[mid] == 2`
- Swap arr[mid] ↔ arr[high]
- Move high backward → `high--`
- ❗ Do NOT do `mid++` here because  
  the swapped element from `high` is unprocessed

### 🎉 Result
✔ One-pass  
✔ In-place  
✔ O(n) time  
✔ O(1) space  
✔ No extra arrays required

Because of all these benefits, **FAANG interviewers prefer this method**.

---

# Short Explanation of Other Methods

### ✔ method1_ArrayBased
- Build a new array
- Fill 0s from left, 2s from right
- Fill the middle with 1s
- Copy back
- Simple but uses O(n) extra space

### ✔ method2_arrayBasedOptimised
- Same as method1 but uses:
    - `Arrays.fill` for filling 1s
    - `System.arraycopy` for copying
- Cleaner but still O(n) extra space

### ✔ method3_countingSort
- Count number of 0s, 1s, 2s in one pass
- Rewrite array with correct counts
- O(n) time, O(1) space
- Great approach when values are limited to small fixed range
- Very common in coding rounds

---

# Complexity Comparison

| Method | Time | Space | Notes |
|--------|------|--------|-------|
| Array-Based | O(n) | O(n) | Simple but uses extra space |
| Array-Based Optimised | O(n) | O(n) | Cleaner implementation |
| Counting Sort | O(n) | O(1) | Stable, reliable |
| Dutch National Flag | **O(n)** | **O(1)** | **BEST**, in-place one pass |

---

# Edge Cases

| Case | Expected Behavior |
|------|------------------|
| Empty array | Nothing happens |
| Array of only 0s / only 1s / only 2s | Works correctly |
| Already sorted | No unnecessary swaps (best-case O(n)) |
| Reverse sorted | Works in one pass |
| Large input | O(n) stable performance |

---

# FAANG Interview Notes

### 🎯 What interviewers look for:
- Ability to recognize this is a variation of **Dutch National Flag**
- Ability to code an **O(n) one-pass** solution
- Knowledge of **constant space** constraints
- Clean pointer manipulation
- Correct handling of the `mid` and `high` pointer logic
- Avoiding unnecessary swaps

### 🧠 Common pitfalls:
- Incrementing `mid` after swapping with `high` (incorrect)
- Forgetting that swapped value from `high` must be examined
- Mismanaging boundaries (off-by-one errors)
- Treating values outside {0,1,2} as valid (should not happen)

### 💬 How to explain in an interview:
> "I will use the Dutch National Flag algorithm.  
> It partitions the array into 3 regions using three pointers:  
> `low` for 0s, `mid` for processing, and `high` for 2s.  
> We perform swaps to grow the 0-region on the left and 2-region on the right.  
> This guarantees a single-pass solution with O(1) extra space."

This explanation demonstrates:
- Strong understanding of the technique
- Ability to communicate algorithms clearly
- Awareness of space/time optimization

### ⭐ Bonus Tip
Mention that this algorithm was proposed by **Edsger Dijkstra**, which signals strong CS fundamentals.

---

# Sample Input / Output

### Input
`[2, 0, 1, 2, 0, 1, 1, 0]`

### Output
`[0, 0, 1, 1, 1, 2, 2, 2]`

---

# Final Recommendation

Use **Dutch National Flag (`method3_dutchNationalFlag`)**.  
It is the **fastest**, **cleanest**, **most scalable**, and the **official FAANG expected solution**.

