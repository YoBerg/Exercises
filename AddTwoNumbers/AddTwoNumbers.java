import java.lang.Math;

public class AddTwoNumbers {
    public static void main(String[] args) {
        try {
            Node node1 = createList(Integer.parseInt(args[0]));
            Node node2 = createList(Integer.parseInt(args[1]));
            printList(node1);
            printList(node2);
            printList(solution1(node1, node2));
        } catch (NumberFormatException e) {
            System.out.println("One of the arguments was not a number.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough arguments, at least 2 required.");
            return;
        }
    }

    public static void printList(Node head) {
        if (head.next != null) printListRecur(head.next);
        System.out.print(head.val);
        System.out.print("\n");
    }

    public static void printListRecur(Node node) {
        if (node.next != null) printListRecur(node.next);
        System.out.print(node.val);
    }

    /**
     * Creates a linked list from the given value
     * 
     * @param val the given value to be turned into a linked list.
     * @return the head of the created linked list
     */
    public static Node createList(int val) {
        Node head = null;
        // Turn val into a character array.
        char[] chars = ("" + val).toCharArray();
        // Read character array from left to right, creating the node with the read digit.
        for (int i = 0; i < chars.length; i++) {
            Node new_node = new Node(Character.getNumericValue(chars[i]), head);
            head = new_node;
        }
        if (head == null) return new Node(0);
        return head;
    }

    /**
     * Generate a random integer from 1 to the given maximum.
     * 
     * @param max the maximum integer of the random number.
     * @return a random interger from 1 to the given maximum.
     */
    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * (max)) + 1;
    }

    public static Node solution1(Node head1, Node head2) {
        // If either node does not exist, treat it as a 0.
        if (head1 == null) return head2;
        else if (head2 == null) return head1;

        int level = 0;
        int value = 0;
        Node node1 = head1;
        Node node2 = head2;
        // While either list contains values, continue adding.
        // Adds the value of the node times the digit value of the node.
        // E.G. 537 + 123 = (7 * 1 + 3 * 1) + (3 * 10 + 2 * 10) + (5 * 100 + 1 * 100)
        // Each pair of parentheses represents an iteration.
        // Runtime is theoretically n where O(n) is the number of digits in the greater number or O(log(n)) where n is the value of the larger number.
        do {
            if (node1 != null) {
                value += node1.val * (int) Math.pow(10, level);
                node1 = node1.next;
            };
            if (node2 != null) {
                value += node2.val * (int) Math.pow(10, level);
                node2 = node2.next;

            }

            level++;
        } while (node1 != null || node2 != null);

        // The below has a runtime theoretical runtime of O(n) where n is the number of digits or O(log(n)) where n is the value.
        return createList(value);
    }
}