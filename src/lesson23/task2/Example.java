package lesson23.task2;

import lesson23.task3.Ignore;

public class Example {

    public Example(long l){
        this.l = l;
    }

    private final long l ;
    private final int id = 1;

    @Ignore
    protected String S = "sa";

    public boolean isTrue = true;
    double Pi = 3.14;
}
