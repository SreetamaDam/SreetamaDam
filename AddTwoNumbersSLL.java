import java.util.*;
import java.io.*;
import java.math.*;

public class AddTwoNumbersSLL{
	
	static Node n1Head, n2Head;
	
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static Node reverse(Node head) {
		if (head == null || head.next == null)
			return head;
		Node node = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}
	static void viewSLL(Node nhead) {
		if (nhead == null) 
			System.out.println("Empty list");
		else {
			Node currentNode = nhead;
			while (currentNode != null) {
				System.out.print(currentNode.data+ " ");
				currentNode = currentNode.next;
			}
		}
		System.out.println();
	}
	
	static void insertAtEnd( Node head, int item) {
		Node node = new Node(item);
		if (head == null)
			head = node;
		else {
			Node currentNode = head;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = node;
		}
	}
	
	static int getSum(int n1, int n2) {
		n1Head = getList(n1);
		n2Head = getList(n2);
		int carry = 0, sum = 0;
		Node head = new Node(0);
		while (n1Head != null && n2Head != null) {
			sum = (n1Head.data + n2Head.data + carry) % 10;
			carry = (n1Head.data + n2Head.data + carry) / 10;
			System.out.println("Sum: "+sum+", carry:"+carry);
			Node currNode = new Node(sum);
			n1Head = n1Head.next;
			n2Head = n2Head.next;
			insertAtEnd(head, sum);
			viewSLL(head);
		}
		while (n1Head != null) {
			sum = (n1Head.data + carry) % 10;
			carry = (n1Head.data + carry) / 10;
			n1Head = n1Head.next;
			insertAtEnd(head, sum);
			viewSLL(head);
		}
		while (n2Head != null) {
			sum = (n2Head.data + carry) % 10;
			carry = (n2Head.data + carry) / 10;
			n2Head = n2Head.next;
			insertAtEnd(head, sum);
			viewSLL(head);
		}
		if (carry != 0)
			insertAtEnd(head, carry);
		
		head = head.next;
		sum = 0;
		int i = 0;
		System.out.println(head.data);
		while (head != null) {
			sum += head.data * Math.pow(10,i);
			i++;
			head = head.next;
		}
		return sum;
	}
	
	static Node getList(int n) {
		Node currNode = new Node(0);
		Node headNode = currNode;
		while (n != 0) {
			currNode.next = new Node(n%10);
			//System.out.println(currNode.next.data);
			n /= 10;
			currNode = currNode.next;
		}
		return headNode.next;
	}
	
	
	public static void main(String[] args) {
		int a = 3456;
		int b = 8762;
		System.out.println("Sum is : " + getSum(a, b));
	}
}