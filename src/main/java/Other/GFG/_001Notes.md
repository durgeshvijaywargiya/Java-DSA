# Sum of Common Elements (GFG — FAANG Level)

## Problem Statement
You are given two arrays of size `n1` and `n2`.  
Your task is to find all the elements that are **common to both arrays** and **sum them**.

### Important Notes:
- Arrays may contain **duplicate elements**
- Sum **only UNIQUE common elements**
- If no common elements exist, return `0`
- Since the answer may be large, return it modulo **(10⁹ + 7)**

---

## Implemented Approaches

| Method | Approach | Time | Space | Notes |
|------|--------|------|------|------|
| method1 | HashSet + Remove | O(n1+n2) | O(n1) | **BEST — unsorted arrays** |
| method2 | Two Pointers | O(n1+n2) | O(1) | Requires sorting |

---

## 🔥 Detailed Explanation — HashSet + Remove (Best Approach)

### Core Idea
- Use a `HashSet` to store elements of the first array
- Traverse the second array
- If an element exists in the set:
    - Add it to the sum
    - Remove it from the set to ensure **uniqueness**

### Why Removal is Important
Removing the element ensures:
- Duplicate elements in `arr2` are counted **only once**
- Each common element contributes **exactly one time**

### Example
- arr1 = [1, 2, 2, 3]
- arr2 = [2, 2, 3, 5]
- Common unique elements = {2, 3} 
- Sum = 5
---

## Complexity Analysis
- **Time:** O(n1 + n2)
- **Space:** O(n1)
- **Modulo Handling:** Applied at each addition to prevent overflow

---

## Edge Cases
- One or both arrays empty → result = 0
- No common elements → result = 0
- All elements duplicated → counted once
- Large values → handled using modulo

---

## FAANG Interview Notes

### What Interviewers Expect
- Correct handling of **duplicates**
- Awareness of **uniqueness requirement**
- Proper modulo handling
- Clean time & space analysis

### How to Explain in Interview
> “I store unique elements of the first array in a HashSet.  
> While scanning the second array, whenever I find a common element,  
> I add it once to the sum and remove it from the set to avoid duplicate counting.”

### Common Pitfalls
- Forgetting to remove element → duplicates counted
- Summing all occurrences instead of unique
- Applying modulo only at the end (risk of overflow)

---

## Final Recommendation
Use **HashSet + removal** for unsorted arrays.  
Mention **two-pointer approach** if arrays are sorted.

This solution is **clean, optimal, and interview-ready**.
