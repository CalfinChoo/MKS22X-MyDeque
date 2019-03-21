public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0, start = 0, end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0, start = 0, end = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){ }
  public void addFirst(E element){
    if (size < data.length) {
      while (data[start] != null) {
        if (start == 0) start = data.length - 1;
        else start--;
      }
      data[start] = element;
    }
    else {
      E[] bigData = (E[])new Object[data.length * 2];
    }
  }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
