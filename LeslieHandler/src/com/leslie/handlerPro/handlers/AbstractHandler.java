package com.leslie.handlerPro.handlers;


@SuppressWarnings("unchecked")
public abstract class AbstractHandler<D> implements IParser<D> {
    @SuppressWarnings("rawtypes")
	protected AbstractParser mParser;


    {
        @SuppressWarnings("rawtypes")
		AbstractParser parser = injectParser();

        initParser(parser);
    }

    @SuppressWarnings("rawtypes")
	protected abstract AbstractParser injectParser();

    @SuppressWarnings("rawtypes")
	public void setParser(AbstractParser parser) {
        if (mParser != null) {
            mParser.close();
        }


    }

    private void initParser(@SuppressWarnings("rawtypes") AbstractParser parser) {
        if (parser == null) {
            throw new IllegalArgumentException("parser is null!");
        }
        
//        checkHandlerTypeMismatch(getParserHandlerType(parser));
        
        
        mParser = parser;
        mParser.attchHandler(this);
    }
    
    
//    private Class<?>getParserHandlerType(@SuppressWarnings("rawtypes") AbstractParser parser) {
//    	Type[] typeParameters = parser.getClass().getGenericSuperclass().getTypeParameters();
//    	Class<?> classType = null;
//    	for (Type type : typeParameters) {
//    		
//    		System.out.println(((TypeVariable)type).toString());
////    		Class.forName()
////    		try {
////				classType =  Class.forName(((ParameterizedType)type).getActualTypeArguments()[0].toString()) ;
////			} catch (ClassNotFoundException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////    		if (type instanceof ParameterizedType)
////    		System.out.println(((ParameterizedType)type).getActualTypeArguments());
////    		if (classType.getSuperclass().isInstance(this)) {
////    			return classType;
////    		}
//		}
//    	return null;
//    }
    
//    private void checkHandlerTypeMismatch(Class<?> handlerClass) {
//    	if (! handlerClass.isInstance(this)) {
//    		throw new IllegalArgumentException("Handler Type Mismatch!");
//    	}
//    }

    @Override
    public void parse(D data) {
        mParser.parse(data);
    }

    public void clsoe() {
        mParser.close();
        mParser = null;
    }
}
