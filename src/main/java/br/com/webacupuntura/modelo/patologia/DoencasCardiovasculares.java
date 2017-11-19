package br.com.webacupuntura.modelo.patologia;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="DOENCAS_CARDIOVASCULARES")
public class DoencasCardiovasculares extends Patologia{
	
	

}
