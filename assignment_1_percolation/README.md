[reference](http://coursera.cs.princeton.edu/algs4/assignments/percolation.html)

## percolation说明

percolation是一个利用`union find`来进行图像表述的算法。

现有一个`N*N`的表格,白色和黑色用来区分是否存在连接(类似迷宫),现水流从最上方开始倒入，能够到达最底端则说明

这个表格是percolate的。

如图：

!(http://coursera.cs.princeton.edu/algs4/assignments/percolates.png)[percolation]


## 解法

我们使用之前的[union-find](https://github.com/vinthony/vinthony.github.io/issues/4)来解决这个问题

1. 创建`N*N`的数组来存储每个格子对应的编号，创建`N*N`的数组来个每个格子赋予是否开启的状态

2. 创建`open(x,y)`函数来使`x`行`y`列的数据进行开启

3. 开启的同时，检查上下左右的元素是否处于开启状态，如开启则进行`union`操作，注意检查边界。

4. 使用`isOpen(x,y)`来判断该点是否开启。

5. 使用`isFull(x,y)`来判断该点是否位于`流水`中

6. 使用`isPrecolate()`来判断上下是否连接。

在这个解法中，`isPrecolate()`函数将会遍历第一排和最后一排来寻找是否有相同根的节点。遍历需要耗费大量的时间。

#### 优化1

在整个图的上方，假设出一个根节点，让他变成第一排的根，在整个图的下方，假设出一个根节点，成为最末的跟,如果这两个根`union`

则可以认定此图连接。

#### 疑问1

`open`函数由于边界效应分得比较繁琐，是否有更好的解决办法？

#### 疑问2

`底部的根`连接之后，会产生底部所有的空隙变成`流水`的情况，我在代码中使用了底部遍历的方法，是否还有更好解决方法。

#### 疑问3

我在此图中新开了一个数组来解决表示格子是否开启的状态，能否有更高效的办法？