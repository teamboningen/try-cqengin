package jp.teamnoppokojin.trycqengine.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * Car Model without Attribute
 * @author teamnoppoKojin
 */
@Data
@Builder
public class Car implements Serializable {

	static final long serialVersionUID = 42L;

	/**	Unique key.  */
	private int carId;
	/** Car model. */
	private String name;
	/** discription. */
	private String discription;
	/** features. */
	private List<String> features;

}
