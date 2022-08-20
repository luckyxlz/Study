//
// Created by Lucky on 21/5/2022.
//

# ifndef STACK_SQSTACK_H
# define STACK_SQSTACK_H

# define ElemType int
# define Status int
# define OVERFLOW 0

# include <stdio.h>
# include <stdlib.h>
# define OK 1
# define ERROR -1

typedef struct
{
    int top;
    int maxsize;
    ElemType *data;
}Stack;

Status InitStack(Stack *& stack, int m);
bool EmptyStack(Stack *& stack);
bool FullStack(Stack*& stack);
Status Push(Stack*& stack, int e);
ElemType Pop(Stack*& stack);
ElemType GetTop(Stack*& stack);
Status DestroyStack(Stack*& stack);


#endif //STACK_SQSTACK_H
