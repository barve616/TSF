package com.origin.server.mp.tsf.mapper;

import com.origin.server.mp.tsf.pojo.TEnvProperty;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TEnvPropertyMapper {
    /* 根据主键 env_id prop_key 删除t_env_property表中记录 */
    int deleteByPrimaryKey(@Param("envId") String envId, @Param("propKey") String propKey);

    /* 向t_env_property表中插入数据 */
    int insert(TEnvProperty record);

    /* 根据主键 env_id prop_key 查找t_env_property数据 */
    TEnvProperty selectByPrimaryKey(@Param("envId") String envId, @Param("propKey") String propKey);

    /* 查找t_env_property表中所有数据 */
    List<TEnvProperty> selectAll();

    /* 根据主键 env_id prop_key 更新t_env_property数据 */
    int updateByPrimaryKey(TEnvProperty record);
}