package com.vpodobano.textblog.entity;

import java.io.Serializable;

import com.vpodobano.textblog.model.AbstractModel;

public abstract class AbstractEntity<PK> extends AbstractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8895480545962296866L;
	private PK id;
	public PK getId() {
		return id;
	}
	public void setId(PK id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} 
		if (obj == null) {
			return false;			
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		AbstractEntity<?> other = (AbstractEntity<?>) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
