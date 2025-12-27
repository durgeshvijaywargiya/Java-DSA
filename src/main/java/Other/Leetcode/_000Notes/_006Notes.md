# Valid Palindrome — FAANG-Level Java Guide (LeetCode 125)

## Problem Statement
Given a string `s`, determine if it is a palindrome, considering:
- Only alphanumeric characters
- Case-insensitive comparison

---

## Approaches Implemented

### 1️⃣ Two-Pointer In-Place (Recommended)
- Skip non-alphanumeric characters
- Compare characters from both ends

Time: O(n)  
Space: O(1)

This is the **best interview answer**.

---

### 2️⃣ Preprocess + Palindrome Check
- Clean string first
- Check palindrome separately

Time: O(n)  
Space: O(n)

Easier to understand, slightly more memory.

---

### 3️⃣ Regex-Based (Mention Only)
- Uses replaceAll and reverse
- Not optimal but acceptable

---

## Constraints-Based Reasoning

- If memory matters → two-pointer
- If clarity matters → preprocessing
- Avoid regex in performance-critical code

---

## Edge Cases
- Empty string → true
- String with only symbols → true
- Mixed case → handled
- Numbers included → handled

---

## Interview Cross-Questions

**Q: Why not reverse the string directly?**  
Because it requires extra memory.

**Q: Why skip characters instead of removing them?**  
To avoid building a new string (O(1) space).

**Q: What if Unicode characters exist?**  
Character.isLetterOrDigit handles them safely.

**Q: Which approach is best?**  
Two-pointer in-place.

---

## Final Notes
- Always start with two-pointer approach
- Mention preprocessing as alternative
- Explain trade-offs clearly
