package cn.bin.javabase.chapter.c1;

public  class Minus{
	public static Minus minusHead = null;
    public static Minus MinusEnd = null;
    public char sign;
    public double number;
    public Minus next;

    public static void findMinusNumber(StringBuffer calc){
    	
    	 minusHead = null;
         MinusEnd = null;
      
       IndexOfSign.findSign(calc.toString());          
        if(IndexOfSign.head == null)return;
        
         else{
        	
        	//String textNumber = null;
            IndexOfSign temp = IndexOfSign.head;
            
            while(temp != null)
            {
                if (minusHead == null)
                {
                    minusHead = new Minus();
                    MinusEnd = minusHead;
                    if(temp.index == 0){//如果下标0的字符是运算符
                        minusHead.sign = temp.sign;
                        
                        //textNumber = calc.substring(1,temp.index);
                        if(temp.next == null) {
                        	minusHead.number =  Double.parseDouble(calc.substring(1,calc.length()));
                        	break;
                        }
                        else minusHead.number =  Double.parseDouble(calc.substring(1,temp.next.index));
                        /*temp = temp.next;
                        continue;*/
                    }else {
                        minusHead.sign = '+';
                        //textNumber = calc.substring(0,temp.index);
                        minusHead.number =  Double.parseDouble(calc.substring(0,temp.index));


                        if (temp.next == null){
                            MinusEnd.next = new Minus();
                            MinusEnd = MinusEnd.next;
                            MinusEnd.sign = temp.sign;
                            //textNumber = calc.substring(temp.index + 1,calc.length());
                            MinusEnd.number =  Double.parseDouble(calc.substring(temp.index + 1,calc.length()));
                            break;
                        }else{
                            MinusEnd.next = new Minus();
                            MinusEnd = MinusEnd.next;
                            MinusEnd.sign = temp.sign;
                            //textNumber = calc.substring(temp.index + 1,temp.next.index);
                            MinusEnd.number =  Double.parseDouble(calc.substring(temp.index + 1,temp.next.index));
                        }

                    }



                }
                else{


                    MinusEnd.next = new Minus();
                    MinusEnd = MinusEnd.next;
                    MinusEnd.sign = temp.sign;
                    if (temp.next == null){
                       
                        //textNumber = calc.substring(temp.index,calc.length());
                        MinusEnd.number =  Double.parseDouble(calc.substring(temp.index + 1,calc.length()));
                        break;
                    }
                    else {
                    	//textNumber = calc.substring(temp.previous.index,temp.index);
                    	MinusEnd.number =  Double.parseDouble(calc.substring(temp.index + 1,temp.next.index));
                    }


                }
                temp = temp.next;
            }




        }
    }
    
    public static void main(String args[]) {
    	StringBuffer calc = new StringBuffer("-1+5");
    	double total = 0;
    	Minus.findMinusNumber(calc);
    	
        if(Minus.minusHead != null){
            total = 0;
            Minus minus = Minus.minusHead;
            while(minus != null){
                if(minus.sign == '+')total += minus.number;
                else if (minus.sign == '-')total -= minus.number;
                
                System.out.println("数值" + minus.number + "\t符号:" + minus.sign);
                minus = minus.next;
            }
        }
        System.out.println(total);
    }
}

