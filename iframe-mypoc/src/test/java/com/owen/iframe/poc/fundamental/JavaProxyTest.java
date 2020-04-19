package com.owen.iframe.poc.fundamental;

import com.owen.iframe.poc.fundamental.dynamicproxy.CarBMW;
import com.owen.iframe.poc.fundamental.dynamicproxy.CglibProxy;
import com.owen.iframe.poc.fundamental.dynamicproxy.IVehicle;
import com.owen.iframe.poc.fundamental.dynamicproxy.MyProxyFactory;
import org.junit.Test;


public class JavaProxyTest {

    @Test
    public void test(){
        CarBMW myCar = new CarBMW();
        IVehicle proxyCar = (IVehicle) MyProxyFactory.CreatProxyedObj(myCar);
        proxyCar.run();
    }

    @Test
    public void cglibTest(){
        CarBMW myCar = new CarBMW();
        CglibProxy factory = new CglibProxy();
        myCar = (CarBMW)factory.CreatProxyedObj(myCar.getClass());
        myCar.run();
    }
}
