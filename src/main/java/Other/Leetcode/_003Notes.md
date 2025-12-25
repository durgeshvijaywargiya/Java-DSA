# Sum of Unique Elements — LeetCode 1748 (FAANG Level)

## Problem Statement
Given an integer array `nums`, return the **sum of all unique elements**.  
An element is considered unique if it appears **exactly once**.

---

## Implemented Approaches

| Method | Approach | Time | Space | Notes |
|------|--------|------|------|------|
| method1 | Frequency Array | O(n) | O(1) | **BEST — uses constraints** |
| method2 | HashMap | O(n) | O(n) | Generic solution |
| method3 | Two HashSets | O(n) | O(n) | Clean logic |

---

## 🔥 Detailed Explanation — Frequency Array (Best Approach)

### Why this works
Constraints:
- 1 <= nums[i] <= 100

So:
- Create an array `freq[100]`
- Index `i` represents number `i + 1`
- Count occurrences
- Add only values with frequency `1`

### Algorithm
1. Initialize frequency array
2. Count occurrences
3. Traverse frequency array
4. Add numbers that appear exactly once

### Complexity
- **Time:** O(n)
- **Space:** O(1) (fixed-size array)

This is the **most optimal and FAANG-preferred** approach.

---

## Other Approaches

### HashMap
- Works when value range is unknown
- Slightly higher memory usage

### Two HashSets
- One set tracks seen elements
- One set tracks duplicates
- Clean but indirect

---

## Edge Cases
- All elements duplicate → sum = 0
- Single element → return that element
- Large input → still linear
- Unordered array → handled naturally

---

## FAANG Interview Notes

### What Interviewers Expect
- Recognition of constraints
- Avoid unnecessary HashMap
- Clean frequency counting
- Correct time & space analysis

### How to Explain in Interview
> “Since values are limited to 1..100,  
> I used a frequency array to count occurrences  
> and summed values that appear exactly once.”

### Common Pitfalls
- Forgetting to use constraints
- Using HashMap unnecessarily
- Off-by-one errors in indexing

---

## Sample Input / Output

Input:
[1, 2, 3, 2]

Output:
4


---

## Final Recommendation
Use **frequency array** when constraints allow it.  
It’s cleaner, faster, and shows strong problem-solving skills.

