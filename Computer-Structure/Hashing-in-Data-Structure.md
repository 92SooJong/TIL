---
title: "Hashing in Data Structure"
date: 2022-11-18T22:00:00+09:00
tags: ["HashMap","CS","English"]
---

[https://www.scaler.com/topics/data-structures/hashing-in-data-structure/](https://www.scaler.com/topics/data-structures/hashing-in-data-structure/)

Time complexity - O(log n)

Space complexity - O(n)

# Key - Value
Key - An Identifier to uniquely identify the data(entity)

Value - The actual Entity which we want to stroe.

This mapping helps to link easier/smaller `key` to a particular `value`

Hashing performs a transformation on this key, to return an Integer value which can be used as the memory address to place this Key-Value at.

On non-integeral keys, there are 2 steps involved.

1. Transform non-integral key to integral value
2. perform hashing

# What is hasing In data Structure
Efficiently finding, storing data in an array.

key as input and returns us the memory address

# Hash Table in Data Structure
In data structure, `hash tables` are used for storing the key-value pairs.

Instead of directly storing the keys in hash table, hasing comes into plcy, which runs the hash function converts these big Keys to the integer value <= size of Array. this Integer value is called `hash index`.

`hash function` creates `hash index`. hash function have to return distinct indexes for every input.

# Hashing Function in DBMS
The memory location where these records are stored is known as `data buckets` or `data blocks`.

Most of the time, the hash function uses the primary key to generate the address of the data block.

# Ways to Calculate Hashing in Data Structure

## 1. Division Method

Division method: HashFunction = Key % size

E.g. if key=15, then 15%10=5 and 5<10 so we can insert this Data with key=15 at the 5th index of the array of size 10.

## 2. Multiplication Method

```
h(k) = floor( n( kA mod 1 ) )
```
k is key

A is constant value between 0 and 1

```
k=123
n=100
A=0.618033 (Has to be between 0 and 1)
h(123) = 100 (123 * 0.618033 mod 1)
= 100 (76.018059 mod 1)
= 100 (0.018059)
= 1
```

## 3. Universal Hashing
Universal hashing means that we don’t use a fixed hash function, but there is a family of hash functions from which we can randomly pick any hash function.

## 4. Folding Method

By folding we mean that, if the array size = 100, that means 2-digit numbers can only fit inside it, so we fold the given key in parts of 2.
I.e. if Key=20574 Then we will fold it in parts of 2, which will be:
20, 57, and 4.
So to get an index < 100 from these parts, we can sum these up i.e.
20 + 57 + 4 = 81. So 81 is the index where this Key=20574 can be placed.

Please note that there can be cases where even after folding we get a number > size e.g. Key=56571 then breaking it down in parts of 2= 56+57+1=114

Now we cant place this Data at index 114 inside the array of size 100, so we can either apply this algorithm again or can use the Division method(mostly used in such scenarios) to get 114%100=14
So this Data can be placed at the 14th Index of this array.

## 5. Mid Square Method

In this method, we basically square the given number and pick N middle numbers in that squared number, to find the index

Let’s take N=2 and Array size=11.
Hash(93) = 93^2 = 8649. Picking N(=2) middle elements i.e. 64 Now since 64>11, so we can apply the Division method to get 64%11=9.
So 93 can be placed at 9th Index in the array of size 11.
