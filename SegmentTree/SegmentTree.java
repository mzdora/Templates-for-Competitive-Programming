package com.mzdora;

interface Merger<E> {
    E merge(E a,E b);
}

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegmentTree(E[] arr,Merger merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++)
            data[i] = arr[i];
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0,0,data.length-1);
    }

    public void buildSegmentTree(int treeIndex,int l,int r){
        if(l==r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        int mid = (l+r)/2;
        buildSegmentTree(leftIndex,l,mid);
        buildSegmentTree(rightIndex,mid+1,r);
        tree[treeIndex] = merger.merge(tree[leftIndex],tree[rightIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }

    public E query(int queryL,int queryR){
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegals");
        return query(0,0,data.length-1,queryL,queryR);
    }

    private E query(int treeIndex,int l,int r,int queryL,int queryR){
        if(l == queryL && r == queryR){
            return tree[treeIndex];
        }
        int mid = (l+r)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL>=mid+1)
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        if(queryR<=mid)
            return query(leftTreeIndex,l,mid,queryL,queryR);
        E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
        E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return merger.merge(leftResult, rightResult);
    }

    public void set(int index,E e){
        if(index<0||index>=data.length)
            throw new IllegalArgumentException("index is illegal");
        data[index] = e;
        set(0,0, data.length-1, index, e);
    }

    private void set(int treeIndex,int l,int r,int index,E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l+(r-l)/2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        if(index >= mid + 1)
            set(rightIndex,mid+1,r,index,e);
        else
            set(leftIndex,l,mid,index,e);
        tree[treeIndex] = merger.merge(tree[leftIndex],tree[rightIndex]);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i=0;i< tree.length;i++){
            if(tree[i]!=null){
                res.append(tree[i]);
            }else{
                res.append("null");
            }
            if(i != tree.length-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
