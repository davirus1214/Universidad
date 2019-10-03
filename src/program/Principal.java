package program;
import orientacionobjectos.*;
import arreglos.*;

public class Principal {
	public static void main(String[] args) {
		
		Estudiante est = new Estudiante(1, "Ana");
		est.matricularCurso("Estructuras de datos");
		est.Cantidad = 1;
		
		Estudiante.Cantidad = 100;
		
		Estudiante est2 = new Estudiante(2, "Pedro");
		est2.Cantidad = 200;
		
		System.out.println("Estudiante: "+est.getNombre()+" "+est.Cantidad);
		System.out.println("Estudiante: "+est2.getNombre()+" "+est2.Cantidad);
		System.out.println("La classe Estudiante: "+Estudiante.Cantidad);
		
		
		System.out.println("Retorna: "+Estudiante.Cantidad);
		
		Pantallilla pantalla = new Pantallilla("Hola estructuras");
		
	}
}
