//
// Created by Lucky on 23/5/2022.
//

#ifndef SIXTH_EXPERIMENT_WORK_GRAPHM_H
#define SIXTH_EXPERIMENT_WORK_GRAPHM_H
# include "stdio.h"
# include "SqQueue.h"

# define ElemType int
# define MAX 100



/*边的定义*/
typedef struct {
    int info;
    int weight;
}ArcCell;
/*有向带权图结构定义*/
typedef struct {
    ElemType vex[MAX];//节点
    ArcCell arcs[MAX][MAX];//邻接矩阵
    int vexNum,arcNum;//节点与边的个数
}Graph;

/*函数声明*/
int LocateVex(Graph,ElemType);
void FindInDegreeNode(Graph &);
void DisplayDG(Graph &);
void CreateDG(Graph &);
void WidthTraverse(Graph &, int);
void DepthTraverse(Graph &, int);
void DFS(Graph &G, int v,int *status);
#endif //SIXTH_EXPERIMENT_WORK_GRAPHM_H
