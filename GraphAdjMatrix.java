import java.util.Arrays;
import java.util.Stack;

public class GraphAdjMatrix implements Graph {
	
	int[][] graph;
	int size;
	
	public GraphAdjMatrix(int size) {
		this.size = size;
		graph = new int[size][size];
	}

	@Override
	public void addEdge(int v1, int v2) {
		graph[v1][v2] = 1;
	}

	@Override
	public void topologicalSort() {
//		System.out.println(Arrays.deepToString(graph));
		boolean[] visited = new boolean[graph.length];
		Stack stack = new Stack();
		
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				topologicalSort(i, visited, stack);
			}
		}
//		System.out.println(Arrays.deepToString(graph));
	}

	private void topologicalSort(int vertex, boolean[] visited, Stack stack) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(new Integer(vertex));
		while(!s.empty()) {
			int v = s.pop();
			
			visited[v] = true;
			
			for(int i = 0; i < neighbors(v).length; i++) {
				int n = neighbors(v)[i];
				
				if(!visited[n]) {
					s.push(new Integer(n));
					visited[n] = true;
				}
			}
		}
		
	}

	@Override
	public int[] neighbors(int vertex) {
		int[] temp = new int[size];
		int index = 0;
		for(int i = 0; i < size; i++) {
			if(graph[vertex][i] == 1 && i != vertex) {
				temp[index] = i;
				index++;
			}
		}
		
		int[] neb = new int[index];
		for(int i = 0; i < index; i++) {
			neb[i] = temp[i];
		}

		return neb;
	}

}
