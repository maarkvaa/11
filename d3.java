import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.*;
import javax.swing.*;
public class work_3 extends JFrame{
    JButton I1;
    JTextField t1,t2;
    JLabel b1,b2;
    eWork kn = new eWork();
    public work_3 (String s) {
        super(s);
        setLayout(new FlowLayout());
        b1 = new JLabel("Укажите нижний диапазон");
        b2 = new JLabel("Укажите верхний диапазон");
        t1 = new JTextField(25);
        t2 = new JTextField(25);

        I1 = new JButton("Рисуй!");

        add(b1);
        add(t1);
        add(b2);
        add(t2);

        add(I1);
        I1.addActionListener(kn);
    }
    public static void main(String[] args){
        work_3 g = new work_3("График");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(500, 130);
        g.setResizable(false);
        g.setLocationRelativeTo(null);

    }
    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==I1 && Double.parseDouble(t1.getText()) <
                        Double.parseDouble(t2.getText()) ) {
                    XYSeries series = new XYSeries("График");
                    for (double x = Double.parseDouble(t1.getText()); x <=
                            Double.parseDouble(t2.getText()); x +=0.0005){
                        series.add(x,log(abs(pow(x,2)-5*x))+5*sin(x));
                    }
                    XYSeriesCollection XYDataset = new XYSeriesCollection();
                    XYDataset.addSeries(series);

                    //legenda
                    JFreeChart che = ChartFactory.createXYLineChart("f(x) =
                            ln|x^2 - 5x| + 5sin(x)","X",
                            "Y",XYDataset,
                            PlotOrientation.VERTICAL,true,true,true);

                    //diagramma
                    che.setBackgroundPaint(Color.white);
                    Plot plot = che.getPlot();
                    plot.setBackgroundPaint(Color.white);

                    //setka
                    ((XYPlot) plot).setDomainGridlinePaint(Color.black);
                    ((XYPlot) plot).setRangeGridlinePaint(Color.black);

                    //ryad
                    XYLineAndShapeRenderer renderer =
                            (XYLineAndShapeRenderer)((XYPlot) plot).getRenderer();
                    renderer.setSeriesPaint(0,Color.black);

                    renderer.setSeriesStroke(0,new BasicStroke(4.0f));
                    JFrame frame = new JFrame("График");
                    frame.getContentPane().add(new ChartPanel(che));
                    frame.setSize(800,600);
                    frame.setVisible(true);

                }
                else JOptionPane.showMessageDialog(work_3.this, "Введенные
                        вами данные, не корректны");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(work_3.this, "Введенные вами
                        данные, не корректны"); }

            }
        }
    }