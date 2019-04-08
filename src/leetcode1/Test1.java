package leetcode1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import structure.TreeNode;


public class Test1 {

	public int run(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int depth=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
				if(node.left==null && node.right==null) {
					return depth;
				}
			}
		}
		return 0;
    }
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			stack.push(Integer.parseInt(tokens[i]));
			if(tokens[i]=="+" || tokens[i]=="-" || tokens[i]=="*" || tokens[i]=="/") {
				int int1 = stack.pop();
				int int2 = stack.pop();
				stack.push(replace(int1,int2,tokens[i]));
			}
		}
		if(stack.size()!=1) {
			return -1;
		}
		
		return stack.pop();
	}

	private Integer replace(int int1, int int2, String string) {
		// TODO Auto-generated method stub
		int num=0;
		if(string=="+") {
			num=int1+int2;
		}
		if(string=="-") {
			num=int1-int2;
		}
		if(string=="*") {
			num=int1*int2;
		}
		if(string=="/") {
			num=int1/int2;
		}
		return num;
	}
}
