package PS_2_Zadanie2_Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ztp03 {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Tabelka");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final Table table = new Table();
        
        JTable jtable = new JTable(table);
        JMenuBar bar = new JMenuBar();
        
        JButton row = new JButton("Dodaj Wiersz");
        JButton col = new JButton("Dodaj Kolumnę");
        
        bar.add(row);
        bar.add(col);
        
        frame.add(new JScrollPane(jtable));
        frame.setJMenuBar(bar);
        
        frame.pack();
        frame.setVisible(true);
        
        row.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                table.addRow();
                System.out.println(table.toString());
            }
        });
        col.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                Object option = JOptionPane.showInputDialog(
                    frame,
                    "Podaj typ kolumny",
                    "Dodaj Kolumnę",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new TableHeader[] {
                        new TableHeader(new TableDataInt()),
                        new TableHeader(new TableDataDouble()),
                        new TableHeader(new TableDataChar()),
                        new TableHeader(new TableDataBoolean()),
                    }, null);
                if(option == null)
                    return;
                table.addCol((TableHeader)option);
                System.out.println(table.toString());
            }
            
        });
        
    }
}