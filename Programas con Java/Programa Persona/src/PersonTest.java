
public class PersonTest {

	public static void main(String[] args) {
	Persona p1 = new Persona();
	Trabajo t1= new Trabajo(5000, 123335577, "desarrollador");
	p1.setNombre("andres");
	p1.setApellido("rodriguez");
	p1.setDireccion("san vicente");
	p1.setCedula(100456789);
	
	
	
		System.out.println("nombre es y empleo:"+ p1.getNombre()+" "+"apellido"+p1.getApellido()+" "+"identificacion carnet o cedula"+p1.getCedula()+" "+ "direccion"+p1.getDireccion());
		
			
	

	
	
	

	}

}
