import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(3);
        q.offer(2);
        q.offer(1);
        if (isQueuePalindrome(q)) System.out.println("DA");


    }

    public static boolean isQueuePalindrome(Queue<Integer> queue) {
        return recFunc(queue.size() / 2, queue);
    }

    public static boolean recFunc(int level, Queue<Integer> queue) {
        if (queue.size() % 2 == 1 && level == 0) queue.offer(queue.poll());
        if (level > 0) {
            int temp = queue.poll();
            queue.offer(temp);
            recFunc(level - 1, queue);
            if (queue.poll() == temp) return true;
        }
        return false;


    }
}
