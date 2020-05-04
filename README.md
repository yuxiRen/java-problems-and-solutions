# Java Problems & Solutions

[![npm version](https://badge.fury.io/js/javascript-problems-and-solutions.svg)](https://badge.fury.io/js/javascript-problems-and-solutions)
[![Build Status](https://travis-ci.org/jeantimex/javascript-problems-and-solutions.svg?branch=master)](https://travis-ci.org/jeantimex/javascript-problems-and-solutions)
[![Coverage Status](https://coveralls.io/repos/github/jeantimex/javascript-problems-and-solutions/badge.svg?branch=code-coverage)](https://coveralls.io/github/jeantimex/javascript-problems-and-solutions?branch=code-coverage)
[![devDependencies Status](https://david-dm.org/jeantimex/javascript-problems-and-solutions/dev-status.svg)](https://david-dm.org/jeantimex/javascript-problems-and-solutions?type=dev)
[![code style: prettier](https://img.shields.io/badge/code_style-prettier-ff69b4.svg)](https://github.com/prettier/prettier)

A collection of Java problems and solutions for studying algorithms.

<!-- markdownlint-disable MD033 -->
<img alt="cover" src="https://user-images.githubusercontent.com/565300/33303581-c55a1280-d3b8-11e7-8e78-6879731416f1.png" width="600" />

## Table of Content
- [Data Structures](#data-structures)
- [Array](#array)
- [Matrix](#matrix)
- [String](#string)
- [Sorting](#sorting)
- [Heap](#heap)
- [Binary Search](#binary-search)
- [Binary Indexed Tree](#binary-indexed-tree)
- [Tree](#tree)
- [Graph](#graph)
- [Trie (Prefix Tree)](#trie-prefix-tree)
- [Backtracking](#backtracking)
- [Breadth First Search](#breadth-first-search)
- [Depth First Search](#depth-first-search)
- [Divide and Conquer](#divide-and-conquer)
- [Linked List](#linked-list)
- [Dynamic Programming](#dynamic-programming)
- [Greedy](#greedy)
- [Math](#math)
- [Sampling](#sampling)
- [Design](#design)

## Data Structures

## Problems

### Array
<!---
- [Two Sum](src/array/two-sum.js)
- [Three Sum](src/array/three-sum.js)
- [Median of Two Sorted Arrays](src/array/median-of-two-sorted-arrays.js)
- [Largest Rectangle in Histogram](src/array/largest-rectangle-in-histogram.js)
- [Plus One](src/array/plus-one.js)
- [Trapping Rain Water](src/array/trapping-rain-water)
- [Merge Intervals](src/array/merge-intervals.js)
- [Spiral Matrix](src/array/spiral-matrix.js)
- [Summary Ranges](src/array/summary-ranges.js)
- [Find All Numbers Disappeared in an Array](src/array/find-all-numbers-disappeared-in-an-array.js)
- [Game of Life](src/array/game-of-life.js)
- [Next Permutation](src/array/next-permutation.js)
- [Find Peak Element](src/array/find-peak-element.js)
- [Wiggle Sort](src/array/wiggle-sort.js)
- [Wiggle Sort II](src/array/wiggle-sort-ii.js)
- [Valid Triangle Number](src/array/valid-triangle-number.js)
- [Find Anagram Mappings](src/array/find-anagram-mappings.js)
- [K Empty Slots](src/array/k-empty-slots.js)
- [Flatten Nested List Iterator](src/array/flatten-nested-list-iterator.js)
- [Daily Temperatures](src/array/daily-temperatures.js)
- [Sliding Window Maximum](src/array/sliding-window-maximum.js)
- [Subarray Sum Equals K](src/array/subarray-sum-equals-k.js)
- [Subarray Product Less Than K](src/array/subarray-product-less-than-k.js)
- [Maximum Product of Three Numbers](src/array/maximum-product-of-three-numbers.js)
- [Maximum Product of Word Lengths](src/array/maximum-product-of-word-lengths.js)
- [Kth Largest Element in an Array](src/array/kth-largest-element-in-an-array.js)
- [Insert Interval](src/array/insert-interval.js)
- [Toeplitz Matrix](src/array/toeplitz-matrix.js)
- [Max Consecutive Ones](src/array/max-consecutive-ones.js)
- [Max Consecutive Ones II](src/array/max-consecutive-ones-ii.js)
- [Flippling an Image](src/array/flipping-an-image.js)
- [Number of Boomerangs](src/array/number-of-boomerangs.js)
- [Beautiful Arrangement II](src/array/beautiful-arrangement-ii.js)
- [Non-decreasing Array](src/array/non-decreasing-array.js)
- [Largest Number At Least Twice of Others](src/array/largest-number-at-least-twice-of-others.js)
- [Maximize Distance to Closest Person](src/array/maximize-distance-to-closest-person.js)
- [Positions of Large Groups](src/array/positions-of-large-groups.js)
- [Maximum Average Subarray I](src/array/maximum-average-subarray-i.js)
- [Shortest Unsorted Continuous Subarray](src/array/shortest-unsorted-continuous-subarray.js)
- [Relative Ranks](src/array/relative-ranks.js)
- [Sentence Similarity](src/array/sentence-similarity.js)
- [Sentence Similarity II](src/array/sentence-similarity-ii.js)
- [Magic Squares In Grid](src/array/magic-squares-in-grid.js)
- [Range Addition](src/array/range-addition.js)
- [Increasing Triplet Subsequence](src/array/increasing-triplet-subsequence.js)
- [Valid Tic-Tac-Toe State](src/array/valid-tic-tac-toe-state.js)
- [Maximum Size Subarray Sum Equals k](src/array/maximum-size-subarray-sum-equals-k.js)
- [Longest Mountain in Array](src/array/longest-mountain-in-array.js)
- [Continuous Subarray Sum](src/array/continuous-subarray-sum.js)
- [Contiguous Array](src/array/contiguous-array.js)
- [Merge Sorted Array](src/array/merge-sorted-array.js)
- [Product of Array Except Self](src/array/product-of-array-except-self.js)
- [Missing Number](src/array/missing-number.js)
- [Maximum Sum Subarray](src/array/maximum-subarray.js)
- [Maximum Product Subarray](src/array/maximum-product-subarray.js)
- [Evaluate Reverse Polish Notation](src/array/evaluate-reverse-polish-notation.js)
- [Shortest Word Distance](src/array/shortest-word-distance.js)
- [Shortest Word Distance II](src/design/shortest-word-distance-ii.js)
- [Shortest Word Distance III](src/array/shortest-word-distance-iii.js)
- [Sort Colors](src/array/sort-colors.js)
- [Find the Celebrity](src/array/find-the-celebrity.js)
- [Can Place Flowers](src/array/can-place-flowers.js)
- [K-diff Pairs in an Array](src/array/k-diff-pairs-in-an-array.js)
- [Container With Most Water](src/array/container-with-most-water.js)
- [First Missing Positive](src/array/first-missing-positive.js)
- [Missing Ranges](src/array/missing-ranges.js)
- [Majority Elements](src/array/majority-element.js)
- [Find All Duplicates in an Array](src/array/find-all-duplicates-in-an-array.js)
- [Third Maximum Number](src/array/third-maximum-number.js)
- [Split Array with Equal Sum](src/array/split-array-with-equal-sum.js)
- [Maximum Swap](src/array/maximum-swap.js)
- [Candy Crush](src/array/candy-crush.js)
- [Pascal's Triangle](src/array/pascals-triangle.js)
- [Pascal's Triangle II](src/array/pascals-triangle-ii.js)
- [Contains Duplicate II](src/array/contains-duplicate-ii.js)
- [Contains Duplicate III](src/array/contains-duplicate-iii.js)
- [H-Index](src/array/h-index.js)
- [H-Index II](src/array/h-index-ii.js)
- [Pour Water](src/array/pour_water.js)
- [Sort a stack using a temporary stack](src/array/sort-a-stack-using-a-temporary-stack.js)
--->


## Backers

Support us with a monthly donation and help us continue our activities. [[Become a backer](https://opencollective.com/java-problems-and-solutions#backer)]

## Sponsors

Become a sponsor and get your logo on our README on Github with a link to your site. [[Become a sponsor](https://opencollective.com/java-problems-and-solutions#sponsor)]

## Support

<!-- markdownlint-disable MD033 -->
<a href="paypal.me/ritayuxi">
  <img alt="But Me a Coffee" src="https://az743702.vo.msecnd.net/cdn/kofi4.png?v=0" width="200" />
</a>

## LICENSE

MIT License

Copyright (c) 2020 Yuxi Ren

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
