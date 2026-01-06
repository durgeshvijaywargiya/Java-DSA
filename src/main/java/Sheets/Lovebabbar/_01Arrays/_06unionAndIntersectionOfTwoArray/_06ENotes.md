# Intersection of Two Arrays (Occurrences vs Distinct) — GFG / FAANG Level

## Problem Context
Given two integer arrays `a[]` and `b[]`, find how many elements are common between them.

⚠️ Important:  
There are **two different interpretations** of “intersection” that often confuse candidates:
1. Count **all occurrences** of common elements
2. Count only **distinct common elements**

This file covers **both interpretations clearly**.

---

## Implemented Methods Overview

| Method | What It Counts | Time | Space | When to Use |
|------|---------------|------|-------|-------------|
| method1_countOccurrences | All occurrences | O(n + m) | O(n) | Default GFG-style |
| method2_distinctIntersection | Distinct only | O(n + m) | O(n + m) | Clarity-focused |
| method3_sortedTwoPointers | Distinct only | O(n + m) | O(1) | Arrays sorted |

---

## Method 1: Count Occurrences (Your Original Logic)

### What It Does
Counts **how many elements in `b` are present in `a`**, including duplicates.

### Example
a = [1, 2, 3]  
b = [2, 2, 3]

Output = **3**  
Explanation:
- 2 appears twice in `b` and exists in `a`
- 3 appears once and exists in `a`

### Key Insight
- Uses a HashSet for lookup
- Does **not** remove elements after matching
- Duplicates in `b` are counted multiple times

### Complexity
Time: O(n + m)  
Space: O(n)

### Interview Note
This is often what **GFG expects by default**, unless the problem explicitly says *distinct*.

---

## Method 2: Distinct Intersection (FAANG Clarity)

### What It Does
Counts only **unique common elements** between `a` and `b`.

### Example
a = [1, 2, 3]  
b = [2, 2, 3]

Output = **2**  
Explanation:  
Common distinct elements = {2, 3}

### Key Insight
- One set for `a`
- One set to track intersection
- Ensures uniqueness explicitly

### Complexity
Time: O(n + m)  
Space: O(n + m)

### Interview Note
Use this when the problem clearly says **“distinct elements”**.

---

## Method 3: Sorted Two-Pointer (Best When Sorted)

### What It Does
Counts **distinct common elements** using two pointers.

### Assumption
Both arrays are **sorted**.

### Why This Is Powerful
- No HashSet
- No extra memory
- Pure algorithmic solution

### Core Idea
- Move pointers forward
- Skip duplicates manually
- Count only once per value

### Complexity
Time: O(n + m)  
Space: O(1)

### Interview Note
This is excellent when:
- Arrays are already sorted
- Memory usage matters
- Hashing is discouraged

---

## Key Differences You Must Understand (Very Important)

| Scenario | Correct Method |
|-------|----------------|
Count all matches | method1_countOccurrences |
Count unique matches | method2 or method3 |
Arrays sorted | method3 |
GFG-style basic problem | method1 |
FAANG clarity | method2 / method3 |

---

## Common Interview Pitfalls
- Not asking whether **distinct** is required
- Assuming intersection always means unique
- Using HashSet blindly
- Missing sorted-array optimization

---

## How to Clarify in an Interview
> “Should duplicates be counted multiple times, or only distinct common elements?”

This single question shows **strong problem understanding**.

---

## Final Recommendation
- Always clarify **definition of intersection**
- Use **HashSet** for simplicity
- Use **two pointers** for optimal space when sorted
- Never mix occurrence-count and distinct-count logic

This topic tests **clarity of thought more than coding difficulty**.
