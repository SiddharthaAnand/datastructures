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
In order to run any file(BinarySearch.java), type the following command:
```
$ javac -d . BinarySearch.java
$ java arrays.BinarySearch
```
The command will create a package named arrays in your local directory and put
the class file inside that directory.
You can add the class files inside .gitignore file.

## Utilities.java
This java file contains the typical common methods that are required in almost
every code that is written in this repository. For example, taking an input,
printing on a new line or printing text along with a data-structure.

## Stub.java
This class contains method to generate a random valued array, given the size and 
the max value you want in the array. It uses the built-in Random class to generate
the values. It also has a method to print the values of a given input array along
with a text given as formal parameter.

## Contribution
Feel free to refactor code, report bugs, submit pull requests or just send a suggestion.

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
- [ ] Add algorithms related to graphs.
- [ ] Add design patterns examples
- [ ] Add language-specific usages of certain common classes(ex. Comparable and Comparator in Java).