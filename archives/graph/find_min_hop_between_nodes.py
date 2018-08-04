# Find the minimum number of hops between node_1 and node_2
# One possible solution is to use BFS from node_1 to node_2


def start_bfs(adjacency_matrix, start_node=0):
    
    # create q queue to keep the nodes which have not been traversed yet
    # create a visited list to visited nodes so as not to vsiit them again
    total_nodes = len(adjacency_matrix)
    queue = []
    visited = [0] * total_nodes
    
    # start with the first ndoe
    queue.append(start_node)
    visited[start_node] = 1
    
    print "_________BFS Traversal_________"
    while (len(queue) > 0):
        # pop from the beginning of the list
        current_node = queue.pop(0)
        print current_node,
        
        for idx in range(current_node+1, len(adjacency_matrix[current_node])):
            if adjacency_matrix[current_node][idx] == 1 and visited[idx] != 1:
                queue.append(idx)
                visited[idx] = 1
                #print queue

def start_dfs(adjacency_matrix, visited, start_node=0):
    # create a stack to store the negihbors of the current node
    # create a visited list to store the nodes which have already been vsited
    
    #visited = [False] * len(adjacency_matrix)
    #stack = [0]
    
    #stack.append(start_node)
    visited[start_node] = True
    
    #while (len(stack) > 0):
        # pop from the end of the list
    #current_node = stack.pop()
    print start_node,
    for idx in range(start_node+1, len(adjacency_matrix[start_node])):
        if visited[idx] == False and adjacency_matrix[start_node][idx] == 1:
            #stack.append(idx)
            #visited[idx] = True
            start_dfs(adjacency_matrix, visited, idx)
    
           
def create_adjacency_list_from_matrix(adjacency_matrix):
    # create a dictionary of lists
    # each list denoting the neighborhood of a vertex
    # make non-redundant adjacency list
    
    adjacency_list = {}
    for node_1 in range(len(adjacency_matrix)):
        for node_2 in range(len(adjacency_matrix[node_1])):
            if adjacency_matrix[node_1][node_2] == 1:
                if node_1 in adjacency_list:
                    adjacency_list[node_1].append(node_2)
                else:
                    adjacency_list[node_1] = [node_2]
    
    for key in adjacency_list:
        print key, adjacency_list[key]
    return adjacency_list
        

def shortest_hop(node_1, node_2, adjacency_list):
    # find the minimum number of hops from node_1 to node_2
    # Assuming the graph is connected
    
    print "minimum number of hops: ", min_hops_using_bfs(adjacency_list, node_1, node_2)
    
    
def min_hops_using_bfs(adjacency_list, node_1, node_2):
    
    
    if adjacency_list != None and node_1 != None and node_2 != None:
        
        if node_1 == node_2:
            return 0
        
        # start bfs
        
        # create a queue to hold the univisted nodes
        # create a visite array to store visited nodes
        
        visited = [False] * len(adjacency_list)
        queue = []
        
        queue.append(node_1)
        visited[node_1] = True
        # hop count for all nodes from node_1
        hop_count = [0] * len(adjacency_list)
        
        while (len(queue) > 0):
            current_node = queue.pop(0)
            
            for neighbor in adjacency_list[current_node]:
                
                if visited[neighbor] == False:
                    hop_count[neighbor] = hop_count[current_node] + 1
                    if neighbor == node_2:
                        visited[neighbor] = True
                        return hop_count[neighbor]
                    else:
                        visited[neighbor] = True
                        queue.append(neighbor)
                        
    else:
        return "Invalid parameters to method min_hops_using_bfs"
        
        
if __name__ == '__main__':
    #x = raw_input()
    adjacency_matrix = [[0,1,0,0,0],[1,0,1,0,0],[0,1,0,1,0],[0,0,1,0,1],[0,0,0,1,0]]
    
    #start_bfs(adjacency_matrix, start_node=0)
    
    visited = [False] * len(adjacency_matrix)
    
    #start_dfs(adjacency_matrix, visited,  start_node=0)
    
    adjacency_list = create_adjacency_list_from_matrix(adjacency_matrix)
    # find the min hop between node_1 and node_2
    node_1 = 0
    node_2 = 4
    shortest_hop(node_1, node_2, adjacency_list)
    
