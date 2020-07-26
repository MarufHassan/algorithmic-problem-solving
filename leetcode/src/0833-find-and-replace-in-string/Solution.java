class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder ans = new StringBuilder();
        String[] build = new String[S.length()];
        
        for (int i = 0; i < indexes.length; i++) {
            int idx = indexes[i];
            if (startsWith(S, idx, sources[i])) {
                build[idx] = targets[i];
                for (int j = 1; j < sources[i].length(); j++) {
                    build[j + idx] = "";
                }
            }
        }
        
        for (int i = 0; i < build.length; i++) {
            if (build[i] == null) {
                ans.append(S.charAt(i));
            } else {
                ans.append(build[i]);
            }
        }
        
        return ans.toString();
    }
    
    private boolean startsWith(String S, int index, String source) {
        for (int i = 0; i < source.length(); i++) {
            if (S.charAt(i + index) != source.charAt(i))
                return false;
        }
        return true;
    }
}