package br.com.webacupuntura.modelo.patologia;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ULCERA")
public class Ulcera extends Patologia{
	
	

}
