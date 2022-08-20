//
// Created by Lucky on 21/5/2022.
//

# include "SqList.h"
# include <stdio.h>
# include <stdlib.h>



//�������Ա����󳤶�
# define LIST_INIT_SIZE 20
//�������Ա���ռ�����
# define LIST_INCREMENT 10
//�ڴ����ʧ��
# define OVERFLOW -2
//������ȷ����
# define OK 1
//����������������
# define ERROR -1
//��ȷ�ʹ���
# define TRUE 1
# define FALSE 0



Status InitList(SqList *& L)
{
    /*��ʼ������*/
    /*������ö�̬�������飬�����ڴ����*/
    L = (SqList*)malloc(sizeof(SqList *));//��̬����ͷָ��
    L->Elem = (ElemType *)malloc(LIST_INIT_SIZE * sizeof(ElemType));//��̬��������
    if (!L->Elem) exit(OVERFLOW);//���б�Ϊ��ʱ���ڴ����ʧ�ܣ���exit���������0��������ʾ����������˳�
    L->length = 0;//��ʼʱ���б�Ĭ�ϳ���Ϊ0
    L->listSize = LIST_INIT_SIZE;//�������󳤶�

    return OK;
}


Status InsertElem(SqList*& L, int i, ElemType e)
{
    /*���б�L�е�iλ�ò���Ԫ��e
    �ںϷ�ֵ�в���Ԫ��	1<=i<=listSize+1*/
    if (i<1 || i> L->listSize + 1) return 0;

    if (L->length >= L->listSize)    //����ռ���ʱ�����ӷ���
    {
        SqList newBase;
        newBase.Elem = (ElemType*)realloc(L->Elem, (L->listSize + LIST_INCREMENT) * sizeof(ElemType));
        if (!newBase.Elem) exit(OVERFLOW);//�ڴ����ʧ�ܣ������˳�
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
    /*��������*/
    int i = ListLength(L);
    printf("�б�Ԫ��Ϊ: ");
    for (int n = 1; n <= i; n++)
        printf("%d ", GetElem(L, n));
    printf("\n");
    return OK;
}


Status ListLength(SqList*& L)
{
    /*����Ԫ�ظ���*/
    return L->length;
}


ElemType GetElem(SqList*& L, int i)
{
    /*��������Ϊi��ֵ*/
    return L->Elem[i - 1];
}


int LocateElem(SqList*& L, ElemType e)
{
    /*����Ԫ��Ϊe������*/
    //�����б��е�Ԫ�أ���Ԫ��e���бȽϣ������ͬ���򷵻�Ԫ�ص�����λ�á����򷵻�0
    //int i;//���ڴ���Ԫ������λ�õ�ֵ��Ĭ��Ϊ0
    int n = 1;
    int len = ListLength(L);
    while (n >= 1 && n <= len){//��eԪ�����ȡ��Ԫ����ͬʱ������λ��
        if (e == GetElem(L, n))
            return n;
        n++;
    }
    return -1;
}


ElemType DeleteElem(SqList*& L, int i)
{
    /*ɾ������������Ϊi��Ԫ��*/
    //ɾ���б�L��λ��i��Ԫ��, ��ɾ��λ�ú����Ԫ��ǰ�ƣ��ҳ��ȼ�1
    //�жϸ���λ���Ƿ�Ϸ�
    if (i<1 || i > ListLength(L))
        return ERROR;
    ElemType* p = &L->Elem[i - 1];//pΪ��ɾ��Ԫ�صĵ�ַ
    ElemType e = *p;
    ElemType* q = &L->Elem[L->length - 1];//qΪ��β��Ԫ��
    for (; p <= q; p++){//Ԫ��ǰ��
        *p = *(p + 1);
    }
    L->length--;

    //��ɾ����Ԫ�ط���
    return e;
}


Status DestroyList(SqList*& L)
{
    //���б���ڴ�����ͷ�
    free(L->Elem);
    return OK;
}


bool EmptyList(SqList*& L)
{
    if (ListLength(L) == 0)
        return TRUE;
    return FALSE;
}

