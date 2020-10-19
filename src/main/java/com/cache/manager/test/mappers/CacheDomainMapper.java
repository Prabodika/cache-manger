package com.cache.manager.test.mappers;

import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.dto.CacheDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.jmx.export.annotation.ManagedOperation;

@Mapper
public interface CacheDomainMapper {

    CacheDomainMapper INSTANCE = Mappers.getMapper( CacheDomainMapper.class );
    CacheDomain CacheDtoToDomain (CacheDto dto);
}
