# Datastructures and Algorithms
Solving data-structures and algorithms problems in Java and Python. 

## Problems
Questions picked up from https://www.geeksforgeeks.org, https://www.hackerrank.com.

## Information
The programs have been divided according to data-structures as can be seen from
the packages created. Please do not use the archives folder for adding any code.
You can also add certain concepts implemented through code.
## How to run
Clone the repository using the following command:
```
$ git clone https://github.com/SiddharthaAnand/datastructures.git
```
Switch directory inside the cloned directory:
```
$ cd datastructures
```

<font size="4">Prerequisites</font>

Make sure gcc compiler is installed for c or c++ files or jdk is installed for java files.

In order to run any file with .java extension(BinarySearch.java), type the following command:
```
$ javac -d . BinarySearch.java
$ java arrays.BinarySearch
```
In order to run any file with .c extension(hello_world.c), type the following command:
```
$ gcc hello_world.c
$ hello_world
or
$ gcc -o hello hello_world.c
$ hello
```
In order to run any file with .cpp extension(two_point_algorithm.cpp), type the following command:
```
$ gcc -o two_point two_point_algorithm.cpp
$ two_point
```
The command will create a package named arrays in your local directory and put
the class file inside that directory.
You can add the class files inside .gitignore file.

<font size="4">Sub-directories</font>
<details>
<summary><font size="4">Archives</font></summary>
This repository consists of problems in data structures and algorithms related to problem solving.This folder also contains subdirectories,feel free to add algorithms related to graphs,linked lists and design patterns.
</details>


<details>
<summary><font size="4">Arrays</font></summary>
An array is a collection of data items, all of the same type, accessed using a common name. A one-dimensional array is like a list; A two dimensional array is like a table; The C language places no limits on the number of dimensions in an array, though specific implementations may.This folder has algorithms with the implementation of arrays.
</details>

<details>
<summary><font size="4">Binary_tree</font></summary>
a data structure in which a record is linked to two successor records, usually referred to as the left branch when greater and the right when less than the previous record.
</details>

<details>
<summary><font size="4">Disjoint_set</font></summary>
In computer science, a disjoint-set data structure is a data structure that tracks a set of elements partitioned into a number of disjoint subsets. It provides near-constant-time operations to add new sets, to merge existing sets, and to determine whether elements are in the same set.
</details>

<details>
<summary><font size="4">Graphs</font></summary>
In computer science, a graph is an abstract data type that is meant to implement the undirected graph and directed graph concepts from mathematics; specifically, the field of graph theory.
</details>

<details>
<summary><font size="4">Heaps</font></summary>
Heap is a special case of balanced binary tree data structure where the root-node key is compared with its children and arranged accordingly
</details>

<details>
<summary><font size="4">Problem Solving</font></summary>
Problem solving involves dealing with pragmatics, the way that context contributes to a meaning, scemantics and interpretation of the problem .This represents the ability to understand the goal of the problem and the rules that can be applied .
</details>

<details>
<summary><font size="4">Python</font></summary>
Python is an interpreted, object-oriented programming language and is used foe developing complex , scientific and numeric applications . It also facilitates data analysis and visualization .
</details>

<details>
<summary><font size="4">Queue</font></summary>
Queue is an abstract data structure, somewhat similar to Stacks. Unlike stacks, a queue is open at both its ends. One end is always used to insert data (enqueue) and the other is used to remove data (dequeue). Queue follows First-In-First-Out methodology, i.e., the data item stored first will be accessed first.
</details>

<details>
<summary><font size="4">Sorts</font></summary>
Data Structure - Sorting Techniques. Sorting refers to arranging data in a particular format. Sorting algorithm specifies the way to arrange data in a particular order. Most common orders are in numerical or lexicographical order.
</details>

<details>
<summary><font size="4">Stacks</font></summary>
Basic features of Stack. Stack is an ordered list of similar data type. Stack is a LIFO(Last in First out) structure or we can say FILO(First in Last out). push() function is used to insert new elements into the Stack and pop() function is used to remove an element from the stack.
</details>

<details>
<summary><font size="4">Strings</font></summary>
A string is generally considered a data type and is often implemented as an array data structure of bytes (or words) that stores a sequence of elements, typically characters, using some character encoding. String may also denote more general arrays or other sequence (or list) data types and structures.
</details>

<details>
<summary><font size="4">Trie</font></summary>
Trie is an efficient information reTrieval data structure. Using Trie, search complexities can be brought to optimal limit (key length).
</details>

<details>
<summary><font size="4">Vectors</font></summary>
Fundamentals of data structures: Vectors. A vector, in computing, is generally a one-dimensional array, typically storing numbers. Vectors typically have fixed sizes, unlike lists and queues. The vector data structure can be used to represent the mathematical vector used in linear algebra.
</details>


## Contribution
Feel free to refactor codes, report bugs, submit pull requests or just send a suggestion.

You can get a list of the repository authors and contributors at the [AUTHORS.md](AUTHORS.md) file.

## How to contribute
Any code that you add needs to have a proper directory name. The directory
names can be one of the following:
* name of the data-structure (arrays/)
* name of an algorithm/design paradigm (divide-and-conquer/)
Do add easy-to-understand comments at the beginning of the code to understand the 
question, input and output of the program.

## To-dos
- [X] Add a Utilities.java file which can be used anywhere in the repository.
- [X] Add other data-structures like Strings, Linked-lists and Trees. (In progress)
- [ ] Add advanced data-structures like Red-Black trees.
- [X] Add algorithms related to graphs.
- [ ] Add design patterns examples
- [X] Add language-specific usages of certain common classes(ex. Comparable and Comparator in Java).
