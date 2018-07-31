/**
 * groovy 入门
 * @author wuzheng.yk
 * @date 2018/7/20
 */

def name = "test"
def test = "this is my name :${name}"
println(test)

def mulAry = ["11", 1, 3]
println(mulAry)
println("mulAry is List:" + (mulAry instanceof List))


String[] mulAry2 = ["tes", 1, 5]
println(mulAry2)
println("mulAry2 is string[] :" + (mulAry2 instanceof String[]))
println("mulAry2[1] is string :" + (mulAry2[1] instanceof String))


def maps = [one: 100, two: 101, three: 102]
println(maps['one'] == 100)
println(maps.one == 100)

def maps2 = [1: 100, 2: 101, 3: 102]
println(maps2[1] == 100)

def key = "name"
//key 当做了字符串而不是变量
def person = [key: 'admin']
println(person.containsKey('name'))
println(person.containsKey('key'))

//必须加上圆括号保卫这个变量或者表达式
def person2 = [(key): 'admin']
println(person2.containsKey('name'))
println(!person2.containsKey('key'))
