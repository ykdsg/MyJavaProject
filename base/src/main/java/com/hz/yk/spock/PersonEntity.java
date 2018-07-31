package com.hz.yk.spock;

/**
 * @author wuzheng.yk
 * @date 2018/7/30
 */
public class PersonEntity {

    private String personId;
    private String personName;
    private int    age;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonEntity{" + "personId='" + personId + '\'' + ", personName='" + personName + '\'' + ", age=" + age
               + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (age != that.age) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        return personName != null ? personName.equals(that.personName) : that.personName == null;

    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (personName != null ? personName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

}
