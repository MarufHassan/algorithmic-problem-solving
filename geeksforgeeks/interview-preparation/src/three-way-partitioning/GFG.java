class GfG
{
	public ArrayList<Integer> threeWayPartition(ArrayList<Integer> a, int lowVal, int highVal) {
	    int lt = 0, gt = a.size() - 1;
	    int i = lt;
	    while (gt >= i) {
	        if      (a.get(i) < lowVal)  exch(a, lt++, i++);
	        else if (a.get(i) > highVal) exch(a, i, gt--);
	        else                         i++;
	    }
	    return a;
	}
	
	private void exch(ArrayList<Integer> a, int i, int j) {
	    int swap = a.get(i);
	    a.set(i, a.get(j));
	    a.set(j, swap);
	}
}