package com.leslie.handlerPro.handlers;

public class TempParser extends AbstractParser<TempHandler, String> {

    @Override
    public void parse(String content) {
    	mHandler.setTemp(content);
    }
}
