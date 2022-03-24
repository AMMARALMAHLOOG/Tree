package newsimple;

import newsimple.Position;


public class BinaryTree<E> {
 
    private Node<E>root=null;
    private int size=0;
    public boolean isEmpty()
    {
        return size==0;
    }

    public int size()
    {
        return size;
    }
 
 protected Node<E>createNode(E e,Node<E>p,                            Node<E>l,Node<E>r){
        return new Node<E>(e,p,l,r);
    }
  protected Node<E> validate (Position<E>p)
  {
    if (!(p instanceof Node))
    throw new IllegalArgumentException("p is not validate position ");
    Node<E>n=(Node<E>)p;
    if (n.getParent()==n)
    throw new IllegalArgumentException("p is not exist anymore ");
    return n;
  }
  
  public Position<E> root(){
    return root;
  }
  
  public Position<E> parant(Position<E>p){
    Node<E>n=validate(p);
    return n.getParent();
  }
  
  public Position<E> left(Position<E>p){
    Node<E>n=validate(p);
    return n.getLeft();
  }
  public Position<E> right(Position<E>p){
    Node<E>n=validate(p);
    return n.getRight();
  }
  
  public int numOfChildren (Position<E>p)
  {
    int count=0;
    if (left(p)!=null)
    count++;
    if (right(p)!=null)
    count++;
    return count;
  }
  
  
  
  //.    part 2
  
  
 public Position<E> addRoot (E e){
    if (!isEmpty())
    throw new IllegalArgumentException("there is already root");
    root=createNode(e,null ,null ,null );
    size=1;
    return root;
  }
  
public Position<E>addLeft (Position<E>p,E e){
    Node<E>parent=validate(p);
    if (parent.getLeft()!=null)
    throw new IllegalArgumentException("there is a left child");
    Node<E>child=createNode(e, parent,null,null);
    parent.setLeft(child);
    size++;
    return child;
  }
  
public Position<E>addRight(Position<E>p,E e){
    Node<E>parent=validate(p);
    if (parent.getRight()!=null)
    throw new IllegalArgumentException("there is a right child");
    Node<E>child=createNode(e, parent,null,null);
    parent.setRight(child);
    size++;
    return child;
  }
  
  public E set (Position<E>p,E e){
    Node<E>n=validate(p);
    E old =n.getElement();
    n.setElement(e);
    return old;
  }
  
  public E remove (Position<E>p){
    Node<E>n=validate(p);
  if  (numOfChildren(p)==2)
   throw new IllegalArgumentException("p have two childern");
   Node<E>child=(n.getLeft()!=null?n.getLeft():n.getRight());
   if (child!=null)
   child.setParent(n.getParent());
   if (n==root)
   root=child;
   else {
     Node<E>parent=n.getParent();
     if (parent.getLeft()==n)
     parent.setLeft(child);
     else parent.setRight(child);
   }
   size--;
   n.setParent(n);
   E del=n.getElement();
   n.setElement(null);
   n.setLeft(null);
   n.setRight(null);
   return del;
  }
  
  
  
  //       End of part two

  private static class Node<E> implements Position<E>{
    E element;
    Node<E> parent;
    Node<E> left;
    Node<E> right;
    
    public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
 
        public void setElement(E element) {
            this.element = element;
        }
 
        public Node<E> getParent() { 
            return parent;
        }
 
        public void setParent(Node<E> parent) { 
            this.parent = parent;
        }
        
        public Node<E> getLeft() {
            return left;
        }
        
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        public Node<E> getRight() {
            return right;
        } 
        public void setRight(Node<E> right) { 
            this.right = right; 
        }
        
        @Override
        public E getElement() {
            return element;
        }

  }

  }