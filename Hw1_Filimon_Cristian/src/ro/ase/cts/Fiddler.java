package ro.ase.cts;

import javax.naming.InvalidNameException;

import ro.ase.cts.exceptions.InstrumentException;
import ro.ase.cts.exceptions.MinimumBribeException;
import ro.ase.cts.exceptions.MinimumConcertFeeException;

public class Fiddler {
	
	private String name;
	private float chargeableSalary;
	private float unchartedSalary;
	private Instrument instrument;
	
	public static final int MIN_CONCERT_PAY = 200;
	public static final int MIN_BRIBE_PAY = 10;
	
	public Fiddler(){
		
	}
	
	public Fiddler(String name, float chargeableSalary, float unchartedSalary, Instrument instrument){
		this.name = name;
		this.chargeableSalary = chargeableSalary;
		this.unchartedSalary = unchartedSalary;
		this.instrument = instrument;
	}
	
	public void setName(String name) throws InvalidNameException{
		if(name.contains("Super"))
			throw new InvalidNameException("Please, grow up!");
		if(name.length()<3)
			throw new InvalidNameException("Please, insert a name!");
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public float getChargeableSalary() {
		return chargeableSalary;
	}

	public void setChargeableSalary(float chargeableSalary) {
		this.chargeableSalary = chargeableSalary;
	}
	
	public float getUnchartedSalary() {
		return unchartedSalary;
	}

	public void setUnchartedSalary(float unchartedSalary) {
		this.unchartedSalary = unchartedSalary;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	public float bribe(float dedication) throws MinimumBribeException{
		if(dedication<MIN_BRIBE_PAY)
			throw new MinimumBribeException("Pay up!");
		this.unchartedSalary = this.unchartedSalary + dedication; 
		return this.unchartedSalary;
	}
	
	public float concert(float payedSum) throws MinimumConcertFeeException{
		if(payedSum<MIN_CONCERT_PAY)
			throw new MinimumConcertFeeException("Pay up!");
		this.chargeableSalary = this.chargeableSalary + payedSum;
		return this.chargeableSalary;
	}

	public double computeTotalSalary() {
		return (this.chargeableSalary - this.chargeableSalary * 0.19 + this.unchartedSalary); 
	}
	
	public void sing() throws InstrumentException {
		if(this.getInstrument() == Instrument.NOTHING)
			throw new InstrumentException("No music source");
		System.out.println("Tralalala");
	}
}
