package main;


import javax.swing.JOptionPane;

import hashing.HashTableEx1;

public class Main_Ex1 {

	public static void main(String[] args) {
		HashTableEx1 tabela = new HashTableEx1();
		int input = 1;
		int item; String objeto;
		while (input > 0) {
			input = Integer.parseInt(JOptionPane.showInputDialog("1 - Acrescentar valores na tabela"
					+ "\n2 - Procurar um elemento da tabela"
					+ "\n3 - Excluir um elemento da tabela"
					+ "\n4 - Printar valores da tabela"
					+ "\n5 - Verificar se tabela está cheia"
					+ "\n-1 - Sair"));
			
			switch(input) {
			case 1:
				item = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da chave."));
				objeto = JOptionPane.showInputDialog("Insira o nome.");
				tabela.inserir(item, objeto);
				break;
			case 2:
				objeto = JOptionPane.showInputDialog("Insira o nome.");
				tabela.buscaNome(objeto);
				break;
			case 3:
				objeto = JOptionPane.showInputDialog("Insira o nome.");
				tabela.apagarNome(objeto);
				break;
			case 4:
				tabela.printar();
				break;
			case 5:
				if(tabela.cheia()) {System.out.println("Esta cheia.");}
				else {System.out.println("Nao esta cheia.");}
			}
			
			
			
		}
	}

}
