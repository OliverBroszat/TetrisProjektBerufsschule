package de.tetris.darstellungsschicht;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.sun.xml.internal.ws.api.server.Container;

public class FrameHighscore extends Panel {

	String[][] rowData = { { "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"},{ "Oliver", "100", "1" }, { "USA", "240","2" },
			{ "Italien", "220" ,"3"} };

	String[] columnNames = { "Rang",
			"Punkte","User" };
	
	JPanel tabelle = new JPanel();

	private JButton zurueck = new JButton();
	

	DefaultTableModel model = new DefaultTableModel(rowData,columnNames);
	private JLabel titelLabel = new JLabel("Highscore");
	
	JTable tableLabel = new JTable(model);

	public FrameHighscore() {
		setLayout(null);

		tableLabel.setPreferredScrollableViewportSize(new Dimension(350,350));
		tableLabel.setFillsViewportHeight(true);
		zurueck.setText("Zurück");

        JScrollPane scrollPane=new JScrollPane(tableLabel);

        setBackground(Color.gray);

        titelLabel.setFont(super.HeadlineFont);
        tableLabel.setFont(super.font);
        zurueck.setFont(super.font);
		
        tabelle.add(scrollPane);
	
		titelLabel.setForeground(Color.BLUE);
		titelLabel.setBounds(290, 100, 300, 70);
		tabelle.setBounds(215, 190, 370, 380);
		zurueck.setBounds(300,600,200,80); 

		add(titelLabel);
		add(tabelle);
		add (zurueck);

	}
	public JButton getZurueck() {
		return zurueck;
	}
	
	public void setZurueck(JButton zurueck) {
		this.zurueck = zurueck;
	}

}
