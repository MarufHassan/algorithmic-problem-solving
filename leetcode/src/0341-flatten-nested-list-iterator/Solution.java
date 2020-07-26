public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int N;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        N = 0;
        flatten(nestedList);
    }
    
    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger nl : nestedList) {
            if (nl.isInteger())
                list.add(nl.getInteger());
            else
                flatten(nl.getList());
        }
    }

    @Override
    public Integer next() {
        return list.get(N++);
    }

    @Override
    public boolean hasNext() {
        return N != list.size();
    }
}