package com.hz.yk.tdd;

import com.hz.yk.tdd.exception.IllegalOptionException;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    public void should_throw_illegal_option_exception_if_option_not_present() {
        final IllegalOptionException ex = assertThrows(IllegalOptionException.class, () -> {
            Args.parse(OptionsWithoutAnnotition.class, "-l", "-p", "8080", "-d", "/usr/logs");
        });
        assertEquals("port",ex.getParameter());
    }

    @Test
    public void should_parse_multiple_option_1() {
        MultiOptions options = Args.parse(MultiOptions.class, "-l", "-p", "8080", "-d", "/usr/logs");

        assertTrue(options.isLogging());
        assertEquals(8080, options.getPort());
        assertEquals("/usr/logs", options.getDirectory());
    }


    @Getter
    private  static class OptionsWithoutAnnotition {
        private boolean logging;
        private int port;
        private String directory;

        public OptionsWithoutAnnotition(@Option("l") boolean logging,  int port, @Option("d") String directory) {
            this.logging = logging;
            this.port = port;
            this.directory = directory;
        }
    }


    @Getter
    private static class MultiOptions {

        private boolean logging;
        private int port;
        private String directory;

        public MultiOptions(@Option("l") boolean logging, @Option("p") int port, @Option("d") String directory) {
            this.logging = logging;
            this.port = port;
            this.directory = directory;
        }

    }

    private static class OptionWithoutAnnotation {

        boolean logging;

        int port;

        String directory;

        public OptionWithoutAnnotation(@Option("l") boolean logging, int port, @Option("d") String directory) {
        }
    }

    @Test
  public void should_example2() {
        ListOptions options = Args.parse(ListOptions.class, "-g","this","is","a","list","-d","1","2","-3","5");
        assertArrayEquals(new String[]{"this","is","a","list"}, options.group);
        assertArrayEquals(new int[]{1,2,-3,5}, options.decimals);
  }


  static class ListOptions {

      private String[] group;
      
      private int[] decimals;

      public ListOptions(@Option("g")String[] group, @Option("d")int[] decimals) {
          this.group = group;
          this.decimals = decimals;
      }
  }
}
