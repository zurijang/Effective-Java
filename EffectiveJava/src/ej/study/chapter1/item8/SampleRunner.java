package ej.study.chapter1.item8;

public class SampleRunner {

    public static void main(String[] args) {
//        SampleRunner runner = new SampleRunner();
//        runner.run();
//        System.gc(); // 실행 될 수도 있꼬 안될 수도 있음.. 의존하면 안됨..
//        Thread.sleep(1000l);
//        System.gc();


//        try(SampleResource sampleResource = new SampleResource()) {
//            sampleResource.hello();
//        }

        SampleRunner runner = new SampleRunner();
        runner.run();
    }

    private void run() {
        SampleResource sampleReousrce = new SampleResource();
        sampleReousrce.hello();
    }

}
