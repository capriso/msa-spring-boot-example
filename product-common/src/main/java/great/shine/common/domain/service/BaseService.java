package great.shine.common.domain.service;

import great.shine.common.domain.AttributeList;
import great.shine.common.domain.entity.BaseEntity;

public interface BaseService<E extends BaseEntity, C> {
	String register(C vo);
	E find(String entityId);
	void modify(String entityId, AttributeList attributes);
	void remove(String entityId);
}
