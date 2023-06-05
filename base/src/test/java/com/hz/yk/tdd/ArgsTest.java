package com.hz.yk.tdd;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author wuzheng.yk
 * @date 2023/6/5
 */
public class ArgsTest {

    //-l -p 8080 -d /usr/logs
    //[-l], [-p, 8080], [-d, /usr/logs]
    //Single Option:
    //    - Bool -l
    //    - Int -p 8080 
    //    - String -d /usr/logs
    //Multiple Option: -l -p 8080 -d /usr/logs
    //sad path:
    //    -bool -l t
    //    -int -p / -p 8080 8081
    //    -string -d / -d  /usr/logs  /user/vars

    @Test
    public void should_set_boolean_option_to_true_if_flag_present() {
        BooleanOption options = Args.parse(BooleanOption.class, "-l");
        assertTrue(options.getLogging());
    }

    @Test
    public void should_set_boolean_option_to_false_if_flag_not_present() {
        BooleanOption option = Args.parse(BooleanOption.class);
        assertFalse(option.getLogging());
    }

    @Test
    public void should_parse_int_option() {
        IntOption option = Args.parse(IntOption.class, "-p", "8080");
        assertEquals(8080, option.getPort());
    }

    @Test
    public void should_parse_String_option() {
        StringOption option = Args.parse(StringOption.class, "-d", "/usr/logs");
        assertEquals("/usr/logs", option.getDirectory());

    }

    private static class StringOption {

        private String directory;

        public StringOption(@Option("d") String directory) {
            this.directory = directory;
        }

        public String getDirectory() {
            return directory;
        }
    }

    private static class IntOption {

        private int port;

        public IntOption(@Option("p") int port) {
            this.port = port;
        }

        public int getPort() {
            return port;
        }
    }

    private static class BooleanOption {

        private boolean logging;

        public BooleanOption(@Option("l") boolean logging) {
            this.logging = logging;
        }

        public boolean getLogging() {
            return logging;
        }
    }

    @Test
    public void should_parse_multiple_option_1() {
        MultiOptions options = Args.parse(MultiOptions.class, "-l", "-p", "8080", "-d", "/usr/logs");

        assertTrue(options.getLogging());
        assertEquals(8080, options.getPort());
        assertEquals("/usr/logs", options.getDirectory());
    }

    private static class MultiOptions {

        private boolean logging;
        private int port;
        private String directory;

        public MultiOptions(@Option("l") boolean logging, @Option("p") int port, @Option("d") String directory) {
            this.logging = logging;
            this.port = port;
            this.directory = directory;
        }

        public boolean getLogging() {
            return logging;
        }

        public int getPort() {
            return port;
        }

        public String getDirectory() {
            return directory;
        }
    }

    //@Test
    //void should_parse_multiple_option_2() {
    //    ListOptions options = Args.parse(ListOptions.class, "-g", "this", "is", "a", "list", "-d", "1", "2", "-3", "5");
    //
    //    assertArrayEquals(new String[]{"this", "is", "a", "list"}, options.getGroup());
    //    assertArrayEquals(new Integer[]{1, 2, -3, 5}, options.getDecimals());
    //}
    //
    //
    //@Test
    //void should_throw_illegal_option_exception_when_annotation_not_present() {
    //    IllegalOptionException exception = assertThrows(IllegalOptionException.class,
    //            () -> Args.parse(OptionWithoutAnnotation.class, "-l", "-p", "8080", "-d", "/usr/logs"));
    //    // the parameter arg is arg1 rather than port
    //    assertEquals("arg1", exception.getParameter());
    //}

    private static class OptionWithoutAnnotation {

        boolean logging;

        int port;

        String directory;

        public OptionWithoutAnnotation(@Option("l") boolean logging, int port, @Option("d") String directory) {
        }
    }

}
