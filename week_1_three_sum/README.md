## Three_sum question

Quiz:In a array , picking up three items,the answer of adding these items is `0`.

a primary way to solve this problem is loop every item , finding out the solution.

## binary Search

a fast way to find the positions in a sorted array ;

        1 2 3 4 5 6 7 8 9

in above array,if we want to find the position of `3`:

1. finding the borders(start,end,mid) items of array(`5`);

2. comparing the number of target(`3`) and mid(`5`);

3. if target is bigger than mid , making  start equals mid+1(the minimum border)

else making end equals mid-1; doing 1,2 until find the target equals mid .

otherwise, just return -1(means couldn't find the target);

## the analyse of binary search;

    T(N) <= T(N/2) + 1 ;
    T(1) = 1;

> ※ 1+1/2+1/4+...+1/N = logN

so the Running time of `binary search` is `logN`;

## some theory about memory

#### primitive types
|-----|------|
| `boolean`| 1 |
|`byte`| 1|
|`char`| 2 |
| `int` |   4  |
| `float`  | 4 |
|`long`|4|
| `double` | 8 |

#### array
|----|----|
| `int[]` | 24 + `4*N` |
|`double[]`| 24 + `8*N` |

## Object in Java

* the Object overhead 16 bytes
* Reference. 8 bytes.
* Padding. Each object uses a multiple of 8 bytes.

for example :


        public class String //16bytes
        {
              private char[] value;//reference to array 8 + every item N*2+24
              private int offset; // 4
              private int count; // 4
              private int hash; // 4
              // padding .. the result of above items are 2*N + 60. and a object must the
              multiple of 8 so the padding is 64-60 = 8;
        }
