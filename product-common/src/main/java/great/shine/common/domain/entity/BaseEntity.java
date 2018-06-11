package great.shine.common.domain.entity;

import java.util.Objects;
import java.util.UUID;

import great.shine.common.util.json.JsonSerializable;
import lombok.Getter;

@Getter
public abstract class BaseEntity implements JsonSerializable {
	private final String entityId;
	private Long entityVersion;

	protected BaseEntity() {
		this(UUID.randomUUID().toString());
	}

	protected BaseEntity(String entityId) {
		this.entityId = entityId;
		this.entityVersion = 0L;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)	return true;
		if(obj == null)	return false;
		if(this.getClass() != obj.getClass())	return false;
		
		BaseEntity entity = (BaseEntity) obj;
		return Objects.equals(entityId, entity.entityId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(entityId);
	}
	
	@Override
	public String toString() {
		return JsonSerializable.super.toJson();
	}
	
	public void setEntityVersion(Long entityVersion) {
		this.entityVersion = entityVersion;
	}
	
	public void increaseEntityVersion() {
		this.entityVersion++;
	}
}
