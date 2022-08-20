//
// Created by Lucky on 21/5/2022.
//

#ifndef QUEUE_SQQUEUE_H
#define QUEUE_SQQUEUE_H

# include <stdio.h>
# include <stdlib.h>
# define MAXSIZE 7
# define ElemType char
# define Status int
# define OVERFLOW 0
# define OK 1
# define ERROR 0


typedef struct {
    ElemType *data;
    int front;
    int rear;
}Queue;


Status InitQueue(Queue*& queue);
bool EmptyQueue(Queue*& queue);
bool FullQueue(Queue*& queue);
Status EnQueue(Queue*& queue, char e);
ElemType OutQueue(Queue*& queue);
Status DestroyQueue(Queue*& queue);



#endif //QUEUE_SQQUEUE_H
