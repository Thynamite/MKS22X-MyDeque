public class Drive{

  public static void main(String[] args) {
    MyDeque<Integer> f  = new MyDeque<>();

    f.addFirst(1);
    f.addFirst(2);
    f.addFirst(3);
    f.addLast(0);
    f.addFirst(4);
    f.addFirst(5);
    f.addFirst(6);
    f.addFirst(7);
    f.addFirst(8);
    f.addFirst(9);

    f.removeFirst();

    f.addLast(1000);
    System.out.println(f);
    //System.out.println(f.start);
    //System.out.println(f.end);
    System.out.println(f.size());
    System.out.println(f.getLast());
    System.out.println(f.getFirst());



    System.out.println(f);
  }
}
