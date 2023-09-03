package medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] firstLinked = { 1, 2, 3 };
        int[] secondLinked = { 1, 2, 3 };

        ListNode one = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode two = new ListNode(9);
        solution.addTwoNumbers(one, two);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger placeValue = new BigInteger("1");
        BigInteger first = new BigInteger("0");

        while (l1 != null) {
            first = first.add(placeValue.multiply(BigInteger.valueOf(l1.val)));
            placeValue = placeValue.multiply(BigInteger.valueOf(10));
            l1 = l1.next;
        }

        placeValue = BigInteger.valueOf(1);
        BigInteger second = BigInteger.valueOf(0);
        while (l2 != null) {
            second = second.add(placeValue.multiply(BigInteger.valueOf(l2.val)));
            placeValue = placeValue.multiply(BigInteger.valueOf(10));
            l2 = l2.next;
        }

        BigInteger resultInt = first.add(second);
        String resultString = String.valueOf(resultInt);
        System.out.println(resultString);

        ListNode firstNode = new ListNode(Character.getNumericValue(resultString.charAt(resultString.length() - 1)));
        ListNode currentNode = firstNode;
        for (int i = resultString.length() - 1; i >= 0; i--) {
            System.out.println(currentNode.val);
            if (i != 0) {
                ListNode nextNode = new ListNode(Character.getNumericValue(resultString.charAt(i - 1)));
                currentNode.next = nextNode;
                currentNode = nextNode;
            }
        }

        return firstNode;
    }
}
