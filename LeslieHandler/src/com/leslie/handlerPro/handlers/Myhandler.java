package com.leslie.handlerPro.handlers;

public class Myhandler extends AbstractHandler<String>{

	@Override
	protected AbstractParser<?, ?> injectParser() {
		return new TempParser();
	}

}
