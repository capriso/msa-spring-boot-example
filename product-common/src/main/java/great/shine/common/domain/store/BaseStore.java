package great.shine.common.domain.store;

import great.shine.common.domain.entity.BaseEntity;

public interface BaseStore<T extends BaseEntity> {
	void create(T entity);
	T retrieve(String entityId);
	void update(T entity);
	void delete(T entity);
	boolean exists(String entityId);
}
