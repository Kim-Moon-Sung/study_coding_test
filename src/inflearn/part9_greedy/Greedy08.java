package inflearn.part9_greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2> {
    public int vex;
    public int cost;
    Edge2(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge2 o) {
        return this.cost - o.cost;
    }
}

class Greedy08 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<ArrayList<Edge2>> graph = new ArrayList<ArrayList<Edge2>>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Edge2>());
        }

        int[] ch = new int[n+1];
        for(int i=0; i<m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge2(b, c));
            graph.get(b).add(new Edge2(a, c));
        }

        int answer = 0;
        PriorityQueue<Edge2> pQ = new PriorityQueue<>();
        pQ.offer(new Edge2(1, 0));
        while(!pQ.isEmpty()) {
            Edge2 tmp = pQ.poll();
            int ev = tmp.vex;
            if(ch[ev]==0) {
                ch[ev]=1;
                answer += tmp.cost;
                for(Edge2 ob : graph.get(ev)) {
                    if(ch[ob.vex]==0) pQ.offer(new Edge2(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }
}
