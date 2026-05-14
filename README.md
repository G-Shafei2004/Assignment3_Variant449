# Assignment 3 — Sorting and Searching Algorithms
**Student:** Ghulam Ali Shafei
**ID:** 255904
**Variant:** #449
**Group = **IT-2509
---

## Dataset
Index:  [0]  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]  [9]
Value:   93   42   70   64   40   39   88   43   25   22

- **Primary Target (T1):** 64
- **Secondary Target (T2):** 88

---

## Project Structure
Assignment3_Variant449/
│
├── A1HeapSort.java        — Section A: Task 1
├── A2BubbleSort.java      — Section A: Task 2
├── A3QuickSort.java       — Section A: Task 3
├── B1BinarySearch.java    — Section B: Task 1
├── B2Hashing.java         — Section B: Task 2
├── B3DivideConquer.java   — Section B: Task 3
└── README.md

---

## Section A — Sorting Algorithms

### A1 — Heap Sort
**Scenario:** Managing a CPU task scheduler where tasks have different priority levels.

**What it does:**
- Builds a Max-Heap from the dataset so the largest element is always at the root
- Performs the first Extract-Max operation to move the maximum to its sorted position
- Re-heapifies the remaining elements

**Output:**
After Heapify:        [93, 64, 88, 43, 40, 39, 70, 42, 25, 22]
After First Extract:  [88, 64, 70, 43, 40, 39, 22, 42, 25, 93]

**Complexity:**
| Case | Time | Space |
|------|------|-------|
| All cases | O(n log n) | O(log n) |

---

### A2 — Bubble Sort
**Scenario:** Optimizing a legacy script for a library catalog where only a few books are out of place.

**What it does:**
- Compares adjacent elements and swaps them if they are in the wrong order
- Runs for the first 3 passes and shows the array state after each pass
- Uses Early Exit optimization — if no swaps happen in a pass, the array is already sorted and the algorithm stops immediately

**Output:**
After Pass 1: [42, 70, 64, 40, 39, 88, 43, 25, 22, 93]
After Pass 2: [42, 64, 40, 39, 70, 43, 25, 22, 88, 93]
After Pass 3: [42, 40, 39, 64, 43, 25, 22, 70, 88, 93]

**Complexity:**
| Case | Time | Space |
|------|------|-------|
| Best (already sorted) | O(n) | O(1) |
| Worst / Average | O(n²) | O(1) |

---

### A3 — Quick Sort
**Scenario:** A high-frequency trading platform needs to sort stock prices in microseconds.

**What it does:**
- Uses the first element (93) as the pivot with the Hoare partitioning scheme
- Moves all elements smaller than pivot to the left, larger to the right
- Places the pivot in its correct final position
- Since 93 is the maximum element, no swaps occur and it moves directly to the last index

**Output:**
Pivot = 93 (first element, Hoare scheme)
Note: Pivot=93 is the maximum element, so no swaps occurred.
Pivot placed at index: 9
Array after partition: [22, 42, 70, 64, 40, 39, 88, 43, 25, 93]

**Complexity:**
| Case | Time | Space |
|------|------|-------|
| Average | O(n log n) | O(log n) |
| Worst (pivot always min or max) | O(n²) | O(log n) |

---

## Section B — Searching and Hashing

### B1 — Binary Search
**Scenario:** Locating a user ID in a sorted database of 1 million registered users.

**What it does:**
- Sorts the dataset first
- Searches for Secondary Target T2 = 88
- At each step prints Low, High, and Mid index values
- Finds 88 in just 3 steps by halving the search space each time

**Sorted Array:**
[22, 25, 39, 40, 42, 43, 64, 70, 88, 93]
  0   1   2   3   4   5   6   7   8   9

**Trace:**
Step 1: Low=0  High=9  Mid=4  arr[4]=42  → 42 < 88, go RIGHT
Step 2: Low=5  High=9  Mid=7  arr[7]=70  → 70 < 88, go RIGHT
Step 3: Low=8  High=9  Mid=8  arr[8]=88  → FOUND at index 8 ✓

**Complexity:**
| Case | Time | Space |
|------|------|-------|
| Best | O(1) | O(1) |
| Worst / Average | O(log n) | O(1) |

---

### B2 — Hashing (Modulo + Linear Probing)
**Scenario:** Creating a fast-access cache for a web server's session tokens.

**What it does:**
- Uses hash function h(k) = k mod 7 with table size M = 7
- Inserts each key into the computed index
- Resolves collisions using Linear Probing (try next slot: index+1, index+2, ...)
- Dataset has 10 elements but table size is 7 — last 3 elements (43, 25, 22) cause overflow

**Hash Table:**
[0] = 42
[1] = 70
[2] = 93
[3] = 64
[4] = 39
[5] = 40
[6] = 88

**Note:** In real systems, overflow triggers rehashing with a larger table.

**Complexity:**
| Case | Time | Space |
|------|------|-------|
| Average | O(1) | O(M) |
| Worst (all keys collide) | O(n) | O(M) |

---

### B3 — Divide and Conquer (Min / Max)
**Scenario:** Finding both the Maximum and Minimum elements in a dataset simultaneously.

**What it does:**
- Recursively splits the array in half until reaching base cases (1 or 2 elements)
- Base case of 1 element: that element is both min and max
- Base case of 2 elements: compare and return the smaller as min, larger as max
- Combines results from left and right halves by taking the overall min and max

**Result:**
Minimum = 22
Maximum = 93
Range (Max - Min) = 71

**Efficiency Comparison (n = 10):**
| Approach | Comparisons | Formula |
|----------|------------|---------|
| Naive (two loops) | 18 | 2*(n-1) |
| Divide & Conquer | 13 | 3n/2 - 2 |

D&C saves 5 comparisons for n=10. The advantage grows larger as n increases.

**Complexity:**
| Case | Time | Space |
|------|------|-------|
| All cases | O(n) | O(log n) |

---

## Algorithm Complexity Summary

| Task | Algorithm | Time (Best) | Time (Average) | Time (Worst) | Space |
|------|-----------|------------|----------------|--------------|-------|
| A1 | Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(log n) |
| A2 | Bubble Sort | O(n) | O(n²) | O(n²) | O(1) |
| A3 | Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) |
| B1 | Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| B2 | Hashing | O(1) | O(1) | O(n) | O(M) |
| B3 | Divide & Conquer | O(n) | O(n) | O(n) | O(log n) |
