//
// Created by Lucky on 21/5/2022.
//

#include "LinkList.h"
#include <stdio.h>
#include <stdlib.h>



Status InitList(Linklist*& L)
{
    /*�����ʼ��*/
    L = (Linklist*)malloc(sizeof(Linklist));//��̬�����ڴ�
    if (L == NULL){//�ж��ڴ��Ƿ����ɹ�
        return OVERFLOW;
    }
    else {//������ͷ�ڵ���ָ����һ����ָ��ָ��Ϊ��
        L->elem = NULL;//Ԫ��ͷ�ڵ�Ԫ��Ϊ��
        L->next = NULL;//��ͷ�ڵ��next�ÿ�
    }

    return OK;
}

Status InsertList(Linklist *& pHead, int pos, ElemType val)
{
    /*�������е�����pos����Ԫ��val*/
    if (pHead == NULL || pos < 1 || pos > LengthLinkList(pHead) + 1){//������δ��ʼ�����߲����λ�ò��Ϸ��򷵻�ERROR
        return ERROR;
    }
    PLinklist p = pHead;//Ϊ�˲��޸�ͷָ��ʶ�ָ����п���
    int i = 0;//����Э��ѭ��������Ԫ�ص�ǰһ��

    while (p != NULL && i<pos-1){//ʹpָ�������Ԫ�ص�ǰһ��
        p = p->next;
        i++;
    }

    PLinklist pNew = (PLinklist) malloc(sizeof(Linklist));//Ϊ�½ڵ�����ڴ�ռ�

    /*�ж��ڴ��Ƿ����ɹ� */
    if (pNew == NULL){
        return OVERFLOW;
    }
    else {//����Ԫ��
        pNew->elem = val;
        pNew->next = p->next;
        p->next = pNew;
        return OK;
    }
}

Status TraverseList(Linklist*& L)
{
    /*��������*/
    PLinklist temp = L;//��������в�����Ϊ�˷�ֹ�޸�ͷ�ڵ��ַ��������ͷ�ڵ�Ԫ�ؽ��п���
    if (L == NULL || EmptyLinkList(L)){//������Ϊ�ջ�������δ��ʼ��������ʾ
        printf("����Ϊ��\n");
    }
    else {
        printf("�����������Ϊ: ");
        while (temp->next != NULL) {//������Ϊ������һ��Ԫ�ز�Ϊ�ս��б���
            temp = temp->next;//tempÿ��ָ����һ��Ԫ��
            printf("%d ", temp->elem);
        }
        printf("\n");
    }
    return OK;
}

bool EmptyLinkList(Linklist*& L)
{
    /*�ж������Ƿ�Ϊ��*/
    if (L->next == NULL)
    {
        return true;//����Ϊ�գ�����true;
    }
    else {
        return false;//����Ϊ�գ�����false;
    }
}

int LengthLinkList(Linklist*& L){
    /*����������*/
    if (EmptyLinkList(L)){
        return 0;
    }
    else {//����ǿ�����µ�����
        int count = 1;//countΪ����ָ��Ԫ�ص�λ�ã����ڷǿ���Ĭ��ָ��1
        PLinklist temp = L;//Ϊ�˲��޸�ԭ������׵�ַ���ʶ�������п���
        temp = temp->next;//ָ���һ��Ԫ��
        while (temp->next != NULL) {
            temp = temp->next;
            count++;
        }
        return count;
    }
}

ElemType GetElem(Linklist*& L, int pos){
    /*��������������Ϊpos��Ԫ��
     �ж�����λ���Ƿ�Ϸ�
     �����Ϸ����򷵻�NULL����������ʾ
     * */
    if (EmptyLinkList(L) || pos <= 0 || pos > LengthLinkList(L) + 1){
        printf("����Ϊ�ջ����������Ϸ�\n");
        return NULL;
    }
    /* �������λ�úϷ�����Ĭ�ϴӵ�һ��Ԫ���������*/
    int count = 1;//����ָ���Ԫ��λ��
    PLinklist p = L;//���޸�Դ����ָ�룬�ʽ��ж������׵�ַ���п���
    p = p->next;//ָ���׽ڵ�
    while(p != NULL){//ѭ������Ϊ����ǿգ���ָ��Ԫ�ز�Ϊ��*/
        /* ������λ��������ָ���λ������ϣ��򷵻��ַ�*/
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
    /*���ز���Ԫ�ص�����
    ������Ϊ�գ������������Ҳ����Ԫ�ط���-1*/
    if (L == NULL || EmptyLinkList(L)){
        printf("����Ϊ��\n");
        return -1;
    }
    else{//��Ϊ�յ����
        int count = 1;//count��¼����ָ��Ԫ�ص�λ��
        PLinklist temp = L;//���޸�ԭ�����ʶ�������п���
        temp = temp->next;//ָ���׽ڵ�
        /*ָ��Ԫ�طǿ�*/
        while (temp != NULL){
            /*��ָ��Ԫ�������Ԫ��һ�����򷵻�Ԫ������*/
            if (elem == temp->elem){
                return count;
            }
            else{
                count++;
                temp = temp->next;
            }
        }
        /*�������������δ�ҵ��������ʾ��Ϣ��������-1*/
        if (temp == NULL){
            printf("�����в����ڸ�Ԫ��\n");
            return -1;
        }
    }
}

ElemType DeleteElem(Linklist*& L, int pos){
    /*ɾ������������Ϊpos��Ԫ�ز�����ɾ����Ԫ��*/
    if(L == NULL || EmptyLinkList(L) || pos < 0 || pos > LengthLinkList(L)){//������δ��ʼ������Ϊ�գ������������Ϸ�������NULL���������ʾ��Ϣ
        printf("����Ϊ�գ�����������������Ϸ���ɾ��ʧ��!\n");
        return NULL;
    }
    else{
        int count = 0;
        PLinklist temp = L;//ͷָ��Ŀ���
        while (temp->next != NULL){//ָ���ɾ��Ԫ�ص�ǰһ��
            if (count == pos-1){ //����ɾ���Ĳ���
                PLinklist del;//����ɾ���ڵ�
                ElemType delElem;
                del = temp->next;//ָ���ɾ����Ԫ��
                delElem = del->elem;
                temp->next = del->next;//ɾ��Ԫ�ص�ǰһ��Ԫ��ָ��ɾ��Ԫ�صĺ�һ��Ԫ��
                free(del);//�ͷ�ɾ��Ԫ�ص��ڴ�
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
    /* �ͷ����� */
    PLinklist del;
    while(L != NULL){
        del = L;//�ͷŽڵ��Ԫ��
        L = del->next;//LΪ��һ���ͷŽڵ��λ��
        free(del);//�ͷŽڵ�Ԫ��
    }
    return OK;
}
