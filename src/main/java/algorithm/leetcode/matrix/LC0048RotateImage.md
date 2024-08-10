# LC0048RotateImage

## 1 Solution

1. swap row
2. swap symmetry

```text

1 2 3    7 8 9    7 4 1
4 5 6 -> 4 5 6 -> 8 5 2
7 8 9    1 2 3    9 6 3
            
5 1 9 11
2 4 8 10    ->
13 3 6 7    
15 14 12 16

```
### 1.1 Swap Row

```text
N = 3 * 3
0 row -> 2 row
1 row -> 1 row
2 row 重複了不要再算，會把上一個 0 row -> 2 row 又換回來

N = 4 * 4
0 row -> 3 row
1 row -> 2 row
2 row 重複了不要再算，會把上一個 1 row -> 2 row 又換回來

所以只要算到 < matrix.length/2 就好
```

### 1.2 Swap Symmetry

```text
主對角線不會動，不用 swap

N = 3 * 3
(0,0) 主對角線
(0,1) -> (1,0)
(0,2) -> (2,0)
(1,0) -> (0,1) 重複了不要再算，會把上一個 (0,1) -> (1,0) 又換回來
(1,1) 主對角線
(1,2) -> (2,1)

N = 4 * 4
(0,0) 主對角線
(0,1) -> (1,0)
(0,2) -> (2,0)
(0,3) -> (3,0)
(1,0) 重複
(1,1) 主對角線
(1,2) -> (2,1)
(1,3) -> (3,1)
(2,0) 重複
(2,1) 重複
(2,2) 主對角線
(2,3) -> (3,2)

每次 i 迭代的時候，j 都會從 i + 1 開始起算
例如第二列從 (1,2) 開始算即可、第三列從 (2,3) 開始算即可
```

## 2 Trick

1. print matrix:
   https://stackoverflow.com/questions/5061912/printing-out-a-2d-array-in-matrix-format

2. java swap
   https://blog.csdn.net/demo_yo/article/details/115984217