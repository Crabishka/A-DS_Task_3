import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++){
            q.add(scanner.nextInt());
        }

        if (isQueuePalindrome(q)) System.out.println("yes");
        else System.out.println("no");

        for (int a : q ){
            System.out.print(a + " ");
        }


    }

    public static boolean isQueuePalindrome(Queue<Integer> queue) {
        return recFunc((queue.size() / 2) , queue);

    }

    public static boolean recFunc(int level, Queue<Integer> queue) throws NullPointerException {
        if (queue.size() < 2 ) return true;
        int temp = 0;
        if (queue.size() % 2 == 1 && level == 0) queue.offer(queue.poll());
        else if (level != 0){
            temp = queue.poll();
            queue.offer(temp);
        }
        if (level > 0) {
            if (!recFunc(level - 1, queue)) {
                queue.offer(queue.poll());
                return false;
            }
            int tempIn = queue.poll();
            if (tempIn == temp) {
                queue.offer(tempIn);
                return true;
            } else {
                queue.offer(tempIn);
                return false;
            }


        }

        return true;
    }
}
