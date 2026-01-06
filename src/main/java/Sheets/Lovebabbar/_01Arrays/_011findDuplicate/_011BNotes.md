# Two Repeated Elements in an Array (FAANG Level)

## Problem Statement
You are given an integer array arr of size n + 2.

- All elements are in the range [1, n]
- All elements appear exactly once
- Exactly two elements appear twice

Return the two repeating numbers **in the order of their second appearance**.

---

## Example
Input:  
arr = [1, 2, 1, 3, 4, 3]

Output:  
[1, 3]

Explanation:
- 1 repeats first
- 3 repeats later

---

## Core Insight
The array contains values strictly in the range **1 to n**.

This allows:
- Direct indexing
- In-place marking
- O(n) time solutions

---

## Implemented Approaches Overview

| Approach | Time | Space | Modifies Array | Interview View |
|-------|------|------|----------------|----------------|
| Counting Array | O(n) | O(n) | ❌ No | Simple |
| In-Place Sign Marking | O(n) | O(1) | ✅ Yes | **Preferred** |

---

## Approach 1: Counting Array (Your Solution)

### Idea
- Maintain a frequency array
- When frequency exceeds 1 → element is repeating
- Store in answer array in order

### Why It Works
- Direct frequency tracking
- Order preserved naturally

### Complexity
Time: O(n)  
Space: O(n)

### Interview Note
Good solution, but **not space optimal**.

---

## Approach 2: In-Place Sign Marking (FAANG Preferred)

### Core Idea
- Use array values as indices
- Flip sign of element at that index
- If already negative → element is repeated

### Why This Works
- Values are guaranteed in [1, n]
- Index-based marking is safe
- No extra memory required

### Example Walkthrough
arr = [1, 2, 1, 3, 4, 3]

Visit 1 → mark arr[1] negative  
Visit 2 → mark arr[2] negative  
Visit 1 → arr[1] already negative → repeated  
Visit 3 → mark arr[3] negative  
Visit 3 → arr[3] already negative → repeated

Answer = [1, 3]

### Complexity
Time: O(n)  
Space: O(1)

---

## Edge Cases
Both repeated numbers adjacent  
Repeated numbers at start/end  
n = 1 (minimum size = 3)

---

## FAANG Interview Expectations

### What Interviewers Expect
- Recognizing the value-range constraint
- Avoiding extra memory
- In-place marking technique
- Preserving order of second occurrence

### How to Explain in Interview
“Since values are between 1 and n, I can use the array itself to mark visited elements by flipping signs. When I encounter a value whose index is already negative, it means that number has appeared before.”

---

## Common Pitfalls
Using sorting (breaks order)  
Using HashSet without thinking  
Forgetting to take absolute value  
Out-of-bounds indexing

---

## Final Recommendation
- Use **in-place sign marking** for optimal solution
- Use **counting array** if array modification is not allowed
- Always clarify whether input modification is permitted

This problem tests **constraint awareness and space optimization**.
