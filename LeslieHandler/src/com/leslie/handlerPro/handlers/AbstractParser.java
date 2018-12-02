package com.leslie.handlerPro.handlers;

public abstract class AbstractParser<H extends AbstractHandler<D>, D> implements IParser<D> {
    protected H mHandler;


    protected  void attchHandler(H h) {
        mHandler = h;
    }


    public void close() {
        mHandler = null;
    }
}
