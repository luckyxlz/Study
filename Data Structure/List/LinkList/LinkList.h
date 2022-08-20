//
// Created by Lucky on 21/5/2022.
//

# ifndef LINKLIST_LINKLIST_H
# define LINKLIST_LINKLIST_H
# include <stdio.h>
# include <stdlib.h>
# define ElemType char
# define Status int

//内存分配失败
# define OVERFLOW -2
//函数正确运行
# define OK 1
//函数不能正常运行
# define ERROR -1



/*链表结构体定义*/
typedef struct Node {
    ElemType elem;          /*数据域*/
    struct Node * next;/*指针域*/
}Linklist, *PLinklist;

/*函数声明*/
Status InitList(Linklist*& L);
Status InsertList(Linklist *& pHead, int pos, ElemType val);
Status TraverseList(Linklist*& L);
bool EmptyLinkList(Linklist*& L);
int LengthLinkList(Linklist*& L);
ElemType GetElem(Linklist*& L, int pos);
int LocateElem(Linklist*& L, ElemType elem);
ElemType DeleteElem(Linklist*& L, int pos);
Status DestroyList(Linklist*& L);

#endif //LINKLIST_LINKLIST_H
