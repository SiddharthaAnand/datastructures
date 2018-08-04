#include <stdio.h>
#include <stdlib.h>

struct adjListNode {
    int dest;
    struct adjListNode *next;
};

struct adjList {
    struct adjListNode *head;;
};

struct graph {
    int V;
    struct adjList *array;
};

struct adjListNode* createNode(int dest) {
    struct adjListNode* newNode = (struct adjListNode *)malloc(sizeof(struct adjListNode));
    newNode->dest = dest;
    newNode->next = NULL;
    return newNode;
}

struct graph* createGraph(int V) {
    struct graph* newGraph = (struct graph*)malloc(sizeof(struct graph));
    newGraph->array = (struct adjList*)malloc(sizeof(struct adjList) * (V+1));
    newGraph->V = V;
    for (int i = 0; i < V; i++) {
        newGraph->array[i].head = NULL;
    }
    return newGraph;
}

void addEdge(struct graph* G, int src, int des) {
    struct adjListNode* newNode = createNode(des);
    //printf("%d ", newNode->dest);
    newNode->next = G->array[src].head;
    G->array[src].head = newNode;
    //printf("%d ", newNode->dest);
    newNode = createNode(src);
    newNode->next = G->array[des].head;
    G->array[des].head = newNode;
}

void printadjacencyList(struct graph *g) {

    for(int i = 1; i <= g->V; i++) {
        printf("\nAdjacency List(%d)", i);
        struct adjListNode *temp = g->array[i].head;
        while(temp) {
            printf("-->%d", temp->dest);
            temp = temp->next;
        }
    }
    printf("\n");
}
int main() {
    struct graph *g = createGraph(5);
    addEdge(g, 1, 2);
    addEdge(g, 1, 3);
    addEdge(g, 2, 3);
    addEdge(g, 3, 4);
    addEdge(g, 3, 5);
    addEdge(g, 1, 5);
    addEdge(g, 2, 5);

    printadjacencyList(g);
}