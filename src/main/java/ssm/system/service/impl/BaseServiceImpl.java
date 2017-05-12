package ssm.system.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.system.entity.PageInfo;
import ssm.system.mapper.BaseMapper;
import ssm.system.service.BaseService;
import ssm.system.util.MethodUtils;

/**
 * 
 * @author huangmengwei
 *
 * @param <M>   通用Mapper
 * @param <T>   实体
 * @param <PK>  主键
 */
public class BaseServiceImpl<M extends BaseMapper<T, PK>, T, PK extends Serializable> implements BaseService<T, PK> {

    @Autowired
    protected M baseMapper;
    
    
    /**
     * 判断数据库操作是否成功
     *
     * @param result
     *            数据库操作返回影响条数
     * @return boolean
     */
    protected boolean retBool(int result) {
        return result >= 1;
    }
    
    @Override
    public T selectByPrimaryKey(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return retBool(baseMapper.deleteByPrimaryKey(id));
    }

    @Override
    public boolean insert(T entity) {
        return retBool(baseMapper.insert(entity));
    }

    @Override
    public boolean insertSelective(T entity) {
        return retBool(baseMapper.insertSelective(entity));
    }

    @Override
    public boolean updateByPrimaryKeySelective(T entity) {
        return retBool(baseMapper.updateByPrimaryKeySelective(entity));
    }

    @Override
    public boolean updateByPrimaryKey(T entity) {
        return retBool(baseMapper.updateByPrimaryKey(entity));
    }

    @Override
    public boolean insertOrUpdateSelective(T entity) {
        // 主键的字段设置为id
        Object oid = MethodUtils.getFieldValue(entity, "id");
        if( oid==null || oid.toString().length() == 0){
            return retBool(baseMapper.insert(entity));
        } else {
            return retBool(baseMapper.updateByPrimaryKeySelective(entity));
        }
        
    }
    
    @Override
    public void selectPageByCondition(PageInfo page) {
        page.setRows(baseMapper.selectListByCondition(page));
        page.setTotal(baseMapper.selectCountByCondition(page));
    }


}
