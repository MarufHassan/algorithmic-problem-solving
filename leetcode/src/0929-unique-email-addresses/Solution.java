class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        
        for (String mail : emails) {
            int index = mail.indexOf("@");
            String local = mail.substring(0, index);
            String rest = mail.substring(index);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll("\\.", "");
            unique.add(local + rest);
        }
        return unique.size();
    }
}