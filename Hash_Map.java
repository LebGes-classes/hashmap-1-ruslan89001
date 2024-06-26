public class Hash_Map<K, V> {
    private class Node {
        int hash;
        K key;
        V value;
        Node next;

        Node(int hash, K key, V value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Node node = (Node) obj;
            return hash == node.hash && key.equals(node.key) && value.equals(node.value);
        }

        @Override
        public int hashCode() {
            int result = hash;
            result = 31 * result + key.hashCode();
            result = 31 * result + (value == null ? 0 : value.hashCode());
            return result;
        }
    }

    private Object[] table;
    private int size;

    public Hash_Map() {
        table = new Object[16];
        size = 0;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash & (table.length - 1);
        Node node = (Node) table[index];

        if (node == null) {
            table[index] = new Node(hash, key, value, null);
        } else {
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            table[index] = new Node(hash, key, value, (Node) table[index]);
        }
        size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash & (table.length - 1);
        Node node = (Node) table[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean containsValue(V value) {
        for (Object o : table) {
            Node node = (Node) o;
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public void remove(K key) {
        int hash = key.hashCode();
        int index = hash & (table.length - 1);
        Node node = (Node) table[index];
        Node prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
    public int size() {
        return size;
    }

}
