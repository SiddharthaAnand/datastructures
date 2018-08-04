#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "graphRepresentation.h"

int breadthfirstsearch(struct graph* g) {
    int* visited = (int *)malloc(sizeof(int) * (g->V)+1);
    memset(visited, 0, sizeof(int) * (g->V)+1);
}
int main() {
    struct graph* g = createGraph(5);
    addEdge(g, 1, 2);
    addEdge(g, 1, 3);
    addEdge(g, 2, 3);
    addEdge(g, 3, 4);
    addEdge(g, 3, 5);
    addEdge(g, 1, 5);
    addEdge(g, 2, 5);

    printadjacencyList(g);
}