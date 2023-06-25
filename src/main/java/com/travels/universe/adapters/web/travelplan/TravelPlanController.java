package com.travels.universe.adapters.web.travelplan;

import com.travels.universe.adapters.web.travelplan.dto.in.TravelPlanInDto;
import com.travels.universe.adapters.web.travelplan.dto.out.TravelPlanOutDto;
import com.travels.universe.adapters.web.travelplan.mapper.NormalTravelPlanMapper;
import com.travels.universe.adapters.web.travelplan.mapper.TravelPlanMapper;
import com.travels.universe.adapters.web.travelplan.mapper.TravelPlanMapperFactory;
import com.travels.universe.application.usecases.CreateTravelPlanUseCase;
import com.travels.universe.application.usecases.DeleteTravelPlanUseCase;
import com.travels.universe.application.usecases.RetrieveTravelPlansUseCase;
import com.travels.universe.application.usecases.UpdateTravelPlanUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/travel_plans")
public class TravelPlanController {

    private final CreateTravelPlanUseCase createTravelPlanUseCase;
    private final RetrieveTravelPlansUseCase retrieveTravelPlansUseCase;
    private final UpdateTravelPlanUseCase updateTravelPlanUseCase;
    private final DeleteTravelPlanUseCase deleteTravelPlanUseCase;
    private final TravelPlanMapperFactory travelPlanMapperFactory;
    private final NormalTravelPlanMapper normalTravelPlanMapper;

    private final Logger logger = LoggerFactory.getLogger(TravelPlanController.class);

    public TravelPlanController(CreateTravelPlanUseCase createTravelPlanUseCase,
                                RetrieveTravelPlansUseCase retrieveTravelPlansUseCase,
                                UpdateTravelPlanUseCase updateTravelPlanUseCase,
                                DeleteTravelPlanUseCase deleteTravelPlanUseCase,
                                TravelPlanMapperFactory travelPlanMapperFactory,
                                NormalTravelPlanMapper normalTravelPlanMapper) {
        this.createTravelPlanUseCase = createTravelPlanUseCase;
        this.retrieveTravelPlansUseCase = retrieveTravelPlansUseCase;
        this.updateTravelPlanUseCase = updateTravelPlanUseCase;
        this.deleteTravelPlanUseCase = deleteTravelPlanUseCase;
        this.travelPlanMapperFactory = travelPlanMapperFactory;
        this.normalTravelPlanMapper = normalTravelPlanMapper;
    }

    @PostMapping
    @Transactional
    public TravelPlanOutDto createTravelPlan(@Valid @RequestBody TravelPlanInDto travelPlanInDto) {
        logger.info("Payload received in create travel plan endpoint: {}", travelPlanInDto);
        final var travelPlan = createTravelPlanUseCase.createTravelPlan(TravelPlanMapper.toDomain(travelPlanInDto));
        logger.info("Travel plan successfully created: {}", travelPlan);
        return normalTravelPlanMapper.toAdapter(travelPlan);
    }

    @GetMapping
    public List<TravelPlanOutDto> retrieveAllTravelPlans(@RequestParam(defaultValue = "false") Boolean optimize,
                                                         @RequestParam(defaultValue = "false") Boolean expand) {
        logger.info("Request received in retrieve all travel plans endpoint. Optimize: {}, Expand: {}", optimize, expand);
        final var travelPlans = retrieveTravelPlansUseCase.retrieveAllTravelPlans(optimize, expand);
        logger.info("Travel plans successfully retrieved: {}", travelPlans);
        return travelPlans.stream()
                .map(travelPlan ->
                        travelPlanMapperFactory.getImplementation(RetrieveOptionsEnum
                                .getRetrieveOptions(expand, optimize))
                                .toAdapter(travelPlan))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TravelPlanOutDto retrieveTravelPlan(@PathVariable("id") Integer travelPlanId,
                                               @RequestParam(defaultValue = "false") Boolean optimize,
                                               @RequestParam(defaultValue = "false") Boolean expand) {
        logger.info("Request received in retrieve travel plan endpoint. Optimize: {}, Expand: {}", optimize, expand);
        final var travelPlan = retrieveTravelPlansUseCase.retrieveTravelPlan(travelPlanId, optimize, expand);
        logger.info("Travel plan successfully retrieved: {}", travelPlan);
        return travelPlanMapperFactory.getImplementation(RetrieveOptionsEnum.getRetrieveOptions(expand, optimize)).toAdapter(travelPlan);
    }

    @Transactional
    @PutMapping("/{id}")
    public TravelPlanOutDto updateTravelPlan(@PathVariable("id") Integer travelPlanId,
                                             @Valid @RequestBody TravelPlanInDto travelPlanInDto) {
        logger.info("Payload received in update travel plan endpoint. Travel Plan id: {}, Updated Travel Plan: {}", travelPlanInDto, travelPlanInDto);
        final var travelPlan = updateTravelPlanUseCase.updateTravelPlan(travelPlanId, TravelPlanMapper.toDomain(travelPlanInDto));
        logger.info("Travel plan successfully updated: {}", travelPlan);
        return normalTravelPlanMapper.toAdapter(travelPlan);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravelPlan(@PathVariable("id") Integer travelPlanId) {
        logger.info("Request received in delete travel plan endpoint: {}", travelPlanId);
        deleteTravelPlanUseCase.deleteTravelPlan(travelPlanId);
        logger.info("Travel plan successfully deleted: {}", deleteTravelPlanUseCase);
        return ResponseEntity.noContent().build();
    }
}
