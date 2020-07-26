class Solution {
    private int room;
    private boolean[] visited;
        
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        room = rooms.size();
        visited = new boolean[room];
        explore(rooms, 0);
        
        for (int i = 0; i < room; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
    
    private void explore(List<List<Integer>> rooms, int s) {
        if (visited[s]) return;
        visited[s] = true;
        for (int v : rooms.get(s)) {
            explore(rooms, v);
        }
    }
}