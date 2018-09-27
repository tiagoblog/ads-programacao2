package aula6swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Questao1 {

	private static final long serialVersionUID = 1L;
	
	private static String RESULTADO = "...";

	private JFrame janela;
	private JPanel painelPrincipal;
	private JLabel labelPrimeiraData;
	private JLabel labelSegundaData;
	private JLabel labelResultado;
	private JFormattedTextField inputPrimeiraData;
	private JFormattedTextField inputSegundaData;
	private JButton buttonCalculaDiferenca;
	private String textoResultado = "A diferença entre as datas é de ... dias";
	

	public Questao1() {
		try {
			montaTela();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void montaTela() throws ParseException {
		preparaJanela();
		preparaPainelPrincipal();
		preparaComponentes();
		preparaBotaoSair();
		mostraJanela();
	}

	private void preparaJanela() {
		janela = new JFrame("Diferença entre datas");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void preparaBotaoSair() {
		JButton botaoSair = new JButton("Sair");

		botaoSair.addActionListener(actionListener -> System.exit(0));

		painelPrincipal.add(botaoSair);
	}

	private void preparaPainelPrincipal() {
		this.painelPrincipal = new JPanel();
		janela.add(this.painelPrincipal);

	}

	private void preparaComponentes() throws ParseException {
		this.labelPrimeiraData = new JLabel("Primeira data:");
		this.labelSegundaData = new JLabel("Segunda data:");
		this.labelResultado = new JLabel(this.textoResultado);

		MaskFormatter mascara = new MaskFormatter("##/##/####");
		this.inputPrimeiraData = new JFormattedTextField(mascara);
		this.inputSegundaData = new JFormattedTextField(mascara);

		this.buttonCalculaDiferenca = new JButton("Calcular Diferença");
		this.buttonCalculaDiferenca.addActionListener(actionListener -> calculaDiferenca());

		this.painelPrincipal.add(this.labelPrimeiraData);
		this.painelPrincipal.add(this.inputPrimeiraData);
		this.painelPrincipal.add(this.labelSegundaData);
		this.painelPrincipal.add(this.inputSegundaData);
		this.painelPrincipal.add(this.labelResultado);
		this.painelPrincipal.add(this.buttonCalculaDiferenca);
	}

	private void calculaDiferenca() {

		String primeiraData = this.inputPrimeiraData.getText();
		String segundaData = this.inputSegundaData.getText();

		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data1 = LocalDate.parse(primeiraData, dateformatter);
		LocalDate data2 = LocalDate.parse(segundaData, dateformatter);
		
		long dias = ChronoUnit.DAYS.between(data1, data2);
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(dias);
		atualizaResultadoNaTela(dias+"");		
	}

	private void atualizaResultadoNaTela(String diferencaEmDias) {
		this.labelResultado.setText(this.textoResultado.replace(RESULTADO, diferencaEmDias));		
	}

	private void mostraJanela() {
		janela.pack();
		janela.setSize(600, 300);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		Questao1 questao1 = new Questao1();

	}

}
