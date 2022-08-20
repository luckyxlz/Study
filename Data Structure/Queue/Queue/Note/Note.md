## 队列

### 基本概念

##### 队列：

只允许在表的一端进行插入，而在表的另一端进行删除

##### 入队：

##### 出队：

##### 特性：

先进先出

![队列](C:\Users\Lucky\Documents\STUDY\Backend Development\Data Structure\Queue\Queue\Note\队列.png)

### 基本操作

InitQueue(&Q)：初始化队列

QueueEmpty(Q)：队列为空

EnQueue(&Q,x)：入队

DeQueue(&Q,&x)：出队

GetHead(Q,&x)：读队头元素



### 循环队列

#### 定义：

把存储队列元素从逻辑上视为一个环

队首指针进1： Q .front = (Q.front +1 ) % MaxSize

队尾指针进1： Q. rear = (Q. rear + 1) % MaxSize

队列长度：(Q. rear + MaxSize - Q.front) % MaxSize



队空条件： Q .front == Q .rear

牺牲一个单元来区分队空和队满，入队时少用一个队列单元

队满条件： (Q. rear +1) % MaxSize == Q.frontkklllllllllllllllllllllllllllbvqq