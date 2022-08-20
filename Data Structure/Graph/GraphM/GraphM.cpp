//
// Created by Lucky on 23/5/2022.
//

#include "GraphM.h"

void CreateDG(Graph & G){
    int vexLen,arcLen;
    int tempWeight;
    ElemType v1,v2;

    printf("请输入顶点的个数：");
    scanf("%d",&G.vexNum);
    printf("请输入边的个数：");
    scanf("%d",&G.arcNum);
    vexLen = G.vexNum;
    arcLen = G.arcNum;

    printf("请输入所有的顶点：");
    getchar();//清除缓冲
    for(int i=0; i<vexLen; i++){
        scanf("%d",&G.vex[i]);
    }

    printf("请输入存在邻接关系的两个点，并输入这条边的权值\n");
    getchar();
    for(int i=0; i<arcLen; i++){
        scanf("%d",&v1);
        scanf("%d",&v2);
        scanf("%d",&tempWeight);
        int row = LocateVex(G, v1);
        int cow = LocateVex(G, v2);
        G.arcs[row][cow].info = 1;
        G.arcs[row][cow].weight = tempWeight;
        tempWeight = 0;
    }

}
void DisplayDG(Graph & G){
    int vexLen = G.vexNum;

    for(int i=0; i<vexLen; i++){
        printf("%d ",G.vex[i]);
    }
    printf("\n");

    printf("该图的邻接矩阵：\n");
    for(int row=0; row<vexLen; row++){
        for(int cow=0; cow<vexLen; cow++){
            printf("%d(%d) ",G.arcs[row][cow].info,G.arcs[row][cow].weight);
        }
        printf("\n");
    }
}
int LocateVex(Graph G,ElemType v){
    for(int i=0; i<G.vexNum; i++){
        if(G.vex[i] == v){
            return i;
        }
    }
}
void FindInDegreeNode(Graph & G){
    for(int cow=0; cow<G.vexNum; cow++){
        int InNum=0;
        printf("%d的入度节点为:",G.vex[cow]);
        for(int row=0; row<G.vexNum; row++){
            if(G.arcs[row][cow].info == 1){
                InNum++;
            }
        }
        printf("%d\n",InNum);
    }
}
void DepthTraverse(Graph &G, int first){
    /*深度遍历*/
    int status[G.vexNum];//创建一个与节点相等数量的数组，用来储存节点是否遍历
//    arcNode temp;
    for(int i=0; i<G.vexNum; i++){//状态初始化
        status[i] = 0;
    }
    printf("深度遍历: ");
    DFS(G, first, status);
    printf("\n");
}
void DFS(Graph &G, int v,int *status) {
    printf("%d", G.vex[v]);
    status[v] = 1;
    for(int i=0; i<G.vexNum; i++){
        if(G.arcs[v][i].info == 1 && status[i] == 0){
            DFS(G,i,status);
        }
    }
}
void WidthTraverse(Graph &G,int v){
    /*广度遍历*/
    int status[G.vexNum];//创建一个与节点相等数量的数组，用来储存节点是否遍历
    Queue *queue;
    for(int i=0; i<G.vexNum; i++){//状态初始化
        status[i] = 0;
    }
    InitQueue(queue);//初始化队列
    EnQueue(queue,v);//对首节点进行入队
    printf("广度遍历: ");
    printf("%d",G.vex[v]);//打印首节点
    status[v] = 1;//修改遍历状态
    while(!EmptyQueue(queue)){
        int outNum= OutQueue(queue);
        for (int n=0; n<G.vexNum; n++){
            if(status[n] == 0 && G.arcs[outNum][n].info == 1){//未访问且存在邻接关系
                printf("%d",G.vex[n]);
                status[n] = 1;
                EnQueue(queue,n);
            }
        }
    }
    printf("\n");
}