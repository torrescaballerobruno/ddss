import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Cypher {

    public Cypher() {
    }

    public static void comenzar() {
        JFrame localJFrame = new JFrame();
        JLabel localJLabel1 = new JLabel();
        JLabel localJLabel2 = new JLabel();
        JTextField localJTextField = new JTextField("", 20);
        JButton localJButton = new JButton();
        final JPasswordField localJPasswordField = new JPasswordField();

        localJFrame.setBounds(100, 100, 300, 200);
        localJFrame.setLocationRelativeTo(null);
        localJFrame.setLayout(null);
        localJFrame.setResizable(false);
        localJFrame.setDefaultCloseOperation(2);
        localJFrame.setTitle("Iniciar Sesion");
        localJFrame.setSize(450, 250);

        localJLabel1.setText("Ingresar usuario: ");
        localJLabel1.setBounds(150, 10, 250, 30);

        localJTextField.setBounds(150, 50, 250, 30);
        localJTextField.setDocument(new FixedSizeDocument(20));

        localJLabel2.setText("Ingresar contrasena: ");
        localJLabel2.setBounds(150, 90, 250, 30);

        localJPasswordField.setBounds(150, 130, 250, 30);
        localJPasswordField.setDocument(new FixedSizeDocument(30));

        localJButton.setText("Iniciar");
        localJButton.setBounds(250, 170, 150, 30);
        localJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                String str1 = "";
                String str2 = "";
                str1 = localJTextField.getText();
                str2 = localJPasswordField.getText();

                String str3 = "29ed00918ceff1a4ffba4cd68d15b363";

                //Aqui va la validacion de contraseña y usuario
//                if ((str3.equals(Cypher.Enc(str2))) && (str1.equals("StandardUser"))) {
                    Simulador.ventana();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrecta, intente nuevamente", "Aviso", 2);
//                }

            }

        });
        localJFrame.add(localJLabel1);
        localJFrame.add(localJLabel2);
        localJFrame.add(localJPasswordField);
        localJFrame.add(localJTextField);
        localJFrame.add(localJButton);
        localJFrame.setVisible(true);
    }

    public static String Enc(String paramString) {
        String str1 = paramString;
        String str2 = null;

        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");

            localMessageDigest.update(str1.getBytes());

            byte[] arrayOfByte = localMessageDigest.digest();

            StringBuilder localStringBuilder = new StringBuilder();
            for (int i = 0; i < arrayOfByte.length; i++) {
                localStringBuilder.append(Integer.toString((arrayOfByte[i] & 0xFF) + 256, 16).substring(1));
            }

            str2 = localStringBuilder.toString();
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        }
        return str2;
    }
}
