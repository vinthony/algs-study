

# About Union Find

Union Find is a algorithm to find 2 point union or not

reference:

[coursera - algorithms part 1](https://class.coursera.org/algs4partI-007/lecture)


[my code](https://github.com/vinthony/algs-study.git)

# Example

        0 1 2 3 4 5 6 7 8 9
        union(2,3)
        union(0,3)
        union(4,5)
        checked(0,9) //false
        checked(0,3) //true

# Structure

Define a `interface` to abstract this problem.it have 2 abstract method.

        public boolean checked(int a,int b);
        public void union(int a,int b);

* `checked()` is a method to check if `a` and `b` is connected.
* `union()` is a method to union two point.

# QuickFind

we can update all the connected items to the same value.

so in this strategy, we just need one step to check  two integer connected or not.

and in `union` step, we choose loop all the array to update the new values.

Obviously,loop the whole array will cost more time.

|algorithm| initialize | union | find |
|---------|------------|-------|------|
|QuickFind|      n     |   n   |   1  |

> you can view this code in `src/main/QuickFind.java`.

#QuickUnion

Quick union is another strategy.

we can use the array's items which has been connected to build a tree.

if two integer has the same root , we consider this two integer `unioned`.

in `union` step, we just need to find the roots of two integer and union the roots.

there is only a step to find the root of the tree.

|algorithm| initialize | union | find |
|---------|------------|-------|------|
|QuickFind|      n     |   n   |   1  |
|QuickUnion|     n     |   n(finding roots)   |   n  |

> in the worse case(which means there is only one line and the item in the bottom of the tree),
QuickUnion will need more time to find.


# Compare

### QuickFind defect:

* union too expensive.

### QuickUnion defect:

* find too expensive, and trees are tall.


# Improvement

### weighting

It is a good idea to add weighting to trees.

if one tree is tall and another is not , we can union the taller tree into the shorter tree,

which would keep tree flat.

|algorithm| initialize | union | find |
|---------|------------|-------|------|
|QuickFind|      n     |   n   |   1  |
|QuickUnion|     n     |   n(finding roots)   |   n(worse)  |
|weighted QU|     n     |   lgn(finding roots)   |   lgn(worse)  |


> you can view this code in `src/main/QuickUnion.java`.

### path compression

the root finder is too expensive, we can compress the path.

Everytime when we add a computing a new item , making all the checked leaves point to the root directly.

add the small root to the grandparent of another root. this move works too.


# Summary

M union-find operations on a set of N objects

|algorithm| worse time |
|---------|------------|
|QuickFind|      `MN`     |
|QuickUnion|     `MN`    |
|weighted QU|     `N+MlogN`     |
|QU+path compression| `N+MlogN` |
|weighted QU+path compression| `N+Mlg*N` |

