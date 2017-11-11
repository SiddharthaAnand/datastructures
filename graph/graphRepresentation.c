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
}

struct graph* createGraph(int V) {
    struct graph* newGraph = (struct graph*)malloc(sizeof(struct graph));
    newGraph->array = (struct adjList*)malloc(sizeof(struct adjList) * V);

    for (int i = 0; i < V; i++) {
        newGraph->array[i].head = NULL;
    }
    return newGraph;
}

void addEdge(struct graph* G, int src, int des) {
    struct adjListNode* newNode = createNode(des);
    newNode->next = G->array[src].head;
    G->array[src].head = newNode;
}

int main() {
}