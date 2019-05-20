# gatling maven 使用


## 用户量为300的对http://localhost:8091/hello/100的测试
```$xslt
mvn gatling:test -Dgatling.simulationClass=test.load.sims.LoadSimulation -Dbase.url=http://localhost:8091/ -Dtest.path=hello/100 -Dsim.users=300

```

## 对dubbo服务的压测
```$xslt
mvn gatling:test -Dgatling.simulationClass=test.load.sims.DubboTest
```
