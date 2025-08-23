# LinkedList Day 1. Started at 17:39 PM 22-Aug-2025

A **Linked List** is a fundamental linear data structure in computer science that consists of a sequence of nodes. Each node contains two parts:

1. **Data**: The value or information stored in the node.
2. **Reference (or Link)**: A pointer or reference to the next node in the sequence.

Unlike arrays, linked list elements are *not* stored in contiguous memory locations. Instead, each node points to the next node, which allows for efficient insertion and deletion of elements without shifting the entire structure.

### Key Features of Linked Lists:
- **Dynamic Size**: Can grow or shrink during runtime easily.
- **Efficient Insertions/Deletions**: Adding or removing nodes doesn't require shifting other elements, unlike arrays.
- **Sequential Access**: Elements must be accessed sequentially from the head node; random access is not possible.
- **Types**:
    - **Singly Linked List**: Nodes have a reference to the next node only.
    - **Doubly Linked List**: Nodes have references to both the next and previous nodes.
    - **Circular Linked List**: The last node points back to the first node, forming a circle.

### Advantages over Arrays:
- Flexible size.
- Faster insertions and deletions (constant time operations when pointers are used efficiently).
- No memory wastage from fixed size allocation.

### Limitations:
- No direct or random access to elements (unlike arrays).
- Extra memory per node to store pointers.
- Slower traversal compared to arrays due to pointer chasing.

***

#### singly linked list

This type of linked list is called a singly linked list because each node points to the next node in the sequence.

