package com.alibaba.fastjson2.internal.processor.maps;

import com.alibaba.fastjson2.internal.processor.maps.Map1Test_test2;

import com.alibaba.fastjson2.JSON.*;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONCompiled;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.alibaba.fastjson.TypeReference;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Map1Test_test2_h0Test2_valid {

    @JSONCompiled
    public static class Bean {

        public Map<String, String> v01;
    }

    @JSONCompiled
    public static class Bean1 {

        public Map<String, Integer> v01;
    }

    @Test
    public void test2_h0Test2() {
    Map<String, Long> v01 = new HashMap<>();
    v01.put("789", 789L);
		List<Object> transformed_inputs = Map1Test_test2.inputTransformation_test2(v01);
    String str2  = (String) transformed_inputs.get(0);
    Type mapType  = (Type) transformed_inputs.get(1);
        String str = JSON.toJSONString(v01);
        Map<String, Long> v02 = JSON.parseObject(str, new TypeReference<Map<String, Long>>() {
        }.getType());
        assertEquals(v01, v02);
    }

    @JSONCompiled
    public static class Bean2 {

        public Map<String, Long> v01;
    }

    @JSONCompiled
    public static class Bean3 {

        public Map<String, Boolean> v01;
    }

    @JSONCompiled
    public static class Bean4 {

        public Map<String, Float> v01;
    }

    @JSONCompiled
    public static class Bean5 {

        public Map<String, Double> v01;
    }

    @JSONCompiled
    public static class Bean6 {

        public Map<String, BigDecimal> v01;
    }

    @JSONCompiled
    public static class Bean7 {

        public Map<String, BigInteger> v01;
    }

    @JSONCompiled
    public static class Bean8 {

        public Map<String, UUID> v01;
    }
}

