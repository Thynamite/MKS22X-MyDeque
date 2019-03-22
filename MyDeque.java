import java.util.NoSuchElementException;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = (data.length/2)-1;
    end = start;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = (initialCapacity/2)-1;
    end = start;
  }
  public int size(){
    return size;
  }

  public String toString(){
    if (size == 0) {
      return "{}";
    }
    String ary = "{";
    if (end < start) {
      for (int i = start; i < data.length; i++ ) {
        if (data[i] != null) {
          ary += data[i] + " ";
        }
      }
      for (int i = 0; i <= end; i++) {
        if (data[i] != null) {
          ary += data[i] + " ";
        }
      }
    }
    else {
      for (int i = 0; i < data.length; i++) {
        if (data[i] != null) {
          ary += data[i] + " ";
        }
      }
    }
    ary = ary.substring(0,ary.length()-1);
    ary+= "}";
    return ary;
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException("n");
    }
    if (size == 0) {
      data[start] = element;
    }
    else if (start == 0){
      resize();
      data[start-1] = element;
      start--;
    }
    else {
      data[start-1] = element;
      start--;
    }
    size++;
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException("n");
    }
    if (size == 0) {
      data[end] = element;

    }
    else if (end == data.length-1) {
      resize();
      data[end+1] = element;
      end++;
    }
    else {
      data[end+1] = element;
      end++;
    }

    size++;
  }

  @SuppressWarnings("unchecked")
  public void resize() {
    E[] d = (E[])new Object[2*data.length];
    int index = (d.length/3);
    if (end < start) {
      for (int i = start; i < data.length; i++) {
        d[index] = data[i];
        index++;
      }
      for (int i = 0; i <= end; i++) {
        d[index] = data[i];
        index++;
      }
    }
    else {
      for (int i = start; i <= end; i++) {
        d[index] = data[i];
        index++;
      }
    }
    start = (d.length/3);
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
