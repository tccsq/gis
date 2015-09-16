package com.pera.gis.data.model;


import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by csq on 2015/9/16.
 */
public class CommonEntity<PK extends Serializable> extends AbstractPersistable<PK>{
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTime;
    @Version
    private long version = 0;

}
