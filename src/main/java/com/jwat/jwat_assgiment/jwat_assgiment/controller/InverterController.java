package com.jwat.jwat_assgiment.jwat_assgiment.controller;

import com.jwat.jwat_assgiment.jwat_assgiment.request.InverterRequest;
import com.jwat.jwat_assgiment.jwat_assgiment.response.MessageResponse;
import com.jwat.jwat_assgiment.jwat_assgiment.response.PageResponse;
import com.jwat.jwat_assgiment.jwat_assgiment.service.InverterService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.jwat.jwat_assgiment.jwat_assgiment.utils.AppConstant.*;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class InverterController {
    private final InverterService inverterService;


    @GetMapping("/inverters")
    public ResponseEntity<PageResponse> getAll(
            @RequestParam(value = "page", defaultValue = PAGE_DEFAULT) String page,
            @RequestParam(value = "size", defaultValue = PAGE_SIZE) String size,
            @RequestParam(value = "sortBy", required = false, defaultValue = SORT_BY_DEFAULT) String sortBy,
            @RequestParam(value = "orderBy", required = false, defaultValue = ORDER_BY_DEFAULT) String orderBy,
            @RequestParam(value = "inverterName", required = false) String inverterName,
            @RequestParam(value = "inverterCode", required = false) String inverterCode,
            @RequestParam(value = "isFlag", required = false) String flag) {
        Boolean isFlag = ("all".equals(flag) || flag == null) ? null : Boolean.parseBoolean(flag);
        PageResponse response = inverterService.getAll(inverterName, inverterCode, isFlag, Integer.parseInt(page),
                Integer.parseInt(size), sortBy, orderBy);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/inverter/{id}")
    public ResponseEntity<MessageResponse> updateInverter(@PathVariable("id") int inverterId,
                                                          @RequestBody InverterRequest request) {
        MessageResponse response = inverterService.updateInverter(inverterId, request);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/inverter")
    public ResponseEntity<MessageResponse> createInverter(@RequestBody InverterRequest request) {
        MessageResponse response = inverterService.createInverter(request);
        return ResponseEntity.ok(response);

    }
}
