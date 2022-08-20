//
// Created by Lucky on 21/5/2022.
//

# include "SqStack.h"

Status InitStack(Stack *& stack, int m){
    /*初始化栈，需要存入栈的大小*/
    stack = (Stack *)malloc(sizeof(Stack));//建立数组
    stack->data = (ElemType*) malloc(sizeof(ElemType)*m);//动态分配大小给数据数组
    stack->maxsize = m;//栈的最大容量
    if (stack == NULL) {
        return OVERFLOW;
    }
    stack->top = 0;//top为长度，使top为0；
    return OK;
}
bool EmptyStack(Stack *& stack) {
    /*返回栈是否为空*/
    return stack->top == 0;
}
bool FullStack(Stack*& stack) {
    return stack->top == stack->maxsize;
}
Status Push(Stack*& stack, ElemType e) {
    /*对元素入栈*/
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
    /*输出栈顶元素*/
    if (!EmptyStack(stack)) {
        return stack->data[stack->top-1];
    }
}
ElemType Pop(Stack*& stack) {
    /*弹出栈顶元素*/
    ElemType temp;//用来存储弹出的元素
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
