package com.jwat.jwat_assgiment.jwat_assgiment.mapper;

import com.jwat.jwat_assgiment.jwat_assgiment.entity.Inverter;
import com.jwat.jwat_assgiment.jwat_assgiment.request.InverterRequest;
import com.jwat.jwat_assgiment.jwat_assgiment.response.InverterResponse;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface InverterMapper {

    InverterResponse convertToResponse(Inverter inverter);

    Inverter convertToEntity(InverterRequest inverterRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInverterRequest(InverterRequest request, @MappingTarget Inverter user);
}
