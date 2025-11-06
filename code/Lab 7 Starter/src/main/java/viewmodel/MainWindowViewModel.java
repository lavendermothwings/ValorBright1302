package viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
	
	public BooleanProperty getDigitProperty() {
		return this.digitProperty;
	}

	public MainWindowViewModel() {
		this.minimumLengthProperty = new SimpleIntegerProperty(1);
		this.digitProperty = new SimpleBooleanProperty(false);
	}

	public String generateThis() {
	//	int checkLength;
	//
	//	try {
	//		checkLength = this.minimumLength;
	//	} catch (NumberFormatException numberError) {
	//		
	//	
	//	try {
	//		this.generator.setMinimumLength(minimumLength);
	//	} catch (IllegalArgumentException invalidLengthError) {
	//		
	//	}
		this.generator.setMinimumLength(this.minimumLengthProperty.get());
		this.generator.setMustHaveAtLeastOneDigit(this.digitProperty.get());//FIXME use property
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(false);//FIXME use property
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(false);//FIXME use property

	//	}
		String password = this.generator.generatePassword();
		return password;

	}



	public IntegerProperty minimumLengthProperty() {
		return this.minimumLengthProperty;//used to be () at the end
	}

}
