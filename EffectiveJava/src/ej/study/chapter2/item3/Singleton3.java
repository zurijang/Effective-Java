package ej.study.chapter2.item3;

// 상속은 안되고, implements만 됨
// 너무 이상적인 방법
public enum Singleton3 {
    INSTANCE;

    public String getName() {
        return "zuri";
    }
}
