package arreglos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import common.IConstants;

//Hereda de JFrame, Frame es una ventana
public class Pantallilla extends JFrame implements IConstants, MouseListener  { //Interface MouseListener es para capturar eventos del mouse
	private Color currentColor;//Color actual cuando pinto
	//El x y Y de cuando voy haciendo clic en ese momento
	private int currentX;
	private int currentY;
	//Me dice si estoy pintando un circulo
	private boolean paintCircle = false;
	
	//Constructores
	public Pantallilla() {
		this("No Title"); //llama al mismo constructor pero con el parámetro "No title", entonces ya con eso agarra el constructor de abajo: public Pantallita(String pTitle){...} donde pTitle es "No title"
	}
	
	public Pantallilla(String pTitle) {
		super(pTitle);	//Llamo al constructor del padre, y mi padre es JFrame. Ya con esto la pantalla se crea
		
		this.setLayout(null);//Null para que me deje poner las cosas donde yo quiera
		this.setSize(PANTALLA_WIDTH, PANTALLA_HEIGHT);
        this.setLocationRelativeTo(null);//No voy a generar punto relativo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Al cerrar la ventana cierra la aplicación
        this.setResizable(false);//Cambiar de tamaño: No
        this.setExtendedState(Frame.NORMAL);// estado normal, minimizado, maximizado la ventana
        this.addMouseListener(this);//Los eventos del mouse los escucha sobre si mismo, y si mismo xq yo estoy implementando a mouselistener, le digo que tiene la habilidad de poder escuchar eventos del mouse.
        
        initComponents();//inicializo para poder pintar las cosas
        
        this.setVisible(true);//Mostrar
	}
	
	private void initComponents() {
		this.currentColor = Color.BLUE;//define color actual: BLUE
			
		JButton button = new JButton("Red");//Creo un nuevo botón con la etiqueta red
		
		button.setBounds(10, 10, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);//ubicarlo en x10 y y10
		button.addActionListener(new ActionListener() {          //le digo al boton que agregue un actionlistener para que reaccione, una nueva instancia del action...
		    public void actionPerformed(ActionEvent e) {//cuando alguna accion se de en el boton, le cambia el color
		    	currentColor = Color.RED;
		    }
		}); 
		this.add(button);//a esta ventana agregue el botón
		
		
		JButton button2 = new JButton("Yellow");
		
		button2.setBounds(10, 110, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentColor = Color.YELLOW;
			}
		});
		this.add(button2);
		
	}
	
	
	//Métodos de la Interface MouseListener
	
	//al clic en la ventana
    @Override
    public void mouseClicked(MouseEvent e) {
    	//Del evento del mouse, extraer coordenada x y y. Y pintar circulo. y llama a repaint();
        currentX = e.getX();
        currentY = e.getY();
        paintCircle = true;
        repaint();//En java, se repinta la ventana. 
    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
	// Esto sobreescribiendo el metodo de paint. el paint recibe el objeto graphics, el cual tendrá la capacidad de pintar todo lo que esté en la pantalla
    @Override
    public void paint(Graphics g) {
    	if (paintCircle) {
			g.setColor(currentColor); //Fija el color, ya sea blue o rojo
			g.fillOval(currentX, currentY, 20, 20);//pinta el ovalo, x y y .....-> esto es un magic number
			paintCircle = false;//y despues que el paint circle lo ponga en false xq esto se va a llamar solo varias veces, y no quiero que se siga pintando
    	}
    }
}
