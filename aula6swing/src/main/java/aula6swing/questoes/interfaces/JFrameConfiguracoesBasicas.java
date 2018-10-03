package aula6swing.questoes.interfaces;

import javax.swing.JFrame;

public interface JFrameConfiguracoesBasicas {
	
	public default void configurarExibicao(JFrame jframe, int width, int heigth) {	
		jframe.pack();
		jframe.setSize(width,heigth);
		jframe.setVisible(true);
		jframe.setLocationRelativeTo(null);
	}
	
	public default void adicionaComponentes() {
		
	}

}
