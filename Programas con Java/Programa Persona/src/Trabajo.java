
public class Trabajo {
private int salario;
private int carnet;
private String  empleo;
public Trabajo(int salario, int carnet, String empleo) {
	
	this.salario = salario;
	this.carnet = carnet;
	this.empleo = empleo;

}
public int getSalario() {
	return salario;
}
public void setSalario(int salario) {
	this.salario = salario;
}
public int getCarnet() {
	return carnet;
}
public void setCarnet(int carnet) {
	this.carnet = carnet;
}
public String getEmpleo() {
	return empleo;
}
public void setEmpleo(String empleo) {
	this.empleo = empleo;
}

}
