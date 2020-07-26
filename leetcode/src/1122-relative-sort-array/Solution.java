class Solution {
    private static int INF = Integer.MAX_VALUE;
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> index = new HashMap<>();
        
        for (int i = 0; i < arr2.length; i++) {
            index.put(arr2[i], i);
        }
        
        Integer[] res = new Integer[arr1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr1[i];
        }
        
        Arrays.sort(res, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                int diff = index.getOrDefault(n1, INF) - index.getOrDefault(n2, INF);
                return diff == 0 ? n1 - n2 : diff;
            }
        });
        
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = res[i];
        }
        return arr1;
    }
}