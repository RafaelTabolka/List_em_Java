package dados;

public class entities {

	private int id;
	private String nome;
	private float salario;
	
	public entities(int id, String nome, float salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Id: " + id + ", Nome: " + nome
				+ ", Salário: " + String.format("%.2f", salario); 
	}
	
	public void aumentoSalario (float porcentagem) {
		salario += salario * porcentagem /100;
	}
	
	
}
