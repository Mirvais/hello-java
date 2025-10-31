import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Collections {

    public static void main(String[] args) {

        demoList();
        System.out.println("\n-----------------\n");

        demoStack();
        System.out.println("\n-----------------\n");

        demoFifoQueue();
        System.out.println("\n-----------------\n");

        demoPriorityQueue();
        System.out.println("\n-----------------\n");

        demoSet();
        System.out.println("\n-----------------\n");
    
        demoMap();
    }



    //-----------------
    // List (ordered, indexable, duplicates allowed)
    //-----------------
    private static void demoList() {
        System.out.println("LIST DEMO");

        // ArrayList: preserves insertion order, allows duplicates and nulls
        List<String> names = new ArrayList<>();
        names.add("Ada");
        names.add("Grace");
        names.add("Ada");    // duplicate allowed
        names.add(null);     // null allowed

        // Read
        System.out.println("First element via index: " + names.get(0));

        // Update
        names.set(1, "Grace Hopper");

        // Remove by index and by value
        names.remove(2);           // removes second "Ada"
        names.remove(null);        // removes a null if present

        // Search
        System.out.println("Contains 'Ada'? " + names.contains("Ada"));
        System.out.println("Index of 'Ada': " + names.indexOf("Ada"));

        // Iterate (3 common ways)
        for (int i = 0; i < names.size(); i++) {
            System.out.println("idx " + i + ": " + names.get(i));
        }
        for (String n : names) {
            System.out.println("for-each: " + n);
        }
        names.forEach(n -> System.out.println("forEach(): " + n));

        // Sort (stable); nulls last
        Collections.sort(names, Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("Sorted: " + names);

        // Notes:
        // - ArrayList: O(1) amortized append, O(1) get, O(n) remove/insert in middle.
        // - LinkedList: O(1) adds/removes at ends, O(n) random get.
    }



    //-----------------
    // Stack (LIFO) using Deque (prefer over legacy java.util.Stack)
    //-----------------
    private static void demoStack() {
        System.out.println("STACK (LIFO) DEMO");

        Deque<String> stack = new ArrayDeque<>(); // fast, no nulls

        // Push (top grows)
        stack.push("first");
        stack.push("second");
        stack.push("third"); // top

        // Peek (no removal)
        System.out.println("Peek top: " + stack.peek()); // third

        // Pop (LIFO removal)
        System.out.println("Pop: " + stack.pop()); // third
        System.out.println("Pop: " + stack.pop()); // second

        System.out.println("Empty? " + stack.isEmpty()); // false
        System.out.println("Size: " + stack.size());     // 1

        // Drain to show LIFO order
        while (!stack.isEmpty()) {
            System.out.println("Drain pop: " + stack.pop());
        }
    }



    //-----------------
    // FIFO Queue (arrival order) using ArrayDeque
    //-----------------
    private static void demoFifoQueue() {
        System.out.println("FIFO QUEUE DEMO");

        Queue<Integer> q = new ArrayDeque<>(); // fast, no nulls

        // Enqueue
        q.offer(10);  // offer is preferable (returns false if bounded-full)
        q.offer(20);
        q.offer(30);

        // Peek front without removing
        System.out.println("Front via peek: " + q.peek()); // 10

        // Dequeue
        System.out.println("poll(): " + q.poll()); // 10 removed
        System.out.println("remove(): " + q.remove()); // 20 removed (throws if empty)

        // Iterate in FIFO order
        q.addAll(Arrays.asList(40, 50));
        for (Integer x : q) {
            System.out.println("iter: " + x); // remaining: 30, 40, 50
        }

        // Note: For blocking/timeout semantics, use java.util.concurrent queues (e.g., LinkedBlockingQueue).
    }



    //-----------------
    // PriorityQueue (min-heap by default). “Smallest” per comparator comes out first.
    //-----------------
    private static void demoPriorityQueue() {
        System.out.println("PRIORITY QUEUE DEMO");

        // We'll model a simple Task with priority (lower number = more urgent)
        // Using a static inner class for Java 8 compatibility (no records).
        class Task {
            final int priority;
            final String name;
            Task(int p, String n) { this.priority = p; this.name = n; }
            @Override public String toString() { return "Task[p=" + priority + ", name=" + name + "]"; }
        }

        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override public int compare(Task a, Task b) {
                return Integer.compare(a.priority, b.priority); // min-heap by priority
            }
        });

        pq.offer(new Task(5, "low"));
        pq.offer(new Task(1, "urgent"));
        pq.offer(new Task(3, "normal"));

        System.out.println("Peek (current min): " + pq.peek()); // urgent

        while (!pq.isEmpty()) {
            System.out.println("Poll (next by priority): " + pq.poll());
        }

        // Notes:
        // - Iteration order is NOT sorted order; only successive polls are ordered.
        // - For a max-heap: use Comparator.reverseOrder() or negate the key.
        // - Nulls not allowed.
    }



    //-----------------
    // Set (uniqueness). HashSet/LinkedHashSet/TreeSet variants.
    //-----------------
    private static void demoSet() {
        System.out.println("SET DEMO");

        // HashSet: fast membership, no order, allows one null
        Set<String> tags = new HashSet<>();
        tags.add("java");
        tags.add("collections");
        tags.add("java");   // duplicate ignored
        tags.add(null);     // allowed in HashSet

        System.out.println("Contains 'java'? " + tags.contains("java"));
        tags.remove("collections");

        // Arbitrary iteration order for HashSet
        for (String t : tags) {
            System.out.println("HashSet iter: " + t);
        }

        // LinkedHashSet: preserves insertion order
        Set<String> ordered = new LinkedHashSet<>(Arrays.asList("a", "b", "c"));
        System.out.println("LinkedHashSet: " + ordered); // [a, b, c]

        // TreeSet: sorted, null not allowed (with natural order)
        Set<Integer> sorted = new TreeSet<>(Arrays.asList(3, 1, 2));
        System.out.println("TreeSet: " + sorted);        // [1, 2, 3]

        // Notes:
        // - Correctness depends on equals() and hashCode() for HashSet/LinkedHashSet.
        // - TreeSet requires Comparable elements or a Comparator.
    }



    //-----------------
    // Map (key -> value). HashMap/LinkedHashMap/TreeMap variants.
    //-----------------
    private static void demoMap() {
        System.out.println("MAP DEMO");

        // HashMap: fast average-case lookups, undefined iteration order. Allows 1 null key and null values.
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Ada", 95);
        scores.put("Grace", 99);
        scores.put("Ada", 97);       // overwrites value for key "Ada"
        scores.put(null, 0);         // one null key allowed

        // Read + defaults
        System.out.println("Grace -> " + scores.get("Grace"));                  // 99
        System.out.println("Alan or default -> " + scores.getOrDefault("Alan", -1)); // -1

        // Presence
        System.out.println("Has key 'Ada'? " + scores.containsKey("Ada"));
        System.out.println("Has value 97? " + scores.containsValue(97));

        // Remove
        scores.remove("Ada");                  // by key
        scores.remove("Grace", 100);           // conditional (no-op; value mismatched)

        // Iterate entries
        for (Map.Entry<String, Integer> e : scores.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // Views
        System.out.println("Keys: " + scores.keySet());
        System.out.println("Values: " + scores.values());

        // Compute/update idioms
        scores.merge("Alan", 50, new BiFunction<Integer, Integer, Integer>() {
            @Override public Integer apply(Integer oldV, Integer add) { return oldV + add; }
        }); // insert 50 if absent, else add

        scores.computeIfAbsent("New", new Function<String, Integer>() {
            @Override public Integer apply(String k) { return k.length(); }
        });

        scores.computeIfPresent("Alan", new BiFunction<String, Integer, Integer>() {
            @Override public Integer apply(String k, Integer v) { return v + 1; }
        });

        System.out.println("After compute/merge: " + scores);

        // Ordered variants
        Map<String, Integer> ordered = new LinkedHashMap<>();
        ordered.put("a", 1); ordered.put("b", 2); ordered.put("c", 3);
        System.out.println("LinkedHashMap (insertion order): " + ordered);

        Map<String, Integer> sorted = new TreeMap<>(Comparator.naturalOrder());
        sorted.put("b", 2); sorted.put("a", 1); sorted.put("c", 3);
        System.out.println("TreeMap (sorted by key): " + sorted);

        // Notes:
        // - HashMap: O(1) average get/put with good hashing; order undefined.
        // - LinkedHashMap: predictable iteration (insertion order) and can be used for LRU by overriding removeEldestEntry.
        // - TreeMap: O(log n) operations; keys sorted; null keys not allowed with natural order.
    }
}
