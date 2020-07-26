class Solution {
    private Map<Integer, Employee> emp;
    
    public int getImportance(List<Employee> employees, int id) {
        emp = new HashMap<>();
        for (Employee e : employees) {
            emp.put(e.id, e);
        }
        return calculate(id);
    }
    
    private int calculate(int id) {
        Employee employee = emp.get(id);
        int ans = employee.importance;
        for (int v : employee.subordinates) {
            ans += calculate(v);
        }
        return ans;
    }
}