package com.corse.agencyerp.dao

import com.corse.agencyerp.config.TkBaseMapper
import com.corse.agencyerp.dao.Domain.BaseDomain
import com.corse.agencyerp.utils.UuidUtil
import org.springframework.beans.factory.annotation.Autowired
import tk.mybatis.mapper.entity.Example

class BaseDaoImpl<Mapper extends TkBaseMapper,Domain extends BaseDomain> {
    @Autowired
    Mapper mapper
    private  Domain d

    List<Domain> listDomain(Domain domain) {
        mapper.select(domain)
    }

    Domain getDomainByUuid(String uuid) {
        Example ex = new Example(d.getClass())
        ex.createCriteria().andEqualTo("uuid",uuid)
        mapper.selectOneByExample(ex)
    }

    Integer save(Domain domain) {
        domain.uuid = domain.uuid?: UuidUtil.genSortUuid()
        domain.createTm = domain.createTm?: new Date()
        mapper.insertSelective(domain)
    }

    Integer update(Domain domain) {
        if(domain.uuid){
            return null
        }
        domain.updateTm  = domain.updateTm ?: new Date()
        Example ex = new Example(d.getClass())
        ex.createCriteria().andEqualTo("uuid",domain.uuid)
        mapper.updateByExampleSelective(domain,ex)
    }

    Integer removeByUuid(String  uuid) {
        if(uuid) {
            Example ex = new Example(d.getClass())
            ex.createCriteria().andEqualTo("uuid", uuid)
            Domain domain = (Domain) d.getClass().newInstance()
            domain.del = 1
            return mapper.updateByExampleSelective(domain, ex)
        }else{
           null
        }

    }
}
