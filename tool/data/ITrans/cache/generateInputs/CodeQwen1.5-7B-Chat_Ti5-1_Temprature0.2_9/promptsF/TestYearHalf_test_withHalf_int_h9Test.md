# ORIGINAL TEST CASE
```java
@Test
public void test_withHalf_int() {
    int year1 = 2007;
    int half1 = 2;
    int half2 = 1;
    int year3 = 2007;
    int half3 = 1;
    assertEquals(YearHalf.of(year3, half3), YearHalf.of(year1, half1).withHalf(half2));
}

```
SOURCE INPUT: `year1`,`half1`,`half2`
FOLLOW UP INPUT: `year3`,`half3`


# METHOD UNDER TEST
```java
/**
 * Obtains an instance of {@code YearHalf} from a year and half.
 *
 * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
 * @param half  the half-of-year to represent, from 1 to 2
 * @return the year-half, not null
 * @throws DateTimeException if either field value is invalid
 */
public static YearHalf of(int year, int half) {
    YEAR.checkValidValue(year);
    return new YearHalf(year, Half.of(half));
}

```


# NEW SOURCE INPUTS
## New source input0:
```java
    int year1 = 2020;
    int half1 = 1;
    int half2 = 2;
```

## New source input1:
```java
    int year1 = 2020;
    int half1 = 2;
    int half2 = 1;
```

## New source input2:
```java
    int year1 = 2020;
    int half1 = 1;
    int half2 = 1;
```

## New source input3:
```java
    int year1 = 2020;
    int half1 = 2;
    int half2 = 2;
```

## New source input4:
```java
    int year1 = 2020;
    int half1 = 1;
    int half2 = 3;
```



# REQUIRED DELIVERABLE
For each new source input listed under 'NEW SOURCE INPUTS', please construct the corresponding follow-up input that satisfies your inferred relation and pass the assertions in the 'ORIGINAL TEST CASE'. Document the complete code for each new input pair in the format shown below:
## New input pairN:
```java
    int year1 = 2007;
    int half1 = 2;
    int half2 = 1;
    int year3 = 2007;
    int half3 = 1;
```

Additionally, for each new source input, provide the code used to generate the follow-up input along with its associated source input code. Please explain why this new input pair satisfies the inferred relation you have identified.