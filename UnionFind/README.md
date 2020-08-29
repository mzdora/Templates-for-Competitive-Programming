## UnionFind实现

## 开始

如何构造一颗UnionFind:

```java
        UF uf = new UnionFind(int size); //size表示UnionFind的大小
```

## 接口

```java
public int getSize() //查询UnionFind的元素个数
public boolean isConnected( int p , int q ) //查看元素p和元素q是否所属一个集合
public void unionElements(int p, int q) // 合并元素p和元素q所属的集合
```

### 使用示例

这里通过构建Main的方法来对数据结构进行测试:

```java
    public static void main(String[] args) {
        int[][] res = {{1,2},{2,4},{6,7},{3,4}};
        UF UF = new UnionFind(10);
        for(int i=0;i<res.length;i++){
            UF.add(res[i][0],res[i][1]);
        }
        System.out.println(UF.isSystem(1, 6));
        System.out.println(UF.isSystem(1, 4));
    }
```

结果输出:

```
false
true
```


## 贡献

Mzdora
