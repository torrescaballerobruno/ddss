
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Simulador {

    public Simulador() {
    }

    public static void ventana() {
        JFrame localJFrame = new JFrame();
        JLabel localJLabel = new JLabel();
        JTextField localJTextField = new JTextField();
        JButton localJButton1 = new JButton();
        JButton localJButton2 = new JButton();
        JButton localJButton3 = new JButton();
        String[] arrayOfString = {"Incubacion en Linea", "Credito para Crecer", "PyME Joven"};

        localJFrame.setBounds(100, 100, 300, 400);
        localJFrame.setLocationRelativeTo(null);
        localJFrame.setLayout(null);
        localJFrame.setResizable(false);
        localJFrame.setDefaultCloseOperation(2);
        localJFrame.setTitle("Credito Joven");
        localJFrame.setSize(450, 250);

        localJLabel.setText("Seleccionar opcion");
        localJLabel.setBounds(150, 10, 250, 30);

        JComboBox localJComboBox = new JComboBox(arrayOfString);
        localJComboBox.setBounds(150, 50, 250, 30);

        localJButton1.setText("Continuar");
        localJButton1.setBounds(250, 150, 150, 30);
        localJButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                String str = (String) localJComboBox.getSelectedItem();

                if (str.equals("Incubacion en Linea")) {

                    Simulador.Incubacion();
                }
                if (str.equals("Credito para Crecer")) {

                    Simulador.Cpc();
                }
                if (str.equals("PyME Joven")) {

                    Simulador.Pyme();
                }

            }
        });
        localJFrame.add(localJLabel);
        localJFrame.add(localJButton1);
        localJFrame.add(localJComboBox);
        localJFrame.setVisible(true);
    }

    public static void Incubacion() {
        JFrame localJFrame = new JFrame();
        JLabel localJLabel = new JLabel();
        JTextField localJTextField = new JTextField("", 6);
        JButton localJButton1 = new JButton();
        JButton localJButton2 = new JButton();

        localJFrame.setBounds(100, 100, 300, 200);
        localJFrame.setLocationRelativeTo(null);
        localJFrame.setLayout(null);
        localJFrame.setResizable(false);
        localJFrame.setDefaultCloseOperation(2);
        localJFrame.setTitle("Incubacion en Linea");
        localJFrame.setSize(450, 250);

        localJLabel.setText("Ingresar monto");
        localJLabel.setBounds(150, 10, 250, 30);

        localJTextField.setBounds(150, 50, 250, 30);
        localJTextField.setDocument(new FixedSizeDocument(6));

        localJButton2.setText("Info");
        localJButton2.setBounds(150, 190, 150, 30);
        localJButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                JOptionPane.showMessageDialog(null, "Monto $50,000 - $150,000.\n14.5% Tasa de Interes.\nPeriodo de gracia: 12 meses\nPlazo total: 48 meses", "Ayuda", 1);
            }

        });
        localJButton1.setText("Calcular");
        localJButton1.setBounds(150, 150, 150, 30);
        localJButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                String str = "";
                str = localJTextField.getText();
                int i = Integer.parseInt(str);
                if ((i >= 50000) && (i <= 150000)) {

                    Simulador.Tabla_Incubacion(i);

                } else {
                    JOptionPane.showMessageDialog(null, "Valor debe estar entre $50,000 y $150,000", "Valor incorrecto", 2);
                }

            }

        });
        localJFrame.add(localJLabel);
        localJFrame.add(localJTextField);
        localJFrame.add(localJButton1);
        localJFrame.add(localJButton2);
        localJFrame.setVisible(true);
    }

    public static void Tabla_Incubacion(int paramInt) {
        double d1 = paramInt;

        double d2 = 0.0D;
        double d3 = 0.145D;

        d2 = paramInt / 12 * d3;

        double d4 = d3 / 12.0D;

        double d5 = d4 + 1.0D;

        double d6 = Math.pow(d5, 36.0D);

        double d7 = d1 * d4 * d6 / (d6 - 1.0D);

        BigDecimal localBigDecimal1 = new BigDecimal(d2);
        localBigDecimal1 = localBigDecimal1.setScale(2, RoundingMode.HALF_UP);

        BigDecimal localBigDecimal2 = new BigDecimal(d7);
        localBigDecimal2 = localBigDecimal2.setScale(2, RoundingMode.HALF_UP);

        double d9 = d1;

        double d11 = 0.0D;
        double d12 = d7;

        String[][] arrayOfString = new String[48][6];
        double d8;
        Object localObject5, localObject2, localObject1, localObject3, localObject4;
        String str1;
        for (int i = 1; i <= 12; i++) {
            d8 = d9 - d11;

            d9 = d8;

            localObject1 = String.valueOf(i);
            localObject2 = String.valueOf(d1);
            localObject3 = localBigDecimal1.toString();
            localObject4 = String.valueOf(d11);
            localObject5 = localBigDecimal1.toString();
            str1 = String.valueOf(d8);

            arrayOfString[(i - 1)][0] = localObject1.toString();
            arrayOfString[(i - 1)][1] = localObject2.toString();
            arrayOfString[(i - 1)][2] = localObject3.toString();
            arrayOfString[(i - 1)][3] = localObject4.toString();
            arrayOfString[(i - 1)][4] = localObject5.toString();
            arrayOfString[(i - 1)][5] = str1;
        }

        for (int i = 13; i <= 48; i++) {
            double d10 = d9 * d4;
            d11 = d12 - d10;
            d8 = d9 - d11;
            localObject1 = new BigDecimal(d9);
            localObject1 = ((BigDecimal) localObject1).setScale(2, RoundingMode.HALF_UP);
            localObject2 = new BigDecimal(d10);
            localObject2 = ((BigDecimal) localObject2).setScale(2, RoundingMode.HALF_UP);
            localObject3 = new BigDecimal(d11);
            localObject3 = ((BigDecimal) localObject3).setScale(2, RoundingMode.HALF_UP);
            localObject4 = new BigDecimal(d12);
            localObject4 = ((BigDecimal) localObject4).setScale(2, RoundingMode.HALF_UP);
            localObject5 = new BigDecimal(d8);
            localObject5 = ((BigDecimal) localObject5).setScale(2, RoundingMode.HALF_UP);

            str1 = String.valueOf(i);
            String str2 = ((BigDecimal) localObject1).toString();
            String str3 = ((BigDecimal) localObject2).toString();
            String str4 = ((BigDecimal) localObject3).toString();
            String str5 = ((BigDecimal) localObject4).toString();
            String str6 = ((BigDecimal) localObject5).toString();

            arrayOfString[(i - 1)][0] = str1;
            arrayOfString[(i - 1)][1] = str2;
            arrayOfString[(i - 1)][2] = str3;
            arrayOfString[(i - 1)][3] = str4;
            arrayOfString[(i - 1)][4] = str5;
            arrayOfString[(i - 1)][5] = str6;

            d9 = d8;
        }

        localObject1 = new JFrame();

        ((JFrame) localObject1).setTitle("Resultados");

        Object[] localObject = {"No.", "Saldo Inical", "Interes", "Capital", "Pago", "Saldo Final"};

        localObject3 = new JTable(arrayOfString, (Object[]) localObject);
        ((JTable) localObject3).setBounds(30, 40, 200, 300);
        localObject4 = new javax.swing.JScrollPane((Component) localObject3);
        ((JFrame) localObject1).add((Component) localObject4);
        ((JFrame) localObject1).setSize(500, 850);
        ((JFrame) localObject1).setResizable(true);
        ((JFrame) localObject1).setVisible(true);
    }

    public static void Cpc() {
        JFrame localJFrame = new JFrame();
        JLabel localJLabel = new JLabel();
        JTextField localJTextField = new JTextField("", 6);
        JButton localJButton1 = new JButton();
        JButton localJButton2 = new JButton();

        localJFrame.setBounds(100, 100, 300, 200);
        localJFrame.setLocationRelativeTo(null);
        localJFrame.setLayout(null);
        localJFrame.setResizable(false);
        localJFrame.setDefaultCloseOperation(2);
        localJFrame.setTitle("Tu credito para Crecer");
        localJFrame.setSize(450, 250);

        localJLabel.setText("Ingresar monto");
        localJLabel.setBounds(150, 10, 250, 30);

        localJTextField.setBounds(150, 50, 250, 30);
        localJTextField.setDocument(new FixedSizeDocument(6));

        String[] arrayOfString = {"Capital de Trabajo", "Activo Fijo"};

        final JComboBox localJComboBox = new JComboBox(arrayOfString);
        localJComboBox.setBounds(150, 100, 150, 30);

        localJButton2.setText("Info");
        localJButton2.setBounds(150, 190, 150, 30);
        localJButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                JOptionPane.showMessageDialog(null, "Monto $50,000 - $300,000.\n14.5% Tasa de Interes.\nPeriodo de gracia: 0 meses\nPlazo total Capital de Trabajo: 36 meses\nPlazo total Activo Fijo: 60 meses", "Ayuda", 1);
            }

        });
        localJButton1.setText("Calcular");
        localJButton1.setBounds(150, 150, 150, 30);
        localJButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                String str1 = "";
                str1 = localJTextField.getText();
                int i = Integer.parseInt(str1);

                String str2 = (String) localJComboBox.getSelectedItem();

                int j;

                if (str2.equals("Capital de Trabajo")) {
                    j = 36;
                } else {
                    j = 60;
                }

                if ((i >= 50000) && (i <= 300000)) {

                    Simulador.Tabla_Cpc(i, j);

                } else {
                    JOptionPane.showMessageDialog(null, "Valor debe estar entre $50,000 y $300,000", "Valor incorrecto", 2);
                }

            }

        });
        localJFrame.add(localJLabel);
        localJFrame.add(localJTextField);
        localJFrame.add(localJButton1);
        localJFrame.add(localJButton2);
        localJFrame.add(localJComboBox);
        localJFrame.setVisible(true);
    }

    public static void Tabla_Cpc(int paramInt1, int paramInt2) {
        double d1 = paramInt1;

        double d2 = 0.0D;
        double d3 = 0.145D;

        d2 = paramInt1 / 12 * d3;

        double d4 = d3 / 12.0D;

        double d5 = d4 + 1.0D;

        double d6 = Math.pow(d5, paramInt2);

        double d7 = d1 * d4 * d6 / (d6 - 1.0D);

        BigDecimal localBigDecimal1 = new BigDecimal(d2);
        localBigDecimal1 = localBigDecimal1.setScale(2, RoundingMode.HALF_UP);

        BigDecimal localBigDecimal2 = new BigDecimal(d7);
        localBigDecimal2 = localBigDecimal2.setScale(2, RoundingMode.HALF_UP);

        double d9 = d1;

        double d11 = 0.0D;
        double d12 = d7;

        String[][] arrayOfString = new String[paramInt2][6];
        Object localObject1, localObject2, localObject3, localObject4, localObject5;

        for (int i = 1; i <= paramInt2; i++) {
            double d10 = d9 * d4;
            d11 = d12 - d10;
            double d8 = d9 - d11;
            localObject1 = new BigDecimal(d9);
            localObject1 = ((BigDecimal) localObject1).setScale(2, RoundingMode.HALF_UP);
            localObject2 = new BigDecimal(d10);
            localObject2 = ((BigDecimal) localObject2).setScale(2, RoundingMode.HALF_UP);
            localObject3 = new BigDecimal(d11);
            localObject3 = ((BigDecimal) localObject3).setScale(2, RoundingMode.HALF_UP);
            localObject4 = new BigDecimal(d12);
            localObject4 = ((BigDecimal) localObject4).setScale(2, RoundingMode.HALF_UP);
            BigDecimal localBigDecimal3 = new BigDecimal(d8);
            localBigDecimal3 = localBigDecimal3.setScale(2, RoundingMode.HALF_UP);

            String str1 = String.valueOf(i);
            String str2 = ((BigDecimal) localObject1).toString();
            String str3 = ((BigDecimal) localObject2).toString();
            String str4 = ((BigDecimal) localObject3).toString();
            String str5 = ((BigDecimal) localObject4).toString();
            String str6 = localBigDecimal3.toString();

            arrayOfString[(i - 1)][0] = str1;
            arrayOfString[(i - 1)][1] = str2;
            arrayOfString[(i - 1)][2] = str3;
            arrayOfString[(i - 1)][3] = str4;
            arrayOfString[(i - 1)][4] = str5;
            arrayOfString[(i - 1)][5] = str6;

            d9 = d8;
        }

        localObject1 = new JFrame();

        ((JFrame) localObject1).setTitle("Resultados");

        Object[] localObject = {"No.", "Saldo Inical", "Interes", "Capital", "Pago", "Saldo Final"};

        localObject3 = new JTable(arrayOfString, (Object[]) localObject);
        ((JTable) localObject3).setBounds(30, 40, 200, 300);
        localObject4 = new javax.swing.JScrollPane((Component) localObject3);
        ((JFrame) localObject1).add((Component) localObject4);
        ((JFrame) localObject1).setSize(500, 850);
        ((JFrame) localObject1).setResizable(true);
        ((JFrame) localObject1).setVisible(true);
    }

    public static void Pyme() {
        JFrame localJFrame = new JFrame();
        JLabel localJLabel = new JLabel();
        JTextField localJTextField = new JTextField("", 6);
        JButton localJButton1 = new JButton();
        JButton localJButton2 = new JButton();

        localJFrame.setBounds(100, 100, 300, 200);
        localJFrame.setLocationRelativeTo(null);
        localJFrame.setLayout(null);
        localJFrame.setResizable(false);
        localJFrame.setDefaultCloseOperation(2);
        localJFrame.setTitle("Tu credito PyME Joven");
        localJFrame.setSize(450, 250);

        localJLabel.setText("Ingresar monto");
        localJLabel.setBounds(150, 10, 250, 30);

        localJTextField.setBounds(150, 50, 250, 30);
        localJTextField.setDocument(new FixedSizeDocument(7));

        localJButton2.setText("Info");
        localJButton2.setBounds(150, 190, 150, 30);
        localJButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                JOptionPane.showMessageDialog(null, "Monto $50,000 - $2,500,000.\n14.5% Tasa de Interes.\nPeriodo de gracia: 3 meses\nPlazo total: 60 meses", "Ayuda", 1);

            }

        });
        localJButton1.setText("Calcular");
        localJButton1.setBounds(150, 150, 150, 30);
        localJButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                String str = "";
                str = localJTextField.getText();
                int i = Integer.parseInt(str);
                if ((i >= 50000) && (i <= 2500000)) {

                    Simulador.Tabla_Pyme(i);

                } else {
                    JOptionPane.showMessageDialog(null, "Valor debe estar entre $50,000 y $2,500,000", "Valor incorrecto", 2);
                }

            }

        });
        localJFrame.add(localJLabel);
        localJFrame.add(localJTextField);
        localJFrame.add(localJButton1);
        localJFrame.add(localJButton2);
        localJFrame.setVisible(true);
    }

    public static void Tabla_Pyme(int paramInt) {
        double d1 = paramInt;

        double d2 = 0.0D;
        double d3 = 0.145D;

        d2 = paramInt / 12 * d3;

        double d4 = d3 / 12.0D;

        double d5 = d4 + 1.0D;

        double d6 = Math.pow(d5, 57.0D);

        double d7 = d1 * d4 * d6 / (d6 - 1.0D);

        BigDecimal localBigDecimal1 = new BigDecimal(d2);
        localBigDecimal1 = localBigDecimal1.setScale(2, RoundingMode.HALF_UP);

        BigDecimal localBigDecimal2 = new BigDecimal(d7);
        localBigDecimal2 = localBigDecimal2.setScale(2, RoundingMode.HALF_UP);

        double d9 = d1;

        double d11 = 0.0D;
        double d12 = d7;

        String[][] arrayOfString = new String[60][6];
        double d8;
        Object localObject5, localObject4, localObject3, localObject2, localObject1;
        String str1;
        for (int i = 1; i <= 3; i++) {
            d8 = d9 - d11;

            d9 = d8;

            localObject1 = String.valueOf(i);
            localObject2 = String.valueOf(d1);
            localObject3 = localBigDecimal1.toString();
            localObject4 = String.valueOf(d11);
            localObject5 = localBigDecimal1.toString();
            str1 = String.valueOf(d8);

            arrayOfString[(i - 1)][0] = localObject1.toString();
            arrayOfString[(i - 1)][1] = localObject2.toString();
            arrayOfString[(i - 1)][2] = localObject3.toString();
            arrayOfString[(i - 1)][3] = localObject4.toString();
            arrayOfString[(i - 1)][4] = localObject5.toString();
            arrayOfString[(i - 1)][5] = str1;
        }

        for (int i = 4; i <= 60; i++) {
            double d10 = d9 * d4;
            d11 = d12 - d10;
            d8 = d9 - d11;
            localObject1 = new BigDecimal(d9);
            localObject1 = ((BigDecimal) localObject1).setScale(2, RoundingMode.HALF_UP);
            localObject2 = new BigDecimal(d10);
            localObject2 = ((BigDecimal) localObject2).setScale(2, RoundingMode.HALF_UP);
            localObject3 = new BigDecimal(d11);
            localObject3 = ((BigDecimal) localObject3).setScale(2, RoundingMode.HALF_UP);
            localObject4 = new BigDecimal(d12);
            localObject4 = ((BigDecimal) localObject4).setScale(2, RoundingMode.HALF_UP);
            localObject5 = new BigDecimal(d8);
            localObject5 = ((BigDecimal) localObject5).setScale(2, RoundingMode.HALF_UP);

            str1 = String.valueOf(i);
            String str2 = ((BigDecimal) localObject1).toString();
            String str3 = ((BigDecimal) localObject2).toString();
            String str4 = ((BigDecimal) localObject3).toString();
            String str5 = ((BigDecimal) localObject4).toString();
            String str6 = ((BigDecimal) localObject5).toString();

            arrayOfString[(i - 1)][0] = str1;
            arrayOfString[(i - 1)][1] = str2;
            arrayOfString[(i - 1)][2] = str3;
            arrayOfString[(i - 1)][3] = str4;
            arrayOfString[(i - 1)][4] = str5;
            arrayOfString[(i - 1)][5] = str6;

            d9 = d8;
        }

        localObject1 = new JFrame();

        ((JFrame) localObject1).setTitle("Resultados");

        Object[] localObject = {"No.", "Saldo Inical", "Interes", "Capital", "Pago", "Saldo Final"};

        localObject3 = new JTable(arrayOfString, (Object[]) localObject);
        ((JTable) localObject3).setBounds(30, 40, 200, 300);
        localObject4 = new javax.swing.JScrollPane((Component) localObject3);
        ((JFrame) localObject1).add((Component) localObject4);
        ((JFrame) localObject1).setSize(500, 850);
        ((JFrame) localObject1).setResizable(true);
        ((JFrame) localObject1).setVisible(true);
    }

    public static void main(String[] paramArrayOfString) {
        Cypher.comenzar();
    }
}
