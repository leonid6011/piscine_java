package ex03;

import java.util.UUID;
public class TransactionsLinkedList implements TransactionsList {
    private int length = 0;
    private TrListNode	begin = new TrListNode(null, null, null);
    private TrListNode	end = new TrListNode(null, null, null);

    public TransactionsLinkedList() {
        begin.setNext(end);
        end.setPrevious(begin);
    }

    public void addTransaction(Transaction transaction) {
        begin.setNext(new TrListNode(begin.getNext(), begin, transaction));
        length++;
    }

    public void deleteTransaction(UUID id) {
        TrListNode tmp = begin.getNext();
        while (tmp != end)
        {
            if (tmp.getData().getIdentifier() == id)
            {
                tmp.getPrevious().setNext(tmp.getNext());
                tmp.getNext().setPrevious(tmp.getPrevious());
                tmp.setNext(null);
                tmp.setPrevious(null);
                tmp.setData(null);
                length--;
                return ;
            }
            tmp = tmp.getNext();
        }
        throw new TransactionNotFoundException();
    }

    public Transaction[] toArray() {
        Transaction[] array = new Transaction[length];
        TrListNode tmpNode = begin.getNext();

        if (tmpNode.getData() != null)
        {
            for (int i = 0; i < length; i++) {
                array[i] = tmpNode.getData();
                tmpNode = tmpNode.getNext();
            }
        }
        return array ;
    }

    private static class TrListNode {

        private TrListNode	next;
        private TrListNode	previous;
        private Transaction		data;

        public TrListNode(TrListNode next, TrListNode prev, Transaction data) {
            this.next = next;
            this.previous = prev;
            this.data = data;
        }

        public void setNext(TrListNode next) {
            this.next = next;
        }
        public void setPrevious(TrListNode previous) {
            this.previous = previous;
        }
        public void setData(Transaction data) {
            this.data = data;
        }

        public TrListNode getNext() {
            return next;
        }
        public TrListNode getPrevious() {
            return previous;
        }
        public Transaction getData() {
            return data;
        }
    }
}
