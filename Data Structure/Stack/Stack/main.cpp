# include <iostream>
# include "SqStack.h"

int main()
{
    Stack * stack;
    int n;

    scanf("%d",&n);

    //��ʼ��˳��ջ
    InitStack(stack, n);

    if(EmptyStack(stack)){
        printf("����Ϊ��\n");
    }

    Push(stack, 3);
    Push(stack, 3);
    Push(stack, 3);
    Push(stack, 3);


    printf("����Ԫ��Ϊ %d\n", GetTop(stack));
    printf("��������Ԫ�� %d\n", Pop(stack));

    Push(stack, 1);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    if (FullStack(stack)){
        printf("��������\n");
    }

    DestroyStack(stack);

    return 0;
}