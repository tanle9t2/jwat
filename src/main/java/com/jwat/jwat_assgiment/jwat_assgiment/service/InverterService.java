package com.jwat.jwat_assgiment.jwat_assgiment.service;

import com.jwat.jwat_assgiment.jwat_assgiment.entity.Inverter;
import com.jwat.jwat_assgiment.jwat_assgiment.request.InverterRequest;
import com.jwat.jwat_assgiment.jwat_assgiment.response.InverterResponse;
import com.jwat.jwat_assgiment.jwat_assgiment.response.MessageResponse;
import com.jwat.jwat_assgiment.jwat_assgiment.response.PageResponse;

public interface InverterService {
    PageResponse<InverterResponse> getAll(String inverterName, String inverterCode,
                                          Boolean isFlag, int page, int size, String sortBy, String orderBy);

    MessageResponse updateInverter(int inverterId, InverterRequest request);

    MessageResponse createInverter(InverterRequest request);
}
