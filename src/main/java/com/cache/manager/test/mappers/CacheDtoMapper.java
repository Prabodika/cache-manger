package com.cache.manager.test.mappers;

import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.dto.CacheDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CacheDtoMapper {

    CacheDtoMapper INSTANCE = Mappers.getMapper( CacheDtoMapper.class );
    CacheDto  CacheDomainToDto(CacheDomain domain);

}
