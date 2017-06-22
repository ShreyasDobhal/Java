import java.util.*;
class MinHeap
{
    private int capacity=10;
    private int size=0;
    int[] items=new int[capacity];
    private int getLeftChildIndex(int parentIndex)
    {
        return 2*parentIndex+1;
    }
    private int getRightChildIndex(int parentIndex)
    {
        return 2*parentIndex+2;
    }
    private int getParentIndex(int childIndex)
    {
        return (childIndex-1)/2;
    }
    private boolean hasLeftChild(int index)
    {
        return getLeftChildIndex(index)<size;
    }
    private boolean hasRightChild(int index)
    {
        return getRightChildIndex(index)<size;
    }
    private boolean hasParent(int index)
    {
        return getParentIndex(index)>=0;
    }
    private int leftChild(int index)
    {
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index)
    {
        return items[getRightChildIndex(index)];
    }
    private int parent(int index)
    {
        return items[getParentIndex(index)];
    }
    private void swap(int indexOne,int indexTwo)
    {
        int tmp=items[indexOne];
        items[indexOne]=items[indexTwo];
        items[indexTwo]=tmp;
    }
    /**
     *  function to ensure that over flow does not occur
     */
    private void ensureExtraCapacity()
    {
        if (size==capacity)
        {
            items=Arrays.copyOf(items,capacity*2);
            capacity*=2;
        }
    }
    /**
     *  returns the topmost element (also the smallest)
     */
    public int peek()
    {
        if (size==0)
            throw new IllegalStateException();
        return items[0];
    }
    /**
     *  removes the topmost element
     */
    public int poll()
    {
        if (size==0)
            throw new IllegalStateException();
        int item=items[0];
        items[0]=items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    public void add(int item)
    {
        ensureExtraCapacity();
        items[size]=item;
        size++;
        heapifyUp();
    }
    public void heapifyUp()
    {
        int index=size-1;
        while (hasParent(index)&&parent(index)>items[index])
        {
            swap(getParentIndex(index),index);
            index=getParentIndex(index);
        }
    }
    public void heapifyDown()
    {
        int index=0;
        while (hasLeftChild(index))
        {
            int smallerChildIndex=getLeftChildIndex(index);
            if (hasRightChild(index)&&rightChild(index)<leftChild(index))
            {
                smallerChildIndex=getRightChildIndex(index);
            }
            if (items[index]<items[smallerChildIndex])
            {
                break;
            }
            else
            {
                swap(index,smallerChildIndex);
            }
            index=smallerChildIndex;
        }
    }
    public static void main()
    {
        MinHeap data = new MinHeap();
        for (int i=0;i<10;i++)
            data.add((int)(Math.random()*10));
        for (int i=0;i<10;i++)
            System.out.println(data.poll());
    }
}