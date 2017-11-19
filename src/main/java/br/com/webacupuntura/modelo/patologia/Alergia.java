package br.com.webacupuntura.modelo.patologia;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ALERGIA")
public class Alergia extends Patologia{
	
	

}
