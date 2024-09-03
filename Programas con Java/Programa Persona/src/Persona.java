
public class Persona {
private String nombre;
private String apellido;
private int cedula;
private String direccion;
private Trabajo trabajo;
public Persona(String nombre, String apellido, int cedula, String direccion, Trabajo trabajo ) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.cedula = cedula;
	this.direccion = direccion;
	this.trabajo = trabajo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getCedula() {
	return cedula;
}
public void setCedula(int cedula) {
	this.cedula = cedula;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public Trabajo getTrabajo() {
	return trabajo;
}
public void setTrabajo(Trabajo trabajo) {
	this.trabajo = trabajo;
}


}
