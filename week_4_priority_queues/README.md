## priority queue

there are many ways to implements priority queue

some straight-forward ways ,for example:

* **ORDER QUEUE** when adding a new item to the queue, sorting the queue.
* **UNORDER QUEUE** when we want to get a item from priority queue, sorting the queue,and dequeue it .

there is the efficiency of this two method:


type|INSERT|DEL|FIND MAX
-----|------|------|------
ORDER QUEUE| N| 1 | 1
UNORDER QUEUE| 1| N| N

Is there have more efficient way to do this.

we can use binary heap to  deal with priority queue:

type|INSERT|DEL|FIND MAX
-----|------|------|------
HEAP| logN| logN|1

#### what is maximum/minimum heap
binary heap is a data structure that base on full binary tree.
the rule of full binary tree is every node has ONLY two child,except the last layer of the tree
just like this:
```
            a
     b              c
d       e       f       g
```

#### maximum/minimum heap
the basic theory of binary heap is we can build a binary tree that every father node is bigger(smaller) than
both their children.
there are two main method of maximum(minimum) heap:
#### swim

when we adding a new item, we want to put it in the current position.

swim is a good way to do that,using max heap as an example:
* adding the current to the last node
* check if its father is bigger than this node
* if father is smaller that this node, exchange this two node
* checkout the new positon's father recusively

#### sink
when we delete(or dequeue) an element(k),and we want the new queue still a binary heap:
* compare the current item with two their children
* if there is child bigger than father node, exchange these two elements.
* if two elements all bigger than father node, exchange father node with bigger one.
* if children are all smaller than their father, it's stable.


#### heap sort

Heap sort is a good sort algorithm that base on maximum/minimum heap
It's the in-place algorithm and cost `logN`.
But,heap sort is not wildly use in practical,there are still some shortage for heap sort:

* Inner loop is quiet longer than quick sort
* Make poor of usage of cache
* Not stable


#### IMPROVEMENT intro sort

it is used in `C++ STL`.
it used quick sort in the beginning and when the stack depth exceeds 2lgN,cutting off to heap sort,
and if N = 16 ,cutting off to insertion sort.
