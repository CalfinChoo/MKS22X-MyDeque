import java.util.*;
public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0; start = 0; end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0; start = 0; end = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String out = "{";
    int index = start;
    while (index != end) {
      out += data[index] + ", ";
      if (index < data.length - 1) index++;
      else index = 0;
    }
    out += data[index] + "}";
    return out;
  }
  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
    if (size < data.length) {
      while (data[start] != null) {
        if (start == 0) start = data.length - 1;
        else start--;
      }
      data[start] = element;
    }
    else {
      E[] bigData = (E[])new Object[data.length * 2];
      int index = 1;
      while (start != end) {
        bigData[index] = data[start];
        index++;
        if (start < data.length - 1) start++;
        else start = 0;
      }
      bigData[index] = data[start];
      bigData[0] = element;
      start = 0; end = index;
      data = bigData;
    }
    size++;
  }
  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    if (size < data.length) {
      while (data[end] != null) {
        if (end == data.length - 1) end = 0;
        else end++;
      }
      data[end] = element;
    }
    else {
      E[] bigData = (E[])new Object[data.length * 2];
      int index = 0;
      while (start != end) {
        bigData[index] = data[start];
        index++;
        if (start < data.length - 1) start++;
        else start = 0;
      }
      bigData[index] = data[start];
      bigData[index + 1] = element;
      start = 0; end = index + 1;
      data = bigData;
    }
    size++;
  }
  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException();
    E out = data[start];
    data[start] = null;
    if (start < data.length - 1) start++;
    else start = 0;
    size--;
    return out;
  }
  public E removeLast(){
    if (size == 0) throw new NoSuchElementException();
    E out = data[end];
    data[end] = null;
    if (end > 0) end--;
    else end = data.length - 1;
    size--;
    return out;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
