# Find Greatest Common Divisor of Array — LeetCode 1979

## Problem Statement
Given an integer array `nums`, return *the greatest common divisor of the smallest number and largest number in `nums`*.

**Example**
- Input: `nums = [2,5,6,9,10]`  
  Output: `2`  
  Explanation: Smallest = 2, Largest = 10, gcd(2,10) = 2

---

## Implemented Methods (in `FindGCDOfArray`)

| Method | Description | Time Complexity | Space Complexity |
|--------|-------------|----------------:|-----------------:|
| `method1_scanEuclid` | Single pass to find min/max + Euclidean gcd (recommended) | O(n) | O(1) |
| `method2_streams` | Java Streams to get min & max then gcd (concise) | O(n) (may be two passes) | O(1) |
| `method3_sortBased` | Sort array then gcd of first & last | O(n log n) | O(1) |

**Recommended:** `method1_scanEuclid` — simplest, clear, optimal time and space.

---

## How Each Approach Works

### `method1_scanEuclid` (Single-pass + Euclid)
1. Scan array once to compute `min` and `max`.
2. Compute gcd(|min|, |max|) via Euclidean algorithm (using `long` to safely take abs).
3. Return result.

**Advantages:** O(n) time, O(1) space. Clear and efficient — best for interviews.

### `method2_streams`
- Uses `Arrays.stream(nums).min()` and `.max()`; concise.
- Slight overhead and may traverse more than once.

### `method3_sortBased`
- Sorts array then picks first and last elements for gcd.
- Simpler to implement when sorting is acceptable, but slower: O(n log n).

---

## Complexity Summary
- **Time:** Best O(n) (method1).
- **Space:** O(1) extra for all methods (aside from sort overhead if you copy array).

---

## Edge Cases & Handling
- `nums == null` or `nums.length == 0` → current implementations throw `IllegalArgumentException`. (Change behavior if your API requires 0 or another sentinel.)
- If `min` or `max` equals `Integer.MIN_VALUE`, taking `Math.abs()` on int overflows — hence we convert to `long` before abs when using Euclid, or we use algorithms that avoid the int-abs issue.
- Duplicate values → handled normally.
- Negative values → gcd is taken on absolute values of min and max.
- Single-element array → gcd of the element with itself → return element's absolute value.

---

## FAANG Interview Notes — What to say
1. **Restate the problem**: find gcd of smallest and largest numbers in the array. Clarify k/vocabulary if needed.
2. **Propose solution**: scan once to find min and max O(n), then compute gcd via Euclidean algorithm O(log min,max).
3. **Explain edge cases**: null/empty array, handling negative numbers, `Integer.MIN_VALUE` abs issue.
4. **Trade-offs**:
    - Sorting approach is simpler but O(n log n).
    - Stream approach is concise but can be slightly less efficient.
5. **Complexity**: emphasize O(n) time and O(1) extra space for the recommended solution.
6. **Implementation detail**: when taking absolute values, convert to `long` or handle `Integer.MIN_VALUE` carefully.

---

## Sample Tests
| Input | Output |
|-------|--------|
| `[2,5,6,9,10]` | `2` |
| `[7,5,6,8,3]`   | `1` |
| `[3,3]`         | `3` |
| `[-4, 8]`       | `4` |

---

## Final Tip
For interviews implement the single-pass + Euclidean gcd (method1). Mention the int-to-long abs safety and optionally offer Stein's algorithm if the interviewer asks for alternative gcd methods.

