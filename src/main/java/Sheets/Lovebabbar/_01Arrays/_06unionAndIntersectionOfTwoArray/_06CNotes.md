# Intersection of Two Arrays II — LeetCode 350 (FAANG Level)

## Problem Statement
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result should appear as many times as it shows in both arrays.

The result can be returned in any order.

---

## Example
Input:  
nums1 = [1,2,2,1]  
nums2 = [2,2]

Output:  
[2,2]

---

## Key Difference from LeetCode 349
- Duplicates **must be preserved**
- Frequency of elements matters

This makes HashSet insufficient.

---

## Implemented Approaches Overview

| Approach | Time | Space | Interview View |
|-------|------|------|----------------|
| ArrayList + contains | O(n × m) | O(n) | ❌ TLE-prone |
| HashMap (frequency) | O(n + m) | O(min(n,m)) | **Preferred** |
| Sorting + Two Pointers | O(n log n + m log m) | O(1) | Strong alternative |

---

## Approach 1: ArrayList-Based (Baseline / Your Solution)

### Idea
- Store nums1 in a list
- For each element in nums2:
    - Check if present
    - Remove one occurrence
    - Add to result

### Why It Fails at Scale
- `contains()` is O(n)
- `remove()` is O(n)
- Nested operations → **TLE**

### Interview Note
Good for understanding, but **not acceptable** for large inputs.

---

## Approach 2: HashMap Frequency Count (FAANG STANDARD)

### Core Idea
- Count occurrences of elements in nums1
- Traverse nums2 and:
    - If count > 0 → add to result
    - Decrement count

### Why This Is Optimal
- Each element processed once
- Handles duplicates naturally
- Clean and readable

### Complexity
Time: O(n + m)  
Space: O(min(n, m))

---

## Approach 3: Sorting + Two Pointers

### Core Idea
- Sort both arrays
- Use two pointers to match elements
- Add to result when equal

### When This Is Useful
- When HashMap is not allowed
- When arrays are already sorted
- When memory is constrained

### Complexity
Time: O(n log n + m log m)  
Space: O(1)

---

## Edge Cases
One array empty  
No common elements  
All elements common  
Large duplicates  
Unsorted input

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognition that HashSet is insufficient
- Frequency-based logic
- Correct handling of duplicates
- Clear complexity explanation

### How to Explain in Interview
“I use a HashMap to count frequencies from the first array. Then I iterate over the second array and reduce the count whenever I find a match, adding it to the result.”

---

## Common Pitfalls
Using HashSet instead of HashMap  
Using ArrayList.contains repeatedly  
Forgetting to decrement frequency  
Sorting without explaining trade-offs

---

## Final Recommendation
- **HashMap approach** is the safest and fastest
- **Two-pointer approach** is a strong backup
- Avoid list-based solutions in interviews

This problem tests frequency handling and complexity awareness.
