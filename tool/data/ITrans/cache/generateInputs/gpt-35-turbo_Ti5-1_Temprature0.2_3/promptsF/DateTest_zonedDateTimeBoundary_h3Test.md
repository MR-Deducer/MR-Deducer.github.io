# ORIGINAL TEST CASE
```java
@Test
public void zonedDateTimeBoundary() throws IOException {
    DslJson<Object> dslJson = new DslJson<>();
    ZonedDateTime now = ZonedDateTime.parse("2020-01-12T12:13:14.123456789-03:30");
    JsonWriter jw = dslJson.newWriter(34);
    ZonedDateTime[] lts = new ZonedDateTime[3];
    Arrays.fill(lts, now);
    dslJson.serialize(jw, lts);
    Class<ZonedDateTime[]> manifest = ZonedDateTime[].class;
    byte[] body = { 91, 34, 50, 48, 50, 48, 45, 48, 49, 45, 49, 50, 84, 49, 50, 58, 49, 51, 58, 49, 52, 46, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 48, 51, 58, 51, 48, 34, 44, 34, 50, 48, 50, 48, 45, 48, 49, 45, 49, 50, 84, 49, 50, 58, 49, 51, 58, 49, 52, 46, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 48, 51, 58, 51, 48, 34, 44, 34, 50, 48, 50, 48, 45, 48, 49, 45, 49, 50, 84, 49, 50, 58, 49, 51, 58, 49, 52, 46, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 48, 51, 58, 51, 48, 34, 93, 0, 0 };
    int size = 115;
    ZonedDateTime[] values = dslJson.deserialize(manifest, body, size);
    Assert.assertArrayEquals(lts, values);
}

```
SOURCE INPUT: `jw`,`lts`
FOLLOW UP INPUT: `manifest`,`body`,`size`


# METHOD UNDER TEST
```java
/**
 * Main serialization API.
 * Convert object instance into JSON.
 * <p>
 * JsonWriter contains a growable byte[] where JSON will be serialized.
 * After serialization JsonWriter can be copied into OutputStream or it's byte[] can be obtained
 * <p>
 * For best performance reuse `JsonWriter` or even better call `JsonWriter.WriteObject` directly
 *
 * @param writer where to write resulting JSON
 * @param value  object instance to serialize
 * @throws IOException error when unable to serialize instance
 */
public final void serialize(final JsonWriter writer, @Nullable final Object value) throws IOException {
    if (writer == null) {
        throw new IllegalArgumentException("writer can't be null");
    }
    if (value == null) {
        writer.writeNull();
        return;
    }
    final Class<?> manifest = value.getClass();
    if (!serialize(writer, manifest, value)) {
        if (fallback == null) {
            throw new ConfigurationException("Unable to serialize provided object. Failed to find serializer for: " + manifest);
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        fallback.serialize(value, stream);
        writer.writeAscii(stream.toByteArray());
    }
}

/**
 * Deserialize API for working with streams.
 * Deserialize provided stream input into target object.
 * This method reuses thread local reader for processing JSON input.
 * <p>
 * Since JSON is often though of as a series of char,
 * most libraries will convert inputs into a sequence of chars and do processing on them.
 * <p>
 * When working on InputStream DslJson will process JSON in chunks of byte[] inputs.
 * <p>
 *
 * @param manifest target type
 * @param stream   input JSON
 * @return deserialized instance
 * @throws IOException error during deserialization
 */
@Nullable
public Object deserialize(final Type manifest, final InputStream stream) throws IOException {
    if (manifest instanceof Class<?>) {
        return deserialize((Class<?>) manifest, stream);
    }
    if (manifest == null) {
        throw new IllegalArgumentException("manifest can't be null");
    }
    if (stream == null) {
        throw new IllegalArgumentException("stream can't be null");
    }
    final JsonReader json = localReader.get().process(stream);
    try {
        json.getNextToken();
        final Object result = deserializeWith(manifest, json);
        if (result != unknownValue)
            return result;
        if (fallback != null) {
            return fallback.deserialize(context, manifest, new RereadStream(json.buffer, stream));
        }
        throw new ConfigurationException("Unable to find reader for provided type: " + manifest + " and fallback serialization is not registered.\n" + "Try initializing DslJson with custom fallback in case of unsupported objects or register specified type using registerReader into " + getClass());
    } finally {
        json.reset();
    }
}

```


# NEW SOURCE INPUTS
## New source input0:
```java
    ZonedDateTime now = ZonedDateTime.parse("2020-01-12T12:13:14.123456789-03:30");
    JsonWriter jw = dslJson.newWriter(34);
    ZonedDateTime[] lts = new ZonedDateTime[3];
    Arrays.fill(lts, now);
```

## New source input1:
```java
    ZonedDateTime now = ZonedDateTime.parse("2021-05-20T10:30:45.678901234+02:00");
    JsonWriter jw = dslJson.newWriter(50);
    ZonedDateTime[] lts = new ZonedDateTime[4];
    Arrays.fill(lts, now);
```

## New source input2:
```java
    ZonedDateTime now = ZonedDateTime.parse("2022-12-31T23:59:59.999999999-05:00");
    JsonWriter jw = dslJson.newWriter(20);
    ZonedDateTime[] lts = new ZonedDateTime[1];
    Arrays.fill(lts, now);
```

## New source input3:
```java
    ZonedDateTime now = ZonedDateTime.parse("2019-06-15T08:45:30.000000001+00:00");
    JsonWriter jw = dslJson.newWriter(100);
    ZonedDateTime[] lts = new ZonedDateTime[2];
    Arrays.fill(lts, now);
```

## New source input4:
```java
    JsonWriter jw = dslJson.newWriter(50);
    ZonedDateTime[] lts = new ZonedDateTime[0];
```



# REQUIRED DELIVERABLE
For each new source input listed under 'NEW SOURCE INPUTS', please construct the corresponding follow-up input that satisfies your inferred relation and pass the assertions in the 'ORIGINAL TEST CASE'. Document the complete code for each new input pair in the format shown below:
## New input pairN:
```java
    ZonedDateTime now = ZonedDateTime.parse("2020-01-12T12:13:14.123456789-03:30");
    JsonWriter jw = dslJson.newWriter(34);
    ZonedDateTime[] lts = new ZonedDateTime[3];
    Arrays.fill(lts, now);
    Class<ZonedDateTime[]> manifest = ZonedDateTime[].class;
    byte[] body = { 91, 34, 50, 48, 50, 48, 45, 48, 49, 45, 49, 50, 84, 49, 50, 58, 49, 51, 58, 49, 52, 46, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 48, 51, 58, 51, 48, 34, 44, 34, 50, 48, 50, 48, 45, 48, 49, 45, 49, 50, 84, 49, 50, 58, 49, 51, 58, 49, 52, 46, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 48, 51, 58, 51, 48, 34, 44, 34, 50, 48, 50, 48, 45, 48, 49, 45, 49, 50, 84, 49, 50, 58, 49, 51, 58, 49, 52, 46, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 48, 51, 58, 51, 48, 34, 93, 0, 0 };
    int size = 115;
```

Additionally, for each new source input, provide the code used to generate the follow-up input along with its associated source input code. Please explain why this new input pair satisfies the inferred relation you have identified.