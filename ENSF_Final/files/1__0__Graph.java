
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Graph {
	
	private int size;
	private int [][] matrix;
	
	public Graph(int size) {
		this.size=size;
		this.matrix= new int[size][size];
		
		for(int i=0;i<this.size;i++)
			for(int j=0;j<this.size;j++)
				this.matrix[i][j] = 0;
	}
	
	public void addEdge(int v1,int v2) {
		if(v1>=size || v2>= size || v1<0  )
			throw new RuntimeException ("Vertex out of bounds v1  " + v1 + v2);
		this.matrix[v1][v2]= 1;
		
	}
	
	public Queue getAdjacent(int v) 
	{
		if(v >=size || v<0)
			throw new RuntimeException ("Vertex out of bounds");
		Queue results = new Queue();
		for(int i=0;i<this.size;i++)
			if(this.matrix[v][i]==1)
				results.enqueue(i);
		return results;	
	}
	
    public Queue breathFirstSearch(int vertice, int end)
    {
        boolean visited[] = new boolean[size];
        for(int i = 0; i < size; i++)
            visited[i] = false;
        Queue queue = new Queue();
        visited[vertice]=true;
        queue.enqueue(vertice);
        Queue result = new Queue();

        while (!queue.isEmpty())
        {

        	vertice = queue.dequeue();
        	result.enqueue(vertice);
        	if(vertice == end)
        	{
        		return result;
        	}
        	Queue adj = getAdjacent(vertice);
            for(int i = 0; i < adj.size; i++)
            {
                int n = adj.array[i];

                if (!visited[n])
                {
                    visited[n] = true;
                    queue.enqueue(n);
                }
            }
        }
        return null;
    }
    
    public void depthFirstSearch(Queue result, int vertice, int end)
    {
        boolean visited[] = new boolean[size];
        DFSUtil(result, vertice, visited, end);
    }
	
    public void DFSUtil(Queue temp, int vertice, boolean visited[], int end)
    {
        visited[vertice] = true;
        temp.enqueue(vertice);

    	if(vertice == end)
    	{
    		return;
    	}
        Queue adj = getAdjacent(vertice);
        for(int i = 0; i < adj.size; i++)
        {
            int n = adj.array[i];

            if(!visited[n])
            	DFSUtil(temp, n, visited, end);
        }
    }
}
