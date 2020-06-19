import java.util.PriorityQueue;
import java.util.Vector;

class Pair<T, T2> implements Comparable<Pair>
{
    T first;
    T2 second;
    Pair(T first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return Long.compare((long)this.first, (long)o.first);
    }
}

public class City {
    private int nodesNumber;
    private Vector<Vector<Pair<Integer, Long>>> graph;
    private Vector<Branch> branches;

    public int findNearestBranch(int blockNumber)
    {
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>();
        long length[] = new long[nodesNumber + 1];
        for(int i = 1 ; i <= nodesNumber ; i++)
        {
            length[i] = Long.MAX_VALUE;
        }

        length[blockNumber] = 0;
        pq.add(new Pair<>(0L, blockNumber));
        while(!pq.isEmpty())
        {
            long cost = pq.peek().first;
            int currentNode = pq.peek().second;
            pq.remove();

            if(length[currentNode] != cost)
                continue;

            boolean isBranch = false;
            int id = -1;
            for(int i = 0 ; i < branches.size() ; i++)
            {
                if(branches.elementAt(i).getBlockNumber() == currentNode)
                {
                    isBranch = true;
                    id = branches.elementAt(i).getId();
                    break;
                }
            }

            if(isBranch)
            {
                return id;
            }

            for(int i = 0 ; i < graph.elementAt(currentNode).size() ; i++)
            {
                int child = graph.elementAt(currentNode).elementAt(i).first;
                long edgeCost = graph.elementAt(currentNode).elementAt(i).second;
                if(length[child] > edgeCost + cost)
                {
                    pq.add(new Pair<>(cost + edgeCost, child));
                    length[child] = edgeCost + cost;
                }
            }
        }
        return -1;
    }

    public Vector<Branch> getBranches() {
        return branches;
    }

    public City(int nodesNumber, Vector<Vector<Pair<Integer, Long>>> graph,
                Vector<Branch> branches)
    {
        this.nodesNumber = nodesNumber;
        this.graph = graph;
        this.branches = branches;
    }
}
