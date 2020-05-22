package co.com.gsdd.bdconocimiento.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import co.com.gsdd.bdconocimiento.dominio.TipoCaso;
import co.com.gsdd.bdconocimiento.persistencia.entidad.comun.AbstraccionEntidad;
import co.com.gsdd.bdconocimiento.persistencia.entidad.enums.TipoCasoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "TipoCaso")
public class TipoCasoEntidad extends AbstraccionEntidad {

	private static final long serialVersionUID = -7835592396239156369L;

	@Id
	@GenericGenerator(name = "codigoTipoGen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "tipo_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "codigoTipoGen")
	@Column(name = "codigotipo", nullable = false)
	private Long codigoTipo;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipocaso", unique = true)
	private TipoCasoEnum descripcion;
	
	public TipoCasoEntidad(TipoCaso tipoCaso) {
		this.codigoTipo = tipoCaso.getCodigoTipo();
		this.descripcion = tipoCaso.getDescripcion();
	}

}