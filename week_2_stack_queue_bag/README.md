# Stack

Stack is a first in last out sequence.

## the basic way to create stack.

taking stack as a  linked-list.

so :

        Node{
            Node next;
            String item;
        }

it's a `String Node`. the `next` pointer to the next `Node`.

As for the `first-in-last-out` principle:

 when `popping`:

    * store the value of lastest node.
    * make the lastest node point to null
    * return the stored value.

 when `pushing`:

    * store the lastest node;
    * create a new node,making the value of item equals pushing string,making the next Node point to the lastest node;

> you can view the completed code in `/week_2_stack_queue_bag/src/main/StackOfString.java`.

#### the memory usage of linked-list

|       items   |     usage(bytes) |
|---------------|-------------------|
|object overhead|         16        |
|innerclass overhead|      8        |
|reference to String|      8        |
|reference to Node  |      8        |

if we have `N` nodes, the memory of these object will consume `40N`.

## Fixed Array.

using an array to store the list;

* `pop()` remove the `arr[N-1]`

* `push()` add the string to `arr[N]`

> you can view the completed code in `/week_2_stack_queue_bag/src/main/FixedStringOfStack.java`.

#### the problem of fixed array.

1. the array's length is fixed , the overflow and underflow will happen.

2. **Loitering** we must reclaim the `arr[N] to null` to make sure that garbage collector is working.

3. we allowed null item to be insert.

## Resize Array

* if the array is full , create a new array of **twice** the size,and copy items.

* if we `pop` a lot of items(currentNodes`<`LengthOfNodes/4),then resizing the array to half.

> you can view the completed code in `/week_2_stack_queue_bag/src/main/ResizeArrayStackOfString.java`.

#### the memory usage of resize array:

* 8 bytes (reference to array)
* 24 bytes (array overhead)
* 8 bytes × array size
* 4 bytes (int)
* 4 bytes (padding)

~`8N` when fulling.

~`32N` when 1/4 fulling.

# Queue

queue is a `first-in-first-out` sequence.

we will just explain the Node version of queue;

when `enqueue`:

    * store the lastNode
    * making the lastNode equals new Node;
    * making the lastNode.item equals enqueued value;
    * checked the array ,if empty,making last equals first else making the stored.next equals newLastNode;

when `dequeue`:

    * store the value of firstValue;
    * making the first equals first.next;
    * (checked the array, if empty,last equals null) return the stored value;

> you can view the completed code in `/week_2_stack_queue_bag/src/main/QueueOfString.java`.

# Generics

        StackOfObject s = new StackOfObject();
        Apple a = new Apple();
        a = (Apple)(s.pop()); //it works,but we do not recommend to do this,it causes run-time error
        //difficult to find.

a good example:

        Stack<Apple> s = new Stack<Apple>();
        Apple a = new Apple();
        s.push(a);
this may cause a compile-time error, which is easy to find.

> you can view the completed code in `/week_2_stack_queue_bag/src/main/Stack.java`.

# Iterators

make Stack implement the `java.lang.Iterable` interface.

* `Iterable` has a method that returns an `Iterator`
* `Iterator` has a method `hasNext()` and `next()`

# Bag

 Adding items to a collection and iterating (when order doesn't matter).

 how to write:Stack (without pop) or queue (without dequeue)