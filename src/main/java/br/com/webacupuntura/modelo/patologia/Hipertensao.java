package br.com.webacupuntura.modelo.patologia;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="HIPERTENSAO")
public class Hipertensao extends Patologia{
	
	

}
