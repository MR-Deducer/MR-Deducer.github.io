package cn.hutool.json;

import cn.hutool.json.JSONUtil;
import cn.hutool.json.JSONUtil.*;
import cn.hutool.core.lang.Pair;
import org.junit.Assert;
import org.junit.Test;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class IssueI6SZYBTest_entryTest_h0Test2 {

    @Test
    public void entryTest_h0Test2() {
    Map.Entry<String, Integer> pair = new AbstractMap.SimpleEntry<>("null", null);
    String jsonString = "{\"null\":null}";
    Class beanClass = AbstractMap.SimpleEntry.class;
        String jsonStr = JSONUtil.toJsonStr(pair);
        final Map.Entry bean = (Entry) JSONUtil.toBean(jsonString, beanClass);
        Assert.assertEquals(pair, bean);
    }
}

