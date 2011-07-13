package de.noonex.moddropplugin.gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import com.avaje.ebean.TxType;

import de.noonex.moddropplugin.conditions.Condition;
import de.noonex.moddropplugin.conditions.ConditionParser;
import de.noonex.moddropplugin.conditions.DamageValueCondition;
import de.noonex.moddropplugin.conditions.WorldCondition;

public class ConditionSettings extends JDialog
{

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JTextField jTextField0;
	private JComboBox jComboBox0;
	private JButton jButton0;
	private JButton jButton1;
	private boolean cancelled;

	public ConditionSettings()
	{
		initComponents();
	}

	public ConditionSettings(Frame parent)
	{
		super(parent);
		initComponents();
	}

	public ConditionSettings(Frame parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}

	public ConditionSettings(Frame parent, String title)
	{
		super(parent, title);
		initComponents();
	}

	public ConditionSettings(Frame parent, String title, boolean modal)
	{
		super(parent, title, modal);
		initComponents();
	}

	public ConditionSettings(Frame parent, String title, boolean modal,
			GraphicsConfiguration arg)
	{
		super(parent, title, modal, arg);
		initComponents();
	}

	public ConditionSettings(Dialog parent)
	{
		super(parent);
		initComponents();
	}

	public ConditionSettings(Dialog parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}

	public ConditionSettings(Dialog parent, String title)
	{
		super(parent, title);
		initComponents();
	}

	public ConditionSettings(Dialog parent, String title, boolean modal)
	{
		super(parent, title, modal);
		initComponents();
	}

	public ConditionSettings(Dialog parent, String title, boolean modal,
			GraphicsConfiguration arg)
	{
		super(parent, title, modal, arg);
		initComponents();
	}

	public ConditionSettings(Window parent)
	{
		super(parent);
		initComponents();
	}

	public ConditionSettings(Window parent, ModalityType modalityType)
	{
		super(parent, modalityType);
		initComponents();
	}

	public ConditionSettings(Window parent, String title)
	{
		super(parent, title);
		initComponents();
	}

	public ConditionSettings(Window parent, String title,
			ModalityType modalityType)
	{
		super(parent, title, modalityType);
		initComponents();
	}

	public ConditionSettings(Window parent, String title,
			ModalityType modalityType, GraphicsConfiguration arg)
	{
		super(parent, title, modalityType, arg);
		initComponents();
	}

	private void initComponents() {
		setTitle("Edit condition");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.white);
		setResizable(false);
		setModal(true);
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(12, 90, 90), new Leading(16, 17, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(12, 12, 12), new Leading(49, 12, 12)));
		add(getJTextField0(), new Constraints(new Trailing(12, 235, 10, 10), new Leading(47, 12, 12)));
		add(getJComboBox0(), new Constraints(new Trailing(12, 236, 54, 54), new Leading(12, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(12, 12, 12), new Leading(73, 12, 12)));
		add(getJButton1(), new Constraints(new Leading(81, 12, 12), new Leading(73, 12, 12)));
		setSize(320, 111);
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Cancel");
			jButton1.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButton1ActionActionPerformed(event);
				}
			});
		}
		return jButton1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("OK");
			jButton0.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButton0ActionActionPerformed(event);
				}
			});
		}
		return jButton0;
	}

	private JComboBox getJComboBox0() {
		if (jComboBox0 == null) {
			jComboBox0 = new JComboBox();
			jComboBox0.setEditable(true);
			jComboBox0.setModel(new DefaultComboBoxModel(new Object[] { "damage", "world" }));
			jComboBox0.setDoubleBuffered(false);
			jComboBox0.setBorder(null);
			jComboBox0.setRequestFocusEnabled(false);
		}
		return jComboBox0;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			jTextField0.setText("1");
		}
		return jTextField0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Value:");
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Key:");
		}
		return jLabel0;
	}
	
	public boolean isCancelled()
	{
		return this.cancelled;
	}
	
	public Condition getCondition() throws ParseException
	{
		Condition newCondition;
		try
		{
			//improve
			newCondition = ConditionParser.ParseConditions(((String)jComboBox0.getSelectedItem()) + "" + jTextField0.getText())[0];
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			throw new ParseException("Invalid condition: " + e.getMessage(), 0);
		}
		
		return newCondition;
	}
	
	public void setCondition(Condition condition)
	{
		String conditionkey = "";
		
		if(condition instanceof WorldCondition)
		{
			conditionkey = "world";
		}
		else if(condition instanceof DamageValueCondition)
		{
			conditionkey = "damage";
		}
		
		this.jComboBox0.setSelectedItem(conditionkey);
		this.jTextField0.setText(condition.ToString());		
	}

	private void jButton0ActionActionPerformed(ActionEvent event) {
		//OK
		this.cancelled = false;
		this.setVisible(false);
	}

	private void jButton1ActionActionPerformed(ActionEvent event) {
		//Cancel
		this.cancelled = true;
		this.setVisible(true);
	}

}
