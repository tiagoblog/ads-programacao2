package aula6swing.questoes;

import javax.swing.JFrame;

import aula6swing.questoes.interfaces.JFrameConfiguracoesBasicas;

public class Questao2 extends JFrame implements JFrameConfiguracoesBasicas{

	private static final long serialVersionUID = 1L;

	public Questao2() {
		montaJFrame();
	}


	private void montaJFrame() {

		configurarExibicao(this);
	}

}
