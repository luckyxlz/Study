//
// Created by Lucky on 21/5/2022.
//

#include "LinkList.h"
#include <stdio.h>
#include <stdlib.h>



Status InitList(Linklist*& L)
{
    /*链表初始化*/
    L = (Linklist*)malloc(sizeof(Linklist));//动态分配内存
    if (L == NULL){//判断内存是否分配成功
        return OVERFLOW;
    }
    else {//将链表头节点与指向下一个的指针指定为空
        L->elem = NULL;//元素头节点元素为空
        L->next = NULL;//将头节点的next置空
    }

    return OK;
}

Status InsertList(Linklist *& pHead, int pos, ElemType val)
{
    /*在链表中的索引pos插入元素val*/
    if (pHead == NULL || pos < 1 || pos > LengthLinkList(pHead) + 1){//若链表未初始化或者插入的位置不合法则返回ERROR
        return ERROR;
    }
    PLinklist p = pHead;//为了不修改头指针故对指针进行拷贝
    int i = 0;//用来协助循环到插入元素的前一个

    while (p != NULL && i<pos-1){//使p指向待插入元素的前一个
        p = p->next;
        i++;
    }

    PLinklist pNew = (PLinklist) malloc(sizeof(Linklist));//为新节点分配内存空间

    /*判断内存是否分配成功 */
    if (pNew == NULL){
        return OVERFLOW;
    }
    else {//插入元素
        pNew->elem = val;
        pNew->next = p->next;
        p->next = pNew;
        return OK;
    }
}

Status TraverseList(Linklist*& L)
{
    /*迭代链表*/
    PLinklist temp = L;//对链表进行操作，为了防止修改头节点地址，对链表头节点元素进行拷贝
    if (L == NULL || EmptyLinkList(L)){//若链表为空或者链表未初始化返回提示
        printf("链表为空\n");
    }
    else {
        printf("单链表的内容为: ");
        while (temp->next != NULL) {//当链表不为空且下一个元素不为空进行遍历
            temp = temp->next;//temp每次指向下一个元素
            printf("%d ", temp->elem);
        }
        printf("\n");
    }
    return OK;
}

bool EmptyLinkList(Linklist*& L)
{
    /*判断链表是否为空*/
    if (L->next == NULL)
    {
        return true;//链表为空，返回true;
    }
    else {
        return false;//链表不为空，返回false;
    }
}

int LengthLinkList(Linklist*& L){
    /*返回链表长度*/
    if (EmptyLinkList(L)){
        return 0;
    }
    else {//链表非空情况下的讨论
        int count = 1;//count为链表指向元素的位置，由于非空则默认指向1
        PLinklist temp = L;//为了不修改原链表的首地址，故对链表进行拷贝
        temp = temp->next;//指向第一个元素
        while (temp->next != NULL) {
            temp = temp->next;
            count++;
        }
        return count;
    }
}

ElemType GetElem(Linklist*& L, int pos){
    /*返回链表中索引为pos的元素
     判断索引位置是否合法
     若不合法则则返回NULL，并给出提示
     * */
    if (EmptyLinkList(L) || pos <= 0 || pos > LengthLinkList(L) + 1){
        printf("链表为空或者索引不合法\n");
        return NULL;
    }
    /* 若输入的位置合法，则默认从第一个元素往后迭代*/
    int count = 1;//链表指向的元素位置
    PLinklist p = L;//不修改源链表指针，故进行对链表首地址进行拷贝
    p = p->next;//指向首节点
    while(p != NULL){//循环条件为链表非空，且指向元素不为空*/
        /* 若索引位置与链表指向的位置相符合，则返回字符*/
        if (count == pos){
            return p->elem;
        }
        else {
            count ++;
            p = p->next;
        }
    }
}

int LocateElem(Linklist*& L, ElemType elem){
    /*返回查找元素的索引
    若链表为空，或者链表中找不大该元素返回-1*/
    if (L == NULL || EmptyLinkList(L)){
        printf("链表为空\n");
        return -1;
    }
    else{//不为空的情况
        int count = 1;//count记录链表指向元素的位置
        PLinklist temp = L;//不修改原链表，故对链表进行拷贝
        temp = temp->next;//指向首节点
        /*指向元素非空*/
        while (temp != NULL){
            /*若指向元素与查找元素一样，则返回元素索引*/
            if (elem == temp->elem){
                return count;
            }
            else{
                count++;
                temp = temp->next;
            }
        }
        /*若遍历完链表后未找到则输出提示信息，并返回-1*/
        if (temp == NULL){
            printf("链表中不存在该元素\n");
            return -1;
        }
    }
}

ElemType DeleteElem(Linklist*& L, int pos){
    /*删除链表中索引为pos的元素并返回删除的元素*/
    if(L == NULL || EmptyLinkList(L) || pos < 0 || pos > LengthLinkList(L)){//若链表未初始化或者为空，或者索引不合法，返回NULL，并输出提示信息
        printf("链表为空，或者输入的索引不合法，删除失败!\n");
        return NULL;
    }
    else{
        int count = 0;
        PLinklist temp = L;//头指针的拷贝
        while (temp->next != NULL){//指向待删除元素的前一个
            if (count == pos-1){ //链表删除的操作
                PLinklist del;//声明删除节点
                ElemType delElem;
                del = temp->next;//指向代删除的元素
                delElem = del->elem;
                temp->next = del->next;//删除元素的前一个元素指向删除元素的后一个元素
                free(del);//释放删除元素的内存
                return delElem;
            }
            else{
                temp = temp->next;
                count ++;
            }
        }
    }
}


Status DestroyList(Linklist*& L){
    /* 释放链表 */
    PLinklist del;
    while(L != NULL){
        del = L;//释放节点的元素
        L = del->next;//L为下一个释放节点的位置
        free(del);//释放节点元素
    }
    return OK;
}
