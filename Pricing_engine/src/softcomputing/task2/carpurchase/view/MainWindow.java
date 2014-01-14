package softcomputing.task2.carpurchase.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import softcomputing.task2.carpurchase.CarPurchaseExpertSystem;
import softcomputing.task2.carpurchase.Steps;
import softcomputing.task2.carpurchase.datasource.Database;
import softcomputing.task2.carpurchase.datasource.MockDatabase;
import softcomputing.task2.carpurchase.model.CarCriterion;
import softcomputing.task2.carpurchase.model.CarDomainType;

import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.AbstractTableModel;

import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarType;
import softcomputing.task2.carpurchase.model.FuelType;
import softcomputing.task2.carpurchase.model.CarFeature;
import softcomputing.task2.carpurchase.model.CarBrand;
import softcomputing.task2.carpurchase.model.Step1UserRequest;
import softcomputing.task2.carpurchase.model.Step2UserRequest;
import softcomputing.task2.carpurchase.model.Step3UserRequest;

import javax.swing.JTable;



public class MainWindow extends CarPurchaseExpertSystem {

	private JFrame frmCarPurchase;

	private CarCriterion c1=CarCriterion.COMFORT,c2,c3;
	private CarDomainType d1=CarDomainType.FAMILY;
	private CarType ct;
	private Double minBudget=1000., maxBudget= 50000.;
	private Double minBurning= 0.1, maxBurning = 60.;
	private Double minKm = 0., maxKm=150000.;
	private Double minCapacity=0.5, maxCapacity= 1.4;
	private FuelType fuelTp;
	private Double minYear=1960., maxYear=1980.;
	private CarBrand cb;
	private CarFeature cf;
	private JTable table;
		
		
	Database database = new MockDatabase();
	Steps steps = new Steps();
	
	Set<CarFeature> features = new HashSet<CarFeature>();
	List<Car> Cars = database.getCars();
	CarTableModel model = new CarTableModel(Cars);
	List<Car> List1,List2,List3;

	//Methods for Handling UserRequest
	
	private List<Car> handleGUIStep1UserRequest(Step1UserRequest userRequest, List<Car> AllCars) {
		
		
		List<Car> cars = steps.step1(AllCars, userRequest);
		return cars;
	}
	
	private List<Car> handleGUIStep2UserRequest(Step2UserRequest userRequest, List<Car> cars) {
		
		
		List<Car> cars2 = steps.step2(cars, userRequest);
		return cars2;
	}	

	private List<Car> handleGUIStep3UserRequest(Step3UserRequest userRequest, List<Car> cars2) {
		
		List<Car> cars3 = steps.step3(cars2, userRequest);
		return cars3;
	}
	
	private CarCriterion carCriterionParse(String a) {
		
		if (a.equals(CarCriterion.COMFORT.toString())) {
			return CarCriterion.COMFORT;
		}else
		if (a.equals(CarCriterion.ECONOMY.toString())) {
			return CarCriterion.ECONOMY;
		}else
		if (a.equals(CarCriterion.HANDLING.toString())) {
			return CarCriterion.HANDLING;
		}else
		if (a.equals(CarCriterion.PERFORMANCE.toString())) {
			return CarCriterion.PERFORMANCE;
		}else
		if (a.equals(CarCriterion.QUALITY.toString())) {
			return CarCriterion.QUALITY;
		}else {
			return null;
		}
	}
	
	private CarFeature carFeatureParse(String a) {
		
		if (a.equals(CarFeature.ABS.toString())) {
			return CarFeature.ABS;
		}else
		if (a.equals(CarFeature.ALARM.toString())) {
			return CarFeature.ALARM;
		}else
		if (a.equals(CarFeature.CAR_AUDIO.toString())) {
			return CarFeature.CAR_AUDIO;
		}else
		if (a.equals(CarFeature.CLIMA.toString())) {
			return CarFeature.CLIMA;
		}else
		if (a.equals(CarFeature.ELECTRICAL_MIRRORS.toString())) {
			return CarFeature.ELECTRICAL_MIRRORS;
		}else
		if (a.equals(CarFeature.ELECTRICAL_WINDOWS.toString())) {
			return CarFeature.ELECTRICAL_WINDOWS;
		}else
		if (a.equals(CarFeature.GPS.toString())) {
				return CarFeature.GPS;
		}else
		if (a.equals(CarFeature.HYDRAULIC_SUSPENSION.toString())) {
			return CarFeature.HYDRAULIC_SUSPENSION;
		}else			
		if (a.equals(CarFeature.COMPUTER.toString())) {
			return CarFeature.COMPUTER;
		}else {
		return null;
		}
	}
	
	private CarDomainType carDomainTypeParse(String a) {
		
		if (a.equals(CarDomainType.BUSINESS.toString())) {
			return CarDomainType.BUSINESS;
		}else
		if (a.equals(CarDomainType.CASUAL.toString())) {
			return CarDomainType.CASUAL;
		}else
		if (a.equals(CarDomainType.FAMILY.toString())) {
			return CarDomainType.FAMILY;
		}else
		if (a.equals(CarDomainType.LUXURY.toString())) {
			return CarDomainType.LUXURY;
		}else
		if (a.equals(CarDomainType.SPORT.toString())) {
			return CarDomainType.SPORT;
		}else {
		if (a.equals(CarDomainType.EXTREME.toString())) {
			return CarDomainType.EXTREME;
		}else
			return null;
		}
	}
	
	private CarType carSizeParse(String a) {
		
		if (a.equals(CarType.CONVERTIBLE.toString())) {
			return CarType.CONVERTIBLE;
		}else
		if (a.equals(CarType.COUPE.toString())) {
			return CarType.COUPE;
		}else
		if (a.equals(CarType.HATCHBACK.toString())) {
			return CarType.HATCHBACK;
		}else
		if (a.equals(CarType.LIMOUSINE.toString())) {
			return CarType.LIMOUSINE;
		}else
		if (a.equals(CarType.PICK_UP.toString())) {
			return CarType.PICK_UP;
		}else
		if (a.equals(CarType.SUV.toString())) {
			return CarType.SUV;
		}else
		if (a.equals(CarType.VAN.toString())) {
			return CarType.VAN;
		}else			
		if (a.equals(CarType.SPORT.toString())) {
			return CarType.SPORT;
		}else {
			return null;
		}
	}
	
	private FuelType fuelTypeParse(String a) {
		
		if (a.equals(FuelType.DIESEL.toString())) {
			return FuelType.DIESEL;
		}else
		if (a.equals(FuelType.ELECTRIC.toString())) {
			return FuelType.ELECTRIC;
		}else
		if (a.equals(FuelType.GASOLINE.toString())) {
			return FuelType.GASOLINE;
		}else
		if (a.equals(FuelType.HYBRID.toString())) {
			return FuelType.HYBRID;
		}else
		if (a.equals(FuelType.LPG.toString())) {
			return FuelType.LPG;
		}else {
			return null;
		}
	}
	
	private CarBrand carBrandParse(String a) {
		
		if (a.equals(CarBrand.FERRARI.toString())) {
			return CarBrand.FERRARI;
		}else
		if (a.equals(CarBrand.JEEP.toString())) {
			return CarBrand.JEEP;
		}else
		if (a.equals(CarBrand.MERCEDES.toString())) {
			return CarBrand.MERCEDES;
		}else
		if (a.equals(CarBrand.OPEL.toString())) {
			return CarBrand.OPEL;
		}else
		if (a.equals(CarBrand.SKODA.toString())) {
			return CarBrand.SKODA;
		}else {
			return null;
		}
	}	
	
	
	// Methods to parse the (string) range values of the GUI 
	
	private Double minValueParse(String a) {
		Pattern p = Pattern.compile("\\d+\\.?\\d*");
		Matcher m = p.matcher(a);
		m.find(); 
		//System.out.println(m.group());
		return Double.parseDouble(m.group()); // Returns the first number
	}
	
	private Double maxValueParse(String a) {
		Pattern p = Pattern.compile("\\d+\\.?\\d*");
		Matcher m = p.matcher(a);
		m.find(); 
		m.find(); 
		//System.out.println(m.group());
		return Double.parseDouble(m.group());// Returns the second number
	}
	
	// Method to sort the lists 
	
	private void ListSorterByEvalution(List<Car> Cars) {
		
		Collections.sort(Cars, new Comparator<Car>(){
		     public int compare(Car o1, Car o2){
		         if(o1.getEvaluation() == o2.getEvaluation())
		             return 0;
		         return o1.getEvaluation() > o2.getEvaluation() ? -1 : 1;
		     }
		});
	}
	
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
				if (cmbBx_Criterion1.getSelectedIndex() != 0) { //Not UNKNOWN
					String criterion1 = new String("" + ((JComboBox)
					e.getSource()).getSelectedItem());
					c1 = carCriterionParse(criterion1);
				}					
			}
		});
		cmbBx_Criterion1.setModel(new DefaultComboBoxModel(CarCriterion
				.values()));
		cmbBx_Criterion1.setSelectedIndex(1);
		cmbBx_Criterion1.setBounds(96, 71, 114, 20);
		panelStep1.add(cmbBx_Criterion1);

		final JComboBox cmbBx_Criterion2 = new JComboBox();
		cmbBx_Criterion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbBx_Criterion2.getSelectedIndex() != 0) { //Not UNKNOWN
				String criterion2 = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
				c2 = carCriterionParse(criterion2);
			 }
			}
		});
		cmbBx_Criterion2.setModel(new DefaultComboBoxModel(CarCriterion
				.values()));
		cmbBx_Criterion2.setBounds(96, 102, 114, 20);
		panelStep1.add(cmbBx_Criterion2);

		final JComboBox cmbBx_Criterion3 = new JComboBox();
		cmbBx_Criterion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbBx_Criterion2.getSelectedIndex() != 0) { //Not UNKNOWN
				String criterion3 = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
				c3 = carCriterionParse(criterion3);
			}
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
				d1 = carDomainTypeParse(carDomainType);
			
			}
		});
		cmbBx_DomainType.setModel(new DefaultComboBoxModel(CarDomainType
				.values()));
		cmbBx_DomainType.setBounds(96, 198, 114, 20);
		panelStep1.add(cmbBx_DomainType);

		JLabel lblBudget = new JLabel("Budget: ");
		lblBudget.setBounds(314, 46, 72, 14);
		panelStep1.add(lblBudget);

		final ActionListener actionlistener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String budget = new String(""
						+ ((JRadioButton) event.getSource()).getText());
				minBudget = minValueParse(budget);
				maxBudget = maxValueParse(budget);
				
			}
		};
				
		final JRadioButton rdbtnLowCost = new JRadioButton("1000 - 50000");
		rdbtnLowCost.setSelected(true);
		rdbtnLowCost.setBounds(372, 70, 120, 23);
		rdbtnLowCost.addActionListener(actionlistener);
		panelStep1.add(rdbtnLowCost);
		
		final JRadioButton rdbtnAverageCost = new JRadioButton(
				"50000 - 120000");
		rdbtnAverageCost.setBounds(372, 101, 120, 23);
		rdbtnAverageCost.addActionListener(actionlistener);
		panelStep1.add(rdbtnAverageCost);

		final JRadioButton rdbtnExpensive = new JRadioButton("120000 - 200000");
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
								
				Step1UserRequest userRequest = new Step1UserRequest(c1, c2, c3, d1, minBudget ,maxBudget);
				List1 = handleGUIStep1UserRequest(userRequest,Cars);
				ListSorterByEvalution(List1); // Sorting
				model = new CarTableModel(List1);
				
				panelStep2.setVisible(true);
				panelStep1.setVisible(false);
			}
		});
		btnNext.setBounds(420, 328, 72, 23);
		panelStep1.add(btnNext);

		final JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Step1UserRequest userRequest = new Step1UserRequest(c1, c2, c3, d1, minBudget ,maxBudget);
				List1 = handleGUIStep1UserRequest(userRequest,Cars);
				ListSorterByEvalution(List1); // Sorting
				model = new CarTableModel(List1);
				
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

		JLabel lblAverageBurning = new JLabel("Average burning cost per 100 km:");
		lblAverageBurning.setBounds(10, 49, 200, 14);
		panelStep2.add(lblAverageBurning);

		final ActionListener actionlistener2 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String averageBurning = new String(""
						+ ((JRadioButton) event.getSource()).getText());
				minBurning = minValueParse(averageBurning);
				maxBurning = maxValueParse(averageBurning);
			}
		};
				
		final JRadioButton rdbtnLowBurn = new JRadioButton("0.1 - 60");
		rdbtnLowBurn.setSelected(true);
		rdbtnLowBurn.setBounds(67, 80, 109, 23);
		rdbtnLowBurn.addActionListener(actionlistener2);
		panelStep2.add(rdbtnLowBurn);

		final JRadioButton rdbtnAverageBurn = new JRadioButton("60 - 100");
		rdbtnAverageBurn.setBounds(67, 106, 109, 23);
		rdbtnAverageBurn.addActionListener(actionlistener2);
		panelStep2.add(rdbtnAverageBurn);

		final JRadioButton rdbtnHighBurn = new JRadioButton("100 - 200");
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
				if (cmbBxCarType.getSelectedIndex() != 0) { //Not UNKNOWN
				String carType = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
				ct = carSizeParse(carType);
			}
			}
		});
		cmbBxCarType.setModel(new DefaultComboBoxModel(CarType.values()));
		cmbBxCarType.setBounds(44, 216, 132, 20);
		panelStep2.add(cmbBxCarType);

		JLabel lblCarHistory = new JLabel("Car history(km):");
		lblCarHistory.setBounds(277, 49, 102, 14);
		panelStep2.add(lblCarHistory);

		final ActionListener actionlistener3 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String carHistory = new String(""
						+ ((JRadioButton) event.getSource()).getText());
				minKm = minValueParse(carHistory);
				maxKm = maxValueParse(carHistory);
			}
		};
		
		final JRadioButton rdbtnNew = new JRadioButton("0 - 15000");
		rdbtnNew.setSelected(true);
		rdbtnNew.setBounds(312, 80, 109, 23);
		rdbtnNew.addActionListener(actionlistener3);
		panelStep2.add(rdbtnNew);

		final JRadioButton rdbtnUsedModerately = new JRadioButton(
				"15000 - 100000");
		rdbtnUsedModerately.setBounds(312, 106, 122, 23);
		rdbtnUsedModerately.addActionListener(actionlistener3);
		panelStep2.add(rdbtnUsedModerately);

		final JRadioButton rdbtnUsedAlot = new JRadioButton("100000 - 500000");
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
				minCapacity = minValueParse(engineCapacity);
				maxCapacity = maxValueParse(engineCapacity);
			}
		};
		
		final JRadioButton rdbtnLowCapacity = new JRadioButton("0.5 - 1.4");
		rdbtnLowCapacity.setSelected(true);
		rdbtnLowCapacity.setBounds(277, 215, 85, 23);
		rdbtnLowCapacity.addActionListener(actionlistener4);
		panelStep2.add(rdbtnLowCapacity);

		final JRadioButton rdbtnAvegCapacity = new JRadioButton("1.5 - 3.0");
		rdbtnAvegCapacity.setBounds(277, 248, 85, 23);
		rdbtnAvegCapacity.addActionListener(actionlistener4);
		panelStep2.add(rdbtnAvegCapacity);

		final JRadioButton rdbtnHighCapacity = new JRadioButton("3.0 - 10.0");
		rdbtnHighCapacity.setBounds(277, 284, 85, 23);
		rdbtnHighCapacity.addActionListener(actionlistener4);
		panelStep2.add(rdbtnHighCapacity);

		ButtonGroup group4 = new ButtonGroup();
		group4.add(rdbtnLowCapacity);
		group4.add(rdbtnAvegCapacity);
		group4.add(rdbtnHighCapacity);

		final JComboBox cmbBxFuelType = new JComboBox();
		cmbBxFuelType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbBxFuelType.getSelectedIndex() != 0) { //Not UNKNOWN
				String fuelType = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
				fuelTp = fuelTypeParse(fuelType);
				
			}
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
				
				Step2UserRequest userRequest2 = new Step2UserRequest(minBurning, maxBurning, ct, minKm, maxKm, minCapacity, maxCapacity, fuelTp);
				List2 = handleGUIStep2UserRequest(userRequest2,List1);
				ListSorterByEvalution(List2); // Sorting
				model = new CarTableModel(List2);
				
				panelStep3.setVisible(true);
				panelStep2.setVisible(false);
			}
		});
		btnNext_1.setBounds(420, 328, 72, 23);
		panelStep2.add(btnNext_1);

		final JButton btnFinish_1 = new JButton("Finish");
		btnFinish_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Step2UserRequest userRequest2 = new Step2UserRequest(minBurning, maxBurning, ct, minKm, maxKm, minCapacity, maxCapacity, fuelTp);
				List2 = handleGUIStep2UserRequest(userRequest2,List1);
				ListSorterByEvalution(List2); // Sorting
				model = new CarTableModel(List2);
				
				panelResults.setVisible(true);
				panelStep2.setVisible(false);
			}
		});
		btnFinish_1.setBounds(502, 328, 72, 23);
		panelStep2.add(btnFinish_1);


		////////////////////////////// STEP 3 ////////////////////////////////////////


		JLabel lblDescription_2 = new JLabel(
				"Select concrete car features:");
		lblDescription_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription_2.setBounds(10, 11, 160, 14);
		panelStep3.add(lblDescription_2);

		JLabel lblCarSpecialFeatures = new JLabel("Special features:");
		lblCarSpecialFeatures.setBounds(10, 49, 107, 14);
		panelStep3.add(lblCarSpecialFeatures);
		features.add(CarFeature.CLIMA);
		
		 // We need to keep track of the selections  
        SelectionManager manager = new SelectionManager();  
        // and make the selection state available to the renderer.  
        MultiRenderer renderer = new MultiRenderer(manager); 
            
        final JComboBox cmbBxCarFeature = new JComboBox();
		cmbBxCarFeature.setModel(new DefaultComboBoxModel(CarFeature.values()));
		cmbBxCarFeature.setBounds(77, 75, 175, 20);
		cmbBxCarFeature.addActionListener(manager);  
        cmbBxCarFeature.setRenderer(renderer);  
		panelStep3.add(cmbBxCarFeature);

		JLabel lblCarBrand = new JLabel("Car brand:");
		lblCarBrand.setBounds(10, 138, 81, 14);
		panelStep3.add(lblCarBrand);

		final JComboBox cmbBxCarBrand = new JComboBox();
		cmbBxCarBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbBxCarBrand.getSelectedIndex() != 0) { //Not UNKNOWN
					String carBrand = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
					cb = carBrandParse(carBrand);
				}
			}
		});
		cmbBxCarBrand.setModel(new DefaultComboBoxModel(CarBrand.values()));
		cmbBxCarBrand.setBounds(77, 164, 133, 20);
		panelStep3.add(cmbBxCarBrand);
		
		final ActionListener actionlistener5 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String YoProd = new String(""
						+ ((JRadioButton) event.getSource()).getText());
				minYear = minValueParse(YoProd);
				maxYear = maxValueParse(YoProd);
			}
		};
		
		JLabel lblYearOfProduction = new JLabel("Year of production:");
		lblYearOfProduction.setBounds(367, 49, 125, 14);
		panelStep3.add(lblYearOfProduction);
		
		final JRadioButton rdbtnAncient = new JRadioButton("1960 - 1980");
		rdbtnAncient.setSelected(true);
		rdbtnAncient.setBounds(441, 74, 109, 23);
		rdbtnAncient.addActionListener(actionlistener5);
		panelStep3.add(rdbtnAncient);
		
		final JRadioButton rdbtnOld = new JRadioButton("1981 - 2000");
		rdbtnOld.setBounds(441, 103, 109, 23);
		rdbtnOld.addActionListener(actionlistener5);
		panelStep3.add(rdbtnOld);
		
		final JRadioButton rdbtnNewCar = new JRadioButton("2001 - 2014");
		rdbtnNewCar.setBounds(441, 134, 109, 23);
		rdbtnNewCar.addActionListener(actionlistener5);
		panelStep3.add(rdbtnNewCar);
		
		ButtonGroup group5 = new ButtonGroup();
		group5.add(rdbtnAncient);
		group5.add(rdbtnOld);
		group5.add(rdbtnNewCar);
		
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
				
				Step3UserRequest userRequest3 = new Step3UserRequest(features, cb, minYear,maxYear);
				List3 = handleGUIStep3UserRequest(userRequest3,List2);
				ListSorterByEvalution(List3); // Sorting
				model = new CarTableModel(List3);
				
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
				
		
		table = new JTable();
		table.setModel(model);
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowSelectionAllowed(false);
		table.setBackground(new Color(144, 238, 144));
		table.setBounds(78, 50, 425, 267);

		//panelResults.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setLocation(70, 50);
		scrollPane.setSize(450, 260);
		panelResults.add(scrollPane);
		
		
		final JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelStep3.setVisible(true);
				panelResults.setVisible(false);
			}
		});
		btnBack_2.setBounds(379, 328, 89, 23);
		panelResults.add(btnBack_2);
		
		final JButton btnStartOver = new JButton("Start over");
		btnStartOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelStep1.setVisible(true);
				panelResults.setVisible(false);
			}
		});
		
		btnStartOver.setBounds(478, 328, 96, 23);
		panelResults.add(btnStartOver);
				
	}
	


	
	/**
	 * @author Efthymios Doukas
	 * 
	 *  A class to display the list on the Results screen
	 *
	 */
	public class CarTableModel extends AbstractTableModel
	{
	   
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private List<Car> CarList;
		String[] columnNames = {"Rating","Brand","Name"};
		
	    public CarTableModel(List<Car> CarList)
	    {
	    	
	        this.CarList = new ArrayList<Car>(CarList);
	        
     	}
	    
	    @Override
	    public int getRowCount()
	    {
	        return CarList.size();
	    }
	    
	    
	    public int getColumnCount()
	    {
	        return 3;
	    }
	    
	    @Override
	    public Class<?> getColumnClass(int columnIndex) {
	        return CarList.get(0).getClass();
	    }
	    
	    @Override
	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	        return false;
	    }
	    
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    {
	    	Car c= CarList.get(rowIndex);

	        
	        Object[] values=new Object[]{c.getEvaluation(),c.getBrand(),c.getName()};
	        return values[columnIndex];
	    }
	    

	    @Override
	    public String getColumnName(int column)
	    {
	        
	        return columnNames[column];
	    }
	}
	
	
	
	
	/**
	 * @author Efthymios Doukas
	 * 
	 * Two classes SelectionManager and MultiRenderer to enable 
	 * multiselection on a Combobox.
	 *
	 */
	class SelectionManager implements ActionListener {  
	    JComboBox combo = null;  
	    List<Object> selectedItems = new ArrayList<Object>();   
	    List<Object> nonSelectables = new ArrayList<Object>();
	    List<String> strFeature = new ArrayList<String>();
	   

	    public void actionPerformed(ActionEvent e) {  
	        if(combo == null) {  
	            combo = (JComboBox)e.getSource();  
	        }
	        Object item = combo.getSelectedItem();
	        String itemName = new String("" + ((JComboBox) e.getSource()).getSelectedItem());
	        cf = carFeatureParse(itemName);
	        
	        // Toggle the selection state for item.  
	        if(selectedItems.contains(item)) {  
	            selectedItems.remove(item);
	            strFeature.remove(itemName);
	            System.out.println("Removed"+itemName);
	            features.remove(cf);
	        } else if(!nonSelectables.contains(item)) {  
	            selectedItems.add(item);  
	            strFeature.add(itemName);
	            System.out.println("Added"+itemName);
	            features.add(cf);
	        }  
	    }  
	   
	    /** 
	     * The varargs feature (Object... args) is new in j2se 1.5 
	     * You can replace the argument with an array. 
	     */  
	    public void setNonSelectables(Object... args) {  
	        for(int j = 0; j < args.length; j++) {  
	            nonSelectables.add(args[j]);  
	        }  
	    }  
	   
	    public boolean isSelected(Object item) {  
	        return selectedItems.contains(item);  
	    }  
	}  
	   
	/** Implementation copied from source code. */  
	class MultiRenderer extends BasicComboBoxRenderer {  
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		SelectionManager selectionManager;  
	   
	    public MultiRenderer(SelectionManager sm) {  
	        selectionManager = sm;  
	    }  
	   
	    public Component getListCellRendererComponent(JList list,  
	                                                  Object value,  
	                                                  int index,  
	                                                  boolean isSelected,  
	                                                  boolean cellHasFocus) {  
	        if (selectionManager.isSelected(value)) {  
	            setBackground(list.getSelectionBackground());  
	            setForeground(list.getSelectionForeground());  
	        } else {  
	            setBackground(list.getBackground());  
	            setForeground(list.getForeground());  
	        }  
	   
	        setFont(list.getFont());  
	   
	        if (value instanceof Icon) {  
	            setIcon((Icon)value);  
	        } else {  
	            setText((value == null) ? "" : value.toString());  
	        }  
	        return this;  
	    } 
	}
}
