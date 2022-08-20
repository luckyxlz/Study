//
// Created by Lucky on 21/5/2022.
//

#include "SqQueue.h"


Status InitQueue(Queue*& queue) {
    queue = (Queue*)malloc(sizeof(Queue));//动态分配内存
    queue->data = (ElemType*) malloc(sizeof(ElemType)*MAXSIZE);
    if (queue == NULL) {
        return OVERFLOW;
    }
    queue->front = queue->rear = 0;
    return OK;
}
bool EmptyQueue(Queue*& queue) {
//    if (queue->front == queue->rear)
//        return true;
//    else
//        return false;
    return queue->front == queue->rear;
}
bool FullQueue(Queue*& queue) {
//    if (queue->front == ((queue->rear + 1) % MAXSIZE)) {
//        return true;
//    }
//    else
//        return false;
    return queue->front == ((queue->rear+1) % MAXSIZE);
}
Status EnQueue(Queue*& queue, char e) {
    if (!FullQueue(queue)) {
        queue->data[(queue->rear + 1) % MAXSIZE] = e;
        queue->rear = (queue->rear + 1) % MAXSIZE;
        return OK;
    }
    else
        return ERROR;

}
ElemType OutQueue(Queue*& queue){
    ElemType temp;
    if (!EmptyQueue(queue)){
        temp = queue->data[queue->front + 1];
        queue->data[queue->front + 1] = NULL;
        queue->front++;
        return temp;
    }
}
Status DestroyQueue(Queue*& queue) {
    free(queue);
}


