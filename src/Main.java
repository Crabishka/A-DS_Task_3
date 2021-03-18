import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(3);
        q.offer(3);
        q.offer(4);
        q.offer(3);
        q.offer(2);
        q.offer(1);

        /*
        q.offer(1);
        q.offer(3);
        q.offer(3);
        q.offer(4);
        q.offer(3);
        q.offer(2);
        q.offer(1);
         */
        if (isQueuePalindrome(q)) System.out.println("yes");
        else System.out.println("no");


    }

    public static boolean isQueuePalindrome(Queue<Integer> queue) {
        return recFunc(queue.size() / 2, queue);
    }

    public static boolean recFunc(int level, Queue<Integer> queue) throws NullPointerException {
        int temp = 0;
        if (queue.size() % 2 == 1 && level == 0) queue.offer(queue.poll());
        else {
            temp = queue.poll();
            queue.offer(temp);
        }
        if (level > 0) {
            if (!recFunc(level - 1, queue)) return false;
            if (queue.poll() == temp) {
                queue.offer(temp);
                return true;
            } else {
                return false;
            }


        }

        return true;
    }
}
