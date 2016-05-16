/**
 *Copyright (c) 2016 Applifire
 *Project : project1(V1.0)
 */


package com.app.customexceptions;

import com.spartan.pluggable.exception.core.BaseBusinessServiceException;


/**
 *Author : John S Doe
 *Date :Mon May 16 08:56:44 UTC 2016
 */

public class MyNewEx extends BaseBusinessServiceException {


     private static final long serialVersionUID = 2547081264479698464L;


     public MyNewEx(final String _appAlarmId, Throwable _throwable) {
          super("MyNewEx", _appAlarmId, _throwable);
     }

     public MyNewEx(final String _msg, final String _appAlarmId, final Throwable _throwable) {
          super(_msg, _appAlarmId, _throwable);
     }

}