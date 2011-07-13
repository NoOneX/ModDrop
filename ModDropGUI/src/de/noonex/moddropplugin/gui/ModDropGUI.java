package de.noonex.moddropplugin.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ModDropGUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JButton btnSaveDroplist;
	private JList jList0;
	private JScrollPane jScrollPane0;
	private JButton btnLoadDroplist;
	private JLabel lblInfoDropSelect;
	private JButton btnAddDrop;
	private JButton btnDeleteDrop;
	private JButton btnChangeDrop;
	private JButton btnSaveAs;

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
		add(getBtnAddDrop(), new Constraints(new Leading(12, 12, 12), new Trailing(12, 84, 140)));
		add(getJScrollPane0(), new Constraints(new Bilateral(11, 12, 22), new Bilateral(50, 50, 22)));
		add(getBtnDeleteDrop(), new Constraints(new Leading(115, 12, 12), new Trailing(12, 78, 203)));
		add(getBtnChangeDrop(), new Constraints(new Leading(232, 12, 12), new Trailing(12, 78, 203)));
		add(getLblInfoDropSelect(), new Constraints(new Leading(12, 202, 280, 280), new Leading(12, 26, 78, 203)));
		add(getBtnLoadDroplist(), new Constraints(new Leading(226, 185, 185), new Leading(12, 78, 203)));
		add(getBtnSaveDroplist(), new Constraints(new Leading(315, 112, 112), new Leading(12, 78, 203)));
		add(getBtnSaveAs(), new Constraints(new Leading(395, 12, 12), new Leading(12, 78, 203)));
		setSize(495, 192);
	}

	private JButton getBtnSaveAs() {
		if (btnSaveAs == null) {
			btnSaveAs = new JButton();
			btnSaveAs.setText("Save as...");
			btnSaveAs.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					btnSaveAsActionActionPerformed(event);
				}
			});
		}
		return btnSaveAs;
	}

	private JButton getBtnChangeDrop() {
		if (btnChangeDrop == null) {
			btnChangeDrop = new JButton();
			btnChangeDrop.setText("Change drop");
			btnChangeDrop.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					btnChangeDropActionActionPerformed(event);
				}
			});
		}
		return btnChangeDrop;
	}

	private JButton getBtnDeleteDrop() {
		if (btnDeleteDrop == null) {
			btnDeleteDrop = new JButton();
			btnDeleteDrop.setText("Delete drop");
			btnDeleteDrop.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					btnDeleteDropActionActionPerformed(event);
				}
			});
		}
		return btnDeleteDrop;
	}

	private JButton getBtnAddDrop() {
		if (btnAddDrop == null) {
			btnAddDrop = new JButton();
			btnAddDrop.setText("Add drop");
			btnAddDrop.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					btnAddDropActionActionPerformed(event);
				}
			});
		}
		return btnAddDrop;
	}

	private JLabel getLblInfoDropSelect() {
		if (lblInfoDropSelect == null) {
			lblInfoDropSelect = new JLabel();
			lblInfoDropSelect.setText("Select the drop you want to edit:");
		}
		return lblInfoDropSelect;
	}

	private JButton getBtnLoadDroplist() {
		if (btnLoadDroplist == null) {
			btnLoadDroplist = new JButton();
			btnLoadDroplist.setText("Load...");
			btnLoadDroplist.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					btnLoadDroplistActionActionPerformed(event);
				}
			});
		}
		return btnLoadDroplist;
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
			jList0.addListSelectionListener(new ListSelectionListener() {
	
				public void valueChanged(ListSelectionEvent event) {
					jList0ListSelectionValueChanged(event);
				}
			});
		}
		return jList0;
	}

	private JButton getBtnSaveDroplist() {
		if (btnSaveDroplist == null) {
			btnSaveDroplist = new JButton();
			btnSaveDroplist.setText("Save");
			btnSaveDroplist.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					btnSaveDroplistActionActionPerformed(event);
				}
			});
		}
		return btnSaveDroplist;
	}

	private void btnSaveAsActionActionPerformed(ActionEvent event) {
	}

	private void btnSaveDroplistActionActionPerformed(ActionEvent event) {
	}

	private void btnLoadDroplistActionActionPerformed(ActionEvent event) {
	}

	private void btnAddDropActionActionPerformed(ActionEvent event) {
		DropSettings dialog = new DropSettings();
		dialog.setVisible(true);
	}

	private void btnDeleteDropActionActionPerformed(ActionEvent event) {
	}

	private void btnChangeDropActionActionPerformed(ActionEvent event) {
	}

	private void jList0ListSelectionValueChanged(ListSelectionEvent event) {
	}

}
