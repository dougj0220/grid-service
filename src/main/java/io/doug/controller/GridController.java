package io.doug.controller;

import io.doug.Application;
import io.doug.service.GridService;
import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
    Imagine a robot sitting on the upper left hand corner of an NxN grid.
    The robot can only move in two directions: right and down.
    How many possible paths are there for the robot?
*/

@Controller(Application.GRID_PATH)
@Version("1")
public class GridController {

    private static final Logger LOG = LoggerFactory.getLogger(GridController.class);

    private final GridService gridService;

    @Inject
    public GridController(GridService gridService) {
        this.gridService = gridService;
    }

    @Get(value = "/{gridSize}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, String>> computeGridRoutes(@PathVariable int gridSize) {
        LOG.info("find NxN grid count with grid size: {}", gridSize);
        int routes = gridService.computeRoutesForGrid(gridSize);
        String answer = String.format("There are %d routes in a %sX%s grid", routes, gridSize, gridSize);
        LOG.info(answer);
        Map<String, String> response = new HashMap<>();
        response.put("response", answer);
        return HttpResponse.ok(response);
    }
}
