class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contents = new HashMap<>();
        
        for (String path : paths) {
            String[] splits = path.split(" ");
            
            for (int i = 1; i < splits.length; i++) {
                int first =  splits[i].indexOf("(");
                int last =  splits[i].indexOf(")", first);
                String key = splits[i].substring(first + 1, last + 1);
                
                contents.putIfAbsent(key, new ArrayList<>());
                contents.get(key).add(splits[0] + "/" + splits[i].substring(0, first));
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (String key : contents.keySet()) {
            List<String> list = contents.get(key);
            if (list.size() > 1)
                ans.add(list);
        }
        
        return ans;
    }
}