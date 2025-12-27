# Minimum Deletion Cost to Make All Characters Equal — LeetCode 3784 (FAANG Level)

## Problem Statement
You are given a string s of length n and an integer array cost of the same length, where cost[i] is the cost to delete the i-th character of s. You may delete any number of characters such that the resulting string is non-empty and consists of equal characters. Return the minimum total deletion cost required.

## Example
Input: s = "aabb", cost = [1, 2, 3, 4]  
Output: 3  
Explanation: Keep only 'b' characters. Total cost = 1 + 2 = 3.

## Constraints
1 <= n <= 10^5  
s consists of lowercase English letters  
cost[i] >= 0

---

## Core Insight (Most Important)
Instead of thinking about which characters to delete, think about which character to keep.

If the final string must contain only one unique character:
- You choose one character to keep
- You delete all other characters
- To minimize cost, keep the character whose total deletion cost is maximum

So the problem becomes:
Minimum deletion cost = Total cost of all characters − Maximum total cost of one character

---

## Algorithm Explanation

### Step 1: Compute Total Cost
Sum up all deletion costs. This represents the cost if we delete everything.

### Step 2: Compute Cost Per Character
Use a fixed-size array of size 26 to store the sum of costs for each character.

### Step 3: Choose the Best Character to Keep
For each character that appears in the string:
- If we keep this character, we delete all others
- Deletion cost = totalCost − costSumOfThisCharacter
- Choose the minimum among all such options

---

## Example Walkthrough
s = "aabbcc"  
cost = [1, 2, 3, 4, 5, 6]

Total cost = 21  
Cost per character:
- a → 1 + 2 = 3
- b → 3 + 4 = 7
- c → 5 + 6 = 11

Best choice: keep 'c'  
Minimum deletion cost = 21 − 11 = 10

---

## Complexity Analysis
Time Complexity: O(n), one pass through the string and one fixed pass of size 26  
Space Complexity: O(1), fixed-size array for character costs

---

## Edge Cases You Must Know
String contains only one unique character → cost = 0  
All characters are different → keep the one with maximum cost  
Multiple occurrences with varying costs  
Large input size → linear solution required

---

## FAANG Interview Expectations

### What Interviewers Expect
- Ability to reframe deletion problems as selection problems
- Efficient use of frequency/count arrays
- O(n) time and O(1) extra space
- Clean reasoning without simulation or DP

### How to Explain in Interview
“I compute the total deletion cost, then for each character calculate how much cost I save by keeping it. The character with the maximum saved cost gives the minimum deletion cost.”

### Why This Is Optimal
- You must examine every character at least once
- Only one character type can remain
- Keeping the most expensive character group minimizes deletions

---

## Common Follow-Up Questions
- What if uppercase letters are allowed? → Increase array size or use HashMap
- What if the resulting string can be empty? → Then answer is 0
- Can this overflow? → Use long for cost accumulation

---

## Common Pitfalls
Trying dynamic programming unnecessarily  
Deleting greedily character-by-character  
Using HashMap when a fixed array suffices  
Forgetting that the resulting string must be non-empty

---

## Final Recommendation
This is a classic greedy counting problem. Always think in terms of what to keep rather than what to delete. The solution is simple, optimal, and exactly what interviewers want to see.
