package com.applilcation.answer;

import java.util.Arrays;


public class MyQueue<E> {
    private int maxSize;// 队列容量
    private E queue[];// 队列
    private int head;// 头指针
    private int tail;// 尾指针
    private int nItems;// 元素个数

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = (E[]) new Object[maxSize];
        this.head = 0;// 移除元素一般从下标0开始，头指针指向待移除的元素（也就是移除元素的下标）
        this.tail = -1;// 一般设为-1，当添加元素后，尾指针数值为当前已经添加的元素的下标位置
        this.nItems = 0;
    }




    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return nItems == 0;
    }

    /**
     * 队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return nItems == queue.length;
    }

    /**
     * 添加从队尾开始
     *
     * @param e
     */
    public void add(E e) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        // 当队尾指针已经到达数组的末尾，但数组却未填满（数组前面有空缺），此时又从起始位置添加元素
        if (tail == maxSize - 1) {
            tail = -1;
        }
        queue[++tail] = e;
        nItems++;
    }

    public E get(int postion){
        if(head+postion<maxSize){
            return queue[head+postion];
        }else {
            return queue[head+postion-maxSize];
        }
    }


    /**
     * 删除从对头开始
     *
     * @return
     */
    public E remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        // 当对头指针到达数组末尾，但数组个数却不为空（说明数组前面还有元素），此时又从起始位置删除元素
        if (head == maxSize) {
            head = 0;
        }
        nItems--;
        return queue[head++];
    }

    /**
     * 获取对头元素
     *
     * @return
     */
    public E getHead() {
        return queue[head];
    }

    /**
     * 获取队尾元素
     *
     * @return
     */
    public E getTail() {
        return queue[tail];
    }

    /**
     * 队列元素个数
     *
     * @return
     */
    public int size() {
        return nItems;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

}