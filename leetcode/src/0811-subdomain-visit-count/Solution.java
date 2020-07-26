class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> freq = new HashMap<>();
        
        for (String domain : cpdomains) {
            String[] parts = domain.split("[. ]");
            
            int count = Integer.parseInt(parts[0]);
            String codomain = "";
            for (int i = parts.length - 1; i >= 1; i--) {
                codomain = parts[i] + (i < parts.length - 1 ? "." : "") + codomain;
                freq.put(codomain, freq.getOrDefault(codomain, 0) + count);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String domain : freq.keySet()) {
            int count = freq.get(domain);
            ans.add(count + " " + domain);
        }
        return ans;
    }
}