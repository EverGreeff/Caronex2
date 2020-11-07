/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import entidades.Viagem;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Everton
 */
public class GraficoDeBarra {
    
    
    public CategoryDataset createDataSet(ArrayList<Viagem> viagens){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for (Viagem viagem : viagens) {
            dataSet.addValue(viagem.getValor_viagem(), viagem.getKm_viagem(), "");
        }
        
        return dataSet;
    }
    
    public JFreeChart createBarChart(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart("A", "B", "C", dataSet, PlotOrientation.VERTICAL, true, true, false);
        
        return graficoBarras;
    }
    
    
   public ChartPanel criarGrafico(ArrayList<Viagem> viagens){
       
       CategoryDataset dataSet = this.createDataSet(viagens);
       JFreeChart grafico = this.createBarChart(dataSet);
       
       ChartPanel painelDoGrafico = new ChartPanel(grafico);
       
       return painelDoGrafico;
   }
    
}
