package com.cat.demo.dao;

import static com.cat.demo.constant.SqlPackage.DAO_SUFFIX;
import static com.cat.demo.constant.SqlPackage.SQL_COUNT;
import static com.cat.demo.constant.SqlPackage.SQL_DELETEBYENTITIES;
import static com.cat.demo.constant.SqlPackage.SQL_DELETEBYENTITY;
import static com.cat.demo.constant.SqlPackage.SQL_DELETEBYID;
import static com.cat.demo.constant.SqlPackage.SQL_DELETEBYIDS;
import static com.cat.demo.constant.SqlPackage.SQL_FINDALL;
import static com.cat.demo.constant.SqlPackage.SQL_FINDBYID;
import static com.cat.demo.constant.SqlPackage.SQL_FINDLIST;
import static com.cat.demo.constant.SqlPackage.SQL_SAVE;
import static com.cat.demo.constant.SqlPackage.SQL_SAVES;
import static com.cat.demo.constant.SqlPackage.SQL_SEPARATOR;
import static com.cat.demo.constant.SqlPackage.SQL_UPDATE;
import static com.cat.demo.constant.SqlPackage.SQL_UPDATES;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.cat.demo.util.ReflectUtil;

/**
 * Created by Archimedes on 2016/6/25.
 */
public class BaseDao<Entity, PrimaryKey> extends SqlSessionDaoSupport {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@SuppressWarnings("unchecked")
	protected String getEntityName() {
		Class<Entity> clazz = (Class<Entity>) ReflectUtil.getClassGenericType(this.getClass());
		return clazz.getSimpleName();
	}

	/**
	 * 需将xml中的命名空间改为XxxDao形式
	 */
	protected String getSqlName(String sqlId) {
		return getEntityName() + DAO_SUFFIX + SQL_SEPARATOR + sqlId;
	}

	public int save(Entity entity) {
		return this.getSqlSession().insert(getSqlName(SQL_SAVE), entity);
	}

	public int saves(Collection<Entity> entities) {
		return this.getSqlSession().insert(getSqlName(SQL_SAVES), entities);
	}

	public int deleteById(PrimaryKey primayKey) {
		return this.getSqlSession().delete(getSqlName(SQL_DELETEBYID), primayKey);
	}

	public int deleteByEntity(Entity entity) {
		return this.getSqlSession().delete(getSqlName(SQL_DELETEBYENTITY), entity);
	}

	public int deleteByIds(PrimaryKey[] primayKeys) {
		return this.getSqlSession().delete(getSqlName(SQL_DELETEBYIDS), primayKeys);
	}

	public int deleteByEntities(Collection<Entity> entities) {
		return this.getSqlSession().delete(getSqlName(SQL_DELETEBYENTITIES), entities);
	}

	public int update(Entity entity) {
		return this.getSqlSession().update(getSqlName(SQL_UPDATE), entity);
	}

	public int updates(Entity entities) {
		return this.getSqlSession().update(getSqlName(SQL_UPDATES), entities);
	}

	public Entity findById(PrimaryKey primayKey) {
		return this.getSqlSession().selectOne(getSqlName(SQL_FINDBYID), primayKey);
	}

	public List<Entity> findAll() {
		return this.getSqlSession().selectList(getSqlName(SQL_FINDALL));
	}

	public List<Entity> findList(Map<String, Object> map) {
		return this.getSqlSession().selectList(getSqlName(SQL_FINDLIST), map);
	}

	public int count(Map<String, Object> map) {
		return this.getSqlSession().selectOne(getSqlName(SQL_COUNT), map);
	}

	public List<Map<String, Object>> findList(String methodName, Map<String, Object> map) {
		return this.getSqlSession().selectList(getSqlName(methodName), map);
	}

}
