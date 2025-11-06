package viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * ViewModel between MainWindow and PasswordGenerator
 * 
 * @author Valor Bright
 * 
 * @version Fall 2025
 */
public class MainWindowViewModel {
	private Random randomNumberGenerator = new Random();
	private PasswordGenerator generator = new PasswordGenerator(this.randomNumberGenerator.nextLong());
	
	private IntegerProperty minimumLengthProperty;
	private BooleanProperty digitProperty;
	private BooleanProperty lowerProperty;
	private BooleanProperty upperProperty;
	private BooleanProperty isDigitChecked;
	private BooleanProperty isLowerChecked;
	private BooleanProperty isUpperChecked;
	private IntegerProperty whatIsTheLength;

	/** Creates a new MainWindowViewModel
	 * 
	 * @precondition none
	 * @postcondition getMinimumLengthProperty() == 1 && getDigitProperty() ==
	 *                false && getLowerProperty() == false &&
	 *                getUpperProperty() == false && isDigitChecked() == false
	 *                && isLowerChecked() == false && isUpperChecked() == false
	 *                && eLength() == 1
	 */
	
	public MainWindowViewModel() {
		this.minimumLengthProperty = new SimpleIntegerProperty(1);
		this.digitProperty = new SimpleBooleanProperty(false);
		this.lowerProperty = new SimpleBooleanProperty(false);
		this.upperProperty = new SimpleBooleanProperty(false);
		this.isDigitChecked = new SimpleBooleanProperty(false);
		this.isLowerChecked = new SimpleBooleanProperty(false);
		this.isUpperChecked = new SimpleBooleanProperty(false);
		this.whatIsTheLength = new SimpleIntegerProperty(1);
	}
	
	/** Returns a password for the generator
	 * 
	 * @return password String password that is generated
	 */
	public String generateAPassword() {
		this.generator.setMinimumLength(this.minimumLengthProperty.get());
		this.generator.setMustHaveAtLeastOneDigit(this.digitProperty.get());
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.lowerProperty.get());
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.upperProperty.get());
		String password = this.generator.generatePassword();
		return password;
	}
	
	/**Gets the minimum length
	 * 
	 * @return this.miminimumLengthProperty the minimimum length of the password
	 */
	public IntegerProperty minimumLengthProperty() {
		return this.minimumLengthProperty;
	}
	
	/**Gets the boolean state of whether the checkbox is checked for the digital
	 * 
	 * @return this.digitProperty the boolean of whether or not to require a digit or not
	 */
	public BooleanProperty getDigitProperty() {
		//System.out.println(this.digitProperty.toString());
		return this.digitProperty;
	}
	
	/**Gets the boolean state of whether the checkbox is checked
	 * 
	 * @return this.lowerProperty the boolean of whether or not to require a digit or not
	 */
	public BooleanProperty getLowerProperty() {
		//System.out.println(this.lowerProperty.toString());
		return this.lowerProperty;
	}
	
	/**Gets the boolean state of whether the checkbox is checked
	 * 
	 * @return this.upperProperty the boolean of whether or not to require a digit or not
	 */
	public BooleanProperty getUpperProperty() {
		return this.upperProperty;
	}
	
	/**Gets the boolean state of whether the checkbox is checked
	 * 
	 * @param digitCheck Boolean check of digit
	 * 
	 * @return this.isDigitChecked the boolean of whether or not to the digit is checked
	 */
	public BooleanProperty isDigitChecked(Boolean digitCheck) {
		this.generator.setMustHaveAtLeastOneDigit(digitCheck);
		return this.isDigitChecked;
	}
	
	/**Gets the boolean state of whether the checkbox is checked
	 * 
	 * @param lowerCheck Boolean check of lowerCase
	 * 
	 * @return this.isDigitChecked the boolean of whether or not to the lowerCase is checked
	 */
	public BooleanProperty isLowerCaseChecked(Boolean lowerCheck) {
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(lowerCheck);
		return this.isLowerChecked;
	}
	
	/**Gets the boolean state of whether the checkbox is checked
	 * 
	 * @param upperCheck Boolean check of upperCase
	 * 
	 * @return this.isUpperChecked the boolean of whether or not to the upperCase is checked
	 */
	public BooleanProperty isUpperCaseChecked(Boolean upperCheck) {
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(upperCheck);
		return this.isUpperChecked;
	}
	
	/**Gets the length of the password
	 * 
	 * @param length Integer length of password
	 * 
	 * @return this.whatIsTheLength the length of the password
	 */
	public IntegerProperty whatIsTheLength(Integer length) {
		this.generator.setMinimumLength(length);
		return this.whatIsTheLength;
	}	

}
