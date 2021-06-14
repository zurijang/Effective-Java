package ej.study.chapter1.item8;


import javax.annotation.Resource;

public class SampleResource implements AutoCloseable{

    private boolean closed;

//    private static final Cleaner CLEANER = Cleaner.create();

//    private final Cleaner.Cleanable cleanable;

    private final ResourceCleaner resourceCleaner;

    public SampleResource() {
        this.resourceCleaner = new ResourceCleaner();
//        this.cleanable = CLEANER.register(this, resourceCleaner);
    }

    private static class ResourceCleaner implements Runnable {

        @Override
        public void run() {
            System.out.println("Clean");
        }
    }

    @Override
    public void close() throws RuntimeException {
        if (this.closed) {
            throw new IllegalStateException();
        }

        closed = true;
        System.out.println("close");
    }

    public void hello() {
        System.out.println("hello");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
