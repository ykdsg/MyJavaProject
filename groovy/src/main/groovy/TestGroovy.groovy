def key = 'name'

//这里的key是'key'
def person = [key: 'mark']
println person.containsKey('key')
//这里的key是'name'
person = [(key): 'mark']
println person.containsKey('name')
