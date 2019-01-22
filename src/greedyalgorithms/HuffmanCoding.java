package greedyalgorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by prajnashetty on 1/16/19.
 *
 * Time complexity: O(nlogn) where n is the number of unique characters. If there are n nodes, extractMin() is called 2*(n – 1) times. extractMin() takes O(logn) time as it calles minHeapify(). So, overall complexity is O(nlogn).

 If the input array is sorted, then complexity is O(n)
 */

class HuffmanNode {
    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(int d, char c, HuffmanNode l, HuffmanNode r) {
        this.data = d;
        this.c = c;
        this.left = l;
        this.right = r;
    }
}

class MyComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        return o1.data - o2.data;
    }
}

public class HuffmanCoding {
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        int n = charArray.length;

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n ; i++) {
            HuffmanNode node = new HuffmanNode(charFreq[i], charArray[i], null, null);
            priorityQueue.add(node);
        }

        HuffmanNode root = createHuffmanTree(priorityQueue);
        printHuffmanCode(root, "");
    }

    private static HuffmanNode createHuffmanTree(PriorityQueue<HuffmanNode> priorityQueue) {
        HuffmanNode root = null;

        while (priorityQueue.size() > 1) {

            //first min extract
            HuffmanNode x = priorityQueue.peek();
            priorityQueue.poll();

            //second min extract
            HuffmanNode y = priorityQueue.peek();
            priorityQueue.poll();

            //new node sum of min 2 nodes
            HuffmanNode sumNode =  new HuffmanNode(x.data + y.data, '-' , x, y);

            root = sumNode;
            priorityQueue.add(sumNode);
        }

        return root;
    }

    private static void printHuffmanCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }

        printHuffmanCode(root.left, s + "0");
        printHuffmanCode(root.right, s + "1");

    }

}





