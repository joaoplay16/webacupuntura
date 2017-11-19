package br.com.webacupuntura.modelo.patologia;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PROBLEMAS_CIRCULATORIOS")
public class ProblemasCirculatorios extends Patologia{
	
	

}
