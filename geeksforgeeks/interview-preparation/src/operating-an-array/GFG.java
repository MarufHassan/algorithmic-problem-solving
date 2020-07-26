class GfG
{   
  public boolean searchEle(int a[], int x){
      for (int i = 0; i < a.length; i++) {
          if (a[i] == x)
              return true;
      }
      return false;
  }
  public boolean insertEle(int a[], int y, int yi) {
      int n = 0;
      for (int i = 0; i < 100; i++, n++) {
          if (a[i] == -1)
              break;
      }
      
      for (int i = n - 1; i >= yi; i--) {
          a[i + 1] = a[i];
      }
      a[yi] = y;
      return true;
  }
  public boolean deleteEle(int a[], int z){
      for (int i = 0; i < a.length; i++) {
          if (a[i] == z)  deleteAtIndex(a, i);
      }
      return true;
  }
  
  private void deleteAtIndex(int[] a, int idx) {
      for (int i = idx; i < a.length - 1; i++) {
          a[i] = a[i + 1];
      }
  }
}