class Student {
    String name;
    int age;

    Student(String name, String s, int age, String email, String course) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}


