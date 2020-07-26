class SnapshotArray {
    private List<TreeMap<Integer, Integer>> maps;
    private int snaps;

    public SnapshotArray(int length) {
        maps = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            maps.add(new TreeMap<>());
            maps.get(i).put(0, 0);
        }
        snaps = 0;
    }
    
    public void set(int index, int val) {
        maps.get(index).put(snaps, val);
    }
    
    public int snap() {
        return snaps++;
    }
    
    public int get(int index, int snap_id) {
        return maps.get(index).floorEntry(snap_id).getValue();
    }
}