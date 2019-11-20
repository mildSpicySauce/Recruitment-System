package Business;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/9 11:55
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class IdOrPwdException extends Exception{
    public IdOrPwdException(){}
    public IdOrPwdException(String messge){
        super(messge);

    }

    public IdOrPwdException(Throwable cause){
        super(cause);
    }
    public  IdOrPwdException(String message ,Throwable cause){
        super(message,cause);

    }
}
