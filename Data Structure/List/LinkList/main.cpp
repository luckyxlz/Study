#include <iostream>
#include "LinkList.h"


int main()
{
    Linklist* L;//��������L
    InitList(L);//��ʼ������

    //����β�巨����a,b,c,d,e
    InsertList(L, 1, 1);
    InsertList(L, 2, 2);
    InsertList(L, 3, 3);
    InsertList(L, 4, 4);
    InsertList(L, 5, 5);

    TraverseList(L);//��������

    printf("������Ϊ %d\n", LengthLinkList(L));//���������

    //�ж������Ƿ�Ϊ��
    if(EmptyLinkList(L)){
        printf("����Ϊ��\n");
    }
    else{
        printf("����ǿ�\n");
    }

    printf("%d\n", GetElem(L, 3));//���������ĵ�����Ԫ��

    printf("%d\n", LocateElem(L, 1));//���Ԫ��a���߼�λ��

    InsertList(L, 4, 5);//�ڵ�4��Ԫ��λ�ò���Ԫ��4

    TraverseList(L);//�������

    DeleteElem(L, 3);//ɾ��������ĵ�����Ԫ��

    TraverseList(L);//�������

    DestroyList(L);//�ͷ�����

}