package aula6swing.questoes;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import aula6swing.questoes.interfaces.JFrameConfiguracoesBasicas;

public class Questao1 extends JFrame implements JFrameConfiguracoesBasicas {

	private static final long serialVersionUID = 1L;

	private static String RESULTADO = "...";	
	
	private String textoResultado = "A diferença entre as datas é de ... dias";

	private JPanel painelPrincipal;
	private JLabel labelPrimeiraData;
	private JLabel labelSegundaData;
	private JLabel labelResultado;
	private JFormattedTextField inputPrimeiraData;
	private JFormattedTextField inputSegundaData;
	private JButton buttonCalculaDiferenca;
	
	public Questao1() {
		
		super("Diferença entre datas");

		try {
			montaJFrame();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void montaJFrame() throws ParseException {
		inicializaComponentes();
		configurarExibicao(this);
	}

	private void inicializaComponentes() throws ParseException {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.painelPrincipal = new JPanel();
		this.labelPrimeiraData = new JLabel("Primeira data:");
		this.labelSegundaData = new JLabel("Segunda data:");
		this.labelResultado = new JLabel(this.textoResultado);

		MaskFormatter mascara = new MaskFormatter("##/##/####");
		this.inputPrimeiraData = new JFormattedTextField(mascara);
		this.inputSegundaData = new JFormattedTextField(mascara);

		this.buttonCalculaDiferenca = new JButton("Calcular Diferença");

		this.add(this.painelPrincipal);
		this.painelPrincipal.add(this.labelPrimeiraData);
		this.painelPrincipal.add(this.inputPrimeiraData);
		this.painelPrincipal.add(this.labelSegundaData);
		this.painelPrincipal.add(this.inputSegundaData);
		this.painelPrincipal.add(this.labelResultado);
		this.painelPrincipal.add(this.buttonCalculaDiferenca);

		criaEventos();

	}

	private void criaEventos() {
		this.buttonCalculaDiferenca.addActionListener(actionListener -> calculaDiferencaEntreDatas());
	}

	private void calculaDiferencaEntreDatas() {

		String primeiraData = this.inputPrimeiraData.getText();
		String segundaData = this.inputSegundaData.getText();

		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data1 = LocalDate.parse(primeiraData, dateformatter);
		LocalDate data2 = LocalDate.parse(segundaData, dateformatter);

		long dias = ChronoUnit.DAYS.between(data1, data2);

		atualizaResultadoNaTela(dias + "");
	}

	private void atualizaResultadoNaTela(String diferencaEmDias) {
		this.labelResultado.setText(this.textoResultado.replace(RESULTADO, diferencaEmDias));
	}

}
