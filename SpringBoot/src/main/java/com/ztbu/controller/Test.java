
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    static class Item {
        int weight;
        int value;
        double unitValue;
        Item(int w, int v) {
            weight = w;
            value = v;
            unitValue = value * 1.0 / weight;
        }
    }

    static class Node {
        int level;
        int weight;
        int bound;
        int value;

        Node(int l, int w, int b, int v) {
            level = l;
            weight = w;
            bound = b;
            value = v;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return n2.bound - n1.bound;
        }
    }

    public static int knapsack01(int[] weights, int[] values, int capacity) {
        Item[] items = new Item[weights.length];
        for (int i = 0; i < weights.length; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        int maxValue = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        pq.offer(new Node(-1, 0, bound(0, 0, items, capacity), 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.bound <= maxValue) {
                break;
            }
            if (node.level == items.length - 1) {
                continue;
            }


            Item item = items[node.level + 1];
            if (node.weight + item.weight <= capacity) {
                int value = node.value + item.value;
                int weight = node.weight + item.weight;
                int bound = bound(node.level + 1, weight, items, capacity);
                if (value > maxValue) {
                    maxValue = value;
                }
                pq.offer(new Node(node.level + 1, weight, bound, value));
            }


            int bound = bound(node.level + 1, node.weight, items, capacity);
            if (bound > maxValue) {
                pq.offer(new Node(node.level + 1, node.weight, bound, node.value));
            }
        }

        return maxValue;
    }

    private static int bound(int level, int weight, Item[] items, int capacity) {
        int bound = 0;
        int w = weight;
        for (int i = level + 1; i < items.length; i++) {
            if (w + items[i].weight <= capacity) {
                bound += items[i].value;
                w += items[i].weight;
            } else {
                bound += (capacity - w) * items[i].unitValue;
                break;
            }
        }
        return bound;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        int maxValue = knapsack01(weights, values, capacity);
        System.out.println(maxValue);
    }
}

