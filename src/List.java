import Exceptions.EmptyListException;
import Exceptions.InvalidIndexException;
import Exceptions.ValueNotFoundException;

public class List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;


    public List() {
        head = null;
        tail = null;
        size = 0;
    }


    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            tail = node;
        } else {
            node.next = head;
        }
        head = node;
        size++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void addMiddle(T data, int index) throws InvalidIndexException {
        if (index < 0 || index > size - 1) {
            throw new InvalidIndexException("Invalid index");
        } else {
            Node<T> temp = head;
            Node<T> node = new Node<>(data);
            if (index == 0) {
                addFirst(data);
                return;
            }
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    public void removeFirst() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("Empty list!");
        } else {
            head = head.next;
            size--;
        }

    }

    public void removeLast() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("Empty list!");
        } else {
            if (size == 1) {
                removeFirst();
            } else {
                Node<T> temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }
                temp.next = null;
                size--;
            }
        }
    }

    public void removeMiddle(int index) throws EmptyListException, InvalidIndexException {
        if (index < 0 || index > size - 1) {
            throw new InvalidIndexException("Invalid index");
        } else {
            if (head == null) {
                throw new EmptyListException("Empty list!");
            } else {
                if (index == 0) {
                    removeFirst();
                    return;
                }
                Node<T> temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }
    }

    public void replaceFirst(T data) throws EmptyListException {
        Node<T> node = new Node<>(data);
        if (head == null) {
            throw new EmptyListException("Empty list!");
        } else {
            node.next = head.next;
            head = node;
        }
    }

    public void replaceLast(T data) throws EmptyListException {
        Node<T> node = new Node<>(data);
        if (head == null) {
            throw new EmptyListException("Empty list!");
        } else {
            Node<T> temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void replaceMiddle(T data, int index) throws InvalidIndexException {
        if (index < 0 || index > size - 1) {
            throw new InvalidIndexException("Invalid index");
        } else {
            Node<T> temp = head;
            Node<T> node = new Node<>(data);
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next.next;
            temp.next = node;
        }
    }

    public int getIndexByValue(T data) throws EmptyListException, ValueNotFoundException {
        Node<T> temp = head;
        if (head == null) {
            throw new EmptyListException("Empty list!");
        } else {
            int index = 0;
            while (temp.data != data) {
                if (temp.next == null) {
                    throw new ValueNotFoundException("Value not found");
                }
                index++;
                temp = temp.next;
            }
            return index;
        }
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}
