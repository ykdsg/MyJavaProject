package com.hz.yk.tdd;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void should_parse_multiple_option() {
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


}
