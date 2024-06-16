package software.amazon.event.ruler;

import software.amazon.event.ruler.SubRuleContext;
import software.amazon.event.ruler.SubRuleContext.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SubRuleContextTest_testGetters_h4Test3 {

    private static final String NAME = "name";

    @Test
    public void testGetters_h4Test3() {
SubRuleContext.Generator generator = null;
String NAME = "name";
Double id = -1.7976931348623157E308;
SubRuleContext.Generator generator2 = new SubRuleContext.Generator();
        SubRuleContext context = generator.generate(NAME);
        generator2.generate("name");
        assertEquals(NAME, generator2.getNameForGeneratedId(id));
        Set<Double> expectedIds = new HashSet<>();
        expectedIds.add(context.getId());
        assertEquals(expectedIds, generator.getIdsGeneratedForName(NAME));
    }
}
