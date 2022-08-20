//
// Created by Lucky on 21/5/2022.
//

#ifndef LIST_SQLIST_H
#define LIST_SQLIST_H
# include <stdio.h>
# include <stdlib.h>

# define ElemType int
# define Status int

//列表元素的定义
typedef struct {
    ElemType* Elem; //储存空间基地址
    int length;//当前长度
    int listSize;//当前分配的储存容量
}SqList;

//初始化列表
Status InitList(SqList*&);
//迭代列表
Status TraverseList(SqList*&);
//释放/删除列表
Status DestroyList(SqList*&);
//插入元素
Status InsertElem(SqList*&, int, ElemType);
//获取列表的长度
Status ListLength(SqList*&);
//获取指定位置的元素
ElemType GetElem(SqList*&, int);
//获取指定元素的指定位置
int LocateElem(SqList*&, ElemType);
//删除指定位置的元素
ElemType DeleteElem(SqList*&, int);
//判断列表是否为空
bool EmptyList(SqList*&);

#endif //LIST_SQLIST_H
