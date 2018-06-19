public class Dis3SLList {
    // Discussion 3 SLList
private class IntNode {
public int item;
public IntNode next;
public IntNode(int item, IntNode next) {
    this.item = item;
    this.next = next;
    }
}
private IntNode first;
public void addFirst(int x) {
    first = new IntNode(x, first);
}

public void get(){
    // Print all items in the SLList
    IntNode pointer = first;
    while (pointer!=null){
        System.out.print(pointer.item);
        System.out.print(",");
        pointer = pointer.next;
    }
    System.out.print("\n");
}

/**insert: takes integer x and insert it at the given position
 * my solution uses a flag to indicate whether i can find the position before the end**/
public void insert (int item, int position){
    int i = 0;
    boolean flag = false;
    IntNode pointer = first;
    while (pointer!=null){
        if (i + 1 == position){
            IntNode NextNode = pointer.next;
            pointer.next = new IntNode(item, NextNode);
            flag = true;
        }
        if(pointer.next==null && flag == false){
            pointer.next = new IntNode(item, null);
            break;
        }
        pointer = pointer.next;
        i++;
    }
}

// official solution
// https://sp18.datastructur.es/materials/discussion/disc03sol.pdf
public void insert_solution(int item, int position){
    if (first == null || position == 0){ // take this situation in to consideration
        addFirst(item);
        return;
    }
    IntNode currentNode = first;
    while (position > 1 && currentNode != null){
        position --; //make changes on position to find the place to insert
        currentNode = currentNode.next;
    }
    IntNode newNode = new IntNode(item, currentNode.next);
    currentNode.next = newNode;
}

// same as the solution
// 反向整个Linked List
public void reverse(){
    IntNode p = first;  //本项p 指向头 better name: nextNodetoAdd
    IntNode prev = null; //前一项prev 存储前一项 better name:frontOfReversed
    while(p != null){ //直到本项为null，前一项prev为最后一项
        IntNode temp = p.next; //暂存下一项为temp better name: remainderOfOriginal
        p.next = prev; //逆转本项的next指针，使其指向prev
        prev = p; //prev前移一位，指向本项
        p = temp; //本项前移一位指向下一项
    }
    first = prev; //头first 指向最后一项，完成反向
}
 //Reverse with recursion, I didn't figure out the solution
private void rreverse(IntNode p){
    if (p.next == null){
        first = p;
    }else{
        rreverse(p.next);
        p.next.next = p;
        p.next = null;  //差了一点就写出来了，根据答案补充的一行，避免陷入死循环。
    }
}

//https://sp18.datastructur.es/materials/discussion/disc03sol.pdf
private IntNode reverseRecursiveHelper(IntNode front){
    if(front == null || front.next == null){
        return front; //最后一层
    }else {
        IntNode reversed = reverseRecursiveHelper(front.next); // 把最底层的front一层层传递到顶层
        front.next.next = front; // 逆转指针
        front.next = null;
        return reversed;
    }
}


public void RecursiveReverse(){
    //first = reverseRecursiveHelper(first);
    rreverse(first);
}

public static void main(String[] args){
    Dis3SLList L = new Dis3SLList();
    L.addFirst(5);
    L.addFirst(4);
    L.addFirst(3);
    L.addFirst(2);
    L.addFirst(1);
    L.get();
    //L.insert(0,10);
    L.reverse();
    L.get();
    L.RecursiveReverse();
    L.get();
}
}
