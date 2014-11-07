package linechart;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface Chart {
    public void adicionarSerie(ArrayList<Point2D> serie, Color cor);
    public void setEixoX(ArrayList<String> valores);
    public void setEixoY(ArrayList<String> valores);
    public void setLabelX(String nome);
    public void setLabelY(String nome);
    public void setTitulo(String titulo);
}
