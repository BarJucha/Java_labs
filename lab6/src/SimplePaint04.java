import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimplePaint04 {

    public static void main(String[] args) {
        new SimplePaint04();
    }

    public SimplePaint04() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                TestPane testPane = new TestPane();
                frame.add(testPane);
                frame.setJMenuBar(new menuBar(testPane, testPane.paintPane, frame));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public PaintPane paintPane;

        public TestPane() {
            setLayout(new BorderLayout());
            add((paintPane = new PaintPane(5)));
            add(new ColorsPane(paintPane), BorderLayout.SOUTH);
            add(new SizePane(paintPane), BorderLayout.EAST);
        }
    }

    public class ColorsPane extends JPanel {

        public ColorsPane(PaintPane paintPane) {
            setLayout(new GridLayout(1, 0));
            add(new JButton(new ColorAction(paintPane, "Red", Color.RED)));
            add(new JButton(new ColorAction(paintPane, "Green", Color.GREEN)));
            add(new JButton(new ColorAction(paintPane, "Blue", Color.BLUE)));
            add(new JButton(new ColorAction(paintPane, "White", Color.WHITE)));
            add(new JButton(new ColorAction(paintPane, "Yellow", Color.YELLOW)));
            add(new JButton(new ColorAction(paintPane, "Black", Color.BLACK)));
            add(new JButton(new ColorAction(paintPane, "Pink", Color.PINK)));
            add(new JButton(new ColorAction(paintPane, "Cyan", Color.CYAN)));
        }

        public class ColorAction extends AbstractAction {

            private PaintPane paintPane;
            private Color color;

            private ColorAction(PaintPane paintPane, String name, Color color) {
                putValue(NAME, name);
                this.paintPane = paintPane;
                this.color = color;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                paintPane.setForeground(color);
            }

        }

    }
    public class menuBar extends JMenuBar{
        JMenu plik;
        JMenu wiecej;
        JMenuItem zapis;
        JMenuItem odczyt;
        JMenuItem wyjscie;
        JMenuItem informacja;
        TestPane testPane;
        PaintPane paintPane;
        JFrame mianFrame;
        public menuBar(TestPane tp, PaintPane pn, JFrame frame){
            plik = new JMenu("Plik");
            wiecej = new JMenu("Więcej");
            zapis = new JMenuItem("Zapisz");
            odczyt = new JMenuItem("Wczytaj");
            wyjscie = new JMenuItem("Wyjście");
            informacja = new JMenuItem("Informacja");
            plik.add(zapis);
            plik.add(odczyt);
            wiecej.add(informacja);
            wiecej.add(wyjscie);
            add(plik);
            add(wiecej);
            testPane = tp;
            paintPane = pn;
            mianFrame = frame;
            zapis.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BufferedImage bi = testPane.paintPane.background;
                    File outputfile = new File("E:\\Java\\Programy Java\\lab6\\saved.png");
                    try {
                        ImageIO.write(bi, "png", outputfile);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            odczyt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("E:\\Java\\Programy Java\\lab6\\saved.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    BufferedImage convertedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
                    convertedImg.getGraphics().drawImage(img, 0, 0, null);
                    paintPane.background = convertedImg;

// parent to główne okno
                    int ww = frame.getWidth() - frame.getWidth();
                    int hh = frame.getHeight() - frame.getHeight();

                    frame.setSize(convertedImg.getWidth() + ww,convertedImg.getHeight() + hh);
                }
            });
            wyjscie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            informacja.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Autor: Bartłomiej Jucha grupa 3", "Autor",JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
    }

    public class SizePane extends JPanel{
        public JSlider PaneSize;
        PaintPane paintPane;
        public SizePane(PaintPane pn){
            setLayout(new GridLayout(0,1));
            paintPane = pn;
            PaneSize = new JSlider(JSlider.VERTICAL, 1, 10, 5);
            PaneSize.setMajorTickSpacing(1);
            PaneSize.setPaintLabels(true);
            PaneSize.setPaintTicks(true);
            add(PaneSize);
            PaneSize.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider) e.getSource();
                    if (!source.getValueIsAdjusting()) {
                        int sliderValue = source.getValue();
                        paintPane.setSize(sliderValue);
                    }
                }
            });
        }
    }

    public class PaintPane extends JPanel {

        public BufferedImage background;
        int size;

        public PaintPane(int size_) {
            size = size_;
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            MouseAdapter handler = new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    drawDot(e.getPoint(), size);
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    drawDot(e.getPoint(), size);
                }

            };
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        public void setSize(int _size){
            size = _size;
        }
        protected void drawDot(Point p, int size) {
            if (background == null) {
                updateBuffer();;
            }

            if (background != null) {
                Graphics2D g2d = background.createGraphics();
                g2d.setColor(getForeground());
                g2d.fillOval(p.x - size, p.y - size, size*2, size*2);
                g2d.dispose();
            }
            repaint();
        }

        @Override
        public void invalidate() {
            super.invalidate();
            updateBuffer();
        }

        protected void updateBuffer() {

            if (getWidth() > 0 && getHeight() > 0) {
                BufferedImage newBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = newBuffer.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                if (background != null) {
                    g2d.drawImage(background, 0, 0, this);
                }
                g2d.dispose();
                background = newBuffer;
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (background == null) {
                updateBuffer();
            }
            g2d.drawImage(background, 0, 0, this);
            g2d.dispose();
        }
    }
}