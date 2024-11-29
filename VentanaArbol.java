import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaArbol extends JFrame {
    private JTextField campoNum; //campo de texto donde se ingresan los números
    private JTextArea campoSalida; //área de texto donde se muestra el árbol
    private ABB arbol; // instancia del árbol (ABB)
    
    //Configuración de la interfaz y sus componentes

    public VentanaArbol() {
        // Inicializa árbol
        arbol = new ABB();

        // Configuración básica de la ventana
        setTitle("Árbol Binario");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Parte superior de ventana: entrada de datos y botones
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        campoNum = new JTextField(10); // Largo del campo donde se insertan números, como solo se esperan números se hace espacio corto de 10 columnas
        JButton botonInsertar = new JButton("Insertar"); //botón para insertar
        JButton botonEliminar = new JButton("Eliminar"); //botón para eliminar
        JButton botonBuscar = new JButton("Buscar"); //botón para buscar

        panelSuperior.add(new JLabel("Digite un número entero:"));
        panelSuperior.add(campoNum);
        panelSuperior.add(botonInsertar);
        panelSuperior.add(botonEliminar);
        panelSuperior.add(botonBuscar);
        
        //Se añade parte superior a ventana principal
        add(panelSuperior, BorderLayout.NORTH);

        // Área de salida para mostrar el árbol
        campoSalida = new JTextArea();
        campoSalida.setEditable(false); //Hace que no se pueda editar el contenido
        campoSalida.setFont(new Font("Monospaced", Font.PLAIN, 14)); //font y tamaño
        add(new JScrollPane(campoSalida), BorderLayout.CENTER); //añade área con scroll para árboles muy largos

        // Acción para insertar dígito en el árbol
        botonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarInsercion();
            }
        });
        
        // Acción para eliminar dígito en el árbol
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarEliminacion();
            }
        });

        // Acción para buscar dígito en el árbol
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarBusqueda();
            }
        });
    }

    // Manejo de la inserción
    private void manejarInsercion() {
        try {
            int numero = Integer.parseInt(campoNum.getText()); //Convierte texto a num
            arbol.insertar(numero); // Inserta el número en el árbol
            mostrarArbol(); // Actualiza la vista del árbol
            campoNum.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
        }
    }

    // Manejo de la eliminación
    private void manejarEliminacion() {
        try {
            int numero = Integer.parseInt(campoNum.getText());
            arbol.eliminar(numero); // Elimina el número del árbol
            mostrarArbol(); // Actualiza la vista del árbol
            JOptionPane.showMessageDialog(this, "Número eliminado correctamente.");
            campoNum.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
        }
    }

    // Manejo de la búsqueda
    private void manejarBusqueda() {
        try {
            int numero = Integer.parseInt(campoNum.getText());
            if (arbol.buscar(numero)) { // Busca el número en el árbol
                JOptionPane.showMessageDialog(this, "Número encontrado en el árbol.");
            } else {
                JOptionPane.showMessageDialog(this, "Número no encontrado en el árbol.");
            }
            campoNum.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
        }
    }

    // Mostrar el árbol en el área de salida
    private void mostrarArbol() {
        campoSalida.setText(arbol.dibujarArbol()); 
    }

}


