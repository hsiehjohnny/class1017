import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class frame extends JFrame {
    private String[] st = {"DES", "AES", "Caesa", "XOR"};
    private Container cp;
    private JTextArea jta1 = new JTextArea("");
    private JTextArea jta2 = new JTextArea("");
    private JLabel jlb = new JLabel("");
    private JTextField jtf = new JTextField("");
    private JScrollPane jsp1 = new JScrollPane(jta1);
    private JScrollPane jsp2 = new JScrollPane(jta2);
    private ButtonGroup btg = new ButtonGroup();
    private JComboBox jcb = new JComboBox(st);
    private JRadioButton jrb1 = new JRadioButton("Encrypt");
    private JRadioButton jrb2 = new JRadioButton("Decrypt");
    private JLabel jlb2 = new JLabel("Method");
    private JLabel jlb3 = new JLabel("Password");
    private JButton jbtr = new JButton("Run");
    private JButton jbtc = new JButton("Close");

    frame() {

        init();
    }

    private void init() {
        this.setBounds(100, 100, 800, 600);
        this.setLayout(null);
        cp = this.getContentPane();
        cp.add(jsp1);
        jsp1.setBounds(0, 0, 300, 600);
        cp.add(jlb);
        jlb.setBounds(300, 0, 200, 600);
        cp.add(jsp2);
        jsp2.setBounds(500, 0, 300, 600);

        jlb.add(jlb2);
        jlb2.setBounds(0, 0, 60, 30);
        jlb.add(jcb);
        jcb.setBounds(0, 30, 200, 30);
        jlb.add(jlb3);
        jlb3.setBounds(0, 60, 60, 30);
        jlb.add(jtf);
        jtf.setBounds(0, 90, 200, 30);
        jlb.add(jrb1);
        jrb1.setBounds(0, 120, 200, 30);
        jrb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jrb1.setSelected(true);
            }
        });
        jlb.add(jrb2);
        jrb2.setBounds(0, 150, 200, 30);
        jrb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jrb2.setSelected(true);
            }
        });
        btg.add(jrb1);
        btg.add(jrb2);
        jlb.add(jbtr);
        jbtr.setBounds(0, 180, 200, 30);
        jbtr.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb1.isSelected()){
                    switch (jcb.getSelectedIndex()){
                        case 0:
                            JOptionPane.showMessageDialog(null,"no");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null,"no");
                            break;
                        case 2:
                            jta2.setText("");
                            int n =Integer.valueOf(jtf.getText());
                           char[] c = jta1.getText().toCharArray();
                            for (int i = 0;i< jta1.getText().length();i++){
                                char a = c[i];
                                if (a>='a' && a <= 'z') {
                                   a += n % 26;
                                    if (a < 'a') {
                                        a +=26;

                                    } else if (a > 'z') {
                                        a -= 26;

                                    }
                                }
                                else if (a >= 'A' && a <= 'Z') {
                                    a += n % 26;
                                    if (a < 'A') {
                                        a += 26;

                                    } else if (a > 'Z') {
                                       a -= 26;
                                    }
                                }
                                 jta2.setText(jta2.getText() + a);
                            }
                    }
                }
            }
        });
        jlb.add(jbtc);
        jbtc.setBounds(0, 210, 200, 30);
        jbtc.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
