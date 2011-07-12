package de.noonex.moddropplugin.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ModDropGUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JButton jButton0;
	private JList jList0;
	private JScrollPane jScrollPane0;
	private JButton jButton1;
	private JLabel jLabel0;

	public ModDropGUI()
	{
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		setTitle("ModDrop - Configuration GUI");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getJButton0(), new Constraints(new Trailing(12, 12, 12), new Leading(12, 12, 12)));
		add(getJButton1(), new Constraints(new Trailing(86, 12, 12), new Leading(12, 12, 12)));
		add(getJLabel0(), new Constraints(new Bilateral(11, 169, 181), new Leading(12, 26, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Bilateral(11, 12, 22), new Bilateral(50, 12, 22)));
		setSize(453, 210);
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Select the drop you want to edit:");
		}
		return jLabel0;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Load...");
		}
		return jButton1;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJList0());
		}
		return jScrollPane0;
	}

	private JList getJList0() {
		if (jList0 == null) {
			jList0 = new JList();
			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement("drop 1");
			listModel.addElement("drop 2");
			listModel.addElement("drop 3");
			listModel.addElement("drop 4");
			jList0.setModel(listModel);
		}
		return jList0;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Save");
		}
		return jButton0;
	}

}
