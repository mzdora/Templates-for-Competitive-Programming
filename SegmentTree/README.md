## SegmentTree实现

## 开始

如何构造一颗SegmentTree:

```java
        SegmentTree<Integer> segTree = new SegmentTree<Integer>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
```
该SegmentTree使用了泛型以及merge接口,merge表示区间之间的关系。
在这里 *a+b* 表示区间求和。

## 接口

```java
public int getSize() //线段树的节点个数
public E get(int index) //求出索引对应的元素
public E query(int queryL,int queryR) //通过左边界和右边界查询区间的值
public void set(int index,E e) //设置索引index的值为e
public String toString() //打印
```

### 使用示例

这里通过构建Main的方法来对数据结构进行测试:

```java
    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree = new SegmentTree<Integer>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segTree);
        System.out.println(segTree.query(1,2));
        segTree.set(0,5);
        System.out.println(segTree);
    }
```

结果输出:

```
[-3,1,-4,-2,3,-3,-1,-2,0,null,null,-5,2,null,null,null,null,null,null,null,null,null,null,null]
3
[4,8,-4,5,3,-3,-1,5,0,null,null,-5,2,null,null,null,null,null,null,null,null,null,null,null]
```


## 贡献

Mzdora
