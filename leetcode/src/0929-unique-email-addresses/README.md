# [929. Unique Email Addresses][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2

Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
```

## Solution

```java
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
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/unique-email-addresses/