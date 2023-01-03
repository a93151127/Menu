package com.martin.orderMenu.exception;

import lombok.*;

@Getter
@Setter
@ToString
public class OPException extends Exception{

    private static final long serialVersionUID = 1L;
    private String opCode;
    private String opMsg;
    private String extInfo;

    public OPException(String opCode, String opMsg, String extInfo){
        this.opCode = opCode;
        this.opMsg = opMsg;
        this.extInfo = extInfo;
    }

    public OPException(String opCode, String opMsg){
        this.opCode = opCode;
        this.opMsg = opMsg;
    }

    public OPException(String opCode){
        this.opCode = opCode;
    }


}
