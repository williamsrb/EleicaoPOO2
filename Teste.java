import java.util.Stack;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> pilha = new Stack<Integer>();
		pilha.push(new Integer(0));
		pilha.push(new Integer(1));
		pilha.push(new Integer(2));
		pilha.push(new Integer(3));
		pilha.push(new Integer(4));
		pilha.push(new Integer(5));
		pilha.push(new Integer(6));
		pilha.push(new Integer(7));
		pilha.push(new Integer(8));
		pilha.push(new Integer(9));
		//pilha.setElementAt(new Integer(10), 0);
		//pilha.setElementAt(new Integer(11), 1);
		//pilha.setElementAt(new Integer(12), 2);
		//pilha.setElementAt(new Integer(13), 3);
		pilha.setElementAt(new Integer(14), 4);
		//pilha.setElementAt(new Integer(15), 5);
		//pilha.setElementAt(new Integer(16), 6);
		//pilha.setElementAt(new Integer(17), 7);
		//pilha.setElementAt(new Integer(18), 8);
		//pilha.setElementAt(new Integer(19), 9);
		
		int listsize = pilha.size();
		for(int i = 0; i < listsize; i++) {
			System.out.println(pilha.pop().intValue());
		}
	}

}
