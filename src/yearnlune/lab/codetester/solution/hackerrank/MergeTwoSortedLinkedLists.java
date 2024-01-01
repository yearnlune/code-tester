package yearnlune.lab.codetester.solution.hackerrank;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2024.1.1
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/problem
 */
public class MergeTwoSortedLinkedLists implements SolutionBase {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next = null;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "SinglyLinkedListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public Object setUp() {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, new SinglyLinkedListNode(3, null)));
        SinglyLinkedListNode head2 = new SinglyLinkedListNode(3, new SinglyLinkedListNode(4, null));
        return mergeLists(head1, head2);
    }

    @MainFunction
    public SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode result = null;
        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(merge(head1));
        mergedList.addAll(merge(head2));
        Collections.sort(mergedList);
        for (int i = mergedList.size() - 1; i >= 0; --i) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(mergedList.get(i));
            node.next = result;
            result = node;
        }

        return result;
    }

    List<Integer> merge(SinglyLinkedListNode head) {
        List<Integer> data = new ArrayList<>();
        data.add(head.data);
        if (head.next != null) {
            data.addAll(merge(head.next));
        }
        return data;
    }
}
