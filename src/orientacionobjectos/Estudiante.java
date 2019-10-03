package orientacionobjectos;

//git prueba



public class Estudiante {
	// estos dos atributos son de instancia classe
	private int Id;
	private String Nombre;
	// es un atributo de classe o static 
	public static int Cantidad;
	
	public Estudiante()  {
		
	}
	
	
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public Estudiante(int pId, String pNombre) {
		this.Id = pId;
		this.Nombre = pNombre;
	}
	
	public boolean matricularCurso(String pNombreCurso) {
		System.out.println("Matricule el curso "+pNombreCurso);
		return true;
	}
	
	// un método static solo puede acceder a atributos static 
	public static int retorneCantidad() {
		return Cantidad;
	}
}
