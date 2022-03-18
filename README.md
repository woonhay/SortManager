# SortManager

The program include 5 sorting method:
1. BinarySorter
2. BubbleSorter
3. InsertionSorter
4. MergeSorter
5. QuickSorter
6. SelectionSorter

The project include below programs:
Java:
  1. start
    - App: The start of the program.
    - SortLoader: Body of the program.
    - SortFactory: Control which sorter will be used.
  
  2. display
    - DisplayManager: Control the display of the program.
  
  3. exception
    - xxxException * 2: Handle exception.

  4. sorter
    - xxxSorter * 6: Sort the array.
    - binary_tree
      - BinaryTree: Interface of binary tree.
      - Tree: Control the action of binary tree.
      - Node: Node of binary tree   

Test:
  1. PerformanceTester: Test the performance of each sorter.
  2. SortTester: Test whether the sorter can handle arrays in different case.

Remark:
1. Each of the individual values in the array between -1000 and +1000
2. Max value of array length should be 1000
3. It will keep asking user until user give the correct input
4. Added logger to each sorter
