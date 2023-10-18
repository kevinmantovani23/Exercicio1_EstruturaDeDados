package hashing;

public class HashTableEx1 {

	Hash_ex1[] tabela;
	static int TAM_MAX = 26;
	int pos;

	public HashTableEx1() {
		tabela = new Hash_ex1[TAM_MAX];
		for (int i = 0; i < TAM_MAX; i++) {
			tabela[i] = new Hash_ex1();
		}
	}

	private int chavealt(int chave) {
		int v = chave;
		v %= TAM_MAX;
		return v;
	}

	public boolean cheia() {
		boolean cheia = true;
		for (int i = 0; i < TAM_MAX; i++) {
			if (!tabela[i].ocupado) {
				cheia = false;
				break;
			}
		}
		return cheia;
	}

	public void inserir(int item, String objeto) {
		if (cheia()) {
			System.out.println("A Hash esta cheia!");
			return;
		}
		pos = chavealt(item);

		while (pos <= TAM_MAX) {
			if (tabela[pos].ocupado) {
				if (tabela[pos].item == item) {
					System.out.println("Esse item já existe.");
					return;
				}
			}
			if (!tabela[pos].ocupado) {
				tabela[pos].item = item;
				tabela[pos].dado = objeto;
				tabela[pos].ocupado = true;
				System.out.println("Item colocado.");
				organizar();
				return;
			}
			if (pos == TAM_MAX - 1) {
				pos = -1;
			}
			pos++;
		}

	}

	private int buscaChave(int chave) {
		int pos = chavealt(chave);
		if (tabela[pos].ocupado) {
			if (tabela[pos].item == chave)
				return pos;
		}
		int inicio = pos;
		while (pos < TAM_MAX) {
			if (pos == TAM_MAX - 1) {
				pos = -1;
			}
			pos++;
			if (tabela[pos].ocupado && tabela[pos].item == chave) {
				System.out.println("Item: Hash[" + pos + "] (" + tabela[pos].item + ", " + tabela[pos].dado);
				return pos;
			}
			if (pos == inicio) {
				System.out.println("Item não encontrado");
				return -1;
			}
		}
		return -1;
	}

	public void apagarChave(int chave) {
		pos = buscaChave(chave);
		if (pos != -1) {
			System.out.println("Item apagado na posicao " + pos);
			tabela[pos].dado = "";
			tabela[pos].item = 0;
			tabela[pos].ocupado = false;
		}
	}

	public void buscaNome(String nome) {
		int pos = 0;
		if (tabela[pos].ocupado) {
			if (tabela[pos].dado == nome)
				System.out.println("O nome consta na posicao " + pos);
			return;
		}
		while (pos < TAM_MAX) {
			pos++;
			if (tabela[pos].ocupado && tabela[pos].dado == nome) {
				System.out.println("O nome consta na posicao " + pos);
				return;
			}
			if (pos == TAM_MAX - 1) {
				System.out.println("O nome nao consta.");
				return;
			}
		}
	}

	public void apagarNome(String nome) {
		for (int pos = 0; pos < TAM_MAX; pos++) {
			if (tabela[pos].dado == nome) {
				tabela[pos].dado = "";
				tabela[pos].item = 0;
				tabela[pos].ocupado = false;
				System.out.println("Nome apagado.");
			}
		}

	}

	public void organizar() {
		for (int i = 0; i < TAM_MAX; i++) {
			for (int x = 0; x < TAM_MAX - 1; x++) {
				if (tabela[x].dado.equals("_")) {
					String tempD = tabela[x].dado;
					int tempK = tabela[x].item;
					boolean tempOC = tabela[x].ocupado;
					tabela[x].dado = tabela[x + 1].dado;
					tabela[x].item = tabela[x + 1].item;
					tabela[x].ocupado = tabela[x + 1].ocupado;
					tabela[x + 1].dado = tempD;
					tabela[x + 1].item = tempK;
					tabela[x + 1].ocupado = tempOC;}
					else if (tabela[x+1].dado.equals("")) {
						
					
				} else {
						if (tabela[x].dado.compareToIgnoreCase(tabela[x+1].dado) > 0) {
							String tempD = tabela[x].dado;
							int tempK = tabela[x].item;
							boolean tempOC = tabela[x].ocupado;
							tabela[x].dado = tabela[x + 1].dado;
							tabela[x].item = tabela[x + 1].item;
							tabela[x].ocupado = tabela[x + 1].ocupado;
							tabela[x + 1].dado = tempD;
							tabela[x + 1].item = tempK;
							tabela[x + 1].ocupado = tempOC;
						}

					}
				}
			}
		}
	

	public void printar() {
		for (int i = 0; i < TAM_MAX; i++) {
			if (tabela[i].dado != "_") {
				System.out.println("Hash[" + i + "]: (" + tabela[i].item + ", " + tabela[i].dado + ")");
			}
		}
	}
}
