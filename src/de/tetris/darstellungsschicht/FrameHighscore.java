package de.tetris.darstellungsschicht;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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

	String[] columnNames = { "User",
			"Punkte","Rang" };
	
	JPanel tabelle = new JPanel();

	DefaultTableModel model = new DefaultTableModel(rowData,columnNames);
	private JLabel titelLabel = new JLabel("Highscore");
	JTable tableLabel = new JTable(model);
//
//	private JTable tableLabel = new JTable(rowData, columnNames);
//	private TableModel model = tableLabel.getModel();
//	JTableHeader header = tableLabel.getTableHeader();
//	JScrollPane scrollPane = new JScrollPane(tableLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public FrameHighscore() {
		setLayout(null);


		tableLabel.setPreferredScrollableViewportSize(new Dimension(350,400));
		tableLabel.setFillsViewportHeight(true);

        JScrollPane scrollPane=new JScrollPane(tableLabel);
       

		
		
//		tableLabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
//		scrollPane.setVisible(true);
//		
//		
		setBackground(Color.gray);
		tabelle.add(scrollPane);
//
		titelLabel.setFont(super.HeadlineFont);
		tableLabel.setFont(super.font);
//		
		titelLabel.setForeground(Color.BLUE);
		titelLabel.setBounds(290, 100, 300, 70);
//		tableLabel.setBounds(200, 190, 400, 400);
		tabelle.setBounds(200, 190, 400, 400);
//		header.setBounds(200,170,400,20);
//		scrollPane.setBounds(600, 190, 15, 400);
//
		add(titelLabel);
		add(tabelle);
		 scrollPane.setVisible(true);
//		add(tableLabel);
//		add(scrollPane);
//		add(header);
		

		// add(newUserButton);
		// add(centerPanel);
	}

}
