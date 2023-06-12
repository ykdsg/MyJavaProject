package com.hz.yk.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * http://www.liuhaihua.cn/archives/442197.html
 *
 * @author wuzheng.yk
 * @date 2019-03-07
 */
public class ReactorSnippets {

    private static List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    /**
     * Observable的创建跟在RxJava里有点类似，在Reactor里可以使用just(T…)和fromIterator(Iterable<T>)工厂方法来创建。just方法会把List作为一个整体触发，而fromIterable会逐个触发List里的每个元素：
     */
    @Test
    public void simpleCreation() {
        Flux<String> fewWords = Flux.just("Hello", "World");
        Flux<String> manyWords = Flux.fromIterable(words);

        fewWords.subscribe(System.out::println);
        System.out.println();
        manyWords.subscribe(System.out::println);
    }

    /**
     * 为了打印句子里的每一个字母，我们还需要flatMap方法（跟在RxJava里一样），不过在Reactor里我们使用fromArray来代替from。然后我们会用distinct过滤掉重复的字母，并用sort对它们进行排序。最后，我们使用zipWith和range输出每个字母的次序：
     */
    @Test
    public void findingMissingLetter() {
        Flux<String> manyLetters = Flux.fromIterable(words).flatMap(word -> Flux.fromArray(word.split(""))).distinct().sort().zipWith(Flux.range(1, Integer.MAX_VALUE), (string, count) -> String.format("%2d. %s", count, string));

        manyLetters.subscribe(System.out::println);
    }

    /**
     * 我们可以通过纠正单词数组来修复这个问题，不过也可以使用concat/concatWith和一个Mono来手动往字母Flux里添加“s”
     */
    @Test
    public void restoringMissingLetter() {
        Mono<String> missing = Mono.just("s");
        Flux<String> allLetters = Flux.fromIterable(words).flatMap(word -> Flux.fromArray(word.split(""))).concatWith(missing).distinct().sort().zipWith(Flux.range(1, Integer.MAX_VALUE), (string, count) -> String.format("%2d. %s", count, string));

        allLetters.subscribe(System.out::println);
    }

}
