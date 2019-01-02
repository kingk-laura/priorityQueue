//comments
class PriorityQueue
{
  private int[] rank;
  private int count;

  public PriorityQueue(int size)
  {
    count = 0;
    rank = new int[size];
  }

  public int parent(int i)
  {
    return (i)/2;
  }

  public int leftChild(int parent)
  {
    return 2*parent+1;
  }

  public int rightChild(int parent)
  {
    return leftChild(parent)+1;
  }

  // public void dequeueAdjust(int root)
  // {
  //   if(root == 1)
  //     return;
  //   else if(root == count - 1)
  //     swap(rank[0], rank[1]);
  //   else
  //   {
  //     int parent = root;
  //     int leftChild = leftChild(root);
  //     int rightChild = rightChild(root); // = leftChild + 1
  //     if(rank[leftChild] < rank[rightChild])       // when leftChild is minimum
  //     {
  //       if(rank[leftChild] < rank[parent])
  //         {
  //           swap(rank[leftChild], rank[parent]);
  //           //dequeueAdjust(leftChild);
  //         }
  //     }
  //     else                                    // when rightChild is the minimum
  //     {
  //       if(rank[rightChild] < rank[parent])
  //         {
  //           swap(rank[rightChild], rank[parent]);
  //           //dequeueAdjust(rightChild);
  //         }
  //     }
  //     dequeueAdjust(leftChild);
  //     dequeueAdjust(rightChild);
  //   }
  // }

  public void swap(int a, int b)
  {
    int temp = a;
    a = b;
    b = temp;
  }

  public void enqueueAdjust(int count)
  {
    if(count == 0 || count == 1)
      return;
    if(count == 2)
    {
      if(rank[0] > rank[1])
        swap(rank[0], rank[1]);
    }
    else
    {
      int parent = parent(count-1);
      int leftChild = leftChild(parent);
      if(rightChild <= count)
        int rightChild = rightChild(parent); // = leftChild + 1
      //int minimum = rank[rightChild];
      if(rank[leftChild] < rank[rightChild])
      {
        //minimum = rank[leftChild];
        if(rank[leftChild] < rank[parent])
          {
            swap(rank[leftChild], rank[parent]);
          }
      }
      else
      {
        if(rank[rightChild] < rank[parent])
          {
            swap(rank[rightChild], rank[parent]);
          }
      }
      enqueueAdjust(parent);
    }
  }

  public int dequeue()
  {
    if(isEmpty())
      throw new IllegalStateException("The priority queue is empty.");
    else if(count >= 2)
    {
      int temp = rank[0];
      rank[0] = rank[count-1]; // move the last element to the 1st

      count -= 1;
      enqueueAdjust(count);
      return temp;
    }
    else
    {
      count -= 1;
      return rank[0];
    }
  }

  public void enqueue(int num)
  {
      rank[count] = num; // add the new element at the end
      count += 1;
      if(count >= 2)
        enqueueAdjust(count);
  }

  public boolean isEmpty()
  {
    return count == 0;
  }

}

//  SNOBBERY. How the aristocracy behaves in a queue. 20 points.

class Snobbery
{

//  MAIN. Queue them up.

  public static void main(String[] args)
  {
    PriorityQueue queue = new PriorityQueue(100);

    // int[] A = {9,8,7,6,5,4,3,2,1,0};
    // for(int i = 0; i < A.length; i++)
    // {
    //   queue.enqueue(A[i]);
    // }
    queue.enqueue(5);
    queue.enqueue(7);
    queue.enqueue(3);
    queue.enqueue(1);
    queue.enqueue(6);
    //System.out.println(queue.dequeue());

    queue.enqueue(90);
    queue.enqueue(8);
    queue.enqueue(-2);
    queue.enqueue(20);



    System.out.println(queue.dequeue());  //  0
    System.out.println(queue.dequeue());  //  1
    System.out.println(queue.dequeue());  //  5
    System.out.println(queue.dequeue());  //  6
    System.out.println(queue.dequeue());  //  7
    System.out.println(queue.dequeue());  //
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());

//  It's OK if Fawlty comes out before Turing, but both must come out last.

    System.out.println(queue.isEmpty());  //  true        2 points.
  }

}
