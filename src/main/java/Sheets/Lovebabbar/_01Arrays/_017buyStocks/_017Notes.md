# Best Time to Buy and Sell Stock — LeetCode 121 (FAANG Level)

## Problem Statement
You are given an array prices where prices[i] is the price of a given stock on the i-th day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve. If no profit is possible, return 0.

## Example
Input: prices = [7, 1, 5, 3, 6, 4]  
Output: 5  
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 − 1 = 5.

## Constraints
1 <= prices.length <= 10^5  
0 <= prices[i] <= 10^4

---

## Implemented Approaches Overview

| Approach | Idea | Time | Space | Interview View |
|--------|----|------|------|----------------|
| Min Price Tracking | Track best buy price | O(n) | O(1) | Preferred |
| Kadane’s Algorithm | Max subarray on diffs | O(n) | O(1) | Advanced insight |

---

## Approach 1: Minimum Price Tracking (Recommended)

### Core Idea
At every day, decide whether to buy or sell based on the minimum price seen so far. If today’s price is lower, update the buying price. Otherwise, compute profit by selling today.

### Algorithm Explanation
- Maintain minPrice = minimum price seen so far
- For each price:
    - Update minPrice if current price is lower
    - Otherwise, update maxProfit using (current price − minPrice)

### Why This Works
- You always buy before you sell
- Greedy ensures best profit at each step
- Single pass guarantees optimal result

### Complexity
Time Complexity: O(n)  
Space Complexity: O(1)

### When to Use
- This is the **default interview solution**
- Simple, readable, and easy to explain

---

## Approach 2: Kadane’s Algorithm Variant

### Core Idea
Transform the problem into a maximum subarray problem by considering daily price differences. The maximum subarray sum corresponds to the maximum profit.

### Transformation
prices = [7, 1, 5, 3, 6, 4]  
diffs  = [-6, 4, -2, 3, -2]

Maximum subarray sum = 5

### Why This Works
- Profit is accumulated through consecutive positive price increases
- Kadane’s algorithm efficiently finds the best range

### Complexity
Time Complexity: O(n)  
Space Complexity: O(1)

### When to Use
- When interviewer asks for alternative thinking
- Shows connection between greedy and Kadane’s algorithm

---

## Edge Cases You Must Know
Prices strictly decreasing → profit = 0  
Single day → profit = 0  
Same price every day → profit = 0  
Large input → must be linear time

---

## FAANG Interview Expectations

### What Interviewers Expect
- O(n) greedy solution
- Correct buy-before-sell logic
- No nested loops or DP
- Clear explanation of decision-making

### How to Explain in Interview
“I track the minimum price so far and compute the profit if I sell today. This guarantees the maximum profit in one pass.”

### Bonus Explanation
“This problem can also be solved using Kadane’s algorithm by treating price differences as an array and finding the maximum subarray sum.”

---

## Common Follow-Up Questions
- Can you do it in one pass? → Yes
- What if multiple transactions are allowed? → Different problem (LC 122)
- What if transaction fee exists? → Modify state machine

---

## Common Pitfalls
Buying after selling (violates constraints)  
Using nested loops (O(n²))  
Tracking max price instead of min price  
Confusing this with multiple-transaction problems

---

## Final Recommendation
Always start with the minimum price tracking solution. Mention Kadane’s algorithm as an alternative to demonstrate deeper understanding. This problem is a fundamental greedy pattern tested heavily in FAANG interviews.
