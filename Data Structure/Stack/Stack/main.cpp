# include <iostream>
# include "SqStack.h"

int main()
{
    Stack * stack;
    int n;

    scanf("%d",&n);

    //初始化顺序栈
    InitStack(stack, n);

    if(EmptyStack(stack)){
        printf("链表为空\n");
    }

    Push(stack, 3);
    Push(stack, 3);
    Push(stack, 3);
    Push(stack, 3);


    printf("顶部元素为 %d\n", GetTop(stack));
    printf("弹出顶部元素 %d\n", Pop(stack));

    Push(stack, 1);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    Push(stack, 2);
    if (FullStack(stack)){
        printf("链表已满\n");
    }

    DestroyStack(stack);

    return 0;
}