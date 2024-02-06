#include <stdio.h>

#define MAX_NODES 100

int n;
char val[MAX_NODES];
int adjMatrix[MAX_NODES][MAX_NODES];

void bfs(int start)
{
    int visited[MAX_NODES] = {0};
    int queue[MAX_NODES], front = -1, rear = -1;

    visited[start] = 1;
    queue[++rear] = start;

    while (front != rear)
    {
        int current = queue[++front];
        printf("%c ", val[current]);

        for (int i = 0; i < n; i++)
        {
            if (adjMatrix[current][i] && !visited[i])
            {
                visited[i] = 1;
                queue[++rear] = i;
            }
        }
    }
}

void dfs(int start)
{
    int visited[MAX_NODES] = {0};
    int stack[MAX_NODES] = {0};
    int top = -1;
    stack[++top] = start;
    visited[start] = 1;
    while (top > -1)
    {   int v = stack[top--];
        printf("%c ", val[v]);

        for (int i = n - 1; i >= 0; i--)
        {
            if (adjMatrix[v][i] && !visited[i])
            {
                stack[++top] = i;
                visited[i] = 1;
            }
        }
    }
}

int main()
{
    printf("Enter the number of Nodes: ");
    scanf("%d", &n);

    printf("Enter the values of nodes: ");
    for (int i = 0; i < n; i++)
        scanf(" %c", &val[i]);

    printf("Enter the adjacency matrix for the graph:\n  ");
    for (int i = 0; i < n; i++)
        printf(" %c", val[i]);
    printf("\n");
    for (int i = 0; i < n; i++)
    {
        printf("%c: ", val[i]);
        for (int j = 0; j < n; j++)
            scanf("%d", &adjMatrix[i][j]);
    }

    printf("\nBFS Traversal: ");
    bfs(0);

    printf("\nDFS Traversal: ");
    dfs(0);

    printf("\n");

    return 0;
}