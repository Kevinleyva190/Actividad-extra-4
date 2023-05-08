import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JButton botonPanles1;
    private JLabel estiquetaPanles1;
    private JLabel EstiquetaPanles2;
    private JPanel panel2;
    private JPanel panel3;
    private JComboBox<String> comboboxPanel3;
    private JPanel panel4;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        layout= new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        // panel 1
        panel1= new JPanel();
        panel1.setBackground(new Color(221,237,250));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        botonPanles1= new JButton("presioname ");
        panel1.add(botonPanles1);
        estiquetaPanles1 =new JLabel("......");
        panel1.add(estiquetaPanles1);
        botonPanles1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                estiquetaPanles1.setText("Hola presionaste el boton del panel uno");
            }
        });
        this.getContentPane().add(panel1,0 );
        // panel 2
        String urlImagen= "https://i0.wp.com/codigoespagueti.com/wp-content/uploads/2022/09/sonic-frontiers.jpg?fit=1280%2C720&quality=80&ssl=1";
        panel2= new JPanel();
        panel2.setBackground(new Color(250,224,221));
        panel2.setLayout(new FlowLayout());
        try {
            URL url= new URL(urlImagen);
            Image image= ImageIO.read(url);
            ImageIcon imageIcon=new ImageIcon(image);
            EstiquetaPanles2= new JLabel(imageIcon);
            panel2.add(EstiquetaPanles2);
            this.getContentPane().add(panel2,1);
        }catch (MalformedURLException me){
            System.out.println("url no valida");
        }catch (Exception e){
            System.out.println("error en carga ");
        }


        // panel 3
        panel3= new JPanel();
        panel3.setBackground(new Color(231,221,250));
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] elementos={"opcion 1","opcion 2","opcion 3","opcion 4"};
        comboboxPanel3= new JComboBox<>(elementos);
        comboboxPanel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource().toString());
                System.out.println(comboboxPanel3.getSelectedIndex());
            }
        });
        panel3.add(comboboxPanel3);
        this.getContentPane().add(panel3,2);

        // panel 4
        panel4= new JPanel();
        panel4.setBackground(new Color(222,245,204));
        this.getContentPane().add(panel4,3);
        this.setVisible(true);
    }
}
