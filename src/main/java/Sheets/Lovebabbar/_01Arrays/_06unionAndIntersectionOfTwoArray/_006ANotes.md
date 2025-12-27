# Union of Two Arrays (FAANG Level)

## Problem Statement
Given two arrays `a[]` and `b[]`, return the **union** of the arrays.  
The union should contain **distinct elements only**.

---

## Implemented Approaches

| Method | Approach | Time | Space | Sorted Output | Use Case |
|------|--------|------|------|--------------|---------|
| method1 | HashSet | O(n + m) | O(n + m) | ❌ No | Unsorted arrays |
| method2 | Two Pointers | O(n + m) | O(1)* | ✅ Yes | Sorted arrays |

\*excluding output list.

---

## 🔥 Detailed Explanation — Two Pointer Approach (FAANG Preferred)

### When to use
When **both input arrays are already sorted**.

### Core Idea
- Maintain two pointers `i` and `j`
- Compare `a[i]` and `b[j]`
- Insert smaller element and move pointer
- If equal, insert once and move both pointers
- Skip duplicates by checking last inserted element

### Why This Works
- Each element is processed once
- No extra hash structure needed
- Maintains sorted order automatically

### Complexity
- **Time:** O(n + m)
- **Space:** O(1) extra
- **Stable & ordered output**

---

## HashSet Approach (Your Solution)

### Idea
- Insert all elements from both arrays into a HashSet
- Convert HashSet to ArrayList

### Pros
- Simple
- Works for unsorted arrays

### Cons
- Output order not guaranteed
- Extra memory used

---

## Edge Cases
- One array empty
- Both arrays empty
- All elements same
- No common elements
- Arrays of different sizes

---

## FAANG Interview Notes

### What Interviewers Expect
- HashSet solution as baseline
- Two-pointer solution for sorted arrays
- Correct time & space analysis
- Awareness of order requirements

### How to Explain in Interview
> “If arrays are unsorted, HashSet gives O(n+m) solution.  
> If arrays are sorted, I prefer two pointers for O(1) extra space.”

### Common Pitfalls
- Forgetting to remove duplicates
- Returning unsorted output when sorted expected
- Using sorting unnecessarily

---

## Sample Input / Output

Input:
- a = [1,2,3,4,5]
- b = [3,4,5,6,7]


Output:
- [1,2,3,4,5,6,7]

---

## Final Recommendation
- **Unsorted arrays → HashSet**
- **Sorted arrays → Two pointers (BEST)**

Mentioning both approaches shows **FAANG-level understanding**.
