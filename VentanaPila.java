import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase que implementa la interfaz gráfica para interactuar con la pila
public class VentanaPila extends JFrame {
    private JTextField campoNum;  // Campo de entrada para ingresar números
    private JTextArea campoSalida; // Área de texto para mostrar el contenido de la pila
    private Pila pila; // Instancia de la pila para manejar las operaciones

    // Constructor que inicializa la ventana y sus componentes
    public VentanaPila() {
        pila = new Pila(); // Se crea una nueva pila

        setTitle("Proyecto 2: Pila"); // Título de la ventana
        setSize(500, 400); // Dimensiones de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el programa al cerrar la ventana
        setLayout(new BorderLayout()); // Define un diseño de bordes

        // Panel superior con los controles de entrada y botones
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        campoNum = new JTextField(10); // Campo para ingresar números
        JButton botonPush = new JButton("Push"); // Botón para agregar elementos
        JButton botonPop = new JButton("Pop"); // Botón para eliminar elementos
        JButton botonBuscar = new JButton("Buscar"); // Botón para buscar elementos

        // Se agregan los componentes al panel superior
        panelSuperior.add(new JLabel("Digite un número entero:"));
        panelSuperior.add(campoNum);
        panelSuperior.add(botonPush);
        panelSuperior.add(botonPop);
        panelSuperior.add(botonBuscar);

        add(panelSuperior, BorderLayout.NORTH); // Agrega el panel superior al norte

        // Área de texto para mostrar la pila
        campoSalida = new JTextArea();
        campoSalida.setEditable(false); // Solo lectura
        campoSalida.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Fuente monoespaciada
        add(new JScrollPane(campoSalida), BorderLayout.CENTER); // Con scroll

        // Asignación de acciones a los botones
        botonPush.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarPush();
            }
        });

        botonPop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarPop();
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarBusqueda();
            }
        });
    }

    // Método para manejar el evento del botón Push
    private void manejarPush() {
        try {
            int numero = Integer.parseInt(campoNum.getText()); // Convierte el texto a número
            pila.push(numero); // Agrega el número a la pila
            mostrarPila(); // Actualiza la vista de la pila
            campoNum.setText(""); // Limpia el campo de entrada
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
        }
    }

    // Método para manejar el evento del botón Pop
    private void manejarPop() {
        pila.pop(); // Elimina el último elemento de la pila
        mostrarPila(); // Actualiza la vista de la pila
        JOptionPane.showMessageDialog(this, "Número eliminado correctamente.");
        campoNum.setText(""); // Limpia el campo de entrada
    }

    // Método para manejar el evento del botón Buscar
    private void manejarBusqueda() {
        try {
            int numero = Integer.parseInt(campoNum.getText()); // Convierte el texto a número
            if (pila.buscar(numero)) { 
                JOptionPane.showMessageDialog(this, "Número encontrado en la pila.");
            } else {
                JOptionPane.showMessageDialog(this, "Número no encontrado en la pila.");
            }
            campoNum.setText(""); // Limpia el campo de entrada
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
        }
    }

    // Método para mostrar el contenido de la pila en el área de texto
    private void mostrarPila() {
        campoSalida.setText(pila.dibujarPila()); // Obtiene la representación textual de la pila
    }
}
