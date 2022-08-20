//
// Created by Lucky on 21/5/2022.
//

#ifndef LIST_SQLIST_H
#define LIST_SQLIST_H
# include <stdio.h>
# include <stdlib.h>

# define ElemType int
# define Status int

//�б�Ԫ�صĶ���
typedef struct {
    ElemType* Elem; //����ռ����ַ
    int length;//��ǰ����
    int listSize;//��ǰ����Ĵ�������
}SqList;

//��ʼ���б�
Status InitList(SqList*&);
//�����б�
Status TraverseList(SqList*&);
//�ͷ�/ɾ���б�
Status DestroyList(SqList*&);
//����Ԫ��
Status InsertElem(SqList*&, int, ElemType);
//��ȡ�б�ĳ���
Status ListLength(SqList*&);
//��ȡָ��λ�õ�Ԫ��
ElemType GetElem(SqList*&, int);
//��ȡָ��Ԫ�ص�ָ��λ��
int LocateElem(SqList*&, ElemType);
//ɾ��ָ��λ�õ�Ԫ��
ElemType DeleteElem(SqList*&, int);
//�ж��б��Ƿ�Ϊ��
bool EmptyList(SqList*&);

#endif //LIST_SQLIST_H
