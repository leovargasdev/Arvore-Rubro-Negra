class Arvore {

    public Nodo Raiz;

    public Arvore(){

        this.Raiz = null;
    }

    public void add(Nodo N, int k) {

        Nodo Novo = new Nodo(k);
        if(this.Raiz == null){
            this.Raiz = Novo;
            Novo.pai = Novo;
            Caso1(Novo);
        } else if ( k > N.info ) {
            if( N.direita == null ){
                N.direita = Novo;
                Novo.pai = N;
                Caso1(Novo);
            } else {
                add(N.direita,k);
            }
        } else {
            if( N.esquerda == null ){
                N.esquerda = Novo;
                Novo.pai = N;
                Caso1(Novo);
            } else {
                add(N.esquerda,k);
            }
        }

    }

    public void Caso1(Nodo N){

        if(N == Raiz){
            N.cor = "preto";
        } else {
            Caso2(N);
        }

    }

    public void Caso2(Nodo N){

        if( !N.pai.cor.equals("preto") ){
            Caso3(N);
        }

    }

    public void Caso3(Nodo N){

        Nodo tio = tio(N);
        Nodo avo = avo(N);
        Nodo pai = N.pai;
        if( tio != null && tio.cor.equals("vermelho") ){
            pai.cor = "preto";
            tio.cor = "preto";
            avo.cor = "vermelho";
            Caso1(avo);
        } else {
            Caso4(N);
        }

    }

    public void Caso4(Nodo N){

        Nodo tio = tio(N);
        Nodo pai = N.pai;
        Nodo avo = avo(N);
        if ( N == pai.direita && pai == avo.esquerda ){
            RotEsquerda(N);
        } else if ( N == pai.esquerda && pai == avo.direita ) {
            RotDireita(N);
        }
        Caso5(N);

    }

    public void Caso5(Nodo N){

        Nodo pai = N.pai;
        N.cor = "preto";
        pai.cor = "vermelho";
        if ( N == pai.esquerda){
            if ( pai.direita != null ) pai.direita.cor = "preto";
            RotDireita(N);
        } else {
            if ( pai.esquerda != null ) pai.esquerda.cor = "preto";
            RotEsquerda(N);
        }

    }

    public void Imprimir(Nodo N){

    		if (N == null) return;
            Imprimir(N.esquerda);
            if (N == Raiz) System.out.println("pai [ RAIZ ], nodo : " + N.info + "-" + N.cor);
            else System.out.println("pai [ " + N.pai.info + " ], nodo : " + N.info + "-" + N.cor);
    		Imprimir(N.direita);
    		return;

    }

    public void RotEsquerda(Nodo N){

        Nodo pai = N.pai;
        Nodo avo = avo(N);
        if ( avo.esquerda == pai ) avo.esquerda = N;
        else avo.direita = N;
        pai.direita = N.esquerda;
        if (N.esquerda != null) N.esquerda.pai =  pai;
        N.esquerda = pai;
        N.pai = avo;
        pai.pai = N;

    }

    public void RotDireita(Nodo N){

        Nodo pai = N.pai;
        Nodo avo = avo(N);
        if ( avo.esquerda == pai ) avo.esquerda = N;
        else avo.direita = N;
        pai.esquerda = N.direita;
        if (N.direita != null) N.direita.pai =  pai;
        N.direita = pai;
        N.pai = avo;
        pai.pai = N;

    }

	public Nodo avo(Nodo Nodo){

		if (Nodo.pai.pai != null){
			return Nodo.pai.pai;
		}
		return null;

    }

	public Nodo tio(Nodo Nodo){

        Nodo avo = avo(Nodo);
        if(avo == null){
            return null;
        } else if (Nodo.pai == avo.esquerda){
        	return avo.direita;
        } else {
        	return avo.esquerda;
        }

    }

}
