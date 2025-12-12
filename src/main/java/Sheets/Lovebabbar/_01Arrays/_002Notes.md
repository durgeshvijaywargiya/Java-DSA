# Find Minimum and Maximum in an Array — FAANG-Level Notes

## Problem Statement
Given an array `arr[]`. Your task is to find the **minimum** and **maximum** elements in the array.

**Example:**  
Input: `[3, 1, 7, -2, 10, 0]`  
Output: `Min: -2, Max: 10`

**Assumption used in solutions:**  
If `arr` is `null` or empty (`length == 0`) the functions return an empty `ArrayList<Integer>` (no min/max), but you can change this to throw an exception if required by your API.

---

## Summary of Approaches (implemented as `method1`, `method2`, `method3`, `method4`)

| Method | Name | Description | Time | Extra Space |
|--------|------|-------------|------|-------------|
| method1 | `method1_sort` | Sort array and pick first/last | O(n log n) | O(1) extra (sorting overhead) |
| method2 | `method2_scan` | Single-pass scan to find min & max (recommended) | O(n) | O(1) |
| method3 | `method3_pairwise` | Pairwise comparisons to reduce comparisons (~3n/2) | O(n) | O(1) |
| method4 | `method4_divideConquer` | Recursive divide & conquer (tournament) | O(n) | O(log n) recursion |

---

## Explanation of Each Approach

### method1 — Sort-based (Simple)
- **Idea:** Sort `arr`, then `arr[0]` is min and `arr[n-1]` is max.
- **Pros:** Extremely simple to implement.
- **Cons:** Not optimal for performance — sorting is O(n log n).
- **Use-case:** Quick scripts or when you already need array sorted for other reasons.

### method2 — Single-pass Scan (Recommended)
- **Idea:** Initialize `min = +INF`, `max = -INF`, traverse once and update.
- **Pros:** Simple, very readable, O(n) time, O(1) space.
- **Cons:** Two comparisons per element on average.
- **Use-case:** Default approach in interviews/production.

### method3 — Pairwise Comparison (Comparison-Optimal)
- **Idea:** Process array in pairs; compare pair internally (1 comparison), then compare smaller with `min` and larger with `max` (2 more comparisons) ⇒ ~3 comparisons per 2 elements → 1.5 comparisons per element.
- **Pros:** Reduces number of comparisons from ~2n to ~1.5n.
- **Cons:** Slightly more code; micro-optimization rather than asymptotic improvement.
- **Use-case:** When comparisons are expensive or interviewer asks for comparison-count optimization.

### method4 — Divide & Conquer (Tournament)
- **Idea:** Recursively compute min & max for halves, combine results.
- **Pros:** Elegant divide-and-conquer; comparable comparisons to pairwise.
- **Cons:** Recursion overhead (stack) — O(log n) extra space.
- **Use-case:** When demonstrating divide-and-conquer or for academic completeness.

---

## Edge Cases (Important)
- `arr == null` → currently returns empty `ArrayList`. Alternatively, throw `IllegalArgumentException` if API expects that.
- `arr.length == 0` → empty `ArrayList`.
- `arr.length == 1` → min == max == single element.
- Negative numbers, duplicates, large integers → handled correctly.
- For very large arrays, prefer single-pass or pairwise (avoid sorting due to O(n log n)).

---

## Time & Space Complexity Summary
- **Sort-based:** Time O(n log n), Space O(1) extra (plus sort overhead)
- **Single-pass scan:** Time O(n), Space O(1)
- **Pairwise comparisons:** Time O(n), Space O(1), comparisons ≈ 1.5n
- **Divide & Conquer:** Time O(n), Space O(log n) recursion

Optimal overall is **O(n)** time; pairwise reduces constant factor of comparisons.

---

## FAANG Interview Checklist — What to Say
1. **State the problem and constraints** (null handling, array size, element domain).
2. **Propose the simple correct solution** (single-pass scan). Mention complexity: O(n) time, O(1) space.
3. **Discuss trade-offs**:
    - Sorting approach: simpler but O(n log n) — not optimal.
    - Pairwise approach: reduces comparisons to ~1.5n — useful when comparisons are expensive.
    - Divide & conquer: similar comparisons but adds recursion overhead.
4. **Mention edge cases** (null, empty, single element, duplicates).
5. **Explain why single-pass is OK in production** and demonstrate the pairwise optimization if asked.
6. **Keep code readable**; use clear names and handle defensive cases.

---

## Sample Inputs / Outputs
- Input: `[]` → Output: `[]` (empty result)
- Input: `[5]` → Output: `Min:5, Max:5`
- Input: `[3,1,7,-2,10,0]` → Output: `Min:-2, Max:10`

---

## Common Pitfalls
- Returning min and max in wrong order — ensure consistent ordering: `[min, max]`.
- Not handling `null` input — could cause NPE.
- Using sort when O(n) is available — mention performance cost to interviewer.
- Forgetting to test even/odd lengths for optimized pairwise approach.

---

## Final Notes
- For most interview and production needs, **method2 (single-pass scan)** is the easiest and safest choice.
- If specifically asked to reduce comparisons or prove you can optimize constants, present **method3 (pairwise)** and explain the ~3n/2 comparison bound.
- Keep answers concise in interviews: describe approach, complexity, edge cases — then show code.

