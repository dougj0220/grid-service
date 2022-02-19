package io.doug.service;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class GridServiceImpl implements GridService {

    private static final Logger LOG = LoggerFactory.getLogger(GridServiceImpl.class);

    @Override
    public int computeRoutesForGrid(int gridSize) {
        LOG.info("finding max grid routes for {} row size grid", gridSize);
        return doRecursionToFindRoutes(gridSize, 1, 1);
    }

    private int doRecursionToFindRoutes(int gridSize, int right, int down) {
        if (right == gridSize || down == gridSize) {
            // reach either border so only one path
            return 1;
        }
        LOG.info("gridSize={}; right={}; down={}", gridSize, right, down);
        return doRecursionToFindRoutes(gridSize, right + 1, down) + doRecursionToFindRoutes(gridSize, right, down + 1);
    }
}
