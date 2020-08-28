## Trie实现

## 开始

如何构造一颗Trie:

```java
        Trie trie = new Trie();
```

## 接口

```java
public void add(String word) //往Trie里添加字符串word
public boolean contains(String word) //查询Trie中是否包含单词word
public boolean isPrefix(String prefix) //查询是否在Trie中有单词为prefix的前缀
```

### 使用示例

这里通过构建Main的方法来对数据结构进行测试:

```java
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("nihao");
        trie.add("ni");
        System.out.println(trie.contains("nihao"));
        System.out.println(trie.contains("hello"));
        System.out.println(trie.isPrefix("n"));
    }
```

结果输出:

```
true
false
true
```


## 贡献

Mzdora
