package de.noonex.moddropplugin.gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import de.noonex.moddropplugin.conditions.WorldCondition;

//VS4E -- DO NOT REMOVE THIS LINE!
public class DropSettings extends JDialog
{

	private static final long serialVersionUID = 1L;
	private JLabel lblBlock;
	private JComboBox cmbBlockId;
	private JLabel lblDropType;
	private JComboBox cmbDropType;
	private JTextField txtArgument;
	private JLabel lblArgument;
	private JLabel lblAmount;
	private JTextField txtAmount;
	private JButton jButton0;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JList jList0;
	private JScrollPane jScrollPane0;

	public DropSettings()
	{
		initComponents();
	}

	public DropSettings(Frame parent)
	{
		super(parent);
		initComponents();
	}

	public DropSettings(Frame parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}

	public DropSettings(Frame parent, String title)
	{
		super(parent, title);
		initComponents();
	}

	public DropSettings(Frame parent, String title, boolean modal)
	{
		super(parent, title, modal);
		initComponents();
	}

	public DropSettings(Frame parent, String title, boolean modal,
			GraphicsConfiguration arg)
	{
		super(parent, title, modal, arg);
		initComponents();
	}

	public DropSettings(Dialog parent)
	{
		super(parent);
		initComponents();
	}

	public DropSettings(Dialog parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}

	public DropSettings(Dialog parent, String title)
	{
		super(parent, title);
		initComponents();
	}

	public DropSettings(Dialog parent, String title, boolean modal)
	{
		super(parent, title, modal);
		initComponents();
	}

	public DropSettings(Dialog parent, String title, boolean modal,
			GraphicsConfiguration arg)
	{
		super(parent, title, modal, arg);
		initComponents();
	}

	public DropSettings(Window parent)
	{
		super(parent);
		initComponents();
	}

	public DropSettings(Window parent, ModalityType modalityType)
	{
		super(parent, modalityType);
		initComponents();
	}

	public DropSettings(Window parent, String title)
	{
		super(parent, title);
		initComponents();
	}

	public DropSettings(Window parent, String title, ModalityType modalityType)
	{
		super(parent, title, modalityType);
		initComponents();
	}

	public DropSettings(Window parent, String title, ModalityType modalityType,
			GraphicsConfiguration arg)
	{
		super(parent, title, modalityType, arg);
		initComponents();
	}

	private void initComponents() {
		setTitle("Editing drop");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.white);
		setModal(true);
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getLblBlock(), new Constraints(new Leading(12, 12, 12), new Leading(16, 12, 12)));
		add(getCmbBlockId(), new Constraints(new Bilateral(149, 12, 60), new Leading(12, 12, 12)));
		add(getJLabel0(), new Constraints(new Leading(12, 12, 12), new Leading(50, 12, 12)));
		add(getCmbDropType(), new Constraints(new Bilateral(149, 13, 60), new Leading(46, 12, 12)));
		add(getTxtArgument(), new Constraints(new Bilateral(150, 12, 4), new Leading(78, 12, 12)));
		add(getLblArgument(), new Constraints(new Leading(12, 28, 35), new Leading(80, 12, 12)));
		add(getLblAmount(), new Constraints(new Leading(12, 12, 12), new Leading(108, 12, 12)));
		add(getTxtAmount(), new Constraints(new Bilateral(149, 12, 4), new Leading(106, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(12, 12, 12), new Trailing(12, 136, 136)));
		add(getJButton1(), new Constraints(new Leading(81, 12, 12), new Trailing(12, 176, 252)));
		add(getJButton2(), new Constraints(new Trailing(13, 44, 204), new Leading(142, 12, 12)));
		add(getJButton3(), new Constraints(new Trailing(12, 140, 186), new Leading(180, 12, 12)));
		add(getJButton4(), new Constraints(new Trailing(12, 177, 223), new Leading(218, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Bilateral(10, 149, 22), new Bilateral(142, 50, 22)));
		setSize(316, 293);
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
			listModel.addElement("damage:10");
			jList0.setModel(listModel);
		}
		return jList0;
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("Edit condition");
		}
		return jButton4;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Delete condition");
		}
		return jButton3;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Add condition");
			jButton2.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButton2ActionActionPerformed(event);
				}
			});
		}
		return jButton2;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Cancel");
		}
		return jButton1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("OK");
		}
		return jButton0;
	}

	private JTextField getTxtAmount() {
		if (txtAmount == null) {
			txtAmount = new JTextField();
			txtAmount.setText("0");
		}
		return txtAmount;
	}

	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel();
			lblAmount.setText("Amount:");
		}
		return lblAmount;
	}

	private JLabel getLblArgument() {
		if (lblArgument == null) {
			lblArgument = new JLabel();
			lblArgument.setText("Argument:");
		}
		return lblArgument;
	}

	private JTextField getTxtArgument() {
		if (txtArgument == null) {
			txtArgument = new JTextField();
			txtArgument.setText("0");
		}
		return txtArgument;
	}

	private JComboBox getCmbDropType() {
		if (cmbDropType == null) {
			cmbDropType = new JComboBox();
			cmbDropType.setModel(new DefaultComboBoxModel(new Object[] { "block", "monster", "icon", "explosion", "lightning" }));
			cmbDropType.setDoubleBuffered(false);
			cmbDropType.setBorder(null);
		}
		return cmbDropType;
	}
	
	private JLabel getLblBlock()
	{
		if(lblBlock == null)
		{
			lblBlock = new JLabel();
			lblBlock.setText("Block (Id or name):");
		}
		return lblBlock;
	}

	private JLabel getJLabel0() {
		if (lblDropType == null) {
			lblDropType = new JLabel();
			lblDropType.setText("Drop type:");
		}
		return lblDropType;
	}

	private JComboBox getCmbBlockId() {
		if (cmbBlockId == null) {
			cmbBlockId = new JComboBox();
			cmbBlockId.setEditable(true);
			cmbBlockId.setModel(new DefaultComboBoxModel(new Object[] { "stone", "cobblestone", "dirt" }));
			cmbBlockId.setDoubleBuffered(false);
			cmbBlockId.setBorder(null);
			cmbBlockId.setRequestFocusEnabled(false);
		}
		return cmbBlockId;
	}

	private void jButton2ActionActionPerformed(ActionEvent event) {
		//add condition
		ConditionSettings cond = new ConditionSettings();
		cond.setCondition(new WorldCondition("world"));
		cond.setVisible(true);
	}

}
