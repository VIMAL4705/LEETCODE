class Solution {
    class Node{
        String key;
        double val;
        Node(String k, double v){
            key = k;
            val = v;
        }
    }
    Map<String, List<Node>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        
        // build the graph
        for(int i=0;i<values.length;i++){
            String src = equations.get(i).get(0);
            String dst = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dst, new ArrayList<>());
            graph.get(src).add(new Node(dst, values[i]));
            graph.get(dst).add(new Node(src, 1/values[i]));
        }
        
        int n = queries.size();
        double[] ans = new double[n];
        
        for(int i=0;i<n;i++){
            ans[i]=dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet());
        }
        return ans;
    }
    
    double dfs(String src, String dst, Set<String> set){
        if(!graph.containsKey(src)||!graph.containsKey(dst))
            return -1.0;
        if(src.equals(dst))
            return 1.0;
        set.add(src);
        for(Node child: graph.get(src)){
            if(!set.contains(child.key)){
                double ans = dfs(child.key, dst, set);
                if(ans!=-1.0)
                    return ans*child.val;
            }
        }
        
        return -1.0;
    }
}
