import java.util.NoSuchElementException;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }
  public int size(){
    return size;
  }

  public String toString(){
    String ary = "{";
    if (end < start) {
      for (int i = start; i < data.length; i++ ) {
        ary += data[i] + ", ";
      }
      for (int i = 0; i <= end; i++) {
        ary += data[i] + ", ";
      }
    }
    else {
      for (int i = 0; i < data.length; i++) {
        ary += data[i] + ", ";
      }
    }
    ary = ary.substring(ary.length()-2);
    ary+= "}";
    return ary;
  }

  public void addFirst(E element){
    if (size == 0) {
      data[start] = element;
    }
    else if (start == 0){
      //resize thingy? or shift over?
    }
    else {
      data[start-1] = element;
      start--;
    }
    size++;
  }

  public void addLast(E element){
    if (size == 0) {
      data[end] = element;

    }

    size++;
  }

  @SuppressWarnings("unchecked")
  public void resize() {
    E[] d = (E[])new Object[2*data.length];
    int index = 0;
    if (end < start) {
      for (int i = start; i < data.length; i++) {
        d[index] = data[i];
        index++;
      }
      for (int i = 0; i < end; i++) {
        d[index] = data[i];
        index++;
      }
    }
    else {
      for (int i = start; i < end; i++) {
        d[index] = data[i];
        index++;
      }
    }
    start = 0;
    end = index--;
    data = d;
  }
  
  public E removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException("e");
    }
    E a = data[start];
    data[start] = null;
    start++;
    size--;
    return a;
  }
  public E removeLast(){
    if (size == 0) {
      throw new NoSuchElementException("e");
    }
    E a = data[end];
    data[end] = null;
    end--;
    size--;
    return a;
  }
  public E getFirst(){
    if (size == 0) {
      throw new NoSuchElementException("e");
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0) {
      throw new NoSuchElementException("e");
    }
    return data[end];
  }
}
