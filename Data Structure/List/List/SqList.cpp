//
// Created by Lucky on 21/5/2022.
//

# include "SqList.h"
# include <stdio.h>
# include <stdlib.h>



//定义线性表的最大长度
# define LIST_INIT_SIZE 20
//定义线性表储存空间增量
# define LIST_INCREMENT 10
//内存分配失败
# define OVERFLOW -2
//函数正确运行
# define OK 1
//函数不能正常运行
# define ERROR -1
//正确和错误
# define TRUE 1
# define FALSE 0



Status InitList(SqList *& L)
{
    /*初始化数组*/
    /*这里采用动态构建数组，方便内存管理*/
    L = (SqList*)malloc(sizeof(SqList *));//动态分配头指针
    L->Elem = (ElemType *)malloc(LIST_INIT_SIZE * sizeof(ElemType));//动态分配数组
    if (!L->Elem) exit(OVERFLOW);//当列表为空时，内存分配失败，给exit函数传入非0参数，表示程序非正常退出
    L->length = 0;//初始时，列表默认长度为0
    L->listSize = LIST_INIT_SIZE;//数组的最大长度

    return OK;
}


Status InsertElem(SqList*& L, int i, ElemType e)
{
    /*在列表L中的i位置插入元素e
    在合法值中插入元素	1<=i<=listSize+1*/
    if (i<1 || i> L->listSize + 1) return 0;

    if (L->length >= L->listSize)    //储存空间满时，增加分配
    {
        SqList newBase;
        newBase.Elem = (ElemType*)realloc(L->Elem, (L->listSize + LIST_INCREMENT) * sizeof(ElemType));
        if (!newBase.Elem) exit(OVERFLOW);//内存分配失败，程序退出
        L->Elem = newBase.Elem;
        L->listSize += LIST_INCREMENT;
    }
    ElemType* q;
    ElemType* p;
    q = &(L->Elem[i - 1]);
    for (p = &(L->Elem[L->length - 1]); p >= q; --p)
        *(p + 1) = * p;
    *q = e;
    ++L->length;
    return OK;
}


Status TraverseList(SqList*& L)
{
    /*遍历数组*/
    int i = ListLength(L);
    printf("列表元素为: ");
    for (int n = 1; n <= i; n++)
        printf("%d ", GetElem(L, n));
    printf("\n");
    return OK;
}


Status ListLength(SqList*& L)
{
    /*返回元素个数*/
    return L->length;
}


ElemType GetElem(SqList*& L, int i)
{
    /*返回索引为i的值*/
    return L->Elem[i - 1];
}


int LocateElem(SqList*& L, ElemType e)
{
    /*返回元素为e的索引*/
    //迭代列表中的元素，与元素e进行比较，如果相同，则返回元素的所在位置。否则返回0
    //int i;//用于储存元素所在位置的值，默认为0
    int n = 1;
    int len = ListLength(L);
    while (n >= 1 && n <= len){//当e元素与获取的元素相同时，返回位置
        if (e == GetElem(L, n))
            return n;
        n++;
    }
    return -1;
}


ElemType DeleteElem(SqList*& L, int i)
{
    /*删除数组中索引为i的元素*/
    //删除列表L中位置i的元素, 将删除位置后面的元素前移，且长度减1
    //判断给定位置是否合法
    if (i<1 || i > ListLength(L))
        return ERROR;
    ElemType* p = &L->Elem[i - 1];//p为待删除元素的地址
    ElemType e = *p;
    ElemType* q = &L->Elem[L->length - 1];//q为表尾的元素
    for (; p <= q; p++){//元素前移
        *p = *(p + 1);
    }
    L->length--;

    //将删除的元素返回
    return e;
}


Status DestroyList(SqList*& L)
{
    //将列表的内存进行释放
    free(L->Elem);
    return OK;
}


bool EmptyList(SqList*& L)
{
    if (ListLength(L) == 0)
        return TRUE;
    return FALSE;
}

