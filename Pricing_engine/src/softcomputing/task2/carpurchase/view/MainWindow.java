package softcomputing.task2.carpurchase.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import softcomputing.task2.carpurchase.model.CarCriterion;
import softcomputing.task2.carpurchase.model.CarDomainType;

import javax.swing.JRadioButton;

import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarType;
import softcomputing.task2.carpurchase.model.FuelType;
import softcomputing.task2.carpurchase.model.CarFeature;
import softcomputing.task2.carpurchase.model.CarBrand;

public class MainWindow {

	private JFrame frmCarPurchase;
	private JPanel panelStep1;
	private JPanel panelStep2;
	private JPanel panelStep3;
	private JPanel panelResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmCarPurchase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	
	private void handleUserRequest(List<Car> a) {
	//TODO	
		/*
		 * List<Car> initial = db.getCars(); ... parse request in gui ... when user
		 * press next: List<Car> filtered = nextStep(initial,userRequest1); ...
		 * parse second user request ... next button filtered =
		 * nextStep(filtered,userRequest2);
		 */
	}
	

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarPurchase = new JFrame();
		frmCarPurchase.setTitle("Car Purchase");
		frmCarPurchase.setBounds(100, 100, 600, 400);
		frmCarPurchase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarPurchase.getContentPane().setLayout(new CardLayout(0, 0));

		final JPanel panelStep1 = new JPanel();
		frmCarPurchase.getContentPane().add(panelStep1, "name_93955994796721");
		panelStep1.setLayout(null);
		panelStep1.setVisible(true);

		final JPanel panelStep2 = new JPanel();
		frmCarPurchase.getContentPane().add(panelStep2, "name_93958192370748");
		panelStep2.setLayout(null);
		panelStep2.setVisible(false);

		final JPanel panelStep3 = new JPanel();
		frmCarPurchase.getContentPane().add(panelStep3, "name_93960816529787");
		panelStep3.setLayout(null);
		panelStep3.setVisible(false);

		final JPanel panelResults = new JPanel();
		frmCarPurchase.getContentPane()
				.add(panelResults, "name_95310782296790");
		panelResults.setLayout(null);
		panelResults.setVisible(false);

			
		
		//////////////////////// STEP 1 //////////////////////////////////////////////

		JLabel lblDescription = new JLabel("Select general car features:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(10, 11, 157, 14);
		panelStep1.add(lblDescription);

		JLabel lblCategory = new JLabel("Category (Select up to 3 categories):");
		lblCategory.setBounds(10, 46, 217, 14);
		panelStep1.add(lblCategory);

		final JComboBox cmbBx_Criterion1 = new JComboBox();
		cmbBx_Criterion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String criterion1 = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBx_Criterion1.setModel(new DefaultComboBoxModel(CarCriterion
				.values()));
		cmbBx_Criterion1.setBounds(96, 71, 114, 20);
		panelStep1.add(cmbBx_Criterion1);

		final JComboBox cmbBx_Criterion2 = new JComboBox();
		cmbBx_Criterion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String criterion2 = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBx_Criterion2.setModel(new DefaultComboBoxModel(CarCriterion
				.values()));
		cmbBx_Criterion2.setBounds(96, 102, 114, 20);
		panelStep1.add(cmbBx_Criterion2);

		final JComboBox cmbBx_Criterion3 = new JComboBox();
		cmbBx_Criterion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String criterion3 = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBx_Criterion3.setModel(new DefaultComboBoxModel(CarCriterion
				.values()));
		cmbBx_Criterion3.setBounds(96, 135, 114, 20);
		panelStep1.add(cmbBx_Criterion3);

		JLabel lblCarType = new JLabel("Car type:");
		lblCarType.setBounds(10, 176, 54, 14);
		panelStep1.add(lblCarType);

		final JComboBox cmbBx_DomainType = new JComboBox();
		cmbBx_DomainType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carDomainType = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBx_DomainType.setModel(new DefaultComboBoxModel(CarDomainType
				.values()));
		cmbBx_DomainType.setBounds(96, 198, 114, 20);
		panelStep1.add(cmbBx_DomainType);

		JLabel lblBudget = new JLabel("Budget (zl): ");
		lblBudget.setBounds(314, 46, 72, 14);
		panelStep1.add(lblBudget);

		final ActionListener actionlistener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String budget = new String(""
						+ ((JRadioButton) event.getSource()).getText());
			}
		};
				
		final JRadioButton rdbtnLowCost = new JRadioButton("10.000 - 60.000");
		rdbtnLowCost.setBounds(372, 70, 120, 23);
		rdbtnLowCost.addActionListener(actionlistener);
		panelStep1.add(rdbtnLowCost);
		
		final JRadioButton rdbtnAverageCost = new JRadioButton(
				"60.000 - 120.000");
		rdbtnAverageCost.setBounds(372, 101, 120, 23);
		rdbtnAverageCost.addActionListener(actionlistener);
		panelStep1.add(rdbtnAverageCost);

		final JRadioButton rdbtnExpensive = new JRadioButton("> 120.000");
		rdbtnExpensive.setBounds(372, 132, 120, 23);
		rdbtnExpensive.addActionListener(actionlistener);
		panelStep1.add(rdbtnExpensive);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnLowCost);
		group.add(rdbtnAverageCost);
		group.add(rdbtnExpensive);
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(33);
		progressBar.setBounds(10, 337, 200, 14);
		panelStep1.add(progressBar);
		
		final JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				panelStep2.setVisible(true);
				panelStep1.setVisible(false);
			}
		});
		btnNext.setBounds(420, 328, 72, 23);
		panelStep1.add(btnNext);

		final JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResults.setVisible(true);
				panelStep1.setVisible(false);
			}
		});
		btnFinish.setBounds(502, 328, 72, 23);
		panelStep1.add(btnFinish);

		/////////////////////// STEP 2	////////////////////////////////////////////


		JLabel lblDescription_1 = new JLabel(
				"Select more specific car features:");
		lblDescription_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription_1.setBounds(10, 11, 182, 14);
		panelStep2.add(lblDescription_1);

		JLabel lblAverageBurning = new JLabel("Average burning / 100 km:");
		lblAverageBurning.setBounds(10, 49, 148, 14);
		panelStep2.add(lblAverageBurning);

		final ActionListener actionlistener2 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String averageBurning = new String(""
						+ ((JRadioButton) event.getSource()).getText());
			}
		};
				
		final JRadioButton rdbtnLowBurn = new JRadioButton("3.5 - 6.5");
		rdbtnLowBurn.setBounds(67, 80, 109, 23);
		rdbtnLowBurn.addActionListener(actionlistener2);
		panelStep2.add(rdbtnLowBurn);

		final JRadioButton rdbtnAverageBurn = new JRadioButton("6.6 - 10.0");
		rdbtnAverageBurn.setBounds(67, 106, 109, 23);
		rdbtnAverageBurn.addActionListener(actionlistener2);
		panelStep2.add(rdbtnAverageBurn);

		final JRadioButton rdbtnHighBurn = new JRadioButton("> 10.0");
		rdbtnHighBurn.setBounds(67, 132, 109, 23);
		rdbtnHighBurn.addActionListener(actionlistener2);
		panelStep2.add(rdbtnHighBurn);

		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnLowBurn);
		group2.add(rdbtnAverageBurn);
		group2.add(rdbtnHighBurn);

		JLabel lblCarSize = new JLabel("Car size:");
		lblCarSize.setBounds(10, 186, 56, 14);
		panelStep2.add(lblCarSize);

		final JComboBox cmbBxCarType = new JComboBox();
		cmbBxCarType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carType = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBxCarType.setModel(new DefaultComboBoxModel(CarType.values()));
		cmbBxCarType.setBounds(44, 216, 132, 20);
		panelStep2.add(cmbBxCarType);

		JLabel lblCarHistory = new JLabel("Car history:");
		lblCarHistory.setBounds(277, 49, 72, 14);
		panelStep2.add(lblCarHistory);

		final ActionListener actionlistener3 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String carHistory = new String(""
						+ ((JRadioButton) event.getSource()).getText());
			}
		};
		
		final JRadioButton rdbtnNew = new JRadioButton("New");
		rdbtnNew.setBounds(312, 80, 109, 23);
		rdbtnNew.addActionListener(actionlistener3);
		panelStep2.add(rdbtnNew);

		final JRadioButton rdbtnUsedModerately = new JRadioButton(
				"Used moderately");
		rdbtnUsedModerately.setBounds(312, 106, 122, 23);
		rdbtnUsedModerately.addActionListener(actionlistener3);
		panelStep2.add(rdbtnUsedModerately);

		final JRadioButton rdbtnUsedAlot = new JRadioButton("Used a lot");
		rdbtnUsedAlot.setBounds(312, 132, 122, 23);
		rdbtnUsedAlot.addActionListener(actionlistener3);
		panelStep2.add(rdbtnUsedAlot);

		ButtonGroup group3 = new ButtonGroup();
		group3.add(rdbtnNew);
		group3.add(rdbtnUsedModerately);
		group3.add(rdbtnUsedAlot);

		JLabel lblEngineCapacity = new JLabel("Engine capacity & fuel type:");
		lblEngineCapacity.setBounds(274, 186, 160, 14);
		panelStep2.add(lblEngineCapacity);

		final ActionListener actionlistener4 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String engineCapacity = new String(""
						+ ((JRadioButton) event.getSource()).getText());
			}
		};
		
		final JRadioButton rdbtnLowCapacity = new JRadioButton("1.0 - 1.4");
		rdbtnLowCapacity.setBounds(277, 215, 85, 23);
		rdbtnLowCapacity.addActionListener(actionlistener4);
		panelStep2.add(rdbtnLowCapacity);

		final JRadioButton rdbtnAvegCapacity = new JRadioButton("1.5 - 2.5");
		rdbtnAvegCapacity.setBounds(277, 249, 85, 23);
		rdbtnAvegCapacity.addActionListener(actionlistener4);
		panelStep2.add(rdbtnAvegCapacity);

		final JRadioButton rdbtnHighCapacity = new JRadioButton("> 2.5");
		rdbtnHighCapacity.setBounds(277, 285, 85, 23);
		rdbtnHighCapacity.addActionListener(actionlistener4);
		panelStep2.add(rdbtnHighCapacity);

		ButtonGroup group4 = new ButtonGroup();
		group4.add(rdbtnLowCapacity);
		group4.add(rdbtnAvegCapacity);
		group4.add(rdbtnHighCapacity);

		final JComboBox cmbBxFuelType = new JComboBox();
		cmbBxFuelType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fuelType = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBxFuelType.setModel(new DefaultComboBoxModel(FuelType.values()));
		cmbBxFuelType.setBounds(420, 216, 96, 20);
		panelStep2.add(cmbBxFuelType);
		
		final JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setValue(66);
		progressBar_1.setBounds(10, 337, 200, 14);
		panelStep2.add(progressBar_1);

		
		final JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStep1.setVisible(true);
				panelStep2.setVisible(false);
			}
		});
		btnBack.setBounds(337, 328, 72, 23);
		panelStep2.add(btnBack);

		final JButton btnNext_1 = new JButton("Next");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStep3.setVisible(true);
				panelStep2.setVisible(false);
			}
		});
		btnNext_1.setBounds(420, 328, 72, 23);
		panelStep2.add(btnNext_1);

		final JButton btnFinish_1 = new JButton("Finish");
		btnFinish_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResults.setVisible(true);
				panelStep2.setVisible(false);
			}
		});
		btnFinish_1.setBounds(502, 328, 72, 23);
		panelStep2.add(btnFinish_1);


		////////////////////////////// STEP 3 ////////////////////////////////////////


		final JLabel lblDescription_2 = new JLabel(
				"Select concrete car features:");
		lblDescription_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription_2.setBounds(10, 11, 160, 14);
		panelStep3.add(lblDescription_2);

		JLabel lblCarSpecialFeatures = new JLabel("Special features:");
		lblCarSpecialFeatures.setBounds(10, 49, 107, 14);
		panelStep3.add(lblCarSpecialFeatures);

		JComboBox cmbBxCarFeature = new JComboBox();
		cmbBxCarFeature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carFeature = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBxCarFeature.setModel(new DefaultComboBoxModel(CarFeature.values()));
		cmbBxCarFeature.setBounds(77, 75, 145, 20);
		panelStep3.add(cmbBxCarFeature);

		JLabel lblCarBrand = new JLabel("Car brand:");
		lblCarBrand.setBounds(10, 133, 81, 14);
		panelStep3.add(lblCarBrand);

		JComboBox cmbBxCarBrand = new JComboBox();
		cmbBxCarBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carBrand = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBxCarBrand.setModel(new DefaultComboBoxModel(CarBrand.values()));
		cmbBxCarBrand.setBounds(77, 158, 145, 20);
		panelStep3.add(cmbBxCarBrand);

		JLabel lblYearOfProduction = new JLabel("Year of production:");
		lblYearOfProduction.setBounds(367, 49, 125, 14);
		panelStep3.add(lblYearOfProduction);

		JComboBox cmbBxYoP = new JComboBox();
		cmbBxYoP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String YearOfProd = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
			}
		});
		cmbBxYoP.setModel(new DefaultComboBoxModel(new String[] { "2013",
				"2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005",
				"2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997",
				"1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989",
				"1988", "1987", "1986", "1985" }));
		cmbBxYoP.setBounds(466, 75, 72, 20);
		panelStep3.add(cmbBxYoP);
		
		final JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setValue(99);
		progressBar_2.setBounds(10, 337, 200, 14);
		panelStep3.add(progressBar_2);
		
		final JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStep2.setVisible(true);
				panelStep3.setVisible(false);
			}
		});
		btnBack_1.setBounds(420, 328, 72, 23);
		panelStep3.add(btnBack_1);
		
		final JButton btnFinish_2 = new JButton("Finish");
		btnFinish_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResults.setVisible(true);
				panelStep3.setVisible(false);
			}
		});
		btnFinish_2.setBounds(502, 328, 72, 23);
		panelStep3.add(btnFinish_2);


		///////////////////////////////// RESULTS //////////////////////////////////////////

		JLabel lblCarSuggestions = new JLabel("Car suggestions");
		lblCarSuggestions.setForeground(new Color(0, 128, 0));
		lblCarSuggestions.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCarSuggestions.setBounds(228, 23, 104, 16);
		panelResults.add(lblCarSuggestions);
	}
}
