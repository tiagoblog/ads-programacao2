package aula6swing.questoes.interfaces;

import java.text.ParseException;

import javax.swing.JFrame;

public interface JFrameConfiguracoesBasicas {
	
	public final int LARGURA = 600;
	public final int ALTURA = 600;
	
	public default void configurarExibicao(JFrame jframe) {	
		jframe.pack();
		jframe.setSize(LARGURA,ALTURA);
		jframe.setVisible(true);
		jframe.setLocationRelativeTo(null);
	}
	
	public void inicializaComponentes() throws ParseException;
	
	public void criaEventos();
}
