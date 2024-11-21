package io;

public class IntegerBagIO extends AbstractBagIO<Integer> {

    // @Override
    public Integer fromString(String text) { // throws ConversionException {
        return Integer.parseInt(text);
    }

    // @Override
    public String toString(Integer value) {
        return Integer.toString(value);
    }

}
