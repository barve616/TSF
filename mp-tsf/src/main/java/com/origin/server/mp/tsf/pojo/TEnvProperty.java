package com.origin.server.mp.tsf.pojo;

import java.io.Serializable;

/**
 * Author: XYX
 * DateTime: 2020-07-21 20:42:02
 * Comment: 请在数据库中添加备注
 */
public class TEnvProperty implements Serializable {
    //请在数据库中添加备注 t_env_property.env_id*/
    private String envId;

    //请在数据库中添加备注 t_env_property.prop_key*/
    private String propKey;

    //请在数据库中添加备注 t_env_property.prop_value*/
    private String propValue;

    //请在数据库中添加备注 t_env_property.prop_comment*/
    private String propComment;

    public String getEnvId() {
        return envId;
    }

    public void setEnvId(String envId) {
        this.envId = envId;
    }

    public String getPropKey() {
        return propKey;
    }

    public void setPropKey(String propKey) {
        this.propKey = propKey;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public String getPropComment() {
        return propComment;
    }

    public void setPropComment(String propComment) {
        this.propComment = propComment;
    }
}