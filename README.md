## Short Project SP09: Divide and Conquer
1. Implementation of divide and conquer algorithm to sort an array of integers - Merge Sort (take1, take2, take3). 
2. O(n) vs O(log n) algorithms for Fibonacci Term using BigInteger Java library, and their comparison. 

#### Author
* [Rahul Nalawade](https://github.com/rahul1947)

#### Date
* Nov 04, 2018

_______________________________________________________________________________
### Problems:

#### A. Team Task: 

**Problem 1.**
   Implement and compare the running times of the following algorithms on 
   randomly generated arrays: 
   a. Insertion sort 
   b. Merge sort (take 1)
   c. Merge sort (take 2) 
   d. Merge sort (take 3)
   
   Do not run more than one algorithm in each trial.
   
   For Insertion sort, if the running time exceeds 2 min, write the time as infinity.
   
   For Merge sort, in each trial, run only one algorithm, for one value of n, 100 times
   in a loop, and taking the average time. 
   
   Try the following values of n: 8M, 16M, 32M, 64M, ..., until you get out of memory exception.
   Submit a report with your observations.

**Solution:** [SP9.java](https://github.com/rahul1947/SP09-Divide-and-Conquer/blob/master/SP9.java) 
   See the [report](https://github.com/rahul1947/SP09-Divide-and-Conquer/blob/master/sp9.pdf) for comparison.


|  Algorithms  |      Insertion Sort | Merge Sort (Take 1) | Merge Sort (Take 2) | Merge Sort (Take 3) | 
|-------------:|--------------------:|--------------------:|--------------------:|--------------------:| 
|      n       |         Time (mSec) |         Time (mSec) |         Time (mSec) |         Time (mSec) |
|              | Memory (used/avail) | Memory (used/avail) | Memory (used/avail) | Memory (used/avail) |
|      1000000 |                 Inf |                 158 |                 136 |                 107 |
|              |                     |         13 / 154 MB |         27 / 113 MB |            / 113 MB |
|      2000000 |                 Inf |                 337 |                 343 |                 239 |
|              |                     |         56 / 134 MB |         23 / 105 MB |         23 / 105 MB |
|      4000000 |                 Inf |                 773 |                 677 |                 569 |
|              |                     |         78 / 117 MB |        260 / 283 MB |        260 / 283 MB |
|      8000000 |                 Inf |                1692 |                1481 |                1295 |
|              |                     |        126 / 154 MB |        581 / 628 MB |        581 / 628 MB |
|     16000000 |                 Inf |                3674 |                3111 |                2793 |
|              |                     |        139 / 234 MB |      1282 / 1322 MB |      1282 / 1322 MB |
|     32000000 |                 Inf |                7681 |                6673 |                6048 |
|              |                     |        625 / 929 MB |      1597 / 1816 MB |      1355 / 1929 MB |
|     64000000 |                 Inf |               16766 |               14221 |               12475 |
|              |                     |       744 / 1135 MB |      1721 / 1929 MB |      1721 / 1929 MB |
|    128000000 |                 Inf |               33781 |               29780 |               27254 |
|              |                     |      1344 / 1753 MB |      1476 / 1653 MB |      1476 / 1653 MB |
|    256000000 |                 OME |                 OME |                 OME |                 OME |
|              |                 OME |                 OME |                 OME |                 OME |

NOTE:
- OME: Out of Memory Error
- For insertionSort(), with n = 1 Million, we got Time = 349689 msec, which is far more than 2 minutes as time limit. So, it is considered to be Infinite. And for rest of the input values, it is even more than the limit, hence they were considered Infinite as well. 
- Due to longer execution time for insertionSort(), *numTrials = 5* was set for it. And for rest of the mergeSort() versions we had *numTrials = 100*.
- Existing Processor: **Intel® Core™ i5-8250U CPU @ 1.60GHz × 8**. 
  Memory: **7.5 GiB**
- The threshold values were T2 = 99 and T3 = 99, as we computed above results. Later on, we found the optimal threshold values, which can be seen in the [report](https://github.com/rahul1947/SP09-Divide-and-Conquer/blob/master/sp9.pdf). 


#### B. Optional Task (individual): 

**Problem 2.**
   Use BigInteger class and write programs to computer f(n), the nth Fibonacci number.
   Implement the O(n) algorithm and the O(log n) algorithm. 
   
   Compare their running times for the following values of n: 1000, 10000, 100000. 
   
   Since printing the output takes a lot of time, stop the timer before starting to print the output.
   
   In each trial, run only one algorithm, for just one value of n.
   At the top of your source file, write the observations within /* ... */ comments.

**Solution:** - 