import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nova
 */
public class KingdomReorganization {

    int[] root;
    int n;
    ArrayList<Edge> eb;
    ArrayList<Edge> ed;

    public int findSet(int u) {
        if (root[u] == u) root[u] = u;
        else root[u] = findSet(root[u]);
        return root[u];
    }

    public void union(int u, int v) {
        root[findSet(u)] = root[findSet(v)];
    }

    public int convert(char c) {
        if ((c >= 'A') && (c <= 'Z')) return c - 'A';
        else return 26 + c - 'a';
    }

    public int getCost(String[] kingdom, String[] build, String[] destroy) {

        n = kingdom.length;

        root = new int[n];
        eb = new ArrayList<Edge>();
        ed = new ArrayList<Edge>();

        int sumDestroy = 0;
        int sumBuild = 0;

        for (int i = 0; i < n; i++)
            root[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (kingdom[i].charAt(j) == '1') {
                    int w = convert(destroy[i].charAt(j));
                    ed.add(new Edge(i, j, w));
                    sumDestroy += w;
                }
                eb.add(new Edge(i, j, convert(build[i].charAt(j))));
            }

        sumDestroy /= 2;

        Collections.sort(ed);
        Collections.reverse(ed);
        Collections.sort(eb);

        int m = ed.size();

        for (Edge e : ed) {
            if (findSet(e.u) != findSet(e.v)) {
                union(e.u, e.v);
                sumDestroy -= e.w;
            }
        }

        for (Edge e : eb) {
            if (findSet(e.u) != findSet(e.v)) {
                union(e.u, e.v);
                sumBuild += e.w;
            }
        }

        return sumDestroy + sumBuild;
    }

    class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge() {
        }

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

}