//
// Created by Lucky on 21/5/2022.
//

# include "SqStack.h"

Status InitStack(Stack *& stack, int m){
    /*��ʼ��ջ����Ҫ����ջ�Ĵ�С*/
    stack = (Stack *)malloc(sizeof(Stack));//��������
    stack->data = (ElemType*) malloc(sizeof(ElemType)*m);//��̬�����С����������
    stack->maxsize = m;//ջ���������
    if (stack == NULL) {
        return OVERFLOW;
    }
    stack->top = 0;//topΪ���ȣ�ʹtopΪ0��
    return OK;
}
bool EmptyStack(Stack *& stack) {
    /*����ջ�Ƿ�Ϊ��*/
    return stack->top == 0;
}
bool FullStack(Stack*& stack) {
    return stack->top == stack->maxsize;
}
Status Push(Stack*& stack, ElemType e) {
    /*��Ԫ����ջ*/
    if (!FullStack(stack)){
        stack->data[stack->top] = e;
        stack->top++;
        return OK;
    }
    else {
        return ERROR;
    }
}
ElemType GetTop(Stack*& stack) {
    /*���ջ��Ԫ��*/
    if (!EmptyStack(stack)) {
        return stack->data[stack->top-1];
    }
}
ElemType Pop(Stack*& stack) {
    /*����ջ��Ԫ��*/
    ElemType temp;//�����洢������Ԫ��
    if (!EmptyStack(stack)) {
        temp = stack->data[stack->top - 1];
        stack->data[stack->top - 1] = NULL;
        stack->top--;
        return temp;
    }

}
Status DestroyStack(Stack*& stack) {
    free(stack->data);
    free(stack);
}
