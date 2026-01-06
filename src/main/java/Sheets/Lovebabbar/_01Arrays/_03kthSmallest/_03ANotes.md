# Kth Smallest Element — FAANG-Level Notes

## Problem Statement
Given an integer array `arr[]` and an integer `k`, your task is to find and return the k-th smallest element in the given array.

**Example**  
Input: `arr = [7, 10, 4, 3, 20, 15], k = 3`  
Output: `3rd smallest = 7`

**Assumptions used in code:**
- If `arr == null` or `k` is out of range (`k <= 0` or `k > arr.length`), methods throw `IllegalArgumentException`. You can change this to return sentinel values depending on API requirements.

---

## Implemented Methods (summary)

| Method | Name | Description | Time Complexity | Extra Space |
|--------|------|-------------|-----------------|-------------|
| method1 | `method1_sort` | Sort array and return `arr[k-1]` | O(n log n) | O(1) extra (sorting overhead) |
| method2 | `method2_minHeapPoll` | Build min-heap, poll `k-1` times, return root | O(n log n) (practical) | O(n) |
| method3 | `method3_maxHeapFixedSize` | Maintain max-heap of size `k`, return root | O(n log k) | O(k) |
| method4 | `method4_quickselect` | Quickselect (randomized pivot) — expected O(n) | Average O(n), Worst O(n^2) | O(1) extra |

---

## Explanation of Each Approach

### `method1_sort` — Sort-based (simple)
- **Idea:** Sort the array and take the `(k-1)`-th index.
- **When to use:** Quick to implement or when you also need the whole array sorted.
- **Trade-offs:** Not optimal for large arrays if only kth is needed.

### `method2_minHeapPoll` — Min-heap poll
- **Idea:** Add all elements to a min-heap and pop k-1 times; next pop is kth smallest.
- **When to use:** Educational/demonstrative; straightforward.
- **Trade-offs:** Uses O(n) space and often slower than method3 for small k.

### `method3_maxHeapFixedSize` — Max-heap of size k (recommended when k << n)
- **Idea:** Maintain a max-heap of up to k smallest elements seen; largest in heap is kth smallest.
- **When to use:** Production when k is much smaller than n — O(n log k).
- **Trade-offs:** Best practical performance when k << n.

### `method4_quickselect` — Quickselect (average linear time)
- **Idea:** Partition around a pivot like quicksort; recurse/iterate into side containing kth element.
- **When to use:** When you want expected linear time and can mutate array in-place.
- **Trade-offs:** Average O(n), but worst-case O(n^2) (randomized pivot mitigates this). If strict worst-case O(n) is required, use median-of-medians (not implemented here due to complexity).

---

## Complexity Summary

- **Sort-based (`method1`)**: Time O(n log n), Space O(1) extra (sorting overhead).
- **Min-heap (`method2`)**: Time O(n log n) (if building heap by offers), Space O(n).
- **Max-heap of size k (`method3`)**: Time O(n log k), Space O(k).
- **Quickselect (`method4`)**: Average Time O(n), Worst Time O(n^2), Space O(1) extra.

**Recommendation:** For large `n` and small `k`, prefer `method3`. For average linear time and minimal extra space, use `method4` (Quickselect). Avoid sorting if you only need kth element.

---

## Edge Cases (must test)
- `arr == null` → throws `IllegalArgumentException` (current behavior).
- `k <= 0` or `k > arr.length` → throws `IllegalArgumentException`.
- `arr.length == 1` and `k == 1` → return the single element.
- Arrays with duplicates — should behave normally (kth smallest counts duplicates as separate positions).
- Negative numbers and large integers — handled correctly.
- Very large arrays — prefer `method3` (k small) or `method4` (quickselect) to avoid O(n log n) overhead.

---

## FAANG Interview Checklist — What to say
1. **Restate the problem & constraints** (null handling, 1-based k).
2. **Propose a simple correct solution** (`method1` or `method2`) and state complexity.
3. **Present optimized options**:
    - `method3` using max-heap size k — O(n log k) and good for k << n.
    - `method4` Quickselect — average O(n), in-place.
4. **Mention edge cases** and how you handle invalid `k` or `null` input.
5. **If asked about worst-case guarantees**, mention median-of-medians (BFPRT) achieves worst-case O(n) but is complex to implement.
6. **Be explicit about mutation**: Quickselect mutates the array; if immutability required, work on a copy or use heaps/sorting.

---

## Sample Input / Output
- Input: `[]`, `k = 1` → `IllegalArgumentException` (empty array)
- Input: `[5]`, `k = 1` → Output: `5`
- Input: `[7, 10, 4, 3, 20, 15]`, `k = 3` → Output: `7`

---

## Common Pitfalls
- Off-by-one errors (`k` is 1-based).
- Not validating `k` or `arr` leading to runtime errors.
- Using sorting unnecessarily when O(n) or O(n log k) solutions exist.
- Forgetting that Quickselect mutates the input array.

---

## Final Notes
- For interviews: present the single-pass heaps approach (method3) and Quickselect (method4) as the two strongest answers — explain trade-offs clearly.
- Keep implementations readable and state assumptions early.
