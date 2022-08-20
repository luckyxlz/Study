//
// Created by Lucky on 21/5/2022.
//

# ifndef LINKLIST_LINKLIST_H
# define LINKLIST_LINKLIST_H
# include <stdio.h>
# include <stdlib.h>
# define ElemType char
# define Status int

//�ڴ����ʧ��
# define OVERFLOW -2
//������ȷ����
# define OK 1
//����������������
# define ERROR -1



/*����ṹ�嶨��*/
typedef struct Node {
    ElemType elem;          /*������*/
    struct Node * next;/*ָ����*/
}Linklist, *PLinklist;

/*��������*/
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
