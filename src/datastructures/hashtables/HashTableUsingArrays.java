package datastructures.hashtables;

/**
 * Created by prajnashetty on 2/28/19.
 *
 * With linear probing in open addressing strategy.
 */
class HashTable {

    private final static int TABLE_SIZE = 100;
    private HashEntry[] table ;

    HashTable() {
        table = new HashEntry[TABLE_SIZE];

        for (int i = 0 ; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public int get(int key) {
        int hash = key % TABLE_SIZE;
        while(table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        //key not present
        if (table[hash] == null)
             return -1;
        else {
            //key is present
            return table[hash].getValue();
        }
    }

    public void put(int key, int value) {
        int hash = key % TABLE_SIZE;
        while(table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        table[hash] = new HashEntry(key, value);
    }


}

class HashEntry{
    int key;
    int value;

    HashEntry(int k, int v) {
        key = k;
        value = v;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

public class HashTableUsingArrays {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(12, 120);
        hashTable.put(100, 1000);
        hashTable.put(400, 480);

        System.out.println(hashTable.get(100));
        System.out.println(hashTable.get(120));
        System.out.println(hashTable.get(400));
    }
}

