package chuji;

import java.util.Stack;
/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 * @author kafka
 *
 */
public class GetMinStack {

	public static class MyStack{
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		public MyStack(){
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}
		
		public void push(Integer num){
			if(this.stackMin.isEmpty())
				this.stackMin.push(num);
			else
				this.stackMin.push(Math.min(this.stackMin.peek(), num));
			this.stackData.push(num);
		}
		
		public int pop(){
			if(this.stackData.isEmpty())
				throw new RuntimeException("your stack is empty.");
			this.stackMin.pop();
			return this.stackData.pop();
		}
		
		public int getMin(){
			if(this.stackMin.isEmpty())
				throw new RuntimeException("your stack is empty.");
			return this.stackMin.peek();
		}
	}
	
	public static void main(String[] args) {
		MyStack stack1 = new MyStack();
		stack1.push(3);
		System.out.println(stack1.getMin());
		stack1.push(4);
		System.out.println(stack1.getMin());
		stack1.push(1);
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());

		System.out.println("=============");
	}
	
}




