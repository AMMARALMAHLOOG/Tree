package newsimple;

import java.util.function.BinaryOperator;
import newsimple.BinaryTree;
import newsimple.Position;


public class main {

  public static void main(String[] args) {
   
   BinaryTree<String> t=new BinaryTree<>();
   Position<String>p= t.addRoot("A");
   Position<String>p1=t.addLeft(p,"B");
   t.addRight(p,"c");
   t.addLeft(p1,"D");
   
System.out.println(t.size());
System.out.println(t.root().getElement());
System.out.println(t.left(p).getElement()); System.out.println(t.right(p).getElement());
System.out.println(t.left(p1).getElement());
   
   
  }
}
