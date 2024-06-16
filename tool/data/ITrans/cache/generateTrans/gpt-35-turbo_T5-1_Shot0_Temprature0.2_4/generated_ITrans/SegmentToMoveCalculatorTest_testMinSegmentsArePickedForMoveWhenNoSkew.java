package org.apache.druid.server.coordinator.balancer;

import org.apache.druid.client.DruidServer;
import org.apache.druid.java.util.common.granularity.Granularities;
import org.apache.druid.server.coordination.ServerType;
import org.apache.druid.server.coordinator.CreateDataSegments;
import org.apache.druid.server.coordinator.ServerHolder;
import org.apache.druid.server.coordinator.loading.TestLoadQueuePeon;
import org.apache.druid.timeline.DataSegment;
import org.joda.time.Duration;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;


import org.apache.druid.server.coordinator.balancer.SegmentToMoveCalculator;
import org.apache.druid.server.coordinator.balancer.SegmentToMoveCalculator.*;
import org.apache.druid.server.coordinator.balancer.SegmentToMoveCalculatorTest;
import org.apache.druid.server.coordinator.balancer.SegmentToMoveCalculatorTest.*;
import java.util.List;
import java.util.Arrays;

public class SegmentToMoveCalculatorTest_testMinSegmentsArePickedForMoveWhenNoSkew {
    public static List<Object> inputTransformation_testMinSegmentsArePickedForMoveWhenNoSkew(int totalSegmentsInTier) {
        String tier = "tier1";
        List<ServerHolder> historicals = Arrays.asList(createServer("A", SegmentToMoveCalculatorTest.WIKI_SEGMENTS), createServer("B", SegmentToMoveCalculatorTest.WIKI_SEGMENTS));
        int maxSegmentsToMoveInTier = Integer.MAX_VALUE;
        List<Object> transformed_inputs = Arrays.asList(tier, historicals, maxSegmentsToMoveInTier);
        return transformed_inputs;
    }
}