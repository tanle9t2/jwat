package com.jwat.jwat_assgiment.jwat_assgiment.service.impl;

import com.jwat.jwat_assgiment.jwat_assgiment.entity.Inverter;
import com.jwat.jwat_assgiment.jwat_assgiment.exception.ResourceNotFoundExeption;
import com.jwat.jwat_assgiment.jwat_assgiment.mapper.InverterMapper;
import com.jwat.jwat_assgiment.jwat_assgiment.repository.InverterRepository;
import com.jwat.jwat_assgiment.jwat_assgiment.request.InverterRequest;
import com.jwat.jwat_assgiment.jwat_assgiment.response.InverterResponse;
import com.jwat.jwat_assgiment.jwat_assgiment.response.MessageResponse;
import com.jwat.jwat_assgiment.jwat_assgiment.response.PageResponse;
import com.jwat.jwat_assgiment.jwat_assgiment.service.InverterService;

import com.jwat.jwat_assgiment.jwat_assgiment.utils.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InverterServiceImpl implements InverterService {
    private final InverterRepository inverterRepository;
    private final InverterMapper inverterMapper;

    @Override
    public PageResponse<InverterResponse> getAll(String inverterName, String inverterCode,
                                                 Boolean isFlag, int page, int size, String sortBy, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(orderBy.toUpperCase()), sortBy));
        Page<Inverter> inverterPage = inverterRepository.findAllWithFilter(inverterName, inverterCode, isFlag, pageable);

        List<InverterResponse> data = inverterPage.get()
                .map(i -> inverterMapper.convertToResponse(i))
                .collect(Collectors.toList());


        return PageResponse.<InverterResponse>builder()
                .content(data)
                .last(inverterPage.isLast())
                .size(inverterPage.getSize())
                .totalElements(inverterPage.getTotalElements())
                .totalPages(inverterPage.getTotalPages())
                .build();
    }

    @Override
    @Transactional
    public MessageResponse updateInverter(int inverterId, InverterRequest request) {
        Inverter inverter = inverterRepository.findById(inverterId)
                .orElseThrow(() -> new ResourceNotFoundExeption(Message.NOT_FOUND.format(String.valueOf(inverterId))));

        inverterMapper.updateInverterRequest(request, inverter);

        inverter.setUpdatedAt(LocalDateTime.now());
        inverterRepository.save(inverter);

        return MessageResponse.builder()
                .status(HttpStatus.OK)
                .message(Message.UPDATE_SUCCESS.format(inverter.getClass().getSimpleName()))
                .data(inverterMapper.convertToResponse(inverter))
                .build();

    }

    @Override
    @Transactional
    public MessageResponse createInverter(InverterRequest request) {

        Inverter inverter = inverterMapper.convertToEntity(request);
        inverterRepository.save(inverter);
        inverter.setUpdatedAt(LocalDateTime.now());
        inverterRepository.flush();
        return MessageResponse.builder()
                .status(HttpStatus.CREATED)
                .message(Message.CREATE_SUCCESS.format(inverter.getClass().getSimpleName()))
                .data(inverterMapper.convertToResponse(inverter))
                .build();

    }
}
