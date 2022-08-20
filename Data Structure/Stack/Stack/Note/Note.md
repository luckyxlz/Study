## 栈的基本概念

##### 栈：

只允许在一端进行插入或删除操作的线性表

##### 空栈：

不含任何元素的空表

##### 特性：

先进后出

![栈](C:\Users\Lucky\Documents\STUDY\Backend Development\Data Structure\Stack\Stack\Note\栈.png)

n个不同元素入栈。出栈元素不同排列的个数为
$$
1/(n+1)C^n_{2n}
$$

#### 基本操作

InitStack(&S)：初始化一个空栈

StackEmpty(S):	判断一个栈是否为空

Push(&S,x)：进栈

Pop(&S,&x)：出栈

GetTop(S,&x)：读栈顶元素

DestroyStack(&S)：销毁栈，并释放栈S占用的存储空间



##### 将一个递归算法改为对应的非递归算法，通常需要使用栈