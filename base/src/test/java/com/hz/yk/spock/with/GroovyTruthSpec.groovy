package com.hz.yk.spock.with

/**
 * @author wuzheng.yk
 * @date 2023/5/2
 */
class GroovyTruthSpec extends spock.lang.Specification {
    
        def "Groovy truth"() {
            expect:
            "" == null
            0 == null
            [] == null
            [:] == null
            null == null
            !null
            !""
            !0
            ![]
            ![:]
        }
}
