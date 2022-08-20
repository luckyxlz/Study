#include <iostream>
#include "LinkList.h"


int main()
{
    Linklist* L;//声明链表L
    InitList(L);//初始化链表

    //采用尾插法插入a,b,c,d,e
    InsertList(L, 1, 1);
    InsertList(L, 2, 2);
    InsertList(L, 3, 3);
    InsertList(L, 4, 4);
    InsertList(L, 5, 5);

    TraverseList(L);//遍历链表

    printf("链表长度为 %d\n", LengthLinkList(L));//输出链表长度

    //判断链表是否为空
    if(EmptyLinkList(L)){
        printf("链表为空\n");
    }
    else{
        printf("链表非空\n");
    }

    printf("%d\n", GetElem(L, 3));//输出单链表的第三个元素

    printf("%d\n", LocateElem(L, 1));//输出元素a的逻辑位置

    InsertList(L, 4, 5);//在第4个元素位置插入元素4

    TraverseList(L);//输出链表

    DeleteElem(L, 3);//删除单链表的第三个元素

    TraverseList(L);//输出链表

    DestroyList(L);//释放链表

}