/**
 * groovy 进阶
 * @author wuzheng.yk
 * @date 2018/7/20
 */

//在Groovy中除非指定了确定的返回类型，void也可以作为返回值的一种，否则定义函数必须加上关键字def
String getString() {
    return "hello world"
}

def getDef() {
    return "hello world"
}

void printSomething() {
    println "hello worlld"
}

printSomething()
println(getString())

//函数可以赋值给其它函数，使用语法标记&将函数赋予新的函数。
def printHello = this.&printSomething
printHello()


def str = "hello world closure"
//闭包的定义格式，闭包可以访问外部变量 ，方法不可以
def closure = {
    println str
}
closure()

//闭包可以有参数，如果没有定义参数，会有一个隐式的默认参数it
def closure2 = {
    println "hello $it"
}
closure2("admin")

//如果存在参数，在[->]之前的就是参数
//闭包中参数名称不能与闭包内或闭包外的参数名重名
def closure3 = {
    param01, param02, param03 -> println param01 + param02 + param03
}
closure3("hello", " world", " ssss")

//闭包可以作为一个参数传递给另一个闭包，也可以在闭包中返回一个闭包
def toTriple = { n -> n * 3 }
def runTwice = { a, c -> c(c(a)) }
println runTwice(5, toTriple)//45

def times = { x -> { y -> x * y } }
println times(3)(4)//12

//闭包接受参数的规则，会将参数列表中所有有键值关系的参数，作为一个map组装，传入闭包作为调用闭包的第一个参数。
// 这个有点奇葩
def f = { m, i, j -> i + j + m.x + m.y }
println f(6, x: 4, y: 3, 7)//20
