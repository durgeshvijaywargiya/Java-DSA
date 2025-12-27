# Reverse Words Based on Vowel Count — FAANG-Ready Guide

## Problem Statement
Given a string of words separated by spaces:
- Count vowels in the **first word**
- Reverse every word whose vowel count equals that of the first word
- Return the modified string

---

## Approaches Used

### 1️⃣ Original Approach
- Split string into words
- Count vowels in the first word
- For each remaining word:
    - Count vowels
    - Reverse if count matches

Time: O(n)  
Space: O(n)

---

### 2️⃣ Micro-Optimized Approach (Recommended)
- Extract vowel counting into helper method
- Use `StringBuilder.reverse()`
- Cleaner and more readable

Time: O(n)  
Space: O(n)

---

## Constraints-Based Reasoning

- If input size is small → `split()` is fine
- If input is very large → character scan is better
- `StringBuilder` is preferred over string concatenation

---

## Interview Cross-Questions

**Q: Why use StringBuilder?**  
Because strings are immutable; StringBuilder avoids O(n²) behavior.

**Q: Why not reverse the first word?**  
Problem logic compares all words **against** the first word.

**Q: What about uppercase vowels?**  
Can be handled by converting characters to lowercase.

**Q: Can this be done in one pass?**  
Yes, but readability decreases; clarity is preferred.

---

## Edge Cases
- Single word → unchanged
- No vowels in first word → only words with zero vowels reverse
- Multiple spaces → requires preprocessing

---

## Final Notes
- Micro-optimized version is best for interviews
- Always extract reusable logic
- Explain trade-offs clearly
