package com.jwat.jwat_assgiment.jwat_assgiment.mapper;

import com.jwat.jwat_assgiment.jwat_assgiment.entity.Inverter;
import com.jwat.jwat_assgiment.jwat_assgiment.request.InverterRequest;
import com.jwat.jwat_assgiment.jwat_assgiment.response.InverterResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T14:49:05+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class InverterMapperImpl implements InverterMapper {

    @Override
    public InverterResponse convertToResponse(Inverter inverter) {
        if ( inverter == null ) {
            return null;
        }

        InverterResponse.InverterResponseBuilder inverterResponse = InverterResponse.builder();

        inverterResponse.id( String.valueOf( inverter.getId() ) );
        inverterResponse.inverterCode( inverter.getInverterCode() );
        inverterResponse.inverterName( inverter.getInverterName() );
        inverterResponse.slaveAddress( inverter.getSlaveAddress() );
        inverterResponse.startAddress( inverter.getStartAddress() );
        inverterResponse.numberOfPoles( inverter.getNumberOfPoles() );
        inverterResponse.updatedAt( inverter.getUpdatedAt() );
        inverterResponse.isFlag( inverter.getIsFlag() );

        return inverterResponse.build();
    }

    @Override
    public Inverter convertToEntity(InverterRequest inverterRequest) {
        if ( inverterRequest == null ) {
            return null;
        }

        Inverter.InverterBuilder inverter = Inverter.builder();

        inverter.inverterCode( inverterRequest.getInverterCode() );
        inverter.inverterName( inverterRequest.getInverterName() );
        inverter.slaveAddress( inverterRequest.getSlaveAddress() );
        inverter.startAddress( inverterRequest.getStartAddress() );
        inverter.numberOfPoles( inverterRequest.getNumberOfPoles() );
        inverter.updatedAt( inverterRequest.getUpdatedAt() );
        inverter.isFlag( inverterRequest.getIsFlag() );

        return inverter.build();
    }

    @Override
    public void updateInverterRequest(InverterRequest request, Inverter user) {
        if ( request == null ) {
            return;
        }

        if ( request.getInverterCode() != null ) {
            user.setInverterCode( request.getInverterCode() );
        }
        if ( request.getInverterName() != null ) {
            user.setInverterName( request.getInverterName() );
        }
        if ( request.getSlaveAddress() != null ) {
            user.setSlaveAddress( request.getSlaveAddress() );
        }
        if ( request.getStartAddress() != null ) {
            user.setStartAddress( request.getStartAddress() );
        }
        user.setNumberOfPoles( request.getNumberOfPoles() );
        if ( request.getUpdatedAt() != null ) {
            user.setUpdatedAt( request.getUpdatedAt() );
        }
        if ( request.getIsFlag() != null ) {
            user.setIsFlag( request.getIsFlag() );
        }
    }
}
