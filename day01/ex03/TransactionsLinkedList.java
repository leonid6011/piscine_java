package ex03;

import java.util.UUID;
public class TransactionsLinkedList implements TransactionsList {
    private int length = 0;
    private TrListNode head = new TrListNode(null);

    public void addTransaction(Transaction transaction) {
        TrListNode node = new TrListNode(transaction);
        if (head != null) {
            head.setPrevious(head);
            node.setNext(head);
            head = node;
            length++;
        }  else {
            node.setPrevious(null);
            node.setNext(head);
            head = node;
            length++;
        }
    }

    public void deleteTransaction(UUID id) {
        TrListNode tmp = head;
        for (int i = 0; i < length; i++)
        {
            if (tmp.getData().getIdentifier() == id)
            {
                if (tmp.getPrevious() != null) {
                    tmp.getPrevious().setNext(tmp.getNext());
                }
                else {
                    head = tmp.getNext();
                }
                if (tmp.getNext() != null) {
                    tmp.getNext().setPrevious(tmp.getPrevious());
                }
                length--;
                return;
            }
            tmp = tmp.getNext();
        }
        throw new TransactionNotFoundException();
    }
    public  Transaction[] toArray() {
        TrListNode tmpNode = head;
        Transaction[] array = new Transaction[length];
        for (int i = 0; i < length; i++)
        {
            array[i] = tmpNode.getData();
            tmpNode = tmpNode.getNext();
        }
        return array;
    }

    public class TrListNode {
        private Transaction data;
        private TrListNode next;
        private TrListNode prev;

        public TrListNode(Transaction data) { this.data = data; }
        public void setData(Transaction data) { this.data = data; }
        public void setPrevious(TrListNode prev) { this.prev = prev; }
        public void setNext(TrListNode next) { this.next = next; }
        public Transaction getData() { return data; }
        public TrListNode getPrevious() { return prev; }
        public TrListNode getNext() { return next; }
    }
}
