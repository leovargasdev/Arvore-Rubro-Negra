class Nodo{

    Nodo esquerda;

	Nodo direita;

	Nodo pai;

    int info;

	String cor;

    public Nodo(int chave){

		this.esquerda = null;

        this.direita = null;

        this.pai = null;

        this.info = chave;

		this.cor = "vermelho";

    }  
}
